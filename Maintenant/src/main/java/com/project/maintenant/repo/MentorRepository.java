package com.project.maintenant.repo;

import com.project.maintenant.model.entities.Mentee;
import com.project.maintenant.model.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor,Long>
{
    Mentor findByEmail(String email);
    Mentor findByEmailAndPassword(String email,String password);
    List<Mentor> findAllById(Long id);
    List<Mentor> getByUsername(String username);
}
