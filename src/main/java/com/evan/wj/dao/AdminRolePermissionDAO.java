package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:24
 * @Description:
 */
public interface AdminRolePermissionDAO extends JpaRepository<AdminRolePermission, Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    List<AdminRolePermission> findAllByRidIn(List<Integer> rids);
    void deleteAllByRid(int rid);
}
