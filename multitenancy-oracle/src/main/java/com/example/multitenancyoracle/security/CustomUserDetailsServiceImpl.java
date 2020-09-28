package com.example.multitenancyoracle.security;


import com.example.multitenancyoracle.model.CustomUserDetails;
import com.example.multitenancyoracle.model.Role;
import com.example.multitenancyoracle.model.User;
import com.example.multitenancyoracle.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsernameAndTenantname(String username, String tenantName) throws UsernameNotFoundException {
        if (StringUtils.isAnyBlank(username, tenantName)) {
            throw new UsernameNotFoundException("Username and domain must be provided");
        }

        // Look for the user based on the username and tenant by accessing the
        // UserRepository via the UserService
        User user = userService.findByUsernameAndTenantname(username, tenantName);

        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format("Username not found for domain, "
                            + "username=%s, tenant=%s", username, tenantName));
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        CustomUserDetails customUserDetails =
                new CustomUserDetails(user.getUsername(),
                        user.getPassword(), grantedAuthorities, tenantName);

        return customUserDetails;

    }
}
