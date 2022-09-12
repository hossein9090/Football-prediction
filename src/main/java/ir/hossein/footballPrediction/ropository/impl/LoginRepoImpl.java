package ir.hossein.footballPrediction.ropository.impl;


import ir.hossein.footballPrediction.entity.Users;
import ir.hossein.footballPrediction.ropository.LoginRepo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("loginDAO")
public class LoginRepoImpl implements LoginRepo {


    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    public boolean checkLogin(String userName, String userPassword) {
        System.out.println("In Check login");
        Session session = sessionFactory.openSession();
        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY = "from Users as o where o.userName=? and o.userPassword=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0, userName);
        query.setParameter(1, userPassword);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }

        session.close();
        return userFound;
    }

    @Override
    public Users findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        Users singleResult = session.createQuery("select u from Users u where u.userName=:username and u.userPassword=:password", Users.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        return singleResult;

    }
}


