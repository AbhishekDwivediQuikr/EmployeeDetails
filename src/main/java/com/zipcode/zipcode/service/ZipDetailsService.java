package com.zipcode.zipcode.service;

import com.zipcode.zipcode.model.EmpDetails;
import com.zipcode.zipcode.model.ZipDetails;
import com.zipcode.zipcode.repository.ZipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipDetailsService {
    @Autowired
    ZipRepo zrepo;
    public List<ZipDetails> zipService(int zipcode)
    {
        return zrepo.findByZipcode(zipcode);
    }
    public String EmpDetailsService(EmpDetails empDetails)
    {
        int salary=empDetails.getSalary();
        if(salary<=1100000){
            empDetails.setDesignation("Assosciate Software Engineer");
            return "Assosciate Software Engineer";
        }
        else if((salary>1100000)&&(salary<=1500000))
        {
            empDetails.setDesignation("Software Engineer");
            return "Software Engineer";
        }
        else
        {
            empDetails.setDesignation("Senior Software Engineer");
            return "Senior Software Engineer";
        }
    }
}
