package com.example.labjpa.repository;
import com.example.labjpa.entity.event.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConferenceRepository extends JpaRepository<Conference, Long> {}
