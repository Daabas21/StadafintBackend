package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Customer;
import com.example.backend.services.BookingService;
import com.example.backend.services.CleanerService;
import com.example.backend.services.CustomerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    private BookingService bookingService;
    private CleanerService cleanerService;
    private CustomerService customerService;

    public AdminController(BookingService bookingService,
                           CleanerService cleanerService,
                           CustomerService customerService) {
        this.bookingService = bookingService;
        this.cleanerService = cleanerService;
        this.customerService = customerService;
    }

    @PutMapping("/{id}")
    public Cleaner updateCleanerById(@PathVariable int id, @RequestBody Cleaner cleaner, Authentication auth) {
        return cleanerService.updateCleanerById(id, cleaner, auth);
    }

    @GetMapping("/cleaner")
    public List<Cleaner> findAllCleaner(){
        return cleanerService.findAllCleaners();
    }

    @PostMapping("/cleaner")
    public Cleaner insertNewCleaner(@RequestBody Cleaner cleaner) {
        return cleanerService.insertNewCleaner(cleaner);
    }

    @GetMapping("/cleaner/{id}/booking")
    public List<Booking> findCleanerBooking(@PathVariable int id){
        return cleanerService.findCleanerBooking(id);
    }

    @GetMapping("/booking")
    public List<Booking> findAllBooking(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/booking/{id}")
    public Booking findByBookingId(@PathVariable int id){
        return bookingService.findById(id);
    }

    @PostMapping("/booking")
    public Booking insertNewBooking(@RequestBody Booking booking) {
        return bookingService.insertNewBooking(booking);
    }

    @PutMapping("/booking/{id}")
    public Booking updateBookingById(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBookingById(id, booking);
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBookingById(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }


    @GetMapping("/customer")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable int id, Authentication auth) {
        return customerService.findById(id, auth);
    }

    @GetMapping("/customer/{id}/booking")
    public List<Booking> findCustomerBookingsById(@PathVariable int id) {
        return customerService.adminFindCustomerBookingsById(id);
    }

    @PostMapping("/customer")
    public Customer insertNewCustomer(@RequestBody Customer customer) {
        return customerService.insertNewCustomer(customer);
    }

}
