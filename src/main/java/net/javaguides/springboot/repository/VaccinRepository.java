package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.Vaccin;
import net.javaguides.springboot.model.Person;

public interface VaccinRepository extends JpaRepository<Vaccin, Long> {

}
