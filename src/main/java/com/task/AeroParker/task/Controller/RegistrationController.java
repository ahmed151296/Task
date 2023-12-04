package com.task.AeroParker.task.Controller;

import com.task.AeroParker.task.Model.Customer;
import com.task.AeroParker.task.Repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }
    @GetMapping("/registrationSuccess")
    public String registrationSuccess() {
        return "registrationSuccess";
    }


    @PostMapping("/registration")
    public String registerCustomerAccount(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {

            return "registration";
        }else {
        customerRepository.save(customer);
        return "redirect:/registrationSuccess";
    }}
}

