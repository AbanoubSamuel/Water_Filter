package com.aqua.prod.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)"; //Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REGISTER = "/auth/register"; // Public path that clients can use to register.
    public static final String CREATE_EMPLOYEE = "/employee/create"; // Public path that clients can use to register.
    public static final String LOGIN = "/auth/login"; // Public path that employee can use to register.
    public static final String ME = "/auth/me"; // Public path that clients can use to register.
    public static final String USER = "ROLE_user";
    public static final String ADMIN = "ROLE_admin";
    public static final String SUPERADMIN = "ROLE_superAdmin";
    public static final String ROOT = "ROLE_root";
}
