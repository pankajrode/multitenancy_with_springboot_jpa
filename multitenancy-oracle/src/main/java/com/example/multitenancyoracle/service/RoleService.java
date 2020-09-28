
package com.example.multitenancyoracle.service;

import com.example.multitenancyoracle.model.Role;

/**
 * Service definition which accesses the {@link com.example.multitenancyoracle.model.Role} entity. This is the
 * recommended way to access the entities through an interface rather than using
 * the corresponding repository. This allows for separation into repository code
 * and the service layer.
 * 
 */
public interface RoleService {
    Role findByRole(String role);
}
