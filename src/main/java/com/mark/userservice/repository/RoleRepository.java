package com.mark.userservice.repository;

import com.mark.userservice.domain.Role;
import com.mark.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

