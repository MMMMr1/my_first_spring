package groupwork.web.controllers;

import groupwork.core.dto.VoiceDTO;
import groupwork.service.api.IVoteService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServlet;
@RestController
@RequestMapping("/answer")
public class AnswerController extends HttpServlet {

    private  IVoteService voteService;
    public AnswerController(IVoteService voteService) {
        this.voteService = voteService;
    }
    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(@RequestBody VoiceDTO voiceDTO) {

        voteService.save(voiceDTO);
    }
}