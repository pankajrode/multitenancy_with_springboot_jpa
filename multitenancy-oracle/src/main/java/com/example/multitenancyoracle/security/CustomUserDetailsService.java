package com.example.multitenancyoracle.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Sunit Katkar
 * @version 1.0
 * @since 1.0 (April 2018)
 *
 */
public interface CustomUserDetailsService {
    
    UserDetails loadUserByUsernameAndTenantname(String username, String tenantName) throws UsernameNotFoundException;
}
