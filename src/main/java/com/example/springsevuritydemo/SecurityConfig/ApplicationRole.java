package com.example.springsevuritydemo.SecurityConfig;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.springsevuritydemo.SecurityConfig.UserPermission.*;

public enum ApplicationRole {
    ADMIN(Sets.newHashSet()),
    STUDENT(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ,COURSE_WRITE));

    private final Set<UserPermission> permissions;

    ApplicationRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
