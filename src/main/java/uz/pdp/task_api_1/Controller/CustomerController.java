package uz.pdp.task_api_1.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task_api_1.Entity.Customer;
import uz.pdp.task_api_1.Service.CustomerService;
import uz.pdp.task_api_1.payload.ApiResponse;
import uz.pdp.task_api_1.payload.CustomerDto;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService coutomerService;

    @GetMapping("/api/customers")
    public List<Customer>  getAll(){
        List<Customer> customerList= coutomerService.getAll();
        return customerList;
    }
    @GetMapping("/api/customer/{id}")
    public  Customer getCustomer(@PathVariable Integer id) {
        Customer customer = coutomerService.getCustomerById(id);
        //  return id;
        return  customer;
    }
    @PostMapping("/api/customers/")
    public ApiResponse createCustomer(@RequestBody CustomerDto customerDto){
        ApiResponse apiResponse= coutomerService.addCustomer(customerDto);
        return  new  ApiResponse("Mijoz qoshildi ",true);
    }
}
