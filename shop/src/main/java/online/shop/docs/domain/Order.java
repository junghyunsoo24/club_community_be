//package online.shop.docs.domain;
//
//import jakarta.persistence.*;
//import lombok.*;
//import online.shop.docs.domain.Member;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Entity
//@Getter
//@Setter
//@Table(name="ORDERS")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
//@Builder
//public class Order {
//    @Id @GeneratedValue
//    @Column(name="ORDER_ID")
//    private Long id;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="MEMBER_ID")
//    private Member member;
//
//    @OneToMany(mappedBy="order",cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
//
//    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name="DELIVERY_ID")
//    private Delivery delivery;
//
//    private LocalDateTime orderDate;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;
//
//    public void setMember(Member member){
//        this.member = member;
//        member.getOrders().add(this);
//    }
//    public void addOrderItem(OrderItem orderItem){
//        orderItems.add(orderItem);
//        orderItem.setOrder(this);
//    }
//    public void setDelivery(Delivery delivery){
//        this.delivery = delivery;
//        delivery.setOrder(this);
//    }
//
//
//    @Builder
//    //====생성 메소드=====/
//    public static Order createOrder(Member member,
//                                    Delivery delivery,
//                                    OrderItem... orderItems){
//        Order order = new Order();
//
//        order.setMember(member);
//        order.setDelivery(delivery);
//        for(OrderItem orderItem:orderItems){
//            order.addOrderItem(orderItem);
//        }
//        order.setStatus(OrderStatus.ORDER);
//        order.setOrderDate( LocalDateTime.now());
//        return order;
//    }
//
//    //주문취소
//    public void cancel(){
//        if(delivery.getStatus()==DeliveryStatus.COMP){
//            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
//        }
//        this.setStatus(OrderStatus.CANCELED);
//        orderItems.stream().forEach(o->o.cancel());
//    }
//
//    //주문의 총 결제 금액
//    public int getTotalPrice(){
//        //totalPrice += orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
//        int totalPrice = orderItems.stream()
//                .map(o -> o.getTotalPrice())
//                .reduce(0, (a, b) -> a + b);
//        return totalPrice;
//    }
//
//
//}
