package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        String url = "http://userserver/user/" + order.getUserId();
//        //发起http请求，查询用户,实现远程调用
//        User user = restTemplate.getForObject(url, User.class);
//
//        //封装user到order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        //使用Feign远程调用
        User user = userClient.fingByid(order.getUserId());

        //封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
