package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateJob {

    @Autowired
    private JobRepository jobRepository;

    public JobResponse execute(final Long id, final Job job) throws JobNotFoundException {
        final Job savedJob = jobRepository.findById(id).orElseThrow(JobNotFoundException::new);
        return JobConverter.toResponse(jobRepository.save(
                savedJob.toBuilder()
                        .id(id)
                        .occupation(job.getOccupation())
                        .company(job.getCompany())
                        .salary(job.getSalary())
                        .isHomeOffice(job.isHomeOffice())
                        .build()
        ));
    }
}
