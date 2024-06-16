//package online.shop.docs.service;
//
//import lombok.RequiredArgsConstructor;
//import online.shop.docs.request.ItemCreateRequest;
//import online.shop.docs.domain.item.Item;
//import online.shop.docs.response.ItemResponse;
//import online.shop.docs.persistence.SpringDataItemRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class ItemApiService {
//    private final SpringDataItemRepository itemRepository;
//
//    public ItemResponse createItem(ItemCreateRequest request){
//        Item savedItem = itemRepository.save(request.toEntity());
//        return ItemResponse.of(savedItem);
//    }
//}
