package cn.itcast.order;



import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@MapperScan("cn.itcast.order.mapper")
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class,clients = UserClient.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * 创建RestTemplate对象并注入Spring容器
     * 这样就可以在Java中发Http请求了
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }
}