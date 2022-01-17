package com.springbootjpamanytomany.controller;

import com.springbootjpamanytomany.model.Role;
import com.springbootjpamanytomany.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAllRoles();
        if (roles == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> createRole(@RequestBody @Valid Role role) {
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        role.setCreated(new Timestamp(System.currentTimeMillis()));
        role.setUpdated(new Timestamp(System.currentTimeMillis()));
        roleService.createRole(role);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role role) {
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        role.setUpdated(new Timestamp(System.currentTimeMillis()));
        roleService.updateRole(role);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> deleteRoleById(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        roleService.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
}
