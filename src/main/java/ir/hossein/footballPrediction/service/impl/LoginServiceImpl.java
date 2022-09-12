package ir.hossein.footballPrediction.service.impl;


import ir.hossein.footballPrediction.entity.Users;
import ir.hossein.footballPrediction.ropository.*;
import ir.hossein.footballPrediction.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	 @Autowired
	 private LoginRepo loginRepo;

	   public void setLoginDAO(LoginRepo loginRepo) {
              this.loginRepo = loginRepo;
       }
      
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginRepo.checkLogin(userName, userPassword);
       }

    @Override
    public Users findByUsernameAndPassword(String username, String password) {
        return loginRepo.findByUsernameAndPassword(username,password);
    }
}