package com.example.labjpa.repository;
import com.example.labjpa.entity.event.Guest;
import com.example.labjpa.entity.event.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
