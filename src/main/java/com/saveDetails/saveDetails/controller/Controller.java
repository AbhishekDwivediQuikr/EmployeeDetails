package com.saveDetails.saveDetails.controller;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.saveDetails.saveDetails.model.EmpDetails;
import com.saveDetails.saveDetails.service.SaveDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/save")
public class Controller {
    @Autowired
    SaveDetailsService saveDetailsService;
    @RequestMapping(value = "/details",method = RequestMethod.POST ,headers = "Accept=application/json")
    @ResponseBody
    public String saveDetails(@RequestBody EmpDetails empDetails)throws JSONException
    {
        JSONObject js =new JSONObject();
        if(CheckById(empDetails)==false)
        {
            saveDetailsService.detailsService(empDetails);
           // EmpDetails newdetails = saveDetailsService.allDetails(empDetails.getName());

            js.put("Name",empDetails.getName());
            js.put("EmpId",empDetails.getEmpid());
           js.put("Designation",empDetails.getDesignation());
            js.put("salary",empDetails.getSalary());
        }
        else
        {
            js.put("Status",0);
        }
        System.out.println(js.toString());
        return (js.toString());

    }
    public Boolean CheckById(EmpDetails empDetails)
    {
        return saveDetailsService.checkByName(empDetails);
    }
}
