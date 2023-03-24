package com.bbb.restfulapiexample.repository;

import com.bbb.restfulapiexample.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT * FROM Project p WHERE p.code = ?1", nativeQuery = true)
    Project getProject(String code);

    @Query(value = "SELECT * FROM Project p WHERE p.code = ?1", nativeQuery = true)
    Long getKeyByCode(String code);

    @Transactional
    void deleteByCode(String code);
}
