package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.Address;
import liga.medical.personservice.core.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/address")
    public ResponseEntity<String> addAddressInDB(@RequestBody Address address) {
        addressService.addAddressInDB(address);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<String> deleteAddressInDB(@PathVariable long id) {
        addressService.deleteAddressInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}