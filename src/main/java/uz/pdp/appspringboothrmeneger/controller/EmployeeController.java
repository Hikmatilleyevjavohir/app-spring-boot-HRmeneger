package uz.pdp.appspringboothrmeneger.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringboothrmeneger.dto.SalaryDto;
import uz.pdp.appspringboothrmeneger.entity.EmpResponse;
import uz.pdp.appspringboothrmeneger.entity.Response;
import uz.pdp.appspringboothrmeneger.service.EmployeeService;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public HttpEntity<?> findAll() {
        Response response = employeeService.findAllEmployees();
        return ResponseEntity.status(response.isSuccess() ? 200 : 401).body(response);
    }

    @PostMapping("/salary")
    public HttpEntity<?> payMonthly(@RequestBody SalaryDto salaryDto) {
        Response response = employeeService.payMonthly(salaryDto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 401).body(response);
    }

    @GetMapping("/byTurniketTask")
    public HttpEntity<?> getAllCompletedTaskByTime(@RequestParam UUID employeeId,
                                                   @RequestParam Timestamp startDateTime,
                                                   @RequestParam Timestamp finishDateTime) {
        EmpResponse response = employeeService.findOneByData(employeeId, startDateTime, finishDateTime);
        return ResponseEntity.status(response.isSuccess() ? 200 : 401).body(response);

    }

    @GetMapping("/salary/byMonthDay")
    public HttpEntity<?> getSalariesByMonth(@RequestParam String year,  @RequestParam Integer monthNumber) {
        Response response = employeeService.getSalariesByMonth(year, monthNumber);
        return ResponseEntity.status(response.isSuccess() ? 200 : 401).body(response);
    }

    @GetMapping("/salary/{id}")
    public HttpEntity<?> getSalariesByEmployeeId(@PathVariable UUID id) {
        Response response = employeeService.getSalariesByUserId(id);
        return ResponseEntity.status(response.isSuccess() ? 200 : 401).body(response);
    }

}
