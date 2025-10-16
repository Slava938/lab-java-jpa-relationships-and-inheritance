package com.example.labjpa.repository;
import com.example.labjpa.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Long> {}
