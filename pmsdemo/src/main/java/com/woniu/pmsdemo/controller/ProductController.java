package com.woniu.pmsdemo.controller;

import com.woniu.pmsdemo.pojo.*;
import com.woniu.pmsdemo.service.OrderService;
import com.woniu.pmsdemo.service.ProductService;
import com.woniu.pmsdemo.service.PromotionsSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */
@Controller
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PromotionsSeckillService promotionsSeckillService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        Product product = productService.findProductById(id);
        List<ProductCover> covers = productService.findCoversByPId(id);
        List<ProductParam> params = productService.findParamsByPId(id);
        List<ProductDetail> details = productService.findDetailByPId(id);
        //List<Comment> comments = productService.findCommentsByPId(id);
        ModelAndView modelAndView = new ModelAndView("productdetail");
        modelAndView.addObject("product",product);
        modelAndView.addObject("covers",covers);
        modelAndView.addObject("params",params);
        modelAndView.addObject("details",details);
       // modelAndView.addObject("comments",comments);
        return modelAndView;
    }


    @RequestMapping("/create/{id}")
    @ResponseBody
    public String createHtml(@PathVariable("id") Integer id) throws IOException {
        Product product = productService.findProductById(id);
        List<ProductCover> covers = productService.findCoversByPId(id);
        List<ProductParam> params = productService.findParamsByPId(id);
        List<ProductDetail> details = productService.findDetailByPId(id);
        List<Comment> comments = productService.findCommentsByPId(id);
        Context context = new Context();
        context.setVariable("product",product);
        context.setVariable("covers",covers);
        context.setVariable("params",params);
        context.setVariable("details",details);
        context.setVariable("comments",comments);
        File path = new File("e:\\temp\\detail");
        if(!path.exists()){
            path.mkdirs();
        }
        FileWriter writer = new FileWriter(new File(path,id+".html"));
        templateEngine.process("productdetail",context,writer);
        return "ok";
    }

    @RequestMapping("/loadComment")
    @ResponseBody
    public List<Comment> loadComment(Integer pid){
        List<Comment> comments = productService.findCommentsByPId(pid);
        return comments;
    }

    /**
     * 加载redis数据库中的秒杀活动数据
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        Map result = redisTemplate.opsForHash().entries("seckillproducts");
        ModelAndView modelAndView = new ModelAndView("seckillproduct");
        modelAndView.addObject("seckillProducts",result);
        return modelAndView;
    }


    @RequestMapping("/seckillProductDetail/{pid}/{psId}")
    public ModelAndView seckillProductDetail(@PathVariable("pid") Integer productId,@PathVariable("psId") Integer psId){
        Product product = productService.findProductById(productId);
        List<ProductCover> covers = productService.findCoversByPId(productId);
        List<ProductParam> params = productService.findParamsByPId(productId);
        List<ProductDetail> details = productService.findDetailByPId(productId);
        List<Comment> comments = productService.findCommentsByPId(productId);
        ModelAndView modelAndView = new ModelAndView("seckillDetail");
        modelAndView.addObject("product",product);
        modelAndView.addObject("covers",covers);
        modelAndView.addObject("params",params);
        modelAndView.addObject("details",details);
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("psId",psId);
        return modelAndView;
    }


    //秒杀商品
    @RequestMapping("/processSeckill")
    @ResponseBody
    public Map processSeckill(Long psId,Integer userId){
        Map result = new HashMap();
        try {
            promotionsSeckillService.process(psId,userId);
            //处理用户下单的业务
            String orderNO = promotionsSeckillService.sendOrderToQueue(userId);
            System.out.println("---->"+orderNO);
            result.put("code","0");
            result.put("data",orderNO);
            result.put("message","success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","500");
            result.put("message",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/showOrder")
    public ModelAndView showOrder(String orderNO){
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findOrderByNo(orderNO);
        if(order != null){
            modelAndView.setViewName("order");
            modelAndView.addObject("order",order);
        }else{
            modelAndView.setViewName("wait");
            modelAndView.addObject("orderNO",orderNO);
        }
        return modelAndView;
    }
}
