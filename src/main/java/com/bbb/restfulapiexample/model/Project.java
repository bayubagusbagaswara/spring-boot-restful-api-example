package com.bbb.restfulapiexample.model;

import com.bbb.restfulapiexample.model.audit.AuditModel;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "project_code_unique", columnNames = "code")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, length = 6)
    private String code;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Problem> problems = new HashSet<>();

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public String firstCode() {
        return randomCode();
    }

    public String randomCode() { //6자리 인증
        Random rnd = new Random();
        StringBuilder buf = new StringBuilder();
        for(int i=0; i<6; i++){
            if(rnd.nextBoolean())
                buf.append((char)(rnd.nextInt(26) + 97));
            else
                buf.append((rnd.nextInt(10)));
        }
        return buf.toString();
    }
}
