package uz.pdp.task_api_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotBlank(message = "fullname  bolishi kerak")
    private String fullName;

    @NotBlank(message = "phoneNumber  bolishi kerak")
    private String phoneNumber;

    @NotBlank(message = "address bolishi kerak")
    private String addrese;

}
