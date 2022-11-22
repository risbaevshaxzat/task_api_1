package uz.pdp.task_api_1.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task_api_1.Entity.Customer;
import uz.pdp.task_api_1.Repo.CustomerRepo;
import uz.pdp.task_api_1.payload.ApiResponse;
import uz.pdp.task_api_1.payload.CustomerDto;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
   CustomerRepo customerRepo;

    public List<Customer> getAll(){
       List<Customer> customerList = customerRepo.findAll();
       return customerList;
    }

 public Customer  getCustomerById(Integer id){
      Optional<Customer> optionalCustomer = Optional.of(customerRepo.getOne(id));
      return optionalCustomer.orElse(null);
    }

    public ApiResponse addCustomer(CustomerDto customerDto){
        boolean ex = customerRepo.existsByPhoneNumber(customerDto.getPhoneNumber());
        if (ex)
            return new ApiResponse("Bunday  mijoz mavjud",false);

        Customer customer = new Customer();
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setFullName(customerDto.getFullName());
        customer.setAddrese(customerDto.getAddrese());
        customerRepo.save(customer);
        return  new ApiResponse("MIjo Saqlandi " , true);

    }

    public  ApiResponse editCustomer(Integer id , CustomerDto customerDto) {
        boolean existsByPhoneNumber = customerRepo.existsByPhoneNumberAndIdNot(customerDto.getPhoneNumber(), id);
        if (existsByPhoneNumber) {
            return new ApiResponse("Bunday telefon raqamly mijoz mavjud", false);

        }
        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        if (!optionalCustomer.isPresent()) {
            return new ApiResponse("Nunday mijoz mavjud emas", false);
        }
        Customer customer = optionalCustomer.get();
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddrese(customerDto.getAddrese());
        customerRepo.save(customer);
        return new ApiResponse("Mijoz taxrirlandi ", true);
    }

    public ApiResponse deleteCust(Integer id ){
        customerRepo.deleteById(id);
        return new ApiResponse("Mijoz o'chirildi",true);
    }
}
