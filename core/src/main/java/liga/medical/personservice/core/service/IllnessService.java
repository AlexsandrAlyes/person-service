package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.Illness;

import java.util.List;

public interface IllnessService {

    List<Illness> getAllIllnesses();

    Illness getIllnessById(long id);

    Illness saveIllness(Illness illness);

    void deleteIllnessById(long id);

}