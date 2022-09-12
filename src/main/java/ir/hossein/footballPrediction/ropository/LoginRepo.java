package ir.hossein.footballPrediction.ropository;


import ir.hossein.footballPrediction.entity.Users;

public interface LoginRepo {
       public boolean checkLogin(String userName, String userPassword);

       public Users findByUsernameAndPassword(String username, String password);
}