package ir.hossein.footballPrediction.service;


import ir.hossein.footballPrediction.entity.Users;

public interface LoginService{
       public boolean checkLogin(String userName, String userPassword);

       public Users findByUsernameAndPassword(String username, String password);

}