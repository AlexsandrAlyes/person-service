package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.model.Contact;
import liga.medical.personservice.core.service.ContactService;
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
@Api(value = "Api для работы с контактами")
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contact")
    @ApiOperation(value = "Получение всех контактов")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{id}")
    @ApiOperation(value = "Получение контакта по id")
    public Contact getContactById(@PathVariable long id) {
        return contactService.getContactById(id);
    }

    @PostMapping("/contact")
    @ApiOperation(value = "Добавление нового контакта")
    public ResponseEntity<String> addContactInDB(@RequestBody Contact contact) {
        contactService.addContactInDB(contact);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/contact/{id}")
    @ApiOperation(value = "Удаление контакта по id")
    public ResponseEntity<String> deleteContactInDB(@PathVariable long id) {
        contactService.deleteContactInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
