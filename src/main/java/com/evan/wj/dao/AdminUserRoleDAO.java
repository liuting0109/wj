package com.evan.wj.dao;

import com.evan.wj.pojo.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:25
 * @Description:
 */
public interface AdminUserRoleDAO extends JpaRepository<AdminUserRole,Integer> {
    List<AdminUserRole> findAllByUid(int uid);
    void deleteAllByUid(int uid);
}
