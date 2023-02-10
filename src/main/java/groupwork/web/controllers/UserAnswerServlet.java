package groupwork.web.controllers;

import groupwork.core.dto.VoiceDTO;
import groupwork.service.api.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
@RestController
@RequestMapping("/answer")
public class UserAnswerServlet extends HttpServlet {

    private  IVoteService voteService;



    public UserAnswerServlet(IVoteService voteService) {
        this.voteService = voteService;
    }
//

//    @Override
//    protected void doPost(HttpServletRequest req,
//                          HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        try {
//            Map<String, String[]> parameterMap = req.getParameterMap();
//
//            String[] singers = parameterMap.get(SINGER_PARAM_NAME);
//
//            if (singers == null || singers.length > 1) {
//                throw new IllegalArgumentException("Choose one singer");
//            }
//
//            Long singer = Long.parseLong(singers[0]);
//
//            String[] genres = parameterMap.get(GENRE_PARAM_NAME);
//
//            if (genres == null) {
//                throw new IllegalArgumentException("Choose genres");
//            }
//
//            long[] intGenre = Arrays.
//                    stream(genres)
//                    .mapToLong(Long::parseLong)
//                    .toArray();
//            String[] mails = parameterMap.get(EMAIL_TO);
//
//            if (mails == null || mails.length > 1) {
//                throw new IllegalArgumentException("Choose one mail");
//            }
//
//            String mail = mails[0];
//
//            String[] aboutUsers = parameterMap.get(ABOUT_USER_PARAM_NAME);
//
//            String aboutUser = (aboutUsers == null) ? null : aboutUsers[0];
//
//            VoiceDTO voiceDTO = new VoiceDTO(singer, intGenre, aboutUser,mail);
//
//            service.save(voiceDTO);
//
//            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath + "/result");
//
//        } catch (RuntimeException e) {
//            if (e.getCause() != null) {
//                writer.write("<p>" + e.getMessage() + ": " + e.getCause() + "</p>");
//            } else {
//                writer.write("<p>" + e.getMessage() + "</p>");
//            }
//        }
//    }
}