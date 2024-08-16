package edu.gdou.pensionlens;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.gdou.pensionlens.config.JacksonConfig;
import edu.gdou.pensionlens.service.ScreenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(JacksonConfig.class)
public class PensionLensTest {
    @Test
    public void testAddition() {
        int a = 5;
        int b = 3;
        int sum = a + b;
        assertEquals(8, sum, "5 + 3 should equal 8");
    }

    @Autowired
    private ScreenService screenService;

    @Test
    public void testScreenService() throws Exception {
        jacksonSerialization(screenService.getScreenInfo(2));
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void exampleTestMyPostMethod() throws Exception {
        Map<String, Object> testInput = new HashMap<>();
        testInput.put("key1", "value1");
        testInput.put("key2", "value2");
        MvcResult result = mockMvc.perform(post("/myPostMethod")
                        .contentType(APPLICATION_JSON)
                        .content(jacksonSerialization(testInput)))
                .andExpect(status().isOk())
                .andReturn(); // 获取响应

        String responseJson = result.getResponse().getContentAsString(); // 获取响应的JSON内容
        // 这里可以对responseJson进行进一步的验证
        System.out.println(responseJson);
    }

    @Test
    public void testCalcController() throws Exception {
        // 读取 JSON 文件内容
        String jsonContent = new String(Files.readAllBytes(Paths.get("D:\\Projects\\IDEAProjects\\PensionLens\\pensionlens-core\\src\\test\\java\\edu\\gdou\\pensionlens\\input.json")), StandardCharsets.UTF_8);
        mockMvc.perform(post("/calc/2").
                contentType(APPLICATION_JSON).
                content(jsonContent))
                .andExpect(status().isOk())
                .andReturn(); // 获取响应
    }


    private String jacksonSerialization(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 序列化为 JSON 字符串
        String json = mapper.writeValueAsString(obj);
        // 打印 JSON 字符串
        System.out.println(json);
        return json;
    }
}
