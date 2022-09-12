package ir.hossein.footballPrediction.service;

import ir.hossein.footballPrediction.model.MatchesModel;

import java.util.List;

public interface MatchesService {

    public List<MatchesModel> getMatch();

    public void saveMatch(MatchesModel matchesModel);

    public MatchesModel getMatch(int matchesId);

    public void deleteMatch(int matchesId);

    public void setAllUserScores(int matchesId);
}
