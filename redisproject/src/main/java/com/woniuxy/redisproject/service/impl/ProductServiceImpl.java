package com.woniuxy.redisproject.service.impl;
import com.woniuxy.redisproject.dao.*;
import com.woniuxy.redisproject.pojo.*;
import com.woniuxy.redisproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCoverMapper productCoverMapper;
    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Autowired
    private ProductParamMapper productParamMapper;
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
        return productCoverMapper.selectProductCoverByProductId(id);
    }

    @Override
    @Cacheable(value = "params",key = "#id")
    public List<ProductParam> findParamsByPId(Integer id) {
        return productParamMapper.selectProductParamByProductId(id);
    }

    @Override
    @Cacheable(value = "details",key = "#id")
    public List<ProductDetail> findDetailByPId(Integer id) {
        return productDetailMapper.selectProductDetailByProductId(id);
    }

    @Override
    @Cacheable(value = "comments",key = "#id")
    public List<Comment> findCommentsByPId(Integer id) {
        return commentMapper.selectCommentByProductId(id);
    }
}
