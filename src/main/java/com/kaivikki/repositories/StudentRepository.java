package com.kaivikki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kaivikki.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query( "from Student")
	List<Student> findAllStudents();

	@Query("select firstName, lastName from Student")
	List<Object[]> findAllStudentFirstNameAndLastName();
	
	@Query("from Student where firstName=:firstName")
	List<Student> findStudentByFirstName(@Param("firstName") String firstName );
	
	@Modifying
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentByFirstName(@Param("firstName") String  firstName);
	
	@Query( value = "select * from student_t", nativeQuery = true)
	List<Student> findAllStudentsNQ();
	
}
