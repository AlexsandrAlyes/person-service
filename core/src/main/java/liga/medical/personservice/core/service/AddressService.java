package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();

    Address saveAddress(Address address);

    Address getAddressById(long id);

    void deleteAddressById(long id);

}