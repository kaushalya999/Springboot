package ijse.springIntroNew.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ijse.springIntroNew.entity.Order;

@Service
public interface OrderService {

    List<Order> getOrderList();

    Order createOrder(Order order);
}
