package br.com.devnaweb.jobs.entities.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class JobRequest {
    @NotNull
    private String occupation;

    @NotNull
    private String company;

    @NotNull
    private double salary;

    @NotNull
    private boolean isHomeOffice;
}
