package br.com.devnaweb.jobs.controllers;

import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.request.JobRequest;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController {

    @Autowired
    private CreateJob createJob;

    @Autowired
    private DeleteJob deleteJob;

    @Autowired
    private GetJob getJob;

    @Autowired
    private ListJobs listJobs;

    @Autowired
    private UpdateJob updateJob;

    @PostMapping("/")
    public ResponseEntity<JobResponse> createJob(@RequestBody final JobRequest jobRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createJob.execute(JobConverter.toEntity(jobRequest)));
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable final Long id) throws JobNotFoundException {
        deleteJob.execute(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJob(@PathVariable final Long id) throws JobNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(getJob.execute(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<JobResponse>> listJobs() {
        return ResponseEntity.status(HttpStatus.OK).body(listJobs.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobResponse> updateJob(@PathVariable final Long id, @RequestBody final JobRequest jobRequest) throws JobNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(updateJob.execute(id, JobConverter.toEntity(jobRequest)));
    }
}
