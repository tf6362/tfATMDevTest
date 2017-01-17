package com.backbase.devtest.test;

/**
 * Created by bbates on 1/13/17.
 */




import com.backbase.devtest.ATM;
import com.backbase.devtest.ATMManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import sun.net.www.http.HttpClient;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/DevTest-servlet.xml" })
@WebAppConfiguration
public class AppTest
    extends TestCase
{
    @Autowired WebApplicationContext wac;
        @Autowired
        MockHttpSession session;
        @Autowired
        MockHttpServletRequest request;
    public AppTest( )
     {
         super(  );
     }



    private MockMvc mockMvc;






        @Before
        public void setup() {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        }



    @org.junit.Test
    public void testApp() throws Exception
    {



         //.accept(MediaType.TEXT_HTML))
         this.mockMvc.perform(get("/api/locator/ATM?city=ALMERE").session(session)
         .accept("application/json"))
         .andExpect(status().isOk())
                 .andExpect(content().string(org.hamcrest.Matchers.containsString("]")))
                 .andExpect(content().string(org.hamcrest.Matchers.containsString("}")));

        this.mockMvc.perform(get("/api/locator/ATM?city=Almere").session(session)
                .accept("application/json"))
                .andExpect(status().isOk())
                        .andExpect(content().string(org.hamcrest.Matchers.containsString("]")))
                        .andExpect(content().string(org.hamcrest.Matchers.containsString("}")));


        this.mockMvc.perform(get("/api/locator/ATM?city=almere").session(session)
                       .accept("application/json"))
                       .andExpect(status().isOk())
                               .andExpect(content().string(org.hamcrest.Matchers.containsString("]")))
                               .andExpect(content().string(org.hamcrest.Matchers.containsString("}")));


        this.mockMvc.perform(get("/api/locator/ATM").session(session)
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("]")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("}")));


        this.mockMvc.perform(get("/api/locator/ATM?city=FDGSGSDFS").session(session)
                .accept("application/json"))
                .andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("[")));


        this.mockMvc.perform(get("/api/locator/ATM?city=").session(session)
                       .accept("application/json"))
                       .andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("[")));


        this.mockMvc.perform(get("/api/locator/ATM?city=ALMERE").session(session)
                 .accept("application/html"))
                 .andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("ALMERE")));

        this.mockMvc.perform(get("/api/locator/ATM").session(session)
                         .accept("application/html"))
                         .andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("ALMERE")));

        List <NameValuePair> nvpList=new ArrayList<NameValuePair>(1);
        nvpList.add(new BasicNameValuePair("city", "ALMERE"));
        this.mockMvc.perform(post("/user/locator/ATM").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(EntityUtils.toString(new UrlEncodedFormEntity(nvpList))).session(session)
                .accept("application/html"))
                         .andExpect(model().attributeExists("atmList"));

        this.mockMvc.perform(post("/user/locator/ATM").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(EntityUtils.toString(new UrlEncodedFormEntity(nvpList))).session(session)
                        .accept("application/html"))
                                 .andExpect(model().attributeExists("atmList"));

        this.mockMvc.perform(get("/logout").session(session)
                 .accept("application/html"))
                 .andExpect(status().is3xxRedirection());



        this.mockMvc.perform(get("/login").session(session)
                 .accept("application/html"))
                 .andExpect(status().isOk());

        this.mockMvc.perform(get("/user/locator/atmform").session(session)
                         .accept("application/html"))
                         .andExpect(status().isOk());

        ApplicationContext context =
                     new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/DevTest-servlet.xml");
        ATMManager manager=(ATMManager)context.getBean("ATMManager");

        assertTrue(manager.isSourceXSSIMode());
        manager.setSourceXSSIMode(false);
        assertFalse(manager.isSourceXSSIMode());
        manager.setSourceService("file://src/main/resources/dropbox?noop=true");
        assertEquals(manager.getSourceService(), "file://src/main/resources/dropbox?noop=true");
        manager.listATMByCity(null);
        manager.stopATMRefresh();
        manager.stopATMRefresh();
    }



}