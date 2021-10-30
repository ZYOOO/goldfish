package fun.joyboy.goldfish.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import fun.joyboy.goldfish.domain.ResultInfo;
import fun.joyboy.goldfish.domain.User;
import fun.joyboy.goldfish.service.UserService;
import fun.joyboy.goldfish.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
@author ZYOOO
@date 2021-10-25 19:41
*/
@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码验证
        String check = request.getParameter("check");
        //从session中获取服务器设置的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)  session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //封装返回信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误!点击图片更换");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.调用Service查询
        User u = userService.login(user);

        ResultInfo info = new ResultInfo();

        //4.判断用户对象是否为null
        if (u == null) {
            //用户名密码或错误
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        //5.判断用户是否被禁用
        if (u != null && !"Y".equals(u.getStatus())) {
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("该用户被禁用，请联系管理员");
        }
        //6.判断登录成功
        if (u != null && "Y".equals(u.getStatus())) {
            request.getSession().setAttribute("user", u);//登录成功标记

            //登录成功
            info.setFlag(true);
        }

        //响应数据
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //检查验证码
        //用户输入的验证码
        String check = request.getParameter("check");
        //从session中获取服务器设置的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)  session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //封装返回信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误!点击图片更换");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //检查邮箱验证码
        String emailCheck = request.getParameter("emailCheck");
        System.out.println(emailCheck);
        //从session中获取服务器设置的验证码
        String emailcode_server = (String) session.getAttribute("EMAILCODE_SERVER");
        System.out.println(emailcode_server);
        session.removeAttribute("EMAILCODE_SERVER");
        if(emailcode_server == null || !emailcode_server.equalsIgnoreCase(emailCheck)){
            //封装返回信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("邮箱激活码错误,请重新发送");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        System.out.println("双重验证通过");
        //验证通过的话,将表单信息写在map中
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.调用service完成注册
        boolean flag = userService.register(user);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if (flag) {
            //注册成功
            info.setFlag(true);
        } else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }

        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Object user = request.getSession().getAttribute("user");
        writeValue(user,response);
    }
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        ResultInfo info = new ResultInfo();
        if(userService.findUserByUsername(username) != null){
            info.setFlag(false);
            info.setErrorMsg("该用户名已存在");
        }else{
            info.setFlag(true);
            info.setErrorMsg("");
        }
        writeValue(info,response);
    }
}

