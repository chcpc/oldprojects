package com.woniu.pmsdemo.service.impl;

import com.woniu.pmsdemo.dao.*;
import com.woniu.pmsdemo.pojo.*;
import com.woniu.pmsdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper detailMapper;

    @Autowired
    private ProductParamMapper productParamMapper;

    @Autowired
    private ProductCoverMapper coverMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    @Cacheable(value = "product",key = "#id")
    public Product findProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "covers",key = "#id")
    public List<ProductCover> findCoversByPId(Integer id) {
        return coverMapper.queryCoversByProductId(id);
    }

    @Override
    @Cacheable(value = "params",key = "#id")
    public List<ProductParam> findParamsByPId(Integer id) {
        return productParamMapper.queryByProductId(id);
    }

    @Override
    @Cacheable(value = "details",key = "#id")
    public List<ProductDetail> findDetailByPId(Integer id) {
        return detailMapper.queryByProductId(id);
    }

    @Override
    @Cacheable(value = "comments",key = "#id")
    public List<Comment> findCommentsByPId(Integer id) {
        return commentMapper.queryByProductId(id);
    }
}
