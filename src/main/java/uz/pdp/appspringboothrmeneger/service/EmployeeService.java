package uz.pdp.appspringboothrmeneger.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.appspringboothrmeneger.dto.SalaryDto;
import uz.pdp.appspringboothrmeneger.entity.EmpResponse;
import uz.pdp.appspringboothrmeneger.entity.Response;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public interface EmployeeService {

    Response findAllEmployees();

    EmpResponse findOneByData(UUID id, Timestamp start, Timestamp end);
    Response payMonthly(SalaryDto salaryDto);

    Response getSalariesByMonth(String year, Integer monthNumber);

    Response getSalariesByUserId(UUID id);

}
