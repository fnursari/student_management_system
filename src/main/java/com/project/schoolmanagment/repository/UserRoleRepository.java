package com.project.schoolmanagment.repository;

import com.project.schoolmanagment.entity.concretes.UserRole;
import com.project.schoolmanagment.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

    @Query("SELECT r FROM UserRole r WHERE r.roleType = ?1") //-- ?1 this is the first parameter
    Optional<UserRole> findByEnumRoleEquals(RoleType roleType);

    @Query("SELECT (count (r)>0) FROM UserRole r WHERE r.roleType = ?1")
    boolean existsByEnumRoleEquals(RoleType roleType);
}
