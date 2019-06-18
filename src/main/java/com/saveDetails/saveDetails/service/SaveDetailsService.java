package com.saveDetails.saveDetails.service;

import com.saveDetails.saveDetails.model.EmpDetails;
import com.saveDetails.saveDetails.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SaveDetailsService {
    @Autowired
    EmpRepo erepo;
    @Transactional
    public void detailsService(EmpDetails empDetails)
    {
        if(empDetails.getSalary()<=1400000)
        {
            empDetails.setDesignation("Associate Software Engineer");
        }
        else if((empDetails.getSalary()>1400000)&&(empDetails.getSalary()<=2000000))
        {
            empDetails.setDesignation("Software Engineer");
        }
        else
        {
            empDetails.setDesignation("Senior Software Engineer");
        }

        System.out.println(empDetails.getEmpid());
        erepo.saveDetails(empDetails.getEmpid(),empDetails.getName(),empDetails.getDesignation(),empDetails.getSalary());
    }
    public boolean checkByName(EmpDetails empDetails)
    {
        int i=-1;
        EmpDetails newDetails=erepo.findById(empDetails.getName());
        System.out.println("i== "+i);
        if(newDetails!=null)
        {
            return true;
        }
        return false;
    }

}
