package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-26 13:35
 */

import fun.joyboy.goldfish.util.MailUtils;
import fun.joyboy.goldfish.util.UuidUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/emailCodeServlet")
public class EmailCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
        String email = request.getParameter("email");
        String emailcode = UuidUtil.getUuid();
        request.getSession().setAttribute("EMAILCODE_SERVER",emailcode);
        String content = "邮箱激活码:"+emailcode;
        MailUtils.sendMail(email,content,"GOLDFISH注册激活码");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
