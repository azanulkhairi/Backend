package com.ex.controllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ex.honey.config.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebMvcConfig.class)
public class FirstControllerTest {

	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.context);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void testController() throws Exception{
    ResultMatcher ok = MockMvcResultMatchers.status().isOk();
    	ResultMatcher msg = MockMvcResultMatchers.model()
                .attribute("word", "test");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		this.mockMvc.perform(builder)
		   .andExpect(ok)
		   .andExpect(msg);
    	
    }
}
