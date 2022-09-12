package ir.hossein.footballPrediction.controller;


import ir.hossein.footballPrediction.model.GuessModel;
import ir.hossein.footballPrediction.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Guess")
public class GuessController {

    @Autowired
    private GuessService guessService;

        @GetMapping("/list")
    public String listGuess(Model theModel) {
        List<GuessModel> theGuessEntities = guessService.getGuess();
        theModel.addAttribute("guess", theGuessEntities);
        return "Guess/list-guess";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("guessId") int guessId, Model theModel) {
        GuessModel theGuessEntity = guessService.getGuess(guessId);
        theModel.addAttribute("guess", theGuessEntity);
        return "Guess/guess-form";
    }


    @PostMapping("/saveGuess")
    public String saveGuess(@ModelAttribute("guess") GuessModel theGuessModel) {
        guessService.saveGuess(theGuessModel);
        return "redirect:/Guess/list";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        GuessModel theGuessEntity = new GuessModel();
        theModel.addAttribute("guess", theGuessEntity);
        return "Guess/guess-form";
    }

    @GetMapping("/showForm2")
    public String showFormForAdd2(@RequestParam("userId") int userId,@RequestParam("matchId") int matchId,Model theModel) {
        GuessModel theGuessEntity = new GuessModel(userId,matchId);
        theModel.addAttribute("guess", theGuessEntity);
        return "Guess/guess-form-user";
    }


    @GetMapping("/delete")
    public String deleteGuess(@RequestParam("guessId") int guessId) {
        guessService.deleteGuess(guessId);
        return "redirect:/Guess/list";
    }


}
