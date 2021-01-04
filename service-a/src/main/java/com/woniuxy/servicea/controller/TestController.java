package com.woniuxy.servicea.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.woniuxy.servicea.client.RestResult;
import com.woniuxy.servicea.client.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@DefaultProperties(defaultFallback = "defaultfallback")
@Controller
public class TestController {
    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ServiceBClient serviceBClient;
//  网页输入http://localhost:8082/test测试
//  当某个通讯方法需要进行容错处理时，可以使用局部服务降级，在目标方法上添加注解@HystrixCommand(fallbackMethod="降级方法名称");
//    @HystrixCommand(fallbackMethod = "fallback")
    @HystrixCommand
    @RequestMapping("/test")
    @ResponseBody
    public String test(int num){
/*//      方式一：RestTemplate
//      通过Springcloud内置的RestTemplated对象，实现服务之间的调用
        RestTemplate restTemplate = new RestTemplate();
//      通过http协议调用服务，参数1为目标服务的url，参数2位接收和返回的数据类型
        Map data = restTemplate.getForObject("http://localhost:8083/hello",Map.class);*/

/*//      方式二：采用Ribbon进行客户端负载均衡
//      通过Spring 工厂自动注入LoadBalancerClient ，是Ribbon的核心组件
//      获取服务列表：loadBalancerClient.choose(“服务Id")
//      通过获取的服务来动态的获取服务的主机和端口号


        ServiceInstance serviceInstance = client.choose("service-b");
        String host = serviceInstance.getHost();
        Integer port = serviceInstance.getPort();
        data = restTemplate.getForObject("http://"+host+":"+port+"/hello",Map.class);*/

/*//      方式三：采用注解简化URL通信
//      将RestTemplate对象注入到IOC容器中
//      在该Bean对象上添加注解： @LoadBalanced
//      利用注解开发的时候，URL的主机名端口号都换成目标服务的名称serviceid即可。
        data = this.restTemplate.getForObject("http://service-b/hello",Map.class);*/

        if(num==1){
//          当前服务降级了
            Map data = this.restTemplate.getForObject("http://service-b/hello",Map.class);
            return (String) data.get("msg");
        }else{
            return "successS";
        }
//      使用通讯组件Feign
//        data = serviceBClient.test();
//        return (String) data.get("msg");
    }
//  服务降级：
//  一：通过RestTemplate 进行服务降级
//  1、局部（部分方法）
//  服务降级的方法需要与目标通讯方法的形参和返回值一致。
    public String fallback(){
        return "请稍后再试（服务降级）";
    }
//  2、全局
//  在类上加注解：@DefaultProperties(defaultFallback="方法名")
//  全局的降级方法是无参数的，返回值是可以序列化的对象
//  同样需要在目标上添加注解@HystrixCommand，但无需单独制定降级方法
//全局默认的降级方法：方法没有参数，返回值类型是一个可序列化的对象即可。
    public String defaultfallback(){
        return "全局服务降级方法";
    }

//  当使用feign获取服务方法中有参数时
    @RequestMapping("/emptest")
    @ResponseBody
    public String empTest(){
        RestResult restResult = serviceBClient.find(1001);
        System.out.println(restResult.getData().getEname());
        return restResult.getMsg();
    }
}
