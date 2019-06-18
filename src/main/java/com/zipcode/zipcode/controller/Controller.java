package com.zipcode.zipcode.controller;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.zipcode.zipcode.model.EmpDetails;
import com.zipcode.zipcode.model.ZipDetails;
import com.zipcode.zipcode.service.ZipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.tools.corba.se.idl.toJavaPortable.Arguments.Client;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/tools")
public class Controller {
    @Autowired
    ZipDetailsService zipDetailsService;
    @RequestMapping(value = "/codes",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String zipCodeDetails(String pincode) throws JSONException
    {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Quikr-Client","desktopsite");
        RestTemplate restTemplate = new RestTemplate();
       HttpEntity zcode=new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("pincode",pincode);

       // ResponseEntity<String> city = restTemplate.getForObject("http://localhost:7878/escrow/v1/getCityNameFromPincode",String.class,pincode);
        ResponseEntity<String> city = restTemplate.exchange("http://localhost:7878/escrow/v1/getCityNameFromPincode?pincode=" + pincode, HttpMethod.GET, zcode ,String.class, params);
        String c=city.getBody();
        JSONObject js=new JSONObject();
        js.put("City",c);

        return (js.toString());
    }
    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public @ResponseBody String empDetails(@RequestBody EmpDetails empDetails)
    {
        int i=empDetails.getEmpid();
        empDetails.setEmpid(i);
        System.out.println(empDetails.getEmpid());
        System.out.println(empDetails.getName());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://localhost:8090/save/details",empDetails,String.class);
        //return zipDetailsService.EmpDetailsService(empDetails);
        return result;
    }

    @RequestMapping(value = "/web")
    public String getWebPage() {
        return "web.html";
    }



}
