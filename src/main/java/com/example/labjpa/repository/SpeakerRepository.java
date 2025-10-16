package com.example.labjpa.repository;
import com.example.labjpa.entity.event.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {}
