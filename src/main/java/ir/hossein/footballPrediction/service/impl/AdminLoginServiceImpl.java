package ir.hossein.footballPrediction.service.impl;


import ir.hossein.footballPrediction.ropository.AdminLoginRepo;
import ir.hossein.footballPrediction.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginRepo adminLoginRepo;

    public void setAdminLoginDAO(AdminLoginRepo adminLoginRepo) {
        this.adminLoginRepo = adminLoginRepo;
    }

    public boolean checkLogin(String userName, String userPassword){
        System.out.println("In Service class...Check Login");
        return adminLoginRepo.checkLogin(userName, userPassword);
    }
}
