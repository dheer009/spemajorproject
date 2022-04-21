package com.project.maintenant.repo;

import com.project.maintenant.model.entities.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenteeRepository extends JpaRepository<Mentee, Long>
{
  Mentee findByEmail(String email);
  Mentee findByEmailAndPassword(String email,String password);
  List<Mentee> getByUsername(String username);

  List<Mentee> findAllById(Long id);
}
