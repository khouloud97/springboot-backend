package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
  
	
		@Query("select p from Person p  where p.cp_fk=?1")
		List<Person> findbyvaccin(long id);
		
  }
