//package online.shop.docs.exception;
//
//public class NotEnoughStockException extends RuntimeException {//exception을 더 구체화하고 싶어서 클래스 만듦
//    private static final String message = "재고가 부족합니다.";
//    public NotEnoughStockException() {
//        super();
//    }
//
//    public NotEnoughStockException(String message) {
//        super(message);
//
//    }
//    public NotEnoughStockException(int stock, int orderNum) {
//        super(message + " 재고: "  + stock + " 주문: " + orderNum + " 초과: " + (orderNum-stock));
//    }
//
//    public NotEnoughStockException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public NotEnoughStockException(Throwable cause) {
//        super(cause);
//    }
//}
//
