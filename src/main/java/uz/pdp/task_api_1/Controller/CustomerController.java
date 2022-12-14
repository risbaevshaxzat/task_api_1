package uz.pdp.task_api_1.Controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;
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
public class CustomerController {

    private final CustomerService coutomerService;

    @GetMapping("/api/customers")
    public List<Customer>  getAll(){
        List<Customer> customerList= coutomerService.getAll();
        return customerList;
    }
    @GetMapping("/api/customers/{id}")
    public  Customer getCustomer(@PathVariable Integer id) {
        Customer customer = coutomerService.getCustomerById(id);
        //  return id;
        return  customer;
    }
    @PostMapping("/api/customers")
    public ApiResponse createCustomer(@Valid  @RequestBody CustomerDto customerDto){
        ApiResponse apiResponse= coutomerService.addCustomer(customerDto);
        return  new  ApiResponse("Mijoz qoshildi ",true);
    }

    @PutMapping("/api/customers/{id}")
    public ApiResponse editCustomer(@Valid @PathVariable Integer id , @RequestBody CustomerDto customerDto){
        ApiResponse apiResponse = coutomerService.editCustomer(id , customerDto);
        return  new ApiResponse("Mijoz yangilandi ", true);
    }

    @DeleteMapping("/api/customers/{id}")
    public ApiResponse deleteCustomer(@PathVariable Integer id ){
        ApiResponse apiResponse = coutomerService.deleteCust(id);
        return  apiResponse;

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
