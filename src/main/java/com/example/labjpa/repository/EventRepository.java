package com.example.labjpa.repository;
import com.example.labjpa.entity.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long> {}
