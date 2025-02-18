package org.example.repository;

import org.example.entity.Chip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipRepository extends JpaRepository<Chip,Long> {}