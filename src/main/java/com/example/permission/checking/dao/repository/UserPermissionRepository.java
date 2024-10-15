package com.example.permission.checking.dao.repository;

import com.example.permission.checking.dao.entity.UserPermissionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserPermissionRepository extends CrudRepository<UserPermissionEntity, Long> {

    Optional<UserPermissionEntity> findByUserIdAndProductNameAndPermissionName(String userId,
                                                                               String productName,
                                                                               String permissionName);
}
