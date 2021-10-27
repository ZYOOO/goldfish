package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-26 15:30
 */

import fun.joyboy.goldfish.domain.Mission;
import fun.joyboy.goldfish.service.MissionService;
import fun.joyboy.goldfish.service.impl.MissionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/mission/*")
public class MissionServlet extends BaseServlet {
    private MissionService missionService = new MissionServiceImpl();
    public void findMissionByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Mission> list = missionService.findMissionByUid(Integer.parseInt(request.getParameter("uid")));
        writeValue(list,response);
        System.out.println(list);
    }
    public void setMission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Mission mission = new Mission();
        mission.setUid(Integer.parseInt(request.getParameter("uid")));
        mission.setMission(request.getParameter("mission"));

        boolean flag = missionService.setMission(mission);
        writeValue(flag,response);
    }
    public void deleteMissionByMid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int mid = Integer.parseInt(request.getParameter("value"));
        boolean flag = missionService.deleteMissionByMid(mid);
        writeValue(flag,response);
    }
}


