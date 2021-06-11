package br.com.devnaweb.jobs.entities.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class JobResponse {
    private Long id;
    private String occupation;
    private String company;
    private double salary;
    private boolean isHomeOffice;
}
