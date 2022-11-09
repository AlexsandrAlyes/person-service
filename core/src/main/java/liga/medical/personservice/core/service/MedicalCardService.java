package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.MedicalCard;

import java.util.List;

public interface MedicalCardService {

    List<MedicalCard> getAllMedicalCards();

    MedicalCard getMedicalCardById(long id);

    MedicalCard saveMedicalCard(MedicalCard medicalCard);

    void deleteMedicalCardById(long id);

}