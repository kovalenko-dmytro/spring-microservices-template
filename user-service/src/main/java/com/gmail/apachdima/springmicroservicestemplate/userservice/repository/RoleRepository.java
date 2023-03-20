package com.gmail.apachdima.springmicroservicestemplate.userservice.repository;

import com.gmail.apachdima.springmicroservicestemplate.userservice.model.Role;
import com.gmail.apachdima.springmicroservicestemplate.userservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(UserRole user);
}
