package ir.hossein.footballPrediction.controller;


import ir.hossein.footballPrediction.entity.Users;
import ir.hossein.footballPrediction.form.LoginForm;
import ir.hossein.footballPrediction.model.GuessModel;
import ir.hossein.footballPrediction.model.MatchesModel;
import ir.hossein.footballPrediction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("loginform.html")
public class LoginController {

	
	@Autowired
	public LoginService loginService;

	@Autowired
	private MatchesService matchesService;

	@Autowired
	private GuessService guessService;


	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model, Model matchModel,Model guessModel) {

		if (result.hasErrors()) {
			System.out.println("username or pass wrong!!!");
			return "loginform";
		}

		boolean userExists = loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
		if(userExists){

			//list of all matches
			List<MatchesModel> theMatchesEntities = matchesService.getMatch();
			matchModel.addAttribute("matches", theMatchesEntities);

			//make list of user guesses by user id
			List<GuessModel> theGuessEntities = guessService.getGuess();
			guessModel.addAttribute("guess", theGuessEntities);

			Users byUsernameAndPassword = loginService.findByUsernameAndPassword(loginForm.getUserName(), loginForm.getPassword());
			model.put("loginForm", loginForm);
			model.put("userInfo", byUsernameAndPassword);
			return "loginsuccess";
		}else{
			result.rejectValue("userName","invaliduser");
			return "loginform";
		}

	}

}
