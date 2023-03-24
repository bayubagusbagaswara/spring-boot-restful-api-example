package com.bbb.restfulapiexample.repository;

import com.bbb.restfulapiexample.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {


}
