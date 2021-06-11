package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UpdateJobUnitTest {

    @InjectMocks
    private UpdateJob updateJob;

    @Mock
    private JobRepository jobRepository;

    private final Job job = JobFixture.defaultJob();

    @Test
    void shouldUpdateJob() throws JobNotFoundException {
        when(jobRepository.findById(any())).thenReturn(Optional.of(job));
        when(jobRepository.save(any())).thenReturn(job);

        final JobResponse jobResponse = updateJob.execute(1L, job);

        assertNotNull(jobResponse);
        assertThat(jobResponse.getId(), is(job.getId()));
        assertThat(jobResponse.getOccupation(), is(job.getOccupation()));
        assertThat(jobResponse.getCompany(), is(job.getCompany()));
        assertThat(jobResponse.getSalary(), is(job.getSalary()));
        assertThat(jobResponse.isHomeOffice(), is(job.isHomeOffice()));
        verify(jobRepository).findById(any());
        verify(jobRepository).save(any());
    }

    @Test
    void shouldFailWhenJobNotFound() {
        when(jobRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(JobNotFoundException.class, () -> {
            updateJob.execute(4L, job);
        });

        verify(jobRepository).findById(any());
        verify(jobRepository, times(0)).save(any());
    }
}
