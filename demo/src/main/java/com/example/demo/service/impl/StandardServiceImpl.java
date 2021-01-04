package com.example.demo.service.impl;

import com.example.demo.exception.FileUploadException;
import com.example.demo.mapper.StandardMapper;
import com.example.demo.pojo.Standard;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//添加业务层注解
@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    StandardMapper standardMapper;

    //  分页查询
    @Override
    public List<Standard> findStandards(Integer currentPage, Integer pageSize, String condition) {
        return standardMapper.queryStandardsPyPage(currentPage, pageSize, condition);
    }

    //  批量删除
    @Override
    public int removeBatch(Integer[] keys) {
        return standardMapper.deleteBatch(keys);
    }

    //  添加
    @Override
    public int addStandard(Standard standard, MultipartFile file, String path) {
        try {
            //  如果得到的文件非空，则执行归档和数据库信息添加操作
            if (!file.isEmpty()) {
                //  判断是否创建文件夹，不存在则直接创建
                File upload = new File(path);
                if (!upload.exists()) {
                    upload.mkdir();
                }
                //  获取得到文件的全名
                String filename = file.getOriginalFilename();
                System.out.println("filename:"+filename);
                //  获取日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
                //  将时间戳和文件名结合作为新文件名
                String newFilename = sdf.format(new Date()) + filename.substring(filename.lastIndexOf("."));
                System.out.println("newFilename:"+newFilename);
                //  将文件归档(路径：e:/upload/)，归档路径为固定路径下的新文件名
                file.transferTo(new File(path + File.separator + newFilename));
                System.out.println("文件路径:"+path + File.separator + newFilename);
                //  将路径添加到实体类中
                standard.setPackagepath(path + File.separator + newFilename);
                //  后将信息添加到数据库中
                standardMapper.insertSelective(standard);
                return 0;
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadException();
        }
    }

//  单个查询
    @Override
    public Standard findStandardById(Integer id) {
        return standardMapper.selectByPrimaryKey(id);
    }

}
