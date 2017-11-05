package com.example.shop;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.shop.controller.ShopController;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ShopApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  private  ShopController controller;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void prepareMockMvc() {
    this.mockMvc = webAppContextSetup(this.webApplicationContext).build();

  }

  @Test
  public void createAccount() throws Exception {
       
   String str = "{\"shopName\": \"lidl\",\"updatedBy\": \"B\",\"shopAddress\": {\"number\": 144,\"postCode\": \"80804\",\"address\" : \"Leopoldstrasse\"}";
   this.mockMvc.perform(post("/shopAppend").contentType(MediaType.APPLICATION_JSON)
		      .content(str)).andExpect(status().isCreated());
  
  }
}
