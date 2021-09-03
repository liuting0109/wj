package com.evan.wj.service;

import com.evan.wj.dao.CategoryDAO;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuting
 * @Date: 2021/8/27 15:09
 * @Description:
 */

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
//        Sort sort = new Sort(Sort.Direction.DESC, "id");//由于jpa版本的原因 如果报错的话可能就是新版本中其构造方法为私有，
        return categoryDAO.findAll(sort);
    }


    public Category get(Integer id){
        Category c = categoryDAO.findById(id).orElse(null);
        return c;
    }
}
