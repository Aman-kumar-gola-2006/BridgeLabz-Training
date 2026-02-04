package com.annotations.advancedlevel.roleallowed;

public class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser(String role) {
        if (!role.equals("ADMIN")) {
            System.out.println("Access Denied!");
            return;
        }
        System.out.println("User deleted");
    }
}