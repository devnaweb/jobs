package br.com.devnaweb.jobs.entities.converters;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.request.JobRequest;
import br.com.devnaweb.jobs.entities.response.JobResponse;

import java.util.List;
import java.util.stream.Collectors;

public class JobConverter {

    public static List<JobResponse> toResponse(final List<Job> jobs) {
        return jobs.stream().map(job ->
                JobResponse.builder()
                        .id(job.getId())
                        .occupation(job.getOccupation())
                        .company(job.getCompany())
                        .salary(job.getSalary())
                        .isHomeOffice(job.isHomeOffice())
                        .build())
                .collect(Collectors.toList());
    }

    public static JobResponse toResponse(final Job job) {
        return JobResponse.builder()
                .id(job.getId())
                .occupation(job.getOccupation())
                .company(job.getCompany())
                .salary(job.getSalary())
                .isHomeOffice(job.isHomeOffice())
                .build();
    }

    public static Job toEntity(final JobRequest jobRequest) {
        return Job.builder()
                .occupation(jobRequest.getOccupation())
                .company(jobRequest.getCompany())
                .salary(jobRequest.getSalary())
                .isHomeOffice(jobRequest.isHomeOffice())
                .build();
    }
}
