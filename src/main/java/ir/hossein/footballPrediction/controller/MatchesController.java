package ir.hossein.footballPrediction.controller;


import ir.hossein.footballPrediction.model.MatchesModel;
import ir.hossein.footballPrediction.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Matches")
public class MatchesController {

    @Autowired
    private MatchesService matchesService;


    //For Admin
    @GetMapping("/list")
    public String listMatches(Model theModel) {
        List<MatchesModel> theMatchesEntities = matchesService.getMatch();
        theModel.addAttribute("matches", theMatchesEntities);
        return "Matches/list-matches";
    }

    //For User
    @GetMapping("/u-list")
    public String listMatchesUser(Model theModel) {
        List<MatchesModel> theMatchesEntities = matchesService.getMatch();
        theModel.addAttribute("matches", theMatchesEntities);
        return "Matches/user-list-matches";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        MatchesModel theMatchesEntity = new MatchesModel();
        theModel.addAttribute("matches", theMatchesEntity);
        return "Matches/matches-form";
    }

    @PostMapping("/saveMatches")
    public String saveMatches(@ModelAttribute("matches") MatchesModel theMatchesModel) {
        matchesService.saveMatch(theMatchesModel);
        return "redirect:/Matches/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("matchesId") int matchesId, Model theModel) {
        MatchesModel theMatchesEntity = matchesService.getMatch(matchesId);
        theModel.addAttribute("matches", theMatchesEntity);
        return "Matches/matches-form";
    }


    @GetMapping("/delete")
    public String deleteMatches(@RequestParam("matchesId") int matchesId) {
        matchesService.deleteMatch(matchesId);
        return "redirect:/Matches/list";
    }

    @GetMapping("/messageWorker")
    public String messageWorker(@RequestParam("matchesId") int matchesId) {
        //update Score for all users that they guess this match:
        matchesService.setAllUserScores(matchesId);
        return "redirect:/Matches/list";
    }
}
