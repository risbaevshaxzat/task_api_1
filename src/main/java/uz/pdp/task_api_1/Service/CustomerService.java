package uz.pdp.task_api_1.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.task_api_1.Entity.Customer;
import uz.pdp.task_api_1.Repo.CustomerRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    public List<Customer> getAll(){
       List<Customer> customerList = customerRepo.findAll();
       return customerList;
    }

//  public Customer  getCustomerById(Integer id){
//      Optional<Customer> optionalCustomer = customerRepo.findAllById(id);
//              if(optionalCustomer.isPresent())
//                  return optionalCustomer.get();
//              return null;
//  }
}
