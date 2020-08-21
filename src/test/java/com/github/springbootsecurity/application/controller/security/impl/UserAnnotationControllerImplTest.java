package com.github.springbootsecurity.application.controller.security.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 下午2:19 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserAnnotationControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void preFilter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/prefilter")
                .contentType(MediaType.APPLICATION_JSON)
//                .content(JSON.toJSONString(Lists.newArrayList(1, 2, 3, 4, 5))))
                .content(objectMapper.writeValueAsString(Lists.newArrayList(1, 2, 3, 4, 5))))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void postFilter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/postfilter")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Lists.newArrayList(1, 2, 3, 4, 5))))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void prePostFilter() throws Exception {
    }

    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void postAuthorize() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/postauthorize/2"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @WithMockUser(roles = "USER", username = "user")
    public void preAuthorize() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/preauthorize/3"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}