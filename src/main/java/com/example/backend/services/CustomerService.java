package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Customer;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    BookingRepo bookingRepo;

    public List <Customer> findAllCustomers(){
        return customerRepo.findAllCustomers();
    }

    public Customer findCustomerById(int id){return customerRepo.findById(id).orElseThrow();}

    public Customer insertNewCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer updateCustomerById(int id, Customer customer){
        Customer existingCustomer = customerRepo.findById(id).orElseThrow();

        if (customer!=null){
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setTelnum(customer.getTelnum());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPassword(customer.getPassword());
        }

        return  customerRepo.save(existingCustomer);
    }

    public List<Booking> findCustomerBookings(int id){return bookingRepo.findByCustomerId(id);}

}
