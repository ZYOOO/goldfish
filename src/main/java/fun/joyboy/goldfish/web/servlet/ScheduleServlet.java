package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-26 22:53
 */

import fun.joyboy.goldfish.domain.Schedule;
import fun.joyboy.goldfish.service.ScheduleService;
import fun.joyboy.goldfish.service.impl.ScheduleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/schedule/*")
public class ScheduleServlet extends BaseServlet {
    private ScheduleService scheduleService = new ScheduleServiceImpl();
    public void setSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Schedule schedule = new Schedule();
        schedule.setUid(Integer.parseInt(request.getParameter("uid")));
        //设置start和end,并格式化时间
        schedule.setT_start(addZero(request.getParameter("start")));
        schedule.setT_end(addZero(request.getParameter("end")));
        schedule.setDailyMission(request.getParameter("dailyMission"));
        System.out.println(schedule);
        boolean flag = scheduleService.setSchedule(schedule);
        writeValue(flag,response);
    }
    public void deleteScheduleBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        boolean flag = scheduleService.deleteScheduleBySid(Integer.parseInt(request.getParameter("value")));
        writeValue(flag,response);
    }
    public void findScheduleByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Schedule> list = scheduleService.findScheduleByUid(Integer.parseInt(request.getParameter("uid")));
        writeValue(list,response);
        System.out.println(list);
    }
    private static String addZero(String str){
        String ans = "";
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            if(split[i].length() < 2){
                ans += split[i].replaceAll(split[i],"0"+split[i]);
                if (i == 0){
                    ans += ":";
                }
            }else {
                ans += split[i];
                if (i == 0){
                    ans += ":";
                }
            }
        }
        return ans;
    }
}
