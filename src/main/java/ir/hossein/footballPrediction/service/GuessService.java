package ir.hossein.footballPrediction.service;

import ir.hossein.footballPrediction.model.GuessModel;
import ir.hossein.footballPrediction.model.MatchesModel;

import java.util.List;

public interface GuessService {

    public List<GuessModel> getGuess();

    public void saveGuess(GuessModel guessModel);

    public GuessModel getGuess(int guessId);

    public void deleteGuess(int guessId);
}
