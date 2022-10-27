package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.IllnessMapper;
import liga.medical.personservice.core.dto.model.Illness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IllnessService {

    private final IllnessMapper illnessMapper;

    public List<Illness> getAllIllness() {
        return illnessMapper.listIllness();
    }

    public Illness getIllnessById(long id) {
        return illnessMapper.getIllnessById(id);
    }

    public void addIllnessInDB(Illness illness) {
        illnessMapper.addIllnessInDB(illness);
    }

    public void deleteIllnessInDB(long id) {
        illnessMapper.deleteIllnessById(id);
    }
}
