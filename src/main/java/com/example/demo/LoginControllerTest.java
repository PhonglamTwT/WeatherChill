//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class LoginControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testShowLoginForm() throws Exception {
//        mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("login"));
//    }
//
//    @Test
//    public void testProcessLoginSuccess() throws Exception {
//        mockMvc.perform(post("/login")
//                        .param("username", "user")
//                        .param("password", "password"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("welcome"))
//                .andExpect(model().attribute("username", "user"));
//    }
//
//    @Test
//    public void testProcessLoginFailure() throws Exception {
//        mockMvc.perform(post("/login")
//                        .param("username", "invalidUser")
//                        .param("password", "invalidPassword"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("login"))
//                .andExpect(model().attribute("error", "Invalid username or password"));
//    }
//}
//
