package com.multischema.tenant;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Tenant findByName(String name);
}
