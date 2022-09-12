package ir.hossein.footballPrediction.mapper;

import ir.hossein.footballPrediction.entity.MatchesEntity;
import ir.hossein.footballPrediction.model.MatchesModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-11T11:46:42+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0-262 (OpenLogic-OpenJDK)"
)
@Component
public class MatchesMapperImpl implements MatchesMapper {

    @Override
    public MatchesEntity convertToEntity(MatchesModel matchesModel) {
        if ( matchesModel == null ) {
            return null;
        }

        MatchesEntity matchesEntity = new MatchesEntity();

        matchesEntity.setId( matchesModel.getId() );
        matchesEntity.setHomeTeam( matchesModel.getHomeTeam() );
        matchesEntity.setAwayTeam( matchesModel.getAwayTeam() );
        matchesEntity.setHomeGoal( matchesModel.getHomeGoal() );
        matchesEntity.setAwayGoal( matchesModel.getAwayGoal() );
        matchesEntity.setStatus( matchesModel.getStatus() );

        return matchesEntity;
    }

    @Override
    public MatchesModel convertToModel(MatchesEntity matchesEntity) {
        if ( matchesEntity == null ) {
            return null;
        }

        MatchesModel matchesModel = new MatchesModel();

        matchesModel.setId( matchesEntity.getId() );
        matchesModel.setHomeTeam( matchesEntity.getHomeTeam() );
        matchesModel.setAwayTeam( matchesEntity.getAwayTeam() );
        matchesModel.setHomeGoal( matchesEntity.getHomeGoal() );
        matchesModel.setAwayGoal( matchesEntity.getAwayGoal() );
        matchesModel.setStatus( matchesEntity.getStatus() );

        return matchesModel;
    }

    @Override
    public List<MatchesModel> convertListToListModel(List<MatchesEntity> matchesEntityList) {
        if ( matchesEntityList == null ) {
            return null;
        }

        List<MatchesModel> list = new ArrayList<MatchesModel>( matchesEntityList.size() );
        for ( MatchesEntity matchesEntity : matchesEntityList ) {
            list.add( convertToModel( matchesEntity ) );
        }

        return list;
    }

    @Override
    public List<MatchesEntity> convertListToListEntity(List<MatchesModel> matchesModelList) {
        if ( matchesModelList == null ) {
            return null;
        }

        List<MatchesEntity> list = new ArrayList<MatchesEntity>( matchesModelList.size() );
        for ( MatchesModel matchesModel : matchesModelList ) {
            list.add( convertToEntity( matchesModel ) );
        }

        return list;
    }
}
