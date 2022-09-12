package ir.hossein.footballPrediction.ropository;

import ir.hossein.footballPrediction.entity.GuessEntity;

import java.util.List;

public interface GuessRepo {


    public List<GuessEntity> getGuess();

    public void saveGuess(GuessEntity guessEntity);

    public GuessEntity getGuess(int guessId);

    public void deleteGuess(int guessId);
}
