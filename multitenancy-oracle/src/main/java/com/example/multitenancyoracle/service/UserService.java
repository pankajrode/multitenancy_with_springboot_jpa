/**
 * 
 */
package com.example.multitenancyoracle.service;

import com.example.multitenancyoracle.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Service definition which accesses the {@link com.example.multitenancyoracle.model.User} entity.
 * This is the recommended way to access the entities through an interface
 * rather than using the corresponding repository directly. This allows for
 * separation into repository code and the service layer.
 * 
 * @author Sunit Katkar
 * @version 1.0
 * @since 1.0 (April 2018)
 */
public interface UserService {

    void save(User user);

    String findLoggedInUsername();

    @Query("select p from User p where p.username = :username and p.tenant = :tenant")
    User findByUsernameAndTenantname(@Param("username") String username, @Param("tenant") String tenant);
}
