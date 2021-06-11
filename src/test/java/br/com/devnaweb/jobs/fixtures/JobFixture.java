package br.com.devnaweb.jobs.fixtures;

import br.com.devnaweb.jobs.entities.Job;

import java.util.Arrays;
import java.util.List;

public class JobFixture {

    public static Job defaultJob() {
        return Job.builder()
                .id(1L)
                .occupation("Engenheiro de Software")
                .company("Amazon")
                .salary(10000.00)
                .isHomeOffice(true)
                .build();
    }

    public static List<Job> defaultJobs() {
        return Arrays.asList(defaultJob(), defaultJob(), defaultJob());
    }
}
