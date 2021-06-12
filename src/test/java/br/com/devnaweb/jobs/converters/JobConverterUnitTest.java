package br.com.devnaweb.jobs.converters;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.converters.JobConverter;
import br.com.devnaweb.jobs.entities.request.JobRequest;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JobConverterUnitTest {

    @Test
    void shouldConvertToResponseList() {
        final List<Job> jobs = JobFixture.defaultJobs();
        final List<JobResponse> jobResponses = JobConverter.toResponse(jobs);

        assertNotNull(jobResponses);
        assertThat(jobResponses.size(), is(jobs.size()));
    }

    @Test
    void shouldConvertToResponse() {
        final Job job = JobFixture.defaultJob();
        final JobResponse jobResponse = JobConverter.toResponse(job);

        assertNotNull(jobResponse);
        assertThat(jobResponse.getId(), is(job.getId()));
        assertThat(jobResponse.getOccupation(), is(job.getOccupation()));
        assertThat(jobResponse.getCompany(), is(job.getCompany()));
        assertThat(jobResponse.getSalary(), is(job.getSalary()));
        assertThat(jobResponse.isHomeOffice(), is(job.isHomeOffice()));
    }

    @Test
    void shouldCovertToEntity() {
        final JobRequest jobRequest = JobFixture.defaultJobRequest();
        final Job job = JobConverter.toEntity(jobRequest);

        assertNotNull(job);
        assertThat(job.getOccupation(), is(jobRequest.getOccupation()));
        assertThat(job.getCompany(), is(jobRequest.getCompany()));
        assertThat(job.getSalary(), is(jobRequest.getSalary()));
        assertThat(job.isHomeOffice(), is(jobRequest.isHomeOffice()));
    }
}
