package uz.pdp.userservice.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private Object object;

    public ApiResponse(String string, boolean b) {
        this.message = string;
        this.success = b;
    }
}
