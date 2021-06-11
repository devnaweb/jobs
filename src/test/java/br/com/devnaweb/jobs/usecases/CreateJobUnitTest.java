package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateJobUnitTest {

    @InjectMocks
    private CreateJob createJob;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Deve ser possível criar uma vaga")
    void shouldCreateJob() {
        final Job job = JobFixture.defaultJob();
        when(jobRepository.save(any())).thenReturn(job);

        final JobResponse createdJob = createJob.execute(job);

        assertNotNull(createdJob);
        assertThat(createdJob.getId(), is(job.getId()));
        assertThat(createdJob.getOccupation(), is(job.getOccupation()));
        assertThat(createdJob.getCompany(), is(job.getCompany()));
        assertThat(createdJob.getSalary(), is(job.getSalary()));
        assertThat(createdJob.isHomeOffice(), is(job.isHomeOffice()));
    }
}
