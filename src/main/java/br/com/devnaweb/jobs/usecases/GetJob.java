package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetJob {

    @Autowired
    private JobRepository jobRepository;

    public JobResponse execute(final Long id) throws JobNotFoundException {
        return JobConverter.toResponse(jobRepository.findById(id).orElseThrow(JobNotFoundException::new));
    }
}
