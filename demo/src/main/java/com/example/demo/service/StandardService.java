package com.example.demo.service;

import com.example.demo.pojo.Standard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StandardService {
    /*
    *@Description 分页加载标准信息数据
    *@param currentPage 当前页
    *@param pageSize 页大小
    *@param condition 查询条件
    *@return 标准信息集合
    *@date 2019/9/21 0:56
    *@author Administrator
    */
    public List<Standard> findStandards(Integer currentPage, Integer pageSize, String condition);
    /*
     *@Description 批量删除
     *@param keys 对象ID数组
     *@return 处理执行结果
     *@date 2019/9/21 0:56
     *@author Administrator
     */
    public int removeBatch(Integer[] keys);
    /*
     *@Description 新增标准信息
     *@param standard 标准信息对象
     *@return 添加执行结果
     *@date 2019/9/21 0:56
     *@author Administrator
     */
    public int addStandard(Standard standard, MultipartFile file, String path);
    /*
     *@Description 根据ID查询对象
     *@param id 标准信息对象ID
     *@return 添加执行结果
     *@date 2019/9/21 0:56
     *@author Administrator
     */
    public Standard findStandardById(Integer id);

}
