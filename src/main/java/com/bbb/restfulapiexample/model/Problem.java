package com.bbb.restfulapiexample.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "code", referencedColumnName = "code", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<SubProblem> subProblems = new HashSet<>();

    public void addSubProblem(SubProblem subProblem) {
        this.subProblems.add(subProblem);
    }
}
