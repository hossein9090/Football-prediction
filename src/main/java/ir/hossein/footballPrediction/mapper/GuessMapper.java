package ir.hossein.footballPrediction.mapper;


import ir.hossein.footballPrediction.entity.GuessEntity;
import ir.hossein.footballPrediction.model.GuessModel;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GuessMapper {

    GuessEntity convertToEntity(GuessModel guessModel);

    GuessModel convertToModel(GuessEntity guessEntity);

    List<GuessModel> convertListToListModel(List<GuessEntity> guessEntityList);

    List<GuessEntity> convertListToListEntity(List<GuessModel> guessModelList);
}
