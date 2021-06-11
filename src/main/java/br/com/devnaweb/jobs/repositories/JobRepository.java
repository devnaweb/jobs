package br.com.devnaweb.jobs.repositories;

import br.com.devnaweb.jobs.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
