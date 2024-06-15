//package online.shop.docs.controller;
//
//import lombok.RequiredArgsConstructor;
//import online.shop.response.ApiResponse;
//import online.shop.response.ResponseCode;
//import online.shop.docs.service.ItemApiService;
//import online.shop.docs.request.ItemCreateRequest;
//import online.shop.docs.response.ItemResponse;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/item")
//public class ItemApiController {
//    private final ItemApiService itemService;
//
//    @PostMapping("/create")
//    public ApiResponse<ItemResponse> createItem(@RequestBody ItemCreateRequest request){
//        ItemResponse res = itemService.createItem(request);
//        return ApiResponse.response(ResponseCode.OK, res);
//    }
//}