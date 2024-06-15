package online.shop.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
//import online.shop.api.response.common.ApiResponse;
//import online.shop.api.response.common.ResponseCode;
import online.shop.response.ApiResponse;
import online.shop.response.ResponseCode;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import online.shop.web.response.ErrorCode;

@Slf4j
@RestController
public class ApiExceptionController {
    private HttpStatus httpStatus(ErrorCode errorCode) {
        return HttpStatus.valueOf(errorCode.getCode()/1000);
    }

    @PostMapping("/api/members")
    public ApiResponse<MemberCreateResponse> createMember(@Valid @RequestBody MemberCreateRequest member)
    {
        if(member.memberId.equals("ex")){
            throw new RuntimeException("잘못된 사용자");
        }
        if(member.memberId.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력");
        }
        if(member.memberId.equals("other")){
            throw new IllegalStateException("내부 에러");
        }


        return ApiResponse.response(ResponseCode.OK, MemberCreateResponse.of(member));
    }
    @Data
    @AllArgsConstructor
    static class MemberCreateRequest{
        @NotBlank( message = "회원 ID는 필수" )
        private String memberId;
        @NotEmpty( message = "회원 이름은 공백일 수 없음" )
        private String name;
        @Range(min = 20, max = 40, message = "나이는 20~40")

        private int age;
    }
    @Data
    @AllArgsConstructor
    @Builder
    static class MemberCreateResponse{
        private long id;
        private String memberId;
        private String name;
        private int age;

        public static MemberCreateResponse of(MemberCreateRequest request){
            return MemberCreateResponse.builder()
                    .id(1)
                    .memberId(request.getMemberId())
                    .name(request.getName())
                    .age(request.getAge())
                    .build();
        }
    }
}

