//package online.shop.docs.domain.item;
//
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.experimental.SuperBuilder;
//import online.shop.docs.domain.Category;
//import online.shop.docs.exception.NotEnoughStockException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@SuperBuilder
//@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="DTYPE")
//public abstract class Item {
//    @Id @GeneratedValue
//    @Column(name="ITEM_ID")
//    private Long id;
//    private String name;
//    private int price;
//    private int stockQuantity;
//
//    @Builder.Default
//    @ManyToMany(mappedBy="items")
//    private List<Category> categories = new ArrayList<Category>();
//
//    @Enumerated(EnumType.STRING)
//    private ItemSellingStatus sellingStatus;
//
//    //==비지니스 로직==//
//    //setter보다는 명시적인 비지니스 로직을 이용하여 값을 변경//
//    public void addStock(int quantity){//1. 입고 2. 주문취소
//        this.stockQuantity +=quantity;
//    }
//    public void removeStock(int quantity){//1. 주문 수행 시 2. 주문 취소 시
//        int restStock = this.stockQuantity-quantity;
//        if(restStock < 0){
//            throw new NotEnoughStockException(this.stockQuantity,quantity);
//        }
//        this.stockQuantity = restStock;
//    }
//
//}
