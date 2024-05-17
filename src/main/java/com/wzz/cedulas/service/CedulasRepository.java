package com.wzz.cedulas.service;

import com.wzz.cedulas.resource.CedulasResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedulasRepository extends JpaRepository<CedulasResource, Long> {
}
