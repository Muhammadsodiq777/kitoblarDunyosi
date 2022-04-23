package uz.pdp.userservice.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponce {

    private String message;
    private boolean success;
    private Object object;

    public ApiResponce(String string, boolean b) {
        this.message = string;
        this.success = b;
    }
}
