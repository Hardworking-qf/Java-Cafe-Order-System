package com.abee.cafe.service;

import com.abee.cafe.dao.*;
import com.abee.cafe.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderUserMenuService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final OrderUserMenuRepository orderUserMenuRepository;
    private final UserOrderRepository userOrderRepository;

    public OrderUserMenuService(
            OrderRepository orderRepository,
            UserRepository userRepository,
            MenuRepository menuRepository,
            OrderUserMenuRepository orderUserMenuRepository,
            UserOrderRepository userOrderRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
        this.orderUserMenuRepository = orderUserMenuRepository;
        this.userOrderRepository = userOrderRepository;
    }

    private List<OrderSearchResultList> toReturnList(List<OrderUserMenu> inputList) {
        List<OrderSearchResultList> resultLists = new ArrayList<OrderSearchResultList>();
        inputList.stream()
                .collect(Collectors.groupingBy(OrderUserMenu::getOrderID))
                .forEach((k, v) -> {
                    OrderSearchResultList tempResultList = new OrderSearchResultList();
                    OrderUserMenu list0 = v.get(0);
                    tempResultList.setOrderID(k);
                    tempResultList.setUserID(list0.getUserID());
                    tempResultList.setUserName(list0.getUserName());
                    tempResultList.setTime(list0.getTime());
                    tempResultList.setStatus(list0.getOrderStatus());

                    List<OrderSearchResult> tempList = new ArrayList<OrderSearchResult>();
                    for (OrderUserMenu l : v) {
                        OrderSearchResult orderSearchResult = new OrderSearchResult();
                        orderSearchResult.setId(l.getId());
                        orderSearchResult.setItemID(l.getMenuID());
                        orderSearchResult.setItemName(l.getItemName());
                        orderSearchResult.setDescribe(l.getDescription());
                        orderSearchResult.setCategory(l.getCategory());
                        orderSearchResult.setAmount(l.getAmount());
                        orderSearchResult.setPrice(l.getPrice());
                        orderSearchResult.setUrl(l.getIcon());
                        tempList.add(orderSearchResult);
                    }

                    tempResultList.setList(tempList);
                    resultLists.add(tempResultList);
                });
        return resultLists;
    }


    @Transactional(rollbackFor = Exception.class)
    public List<OrderSearchResultList> getAll() {
        return toReturnList(orderUserMenuRepository.findAll());
    }

    /*// 通过用户ID返回订单列表
    @Transactional(rollbackFor = Exception.class)
    List<OrderSearchResultList> findOrdersByUserID(Long userID) {
        return toReturnList(orderUserMenuRepository.findOrderUserMenusByUserID(userID));
    }

    // 通过用户名返回订单列表
    List<OrderSearchResultList> findOrdersByUserName(String userName) {

        return null;
    }

    // 通过用户邮箱返回订单列表
    List<OrderUserMenu> findOrdersByUserEmail(String userEmail) {

        return null;
    }

    // 通过用户电话返回订单列表
    List<OrderUserMenu> findOrdersByUserTel(String userTel) {

        return null;
    }
*/
    @Transactional(rollbackFor = Exception.class)
    List<OrderSearchResultList> findOrdersByUser(User user) {

        return null;
    }
    // 通过订单ID返回订单
    @Transactional(rollbackFor = Exception.class)
    OrderSearchResultList findOrderByOrderID(Long orderID) {
        List<OrderSearchResultList> temp = toReturnList(orderUserMenuRepository.findOrderUserMenusByOrderID(orderID));
        if (temp.size() == 0) return null;
        else return temp.get(0);
    }
}
