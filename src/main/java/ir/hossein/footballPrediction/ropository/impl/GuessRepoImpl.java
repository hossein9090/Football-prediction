package ir.hossein.footballPrediction.ropository.impl;


import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.entity.Users;
import ir.hossein.footballPrediction.ropository.GuessRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GuessRepoImpl implements GuessRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GuessEntity> getGuess() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<GuessEntity> cq = cb.createQuery(GuessEntity.class);
        Root<GuessEntity> root = cq.from(GuessEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveGuess(GuessEntity guessEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(guessEntity);
    }

    @Override
    public GuessEntity getGuess(int guessId) {
        Session currentSession = sessionFactory.getCurrentSession();
        GuessEntity theGuessEntity = currentSession.get(GuessEntity.class, guessId);
        return theGuessEntity;
    }

    @Override
    public void deleteGuess(int guessId) {
        Session session = sessionFactory.getCurrentSession();
        GuessEntity match = session.byId(GuessEntity.class).load(guessId);
        session.delete(match);
    }
}
