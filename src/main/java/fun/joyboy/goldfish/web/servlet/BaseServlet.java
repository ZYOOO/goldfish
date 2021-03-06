package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-14 10:01
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成方法分发
        //1.获取请求路径
        String uri = req.getRequestURI();
//        System.out.println("请求uri:"+uri);
        //2.获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
//        System.out.println("方法名称："+methodName);
        //3.获取方法对象method
        //this 代表调用的对象
        try {
            //暴力反射
//            Method method = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
//            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //4.执行方法
    }

    //直接传入的对象序列化为json,并且写回客户端
    public void  writeValue(Object obj,HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),obj);
    }
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(obj);
    }

}
