package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ListJobsUnitTest {

    @InjectMocks
    private ListJobs listJobs;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Deve ser possível listar as vagas")
    void shouldListJobs() {
        when(jobRepository.findAll()).thenReturn(JobFixture.defaultJobs());

        final List<JobResponse> jobResponseList = listJobs.execute();

        assertNotNull(jobResponseList);
        assertThat(jobResponseList.size(), is(3));
    }
}
