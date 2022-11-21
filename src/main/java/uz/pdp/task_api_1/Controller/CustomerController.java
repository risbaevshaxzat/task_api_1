package uz.pdp.task_api_1.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task_api_1.Entity.Customer;
import uz.pdp.task_api_1.Service.CustomerService;

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
    @GetMapping("/api.customer/{id}")
    public  Customer getCustomer(@PathVariable Integer id) {

        //  return id;
        return null;
    }
}
