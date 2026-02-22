package ijse.springIntroNew.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.springIntroNew.dto.OrderReqDto;
import ijse.springIntroNew.entity.Order;
import ijse.springIntroNew.entity.Product;
import ijse.springIntroNew.service.OrderService;
import ijse.springIntroNew.service.ProductService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> orders = orderService.getOrderList();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderReqDto orderReqDto) {

        Order orders = new Order();

        orders.setTotalAmount(0.0);

        // get productIds from OrderReqDto to ProductIds ArrayList
        List<Long> productIds = orderReqDto.getProductIds();

        List<Product> orderProducts = new ArrayList<>();

        productIds.forEach(productId -> {
            // get product by the product Id
            Product product = productService.getProductById(productId);

            // add this product to order
            if (product != null) {
                orderProducts.add(product);

                // set order ottal price
                orders.setTotalAmount(orders.getTotalAmount() + product.getPrice());
            }

        });

        orders.setOrderProducts(orderProducts);

        // save the order in DB
        orderService.createOrder(orders);

        return ResponseEntity.status(201).body(orders);

    }

}
