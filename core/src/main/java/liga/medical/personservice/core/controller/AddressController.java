package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.entity.Address;
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
@Api(value = "Api по работе с адресами")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address")
    @ApiOperation(value = "Получение всех адрессов")
    public List<Address> getAllAddress() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    @ApiOperation(value = "Получение адреса по id")
    public Address getAddressById(@PathVariable long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/address")
    @ApiOperation(value = "Добавление нового адреса")
    public ResponseEntity<String> addAddressInDB(@RequestBody Address address) {
        addressService.saveAddress(address);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/address/{id}")
    @ApiOperation(value = "Удаление адреса по id")
    public ResponseEntity<String> deleteAddressInDB(@PathVariable long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}