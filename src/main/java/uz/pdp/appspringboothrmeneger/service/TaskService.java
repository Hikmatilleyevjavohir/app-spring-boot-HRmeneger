package uz.pdp.appspringboothrmeneger.service;

import org.springframework.stereotype.Service;
import uz.pdp.appspringboothrmeneger.dto.TaskDto;
import uz.pdp.appspringboothrmeneger.entity.Response;

import java.util.UUID;

@Service
public interface TaskService {

    Response save(TaskDto taskDto);

    Response completeTask(Integer id, Integer taskStatus);

    Response checkEmployeeTask(UUID employeeId, Integer status);

}
