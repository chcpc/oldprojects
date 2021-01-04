package com.woniuxy.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Feign是一个声明web服务客户端，它出现的目的是为了简化微服务之间通信的过程。
 * • 使用Feign开发创建一个接口并使用Spring MVC进行注解
 * • Feign集成Ribbon内置负载均衡。
 * • 开发步骤：
 * – 1）添加依赖： <dependency> <groupId>org.springframework.cloud</groupId> <artifactId>spring-cloud-starter-openfeign</artifactId> </dependency>
 * – 2）创建接口；添加注解@FeignClient(name=“服务Id")
 * – 3）接口方法上添加请求注解：@GetMapping @PostMapping • 例如： @GetMapping(“/list”)
 * – 4）如果请求路径中有参数，则通过方法参数中加入@RequestParam(“参数名”)来指定
 * – 5）在启动类中添加注解： @EnableFeignClients启用Feign客户端
 * – 6）直接调用接口中的方法进行微服务间的通讯
 */

//配置目标服务serviceid
//@FeignClient("service-b")
//  在降级的接口中，编写内部实现类：
//  @FeignClient("服务名",降级接口实现类.class)
@FeignClient(value = "service-b",fallback = ServiceBClient.ClientFallback.class)
public interface ServiceBClient {
//  配置目标方法的requestMapping
    @RequestMapping("/hello")
    public Map test();
//  方法中有参数时，和http协议样，需要加@RequestParam
    @RequestMapping("/emp")
    public RestResult find(@RequestParam("empno") Integer id);

//  在降级的接口中，编写内部实现类：
    @Component
    static class ClientFallback implements ServiceBClient{
        @Override
        public Map test() {
            return null;
        }

        @Override
        public RestResult find(Integer id) {
            RestResult restResult = new RestResult();
            restResult.setMsg("feign系统降级");
            EmpDTO dto = new EmpDTO();
            restResult.setData(dto);
            System.out.println(restResult.getMsg());
            return restResult;
        }
    }
}
