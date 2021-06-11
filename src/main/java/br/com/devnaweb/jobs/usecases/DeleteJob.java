package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteJob {

    @Autowired
    private JobRepository jobRepository;

    public void execute(final Long id) throws JobNotFoundException {
        jobRepository.delete(jobRepository.findById(id).orElseThrow(JobNotFoundException::new));
    }
}
