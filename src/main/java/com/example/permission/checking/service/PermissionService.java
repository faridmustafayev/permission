package com.example.permission.checking.service;

import com.example.permission.checking.dao.entity.UserPermissionEntity;
import com.example.permission.checking.dao.repository.UserPermissionRepository;
import com.example.permission.checking.model.CheckPermissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.permission.checking.mapper.UserPermissionMapper.USER_PERMISSION_MAPPER;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final UserPermissionRepository userPermissionRepository;

    public boolean checkPermission(CheckPermissionDto dto) {
        var userPermission = userPermissionRepository
                .findByUserIdAndProductNameAndPermissionName(
                        dto.getUserId(),
                        dto.getProductName(),
                        dto.getPermissionName()
                );

        return userPermission.isPresent();
    }

    public void savePermission(CheckPermissionDto dto) {
        var userPermission = USER_PERMISSION_MAPPER.buildPermissionEntity(dto);
        userPermissionRepository.save(userPermission);
    }

    public void updatePermission(Long userId, CheckPermissionDto dto) {
        var user = fetchUserIfExist(userId);
        user.setPermissionName(dto.getPermissionName());
        user.setProductName(dto.getProductName());
        userPermissionRepository.save(user);
    }

    private UserPermissionEntity fetchUserIfExist(Long userId) {
        return userPermissionRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));
    }
}
