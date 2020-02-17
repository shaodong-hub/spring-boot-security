//package com.github.springbootsecurity.controller.application.impl;
//
//import lombok.SneakyThrows;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 下午7:20 2019/10/18
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@AutoConfigureMockMvc
//@ActiveProfiles("junit")
//@RunWith(SpringRunner.class)
//@WithMockUser(roles = "USER", username = "user")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class UserCenterControllerImplTest {
//
//    @Resource
//    private MockMvc mockMvc;
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void getAuthentication() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/center/user/auth"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void getUserDetails() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/center/user/info"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void findAllBooksOwned() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/center/user/books"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void findByBookId() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/center/user/book/2"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//}