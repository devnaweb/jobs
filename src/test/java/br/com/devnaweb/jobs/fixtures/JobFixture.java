package br.com.devnaweb.jobs.fixtures;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.request.JobRequest;
import br.com.devnaweb.jobs.entities.response.JobResponse;

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

    public static JobResponse defaultJobResponse() {
        return JobResponse.builder()
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

    public static JobRequest defaultJobRequest() {
        return JobRequest.builder()
                .occupation("Engenheiro de Software")
                .company("Amazon")
                .salary(10000.00)
                .isHomeOffice(true)
                .build();
    }
}
