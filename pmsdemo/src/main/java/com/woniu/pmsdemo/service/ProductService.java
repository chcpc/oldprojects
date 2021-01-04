package com.woniu.pmsdemo.service;

import com.woniu.pmsdemo.pojo.*;

import java.util.List;

public interface ProductService {
    Product findProductById(Integer id);

    List<ProductCover> findCoversByPId(Integer id);

    List<ProductParam> findParamsByPId(Integer id);

    List<ProductDetail> findDetailByPId(Integer id);

    List<Comment> findCommentsByPId(Integer id);
}
