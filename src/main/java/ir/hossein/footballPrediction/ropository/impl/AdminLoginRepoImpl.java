package ir.hossein.footballPrediction.ropository.impl;


import ir.hossein.footballPrediction.ropository.AdminLoginRepo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("adminLoginDAO")
public class AdminLoginRepoImpl implements AdminLoginRepo {

    @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public boolean checkLogin(String userName, String userPassword){
        System.out.println("In Check login Admin");
        Session session = sessionFactory.openSession();
        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY =" from Admin as a where a.userName=? and a.userPassword=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0,userName);
        query.setParameter(1,userPassword);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound= true;
        }

        session.close();
        return userFound;
    }
}
