package com.evan.wj.service;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.dao.AdminRolePermissionDAO;
import com.evan.wj.pojo.AdminPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:27
 * @Description:
 */
@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDAO adminPermissionDAO;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;

    @Autowired
    UserService userService;

    public List<AdminPermission> list(){
        return adminPermissionDAO.findAll();
    }


}
