package com.loads.loads.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loads.loads.exception.ResourceNotFoundException;
import com.loads.loads.model.load;
import com.loads.loads.repository.repository;

@RestController
@RequestMapping("")
public class controller {
    @Autowired
    private repository userRepository;

    @GetMapping("/load")
    public List<load> getUsers() {
        return this.userRepository.findAll();
    }

    // create load rest api

    @PostMapping("/load")
    public load createEmployee(@Valid @RequestBody load employee) throws ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy"); // Format for input
        String date = employee.getDate();
        java.util.Date dn = dateParser.parse(date); // Parsing the date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); // Format for output
        employee.setDate(dateFormatter.format(dn));
        return userRepository.save(employee);
    }

    // get details by id rest api

    @GetMapping("/load/{id}")
    public ResponseEntity<load> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        load employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("truck not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    // update details rest api

    @PutMapping("/load/{id}")
    public ResponseEntity<load> updateEmployee(@PathVariable Long id, @Valid @RequestBody load loaddetails)
            throws ResourceNotFoundException, ParseException {
        load employee = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("truck not exist with id:" + id));
        employee.setLoadingPoint(loaddetails.getLoadingPoint());
        employee.setUnloadingPoint(loaddetails.getUnloadingPoint());
        employee.setProductType(loaddetails.getProductType());
        employee.setTruckType(loaddetails.getTruckType());
        employee.setNoOfTrucks(loaddetails.getNoOfTrucks());
        employee.setWeight(loaddetails.getWeight());
        employee.setComment(loaddetails.getComment());
        employee.setDate(loaddetails.getDate());
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy"); // Format for input
        String date = employee.getDate();
        java.util.Date dn = dateParser.parse(date); // Parsing the date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); // Format for output
        employee.setDate(dateFormatter.format(dn));
        load updatedEmployee = userRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api

    @DeleteMapping("/load/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {
        load employee = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        userRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
