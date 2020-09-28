package com.example.multitenancyoracle.config;

import java.util.Map;
import javax.sql.DataSource;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class does the job of selecting the correct database based on the tenant
 * id found by the {@link CurrentTenantIdentifierResolverImpl}
 */

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = 1L;

    @Autowired
    private Map<String,DataSource> dataSourcesMtApp;

    @Override
    protected DataSource selectAnyDataSource() {
        return this.dataSourcesMtApp.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return this.dataSourcesMtApp.get(tenantIdentifier);
    }
}
