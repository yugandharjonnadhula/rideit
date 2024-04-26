package com.example.RideIt.service;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
//     @Autowired
//     CustomerRepository customerRepository;

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        customer.setName(customer.getName());
        customer.setId(customer.getId());
        customer.setAge(customer.getAge());
        customer.setEmailId(customer.getEmailId());
        customer.setAddress(customer.getAddress());
        customer.setGender(customer.getGender());

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
}
