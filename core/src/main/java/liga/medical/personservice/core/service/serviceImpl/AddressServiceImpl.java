package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Address;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addressList = new ArrayList<>();
        addressRepository.findAll().forEach(addressList::add);
        return addressList;
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(long id) {
        addressRepository.deleteById(id);
    }

}
