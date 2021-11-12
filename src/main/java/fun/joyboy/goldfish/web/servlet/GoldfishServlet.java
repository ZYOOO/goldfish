package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-27 19:36
 */

import fun.joyboy.goldfish.service.RewardService;
import fun.joyboy.goldfish.service.impl.RewardServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/inputReward/*")
public class GoldfishServlet extends BaseServlet {
    private RewardService rewardService= new RewardServiceImpl();
    public void showReviewDateByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<String> list = rewardService.findRewardByUid(Integer.parseInt(request.getParameter("uid")));
        writeValue(list,response);
    }
}
