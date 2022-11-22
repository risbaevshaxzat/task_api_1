package uz.pdp.task_api_1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task_api_1.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer ,  Integer> {

            boolean existsByPhoneNumber(String PhoneNomber);

            boolean existsByPhoneNumberAndIdNot(String phonenumber, Integer id);
}
