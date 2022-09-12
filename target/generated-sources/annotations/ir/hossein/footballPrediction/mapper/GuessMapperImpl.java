package ir.hossein.footballPrediction.mapper;

import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.model.GuessModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-11T11:46:43+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0-262 (OpenLogic-OpenJDK)"
)
@Component
public class GuessMapperImpl implements GuessMapper {

    @Override
    public GuessEntity convertToEntity(GuessModel guessModel) {
        if ( guessModel == null ) {
            return null;
        }

        GuessEntity guessEntity = new GuessEntity();

        guessEntity.setId( guessModel.getId() );
        guessEntity.setUserId( guessModel.getUserId() );
        guessEntity.setMatchId( guessModel.getMatchId() );
        if ( guessModel.getGuessHomeGoal() != null ) {
            guessEntity.setGuessHomeGoal( guessModel.getGuessHomeGoal() );
        }
        if ( guessModel.getGuessAwayGoal() != null ) {
            guessEntity.setGuessAwayGoal( guessModel.getGuessAwayGoal() );
        }
        guessEntity.setScore( guessModel.getScore() );

        return guessEntity;
    }

    @Override
    public GuessModel convertToModel(GuessEntity guessEntity) {
        if ( guessEntity == null ) {
            return null;
        }

        GuessModel guessModel = new GuessModel();

        guessModel.setId( guessEntity.getId() );
        guessModel.setUserId( guessEntity.getUserId() );
        guessModel.setMatchId( guessEntity.getMatchId() );
        guessModel.setGuessHomeGoal( guessEntity.getGuessHomeGoal() );
        guessModel.setGuessAwayGoal( guessEntity.getGuessAwayGoal() );
        guessModel.setScore( guessEntity.getScore() );

        return guessModel;
    }

    @Override
    public List<GuessModel> convertListToListModel(List<GuessEntity> guessEntityList) {
        if ( guessEntityList == null ) {
            return null;
        }

        List<GuessModel> list = new ArrayList<GuessModel>( guessEntityList.size() );
        for ( GuessEntity guessEntity : guessEntityList ) {
            list.add( convertToModel( guessEntity ) );
        }

        return list;
    }

    @Override
    public List<GuessEntity> convertListToListEntity(List<GuessModel> guessModelList) {
        if ( guessModelList == null ) {
            return null;
        }

        List<GuessEntity> list = new ArrayList<GuessEntity>( guessModelList.size() );
        for ( GuessModel guessModel : guessModelList ) {
            list.add( convertToEntity( guessModel ) );
        }

        return list;
    }
}
