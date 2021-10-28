package fun.joyboy.goldfish.web.servlet; /**
 * @author ZYOOO
 * @date 2021-10-27 16:52
 */

import fun.joyboy.goldfish.domain.Vocabulary;
import fun.joyboy.goldfish.service.VocabularyService;
import fun.joyboy.goldfish.service.impl.VocabularyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/vocabulary/*")
public class VocabularyServlet extends BaseServlet{
    private VocabularyService vocabularyService = new VocabularyServiceImpl();
    public void addVocabulary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int i = 1;
        int uid = Integer.parseInt(request.getParameter("uid"));
        String en = request.getParameter("en"+Integer.toString(i));
        String cn = request.getParameter("cn"+Integer.toString(i));
        Date date_now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date =  dateFormat.format(date_now);
        while (en != null && cn != null && en != "null" && cn != ""){
            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setUid(uid);
            vocabulary.setC_date(date);
            vocabulary.setWord(en);
            vocabulary.setMeaning(cn);
            vocabularyService.addVocabulary(vocabulary);
            en = request.getParameter("en"+Integer.toString(++i));
            cn = request.getParameter("cn"+Integer.toString(i));
        }
        boolean flag = true;
        writeValue(flag,response);
    }

    public void searchVocabularyByUidAndDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int uid = Integer.parseInt(request.getParameter("uid"));
        String date = request.getParameter("date");
        List<Vocabulary> list  = vocabularyService.searchVocabularyByUidAndDate(uid,date);
        writeValue(list,response);
    }

    public void searchVocabularyByI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int uid = Integer.parseInt(request.getParameter("uid"));
        List<Vocabulary> list  = vocabularyService.searchVocabularyByI(uid);
        writeValue(list,response);
    }
    public void unknown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int vid = Integer.parseInt(request.getParameter("vid"));
        boolean flag = vocabularyService.unknown(vid);
        writeValue(flag,response);
    }
    //伪删除,只是改变状态不显示
    public void changeStatusByVid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int vid = Integer.parseInt(request.getParameter("vid"));
        boolean flag = vocabularyService.changeStatus(vid);
        writeValue(flag,response);
    }
    //真正从数据库删除
    public void deleteVocabularyByVid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
