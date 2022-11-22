package uz.pdp.task_api_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NonNull
    private String fullName;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String addrese;

}
