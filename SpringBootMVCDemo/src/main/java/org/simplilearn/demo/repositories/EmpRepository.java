package org.simplilearn.demo.repositories;

import org.simplilearn.demo.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
