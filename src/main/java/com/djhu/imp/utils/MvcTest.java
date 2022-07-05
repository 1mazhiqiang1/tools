//package com.djhu.imp.utils;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.HashMap;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MvcTest {
//
//    MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext applicationContext;
//
//
//    @Before
//    public void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
//
//        //通过参数指定一组控制器，这样就不需要从上下文获取了
//        //mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
//    }
//
//    /** get **/
//    @Test
//    public void getTest() throws Exception {
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/main/get")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .param("pageNum", "1");
//
//        MvcResult mvcResult = mockMvc.perform(requestBuilder)
//                .andDo(MockMvcResultHandlers.print()) //打印输出发出请求的详细信息
//                .andExpect(MockMvcResultMatchers.status().isOk()) //对返回值进行断言
//                .andReturn();
//
//        System.err.println(mvcResult.getResponse().getContentAsString());
//    }
//
//    /** post **/
//    @Test
//    public void postTest() throws Exception {
//        java.util.Map<String, Object> map = new HashMap<>();
//        map.put("pageNum", 1);
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/main/post")
//                //.put("/main/put")
//                //.delete("/main/delete")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(JSON.toJSONString(map));
//
//        MvcResult mvcResult = mockMvc.perform(requestBuilder)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        System.err.println(mvcResult.getResponse().getContentAsString());
//    }
//
//    @Test
//    public void fileTest() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
////                .multipart("/main/file")
//                .multipart("/app/study/homework/upload")
//                .file(new MockMultipartFile("file", "C:\\Users\\Administrator\\Desktop\\ppt\\1234.pptx",
//                        "multipart/form-data",
//                        "hello upload".getBytes("UTF-8")))
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .param("p", "95ae5c3040d035f1814c6295d6153e2a");
//
//
//        MvcResult mvcResult = mockMvc.perform(requestBuilder)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//
//        System.err.println(mvcResult.getResponse().getContentAsString());
//    }
//}
