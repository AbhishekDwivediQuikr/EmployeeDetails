package com.zipcode.zipcode.repository;

import com.zipcode.zipcode.model.ZipDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZipRepo extends JpaRepository<ZipDetails,Integer> {
    @Query(value = "select * from zip_details where zipcode = ?1",nativeQuery = true)
     List<ZipDetails> findByZipcode(int zipcode);
}
