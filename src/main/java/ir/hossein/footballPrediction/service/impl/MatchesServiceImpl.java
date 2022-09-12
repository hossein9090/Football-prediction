package ir.hossein.footballPrediction.service.impl;

import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.entity.MatchesEntity;
import ir.hossein.footballPrediction.mapper.MatchesMapper;
import ir.hossein.footballPrediction.model.MatchesModel;
import ir.hossein.footballPrediction.ropository.GuessRepo;
import ir.hossein.footballPrediction.ropository.MatchesRepo;
import ir.hossein.footballPrediction.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MatchesServiceImpl implements MatchesService {

    @Autowired
    private MatchesRepo matchesRepo;

    @Autowired
    private MatchesMapper matchesMapper;

    @Autowired
    private GuessRepo guessRepo;


    @Override
    public List<MatchesModel> getMatch() {
        List<MatchesEntity> matchesEntityList = matchesRepo.getMatch();
        return matchesMapper.convertListToListModel(matchesEntityList);
    }

    @Override
    public void saveMatch(MatchesModel matchesModel) {
        MatchesEntity matchesEntity = matchesMapper.convertToEntity(matchesModel);
        matchesRepo.saveMatch(matchesEntity);
    }

    @Override
    public MatchesModel getMatch(int matchesId) {
        MatchesEntity matchesEntity = matchesRepo.getMatch(matchesId);
        return matchesMapper.convertToModel(matchesEntity);
    }

    @Override
    public void deleteMatch(int matchesId) {
        matchesRepo.deleteMatch(matchesId);
    }

    @Override
    public void setAllUserScores(int matchesId) {
        List<GuessEntity> listGuessEntity = matchesRepo.setAllUserScores(matchesId);
        MatchesModel matchModel = getMatch(matchesId);
        for (int i = 0; i <listGuessEntity.size();i++){
            boolean flag = true;
            GuessEntity guessEntity = listGuessEntity.get(i);
            Integer score=0;
            if (guessEntity.getGuessHomeGoal()==matchModel.getHomeGoal()
                    && guessEntity.getGuessAwayGoal()==matchModel.getAwayGoal()){
                score+=3;
                flag = false;
            }
            if (flag){
                if ( guessEntity.getGuessHomeGoal() == matchModel.getHomeGoal()
                        || guessEntity.getGuessAwayGoal() == matchModel.getAwayGoal()){
                    score+=1;
                }
            }

            guessEntity.setScore(score);
            guessRepo.saveGuess(guessEntity);
        }
    }
}
