//package online.shop.docs.persistence;
//
//import online.shop.docs.domain.item.Item;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface SpringDataItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findByPriceGreaterThanEqual(int price);
//    List<Item> findByNameLike(String name);
//    List<Item> findByNameLikeAndPriceLessThanEqualOrderByPriceAsc(String name, int price);
//    Item findFirstByNameLike(String name);
//}
//
