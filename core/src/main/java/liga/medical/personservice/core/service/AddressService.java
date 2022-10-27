package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.AddressMapper;
import liga.medical.personservice.core.dto.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressMapper addressMapper;

    public List<Address> getAllAddress() {
        return addressMapper.listAddress();
    }

    public Address getAddressById(long id) {
        return addressMapper.getAddressById(id);
    }

    public void addAddressInDB(Address address) {
        addressMapper.addAddressInDB(address);
    }

    public void deleteAddressInDB(long id) {
        addressMapper.deleteAddressById(id);
    }
}
