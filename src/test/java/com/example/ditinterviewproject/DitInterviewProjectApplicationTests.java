package com.example.ditinterviewproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DitInterviewProjectApplicationTests.class)
@AutoConfigureMockMvc
class DitInterviewProjectApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(status().isOk());
    }
    @Test
    public void shouldAllowAccessToAuthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders
        .get("/hello")
        .accept(MediaType.APPLICATION_JSON)
        .header(HttpHeaders.AUTHORIZATION,"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aXNocHRsIiwiZXhwIjoxNjI0ODE3NjM3LCJpYXQiOjE2MjQ3OTk2Mzd9.ykZr2zvmO5ZmOE2VoaR_MKW1tsTiSzl5f8hj8-z8LZftvlto7PZQcN_CKMlalCj8rGO6oCbnFaXabS546Arzzg")
        .contentType(MediaType.APPLICATION_JSON));
    }
}
