package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:22
 * @Description:
 */
public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
