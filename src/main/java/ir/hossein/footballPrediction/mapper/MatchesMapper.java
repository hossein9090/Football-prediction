package ir.hossein.footballPrediction.mapper;


import ir.hossein.footballPrediction.entity.MatchesEntity;
import ir.hossein.footballPrediction.model.MatchesModel;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MatchesMapper {

    MatchesEntity convertToEntity(MatchesModel matchesModel);

    MatchesModel convertToModel(MatchesEntity matchesEntity);

    List<MatchesModel> convertListToListModel(List<MatchesEntity> matchesEntityList);

    List<MatchesEntity> convertListToListEntity(List<MatchesModel> matchesModelList);
}
