package com.example.permission.checking.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_permissions")
public class UserPermissionEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String userId;

    private String productName;

    private String permissionName;
}
