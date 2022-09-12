package ir.hossein.footballPrediction.ropository.impl;

import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.entity.MatchesEntity;
import ir.hossein.footballPrediction.ropository.MatchesRepo;
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
public class MatcherRepoImpl implements MatchesRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MatchesEntity> getMatch() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MatchesEntity> cq = cb.createQuery(MatchesEntity.class);
        Root<MatchesEntity> root = cq.from(MatchesEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveMatch(MatchesEntity matchesEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(matchesEntity);
    }

    @Override
    public MatchesEntity getMatch(int matchId) {
        Session currentSession = sessionFactory.getCurrentSession();
        MatchesEntity theMatchEntity = currentSession.get(MatchesEntity.class, matchId);
        return theMatchEntity;
    }

    @Override
    public void deleteMatch(int matchId) {
        Session session = sessionFactory.getCurrentSession();
        MatchesEntity match = session.byId(MatchesEntity.class).load(matchId);
        session.delete(match);
    }

    @Override
    public List<GuessEntity> setAllUserScores(int matchesId) {
        Session session = sessionFactory.getCurrentSession();
        List<GuessEntity> listGuessEntity = session.createQuery("select g from GuessEntity g where g.matchId=:matchesId", GuessEntity.class)
                .setParameter("matchesId", matchesId)
                .getResultList();
        return listGuessEntity;

    }
}
