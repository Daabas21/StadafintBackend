package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Customer;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public int customerId(Authentication auth){
        String customerEmail = ((Customer) auth.getPrincipal()).getEmail();
        Customer customer = customerRepo.findCustomerByEmail(customerEmail).orElseThrow();

        return  customer.getId();
    }

    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer findById(int id, Authentication auth) {

        int customerId = customerId(auth);
        if (id == customerId) {
            return customerRepo.findById(id).orElseThrow();
        } else {
            return customerRepo.findById(customerId).orElseThrow();
        }

    }

    public Customer insertNewCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomerById(int id, Customer customer, Authentication auth) {

        int customerId = customerId(auth);
        Customer existingCustomer = customerRepo.findById(customerId).orElseThrow();

        if (customer != null) {
            if (!customer.getName().equals("")) {
                existingCustomer.setName(customer.getName());
            }
            if (!customer.getAddress().equals("")) {
                existingCustomer.setAddress(customer.getAddress());
            }
            if (!customer.getEmail().equals("")) {
                existingCustomer.setEmail(customer.getEmail());
            }
            if (!customer.getTelnum().equals("")) {
                existingCustomer.setTelnum(customer.getTelnum());
            }
            if (!customer.getPassword().equals("")) {
                existingCustomer.setPassword(customer.getPassword());
            }
        }

        return customerRepo.save(existingCustomer);

    }

    public List<Booking> findCustomerBookingsById(int id) {
        return bookingRepo.findByCustomerId(id);
    }

}
