package com.example.multitenancyoracle.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
    private static final long serialVersionUID = 1L;

    /**
     * The extra field in login form is for the tenant name
     */
    private String tenant;

    public CustomUserDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities, String tenant) {
        super(username, password, authorities);
        this.tenant = tenant;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
