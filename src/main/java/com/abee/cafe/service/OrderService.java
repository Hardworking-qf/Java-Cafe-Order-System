package com.abee.cafe.service;

import com.abee.cafe.dao.CartRepository;
import com.abee.cafe.dao.MenuRepository;
import com.abee.cafe.dao.OrderRepository;
import com.abee.cafe.dao.UserOrderRepository;
import com.abee.cafe.entity.Cart;
import com.abee.cafe.entity.Order;
import com.abee.cafe.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;
    private final UserOrderRepository userOrderRepository;

    public OrderService(CartRepository cartRepository, OrderRepository orderRepository, MenuRepository menuRepository,UserOrderRepository userOrderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.userOrderRepository=userOrderRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public UserOrder addUserOrder(UserOrder userOrder){
        /*validate*/

        userOrder.setStatus("succeed");
        UserOrder newUserOrder=userOrderRepository.save(userOrder);
        addFromCart(newUserOrder.getUserID(),newUserOrder.getOrderID());
        return newUserOrder;
    }


    @Transactional(rollbackFor = Exception.class)
    public List<Order> addFromCart(Long userID, Long orderID) {
        List<Cart> carts = cartRepository.findCartsByUserID(userID);
        List<Order> orders = new ArrayList<Order>();
        for (Cart cart : carts) {
            Order order = new Order();
            order.setAmount(cart.getAmount());
            order.setItemID(cart.getItemID());
            order.setOrderID(orderID);
            order.setPrice(menuRepository.findMenuById(cart.getItemID()).getPrice());
            orders.add(order);
        }
        return orderRepository.saveAll(orders);
    }

}
