package uz.pdp.task_api_1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_api_1.Entity.Customer;
import uz.pdp.task_api_1.Service.CustomerService;
import uz.pdp.task_api_1.payload.ApiResponse;
import uz.pdp.task_api_1.payload.CustomerDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@AllArgsConstructor
public class ControllerSecond {
    private final CustomerService coutomerService;

    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer> > getAll(){
        List<Customer> customerList= coutomerService.getAll();
        return  ResponseEntity.ok(customerList);
    }
    @GetMapping("/api/customer/{id}")
    public  ResponseEntity<?> getCustomer(@PathVariable Integer id) {
        Customer customer = coutomerService.getCustomerById(id);
        //  return id;
        return  ResponseEntity.ok(customer);
    }
    @PostMapping("/api/customer")
    public HttpEntity<?> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        ApiResponse apiResponse= coutomerService.addCustomer(customerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED :
                HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/api/customer/{id}")
    public ResponseEntity<?> editCustomer(@Valid @PathVariable Integer id , @RequestBody CustomerDto customerDto){
        ApiResponse apiResponse = coutomerService.editCustomer(id , customerDto);
        return  ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/api/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id ){
        ApiResponse apiResponse = coutomerService.deleteCust(id);
        return  ResponseEntity.ok(apiResponse);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
