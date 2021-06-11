package br.com.devnaweb.jobs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "job")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Job {

    @Id
    @Column(name = "id")
    @JsonIgnore
    @GeneratedValue(generator = "job_sq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "is_home_office", nullable = false)
    private boolean isHomeOffice;
}
