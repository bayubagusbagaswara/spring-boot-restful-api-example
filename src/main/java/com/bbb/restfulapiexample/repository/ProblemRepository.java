package com.bbb.restfulapiexample.repository;

import com.bbb.restfulapiexample.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    @Query(value = "SELECT * FROM Problem p WHERE p.project.code = ?1", nativeQuery = true)
    List<Problem> findProblemByProjectCode(String code);


}
