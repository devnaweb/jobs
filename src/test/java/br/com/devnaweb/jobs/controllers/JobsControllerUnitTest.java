package br.com.devnaweb.jobs.controllers;

import br.com.devnaweb.jobs.entities.response.JobResponse;
import br.com.devnaweb.jobs.fixtures.JobFixture;
import br.com.devnaweb.jobs.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class JobsControllerUnitTest extends AbstractControllerTest {

    @InjectMocks
    private JobsController jobsController;

    @Mock
    private CreateJob createJob;

    @Mock
    private DeleteJob deleteJob;

    @Mock
    private GetJob getJob;

    @Mock
    private ListJobs listJobs;

    @Mock
    private UpdateJob updateJob;

    @BeforeEach
    void setUp() {
        this.setUp(jobsController);
    }

    @Test
    void shouldCreateJob() throws Exception {
        final JobResponse jobResponse = JobFixture.defaultJobResponse();
        when(createJob.execute(any())).thenReturn(jobResponse);

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(JobFixture.defaultJobRequest()))
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.occupation").value("Engenheiro de Software"))
                .andExpect(jsonPath("$.company").value("Amazon"))
                .andExpect(jsonPath("$.salary").value(10000.00))
                .andExpect(jsonPath("$.homeOffice").value(true));
    }

    @Test
    void shouldDeleteJob() throws Exception {
        mockMvc.perform(delete("/{id}", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldGetJob() throws Exception {
        final JobResponse jobResponse = JobFixture.defaultJobResponse();
        when(getJob.execute(any())).thenReturn(jobResponse);

        mockMvc.perform(get("/{id}", "4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldListJobs() throws Exception {
        final JobResponse jobResponse = JobFixture.defaultJobResponse();
        when(listJobs.execute()).thenReturn(Collections.singletonList(jobResponse));

        mockMvc.perform(get("/", "4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateJob() throws Exception {
        final JobResponse jobResponse = JobFixture.defaultJobResponse();
        when(updateJob.execute(any(), any())).thenReturn(jobResponse);

        mockMvc.perform(put("/{id}", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(JobFixture.defaultJobRequest()))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }
}
