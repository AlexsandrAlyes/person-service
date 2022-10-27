package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.MedicalCardMapper;
import liga.medical.personservice.core.dto.model.MedicalCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalCardService {

    private final MedicalCardMapper medicalCardMapper;

    public List<MedicalCard> getAllMedicalCard() {
        return medicalCardMapper.listMedicalCard();
    }

    public MedicalCard getMedicalCardById(long id) {
        return medicalCardMapper.getMedicalCardById(id);
    }

    public void addMedicalCardInDB(MedicalCard medicalCard) {
        medicalCardMapper.addMedicalCardInDB(medicalCard);
    }

    public void deleteMedicalCardInDB(long id) {
        medicalCardMapper.deleteMedicalCardById(id);
    }
}
