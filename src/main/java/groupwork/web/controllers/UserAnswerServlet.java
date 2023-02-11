package groupwork.web.controllers;

import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.VoiceDTO;
import groupwork.service.api.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(@RequestBody VoiceDTO voiceDTO) {

        voteService.save(voiceDTO);
    }
}