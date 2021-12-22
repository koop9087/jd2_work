package by.academy.it.repository;

import by.academy.it.pojo.UserRole;

import java.io.Serializable;

public interface RoleDao {
   UserRole getById(Long id);

   Serializable saveRole(UserRole userRole);
}
