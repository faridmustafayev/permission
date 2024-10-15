package com.example.permission.checking.controller;

import com.example.permission.checking.model.CheckPermissionDto;
import com.example.permission.checking.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/permission")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/check")
    public boolean checkPermission(@RequestBody CheckPermissionDto dto) {
        return permissionService.checkPermission(dto);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void savePermission(@RequestBody CheckPermissionDto dto) {
        permissionService.savePermission(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(CREATED)
    public void updatePermission(@PathVariable Long id, @RequestBody CheckPermissionDto dto) {
        permissionService.updatePermission(id, dto);
    }

}
