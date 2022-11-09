package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.MedicalCard;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    @Override
    public List<MedicalCard> getAllMedicalCards() {
        List<MedicalCard> medicalCardList = new ArrayList<>();
        medicalCardRepository.findAll().forEach(medicalCardList::add);
        return medicalCardList;
    }

    @Override
    public MedicalCard getMedicalCardById(long id) {
        return medicalCardRepository.findById(id).get();
    }

    @Override
    public MedicalCard saveMedicalCard(MedicalCard medicalCard) {
        return medicalCardRepository.save(medicalCard);
    }

    @Override
    public void deleteMedicalCardById(long id) {
        medicalCardRepository.deleteById(id);
    }

}
