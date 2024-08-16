//package edu.gdou.pensionlens.security.handler;
//
//import com.alibaba.fastjson.JSON;
//import edu.gdou.pensionlens.pojo.Result;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import edu.gdou.pensionlens.utils.WebUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////@Component
//public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        Result result = new Result(HttpStatus.UNAUTHORIZED.value(), "认证失败请重新登录");
//        String json = JSON.toJSONString(result);
//        WebUtil.renderString(response,json);
//    }
//}
//
