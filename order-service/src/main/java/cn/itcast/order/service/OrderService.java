package cn.itcast.order.service;


import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.远程调用Feign
        User user = userClient.findById(order.getUserId());

        // 3.封装
        order.setUser(user);

        // 4.返回
        return order;
    }

//    @Autowired
//    private RestTemplate restTemplate;

//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        // 2.利用restTemplate发Http请求
//        //String url = "http://localhost:8081/user/" + order.getUserId();
//        String url = "http://userservice/user/" + order.getUserId();
//
//        User user = restTemplate.getForObject(url, User.class);
//
//        // 3.封装
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }
}
