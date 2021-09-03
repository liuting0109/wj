package com.evan.wj.dao;

import com.evan.wj.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: liuting
 * @Date: 2021/9/2 17:22
 * @Description:
 */
public interface AdminMenuDAO extends JpaRepository<AdminMenu, Integer> {
    AdminMenu findById(int id);
    List<AdminMenu> findAllByParentId(Integer parentId);
}