package ir.hossein.footballPrediction.ropository;

import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.entity.MatchesEntity;

import java.util.List;

public interface MatchesRepo {

    public List<MatchesEntity> getMatch();

    public void saveMatch(MatchesEntity matchesEntity);

    public MatchesEntity getMatch(int matchId);

    public void deleteMatch(int matchId);

    public List<GuessEntity> setAllUserScores(int matchesId);
}
