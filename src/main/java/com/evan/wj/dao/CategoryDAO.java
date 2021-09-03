package com.evan.wj.dao;

import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liuting
 * @Date: 2021/8/27 15:07
 * @Description:
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
