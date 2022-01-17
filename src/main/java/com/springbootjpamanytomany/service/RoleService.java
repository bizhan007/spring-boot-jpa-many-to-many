package com.springbootjpamanytomany.service;

import com.springbootjpamanytomany.model.Role;

import java.util.List;

public interface RoleService {

    Role findRoleById(Long id);
    List<Role> findAllRoles();
    Role createRole(Role role);
    Role updateRole(Role role);
    void deleteRoleById(Long id);
    
}
