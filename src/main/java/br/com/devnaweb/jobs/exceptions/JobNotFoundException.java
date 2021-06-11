package br.com.devnaweb.jobs.exceptions;

import org.springframework.http.HttpStatus;

public class JobNotFoundException extends BaseBusinessException {

    public JobNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Job not found", false);
    }
}
