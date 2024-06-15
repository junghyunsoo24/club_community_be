//package online.shop.docs.response;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import online.shop.docs.domain.item.Item;
//import online.shop.docs.domain.item.ItemSellingStatus;
//
//@Getter
//@Builder
//@AllArgsConstructor
//public class ItemResponse {
//    private Long itemId;
//    private String name;
//    private int price;
//    private int stockQuantity;
//    private ItemSellingStatus sellingStatus;
//
//    public static ItemResponse of(Item item){
//        return ItemResponse.builder()
//                .itemId(item.getId())
//                .name(item.getName())
//                .price(item.getPrice())
//                .stockQuantity(item.getStockQuantity())
//                .sellingStatus(item.getSellingStatus())
//                .build();
//    }
//}
//
