package com.example.demo.controller;

import com.example.demo.pojo.Standard;
import com.example.demo.service.StandardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StandardController {
    @Autowired
    StandardService standardService;
    @Value("${filepath}")
    private String filepath;
//  分页展示
//  获取Get方法传来的currentPage和pageSize和condition参数，并赋予默认值
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "currentPage", defaultValue = "1", required = false)Integer currentPage,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "5") Integer pageSize,
                             String condition){
        //  执行分页查询
        List<Standard> list = standardService.findStandards(currentPage, pageSize, condition);
        //  将查询结果封装到PageInfo对象中
        PageInfo<Standard> pageInfo = new PageInfo<>(list);
        //  将结果装入mv
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("condition",condition);
        return mv;
    }
//  批量删除
//  异步操作，从前端获取id数组，并返回结果
    @ResponseBody
    @DeleteMapping("/deleteStandard")
    public Map delete(Integer[] keys){
        Map map = new HashMap();
        try {
            standardService.removeBatch(keys);
            map.put("code","0");
            map.put("msg","删除成功");
        } catch (Exception e) {
            map.put("code","500");
            map.put("msg","删除失败");
            e.printStackTrace();
        }
        return map;
    }
//  新增标准
    @ResponseBody
    @PostMapping("/saveStandard")
    public Map save(Standard standard,@RequestParam("file") MultipartFile file){
        Map map = new HashMap();
        try {
            standardService.addStandard(standard, file, filepath);
            map.put("code","0");
            map.put("msg","上传成功");
        } catch (Exception e) {
            map.put("code","500");
            map.put("msg","上传失败");
            e.printStackTrace();
        }
        return map;
    }
//  下载标准
    @ResponseBody
    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id")Integer id){
        //  获取对应的标准信息
        Standard standard = standardService.findStandardById(id);
        //  获取存储路径
        String packagepath = standard.getPackagepath();
        //  按路径读取并返回文件
        try {
            //  按路径获取输入流
           InputStream inputStream = new FileInputStream(new File(packagepath));
            //  按路径获取输入流
            //available();获取字节流中可读取的数据长度
            byte[] body = new byte[inputStream.available()];
            inputStream.read(body);
            HttpHeaders headers = new HttpHeaders();
            //  以附件形式返回
            //  获取文件名称
            //  1.以存储路径中的名称作为返回的文件名
            String name = packagepath.substring(packagepath.lastIndexOf("\\")+1);
            //  2.以数据库中指定字段组合出文件名
//            name = standard.getZhname()+standard.getStdnum();
//          将传输数据格式化
            headers.setContentDispositionFormData("attachment",new String(name.getBytes("utf-8"),"ISO8859-1"));
//          创建传输对象类
            ResponseEntity<byte[]> entity = new ResponseEntity<>(body,headers, HttpStatus.OK);
            return entity;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
