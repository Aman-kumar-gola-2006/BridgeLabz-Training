package com.annotations.advancedlevel.roleallowed;

import java.lang.reflect.Method;

public class RoleAllowedTest {

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();

        // Simulate logged-in user role
        String currentUserRole = "ADMIN";   // try "ADMIN" also

        // Get method reference
        Method method = AdminService.class.getMethod("deleteUser", String.class);

        // Check if @RoleAllowed is present
        if (method.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();

            // Validate access
            if (!allowedRole.equals(currentUserRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // Invoke method if access is allowed
        method.invoke(service, currentUserRole);
    }
}
