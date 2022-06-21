package com.octo.octoTestProject.repository;

import com.octo.octoTestProject.model.domain.Role;
import com.octo.octoTestProject.model.enums.RoleName;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Set<Role> findAllByRoleName(RoleName roleName);
}
