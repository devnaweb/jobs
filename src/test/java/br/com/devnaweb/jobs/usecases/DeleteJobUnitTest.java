package br.com.devnaweb.jobs.usecases;

import br.com.devnaweb.jobs.entities.Job;
import br.com.devnaweb.jobs.exceptions.JobNotFoundException;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeleteJobUnitTest {

    @InjectMocks
    private DeleteJob deleteJob;

    @Mock
    private JobRepository jobRepository;

    private final Job job = JobFixture.defaultJob();

    @Test
    @DisplayName("Deve ser possível excluir uma vaga")
    void shouldDeleteJob() throws JobNotFoundException {
        when(jobRepository.findById(anyLong())).thenReturn(Optional.of(job));

        deleteJob.execute(1L);

        verify(jobRepository).findById(any());
        verify(jobRepository).delete(any());
    }

    @Test
    @DisplayName("Deve ser recebido um erro ao tentar excluir uma vaga que não existe")
    void shouldFailWhenJobNotFound() {
        when(jobRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(JobNotFoundException.class, () -> {
            deleteJob.execute(4L);
        });

        verify(jobRepository).findById(anyLong());
        verify(jobRepository, times(0)).delete(any());
    }
}
