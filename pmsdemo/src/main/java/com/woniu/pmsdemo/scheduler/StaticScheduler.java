package com.woniu.pmsdemo.scheduler;

import com.woniu.pmsdemo.dao.ProductMapper;
import com.woniu.pmsdemo.pojo.*;
import com.woniu.pmsdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */
@Component
public class StaticScheduler {

    @Value("${static.path}")
    private String path;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    //任务调度：按照自定义的时间，自动触发任务的执行
    //@Scheduled(cron = "* 0/10 * * * ?")
    public void initStaticHtml() throws IOException {
        System.out.println("----------");
        List<Product> products = productMapper.queryProductLastUpdate();
        for (Product p : products) {
            List<ProductCover> covers = productService.findCoversByPId(p.getId());
            List<ProductParam> params = productService.findParamsByPId(p.getId());
            List<ProductDetail> details = productService.findDetailByPId(p.getId());
           // List<Comment> comments = productService.findCommentsByPId(p.getId());
            FileWriter writer = new FileWriter(new File(path,p.getId()+".html"));

            Context context = new Context();
            context.setVariable("product",p);
            context.setVariable("covers",covers);
            context.setVariable("params",params);
            context.setVariable("details",details);
            //context.setVariable("comments",comments);
            templateEngine.process("productdetail",context,writer);
        }
    }





}
