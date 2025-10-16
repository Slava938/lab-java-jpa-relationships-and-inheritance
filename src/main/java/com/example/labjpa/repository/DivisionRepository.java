package com.example.labjpa.repository;
import com.example.labjpa.entity.association.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrictIgnoreCase(String district);
}
