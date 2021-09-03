package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liuting
 * @Date: 2021/9/3 15:27
 * @Description:
 */
@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;

    @Autowired
    UserService userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminMenuService adminMenuService;


}
