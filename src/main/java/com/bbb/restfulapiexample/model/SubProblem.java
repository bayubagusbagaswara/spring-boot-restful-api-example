package com.bbb.restfulapiexample.model;

import com.bbb.restfulapiexample.model.audit.AuditModel;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sub_problem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubProblem extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_problem", referencedColumnName = "id", nullable = false)
    private Problem problem;

    @Column(name = "content", nullable = false, length = 200)
    private String content;

    @Column(name = "count")
    private long count = 0;
}
