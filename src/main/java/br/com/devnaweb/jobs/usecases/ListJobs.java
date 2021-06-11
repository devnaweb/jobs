package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListJobs {
    @Autowired
    private JobRepository jobRepository;

    public List<JobResponse> execute()   {
        return JobConverter.toResponse(jobRepository.findAll());
    }
}
