package com.example.EmployeeSearchService.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeSearchService.domain.model.Employee;
import com.example.EmployeeSearchService.service.EmployeeSearchService;
@RefreshScope
@RestController
@EnableCircuitBreaker
public class EmployeeSearchController {
 @Autowired
 EmployeeSearchService employeeSearchService;
 @Value("${application.message}")
 String propName;
 
 @RequestMapping("/employee/find/{id}")
 public Employee findById(@PathVariable Long id) {
  Employee emp=employeeSearchService.findById(id);
  emp.setCompanyInfo(propName);
	return emp;
 }
 @RequestMapping("/employee/findall")
 public Collection < Employee > findAll() {
  return employeeSearchService.findAll();
 }
}