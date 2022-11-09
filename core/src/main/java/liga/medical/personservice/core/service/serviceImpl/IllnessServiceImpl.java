package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Illness;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.core.service.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IllnessServiceImpl implements IllnessService {

    private final IllnessRepository illnessRepository;

    @Override
    public List<Illness> getAllIllnesses() {
        List<Illness> illnessList = new ArrayList<>();
        illnessRepository.findAll().forEach(illnessList::add);
        return illnessList;
    }

    @Override
    public Illness getIllnessById(long id) {
        return illnessRepository.findById(id).get();
    }

    @Override
    public Illness saveIllness(Illness illness) {
        return illnessRepository.save(illness);
    }

    @Override
    public void deleteIllnessById(long id) {
        illnessRepository.deleteById(id);
    }

}
