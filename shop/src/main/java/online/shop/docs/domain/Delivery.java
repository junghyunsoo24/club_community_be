//package online.shop.docs.domain;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Delivery {
//    @Id @GeneratedValue
//    @Column(name = "DELIVERY_ID")
//    private Long id;
//
//    @OneToOne(mappedBy = "delivery")
//    private Order order;
//
//    @Embedded
//    private Address address;
//
//    @Enumerated(EnumType.STRING)
//    private DeliveryStatus status; //READY -> 준비, COMP ->배송
//}
