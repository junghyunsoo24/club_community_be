//package online.shop.docs.request;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import online.shop.docs.domain.item.Book;
//import online.shop.docs.domain.item.Item;
//import online.shop.docs.domain.item.ItemSellingStatus;
//
//@Getter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class ItemCreateRequest {
//    private String name;
//    private int price;
//    private int stockQuantity;
//    private ItemSellingStatus sellingStatus;
//
//    public Item toEntity(){
//        return Book.builder()
//                .name(this.name)
//                .price(this.price)
//                .stockQuantity(this.stockQuantity)
//                .sellingStatus(this.sellingStatus)
//                .build();
//    }
//}
