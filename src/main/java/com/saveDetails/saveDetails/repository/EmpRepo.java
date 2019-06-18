package com.saveDetails.saveDetails.repository;

import com.saveDetails.saveDetails.model.EmpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

public interface EmpRepo extends JpaRepository<EmpDetails,Integer> {
    @Modifying
    @Query(value = "INSERT INTO `emp_details`(`emp_id`, `name`, `designation`, `salary`) VALUES (?1,?2,?3,?4)",nativeQuery = true)
     void saveDetails(int empid,String name,String designation,int salary);
    @Query(value = "select * from emp_details where name = ?1",nativeQuery = true)
    EmpDetails findById(String name);
//    @Query(value = "select * from emp_details where name = ?1",nativeQuery = true)
//    EmpDetails fingByName(String name);
}
