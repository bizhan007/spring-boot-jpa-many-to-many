package com.springbootjpamanytomany.repository;

import com.springbootjpamanytomany.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);
    void deleteRoleById(Long id);

}
