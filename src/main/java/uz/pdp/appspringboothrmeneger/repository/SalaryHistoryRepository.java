package uz.pdp.appspringboothrmeneger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringboothrmeneger.entity.SalaryHistory;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Repository
public interface SalaryHistoryRepository extends JpaRepository<SalaryHistory, Integer> {

    List<SalaryHistory> findAllByEmployeeId(UUID employee_id);

    List<SalaryHistory> findAllByWorkStartDate(Date workStartDate);



}
