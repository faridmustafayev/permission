package com.example.permission.checking.mapper;

import com.example.permission.checking.dao.entity.UserPermissionEntity;
import com.example.permission.checking.model.CheckPermissionDto;

public enum UserPermissionMapper {
    USER_PERMISSION_MAPPER;

    public UserPermissionEntity buildPermissionEntity(CheckPermissionDto dto) {
        return UserPermissionEntity.builder()
                .userId(dto.getUserId())
                .permissionName(dto.getPermissionName())
                .productName(dto.getProductName())
                .build();
    }
}
