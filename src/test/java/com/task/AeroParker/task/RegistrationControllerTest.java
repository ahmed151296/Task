package com.task.AeroParker.task;

import com.task.AeroParker.task.Controller.RegistrationController;
import com.task.AeroParker.task.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testShowRegistrationForm() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"))
                .andExpect(model().attributeExists("customer"));
    }

    @Test
    public void testRegistrationSuccess() throws Exception {
        mockMvc.perform(get("/registrationSuccess"))
                .andExpect(status().isOk())
                .andExpect(view().name("registrationSuccess"));
    }

    @Test
    public void testRegisterCustomerAccount_Success() throws Exception {
        mockMvc.perform(post("/registration")
                                .param("emailAddress", "test@example.com")
                                .param("title", "Mr")
                                .param("firstName", "John")
                                .param("lastName", "Doe")
                                .param("addressLine1", "123 Street")
                                .param("postcode", "ABC123")

                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/registrationSuccess"));
    }


}
