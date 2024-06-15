//package online.shop.docs.domain;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
////@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Member extends BaseEntity {
//
//    @Id @GeneratedValue
//    @Column(name="MEMBER_ID")
//    private Long id;
//    private String name;
//    private int age;
//
//    @Embedded
//    private Address address;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "member", cascade=CascadeType.ALL, orphanRemoval = true)
//    @Builder.Default
//    private List<Order> orders = new ArrayList<Order>();
//
//
//    @Builder
//    public Member(String name, int age, Address address) {
//        if(age>= 100 || age<=20){
//            throw new IllegalArgumentException("나이는 20보다크고 100보다 작아야 함");
//        }
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }
//
//}
