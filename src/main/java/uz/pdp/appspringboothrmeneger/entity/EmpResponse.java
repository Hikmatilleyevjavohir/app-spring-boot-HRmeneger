package uz.pdp.appspringboothrmeneger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpResponse {

    private String message;
    private boolean success;
    private List<Turniket> turniketList;
    private List<Task> taskList;

    public EmpResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
