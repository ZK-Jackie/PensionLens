package edu.gdou.pensionlens;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.gdou.pensionlens.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PensionLensTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testAddition() {
        int a = 5;
        int b = 3;
        int sum = a + b;
        assertEquals(8, sum, "5 + 3 should equal 8");
    }

    @Test
    public void testService() {
        // 这里可以调用sysUserService的方法进行测试
        // 例如，你可以验证方法的返回值，或者验证方法是否抛出了预期的异常
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMyPostMethod() throws Exception {
        Map<String, Object> testInput = new HashMap<>();
        testInput.put("key1", "value1");
        testInput.put("key2", "value2");
        MvcResult result = mockMvc.perform(post("/myPostMethod")
                        .contentType(APPLICATION_JSON)
                        .content(mapToJSONString(testInput)))
                .andExpect(status().isOk())
                .andReturn(); // 获取响应

        String responseJson = result.getResponse().getContentAsString(); // 获取响应的JSON内容
        // 这里可以对responseJson进行进一步的验证
        System.out.println(responseJson);
    }

    private String mapToJSONString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
