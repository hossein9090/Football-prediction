package ir.hossein.footballPrediction.service.impl;


import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.mapper.GuessMapper;
import ir.hossein.footballPrediction.model.GuessModel;
import ir.hossein.footballPrediction.ropository.GuessRepo;
import ir.hossein.footballPrediction.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuessServiceImpl implements GuessService {

    @Autowired
    private GuessRepo guessRepo;

    @Autowired
    private GuessMapper guessMapper;


    @Override
    public List<GuessModel> getGuess() {
        List<GuessEntity> guessEntityList = guessRepo.getGuess();
        return guessMapper.convertListToListModel(guessEntityList);
    }

    @Override
    public void saveGuess(GuessModel guessModel) {
        GuessEntity guessEntity = guessMapper.convertToEntity(guessModel);
        guessRepo.saveGuess(guessEntity);
    }

    @Override
    public GuessModel getGuess(int guessId) {
        GuessEntity guessEntity = guessRepo.getGuess(guessId);
        return guessMapper.convertToModel(guessEntity);
    }

    @Override
    public void deleteGuess(int guessId) {
        guessRepo.deleteGuess(guessId);
    }
}
