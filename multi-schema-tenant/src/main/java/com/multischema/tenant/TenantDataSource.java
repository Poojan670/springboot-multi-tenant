package com.multischema.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class TenantDataSource implements Serializable {

    private HashMap<String, DataSource> dataSources = new HashMap<>();

    @Autowired
    private TenantRepository configRepo;

    public DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    //@PostConstruct
    public Map<String, DataSource> getAll() {
        List<Tenant> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (Tenant config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        return result;
    }

    private DataSource createDataSource(String name) {
        Tenant config = configRepo.findByName(name);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            if (config.getInitialize()) {
                initialize(ds);
            }
            return ds;
        }
        return null;
    }

    private void initialize(DataSource dataSource) {
        //ClassPathResource schemaResource = new ClassPathResource("schema.sql");
        //ClassPathResource dataResource = new ClassPathResource("data.sql");
        //ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schemaResource, dataResource);
        //populator.execute(dataSource);
    }


}
