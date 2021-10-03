package uz.pdp.appspringboothrmeneger.service;

import org.springframework.stereotype.Service;
import uz.pdp.appspringboothrmeneger.entity.Response;

@Service
public interface TurniketService {

    Response enterToWork();

    Response exitFromWork();
}
