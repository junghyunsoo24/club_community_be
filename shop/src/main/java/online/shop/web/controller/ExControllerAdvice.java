package online.shop.web.controller;

import lombok.extern.slf4j.Slf4j;
import online.shop.web.response.ErrorCode;
import online.shop.web.response.ApiErrorResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {
    private final MessageSource messageSource;

    public ExControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    private String getErrorMessage(ObjectError error) {
        String[] codes = error.getCodes();
        for (String code : codes) {
            try {
                return messageSource.getMessage(code, error.getArguments(), Locale.KOREA);
            } catch (NoSuchMessageException ignored) {}
        }
        return error.getDefaultMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> illegalExHandler(IllegalArgumentException e){
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode, e.getMessage());
        return ResponseEntity.status(httpStatus(errorCode))
                .body(errorResponse);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiErrorResponse> internalExHandler(Exception e){
//        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
//        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode, e.getMessage());
//        return ResponseEntity.status(httpStatus(errorCode))
//                .body(errorResponse);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> invalidFormatHandler(MethodArgumentNotValidException e){
//        String errorMsg = e.getAllErrors().get(0).getDefaultMessage();
//        System.out.println("errorMsg = " + errorMsg);
//        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
//        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode, errorMsg);
//        return ResponseEntity.status(httpStatus(errorCode))
//                .body(errorResponse);

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c -> {
                    errors.put(((FieldError) c).getField(), getErrorMessage(c));
                });
        System.out.println("errors = " + errors);
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode,errors.toString());
        return ResponseEntity.status(httpStatus(errorCode))
                .body(errorResponse);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrorResponse> invalidTypeHandler(HttpMessageNotReadableException e){
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        String errorMessage = messageSource.getMessage("typeMismatch", new Object[] {}, Locale.KOREA);
        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode, errorMessage);
        return ResponseEntity.status(httpStatus(errorCode))
                .body(errorResponse);
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ApiErrorResponse> invalidTypeHandler(HttpMessageNotReadableException e){
//        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
//        System.out.println("e.getMessage() = " + e.getMessage());
//        ApiErrorResponse errorResponse = ApiErrorResponse.of(errorCode, e.getMessage());
//        return ResponseEntity.status(httpStatus(errorCode))
//                .body(errorResponse);
//    }



    private HttpStatus httpStatus(ErrorCode errorCode) {
        return HttpStatus.valueOf(errorCode.getCode()/1000);
    }
}