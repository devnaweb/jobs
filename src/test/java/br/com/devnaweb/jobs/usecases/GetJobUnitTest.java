package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetJobUnitTest {

    @InjectMocks
    private GetJob getJob;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Deve ser possível buscar uma vaga")
    void shouldGetJob() throws JobNotFoundException {
        final Job job = JobFixture.defaultJob();
        when(jobRepository.findById(any())).thenReturn(Optional.of(job));

        final JobResponse jobResponse = getJob.execute(1L);

        assertNotNull(jobResponse);
        assertThat(jobResponse.getId(), is(job.getId()));
        assertThat(jobResponse.getOccupation(), is(job.getOccupation()));
        assertThat(jobResponse.getCompany(), is(job.getCompany()));
        assertThat(jobResponse.getSalary(), is(job.getSalary()));
        assertThat(jobResponse.isHomeOffice(), is(job.isHomeOffice()));
    }

    @Test
    @DisplayName("Deve ser recebido um erro ao tentar buscar uma vaga que não existe")
    void shouldFailWhenJobNotFound() {
        when(jobRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(JobNotFoundException.class, () -> {
            getJob.execute(4L);
        });

        verify(jobRepository).findById(any());
    }
}
