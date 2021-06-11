package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJob {

    @Autowired
    private JobRepository jobRepository;

    public JobResponse execute(final Job job) {
        return JobConverter.toResponse(jobRepository.save(job));
    }
}
