package com.evan.wj.dao;

import com.evan.wj.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:21
 * @Description:
 */
public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
