package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contact")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{id}")
    public Contact getContactById(@PathVariable long id) {
        return contactService.getContactById(id);
    }

    @PostMapping("/contact")
    public ResponseEntity<String> addContactInDB(@RequestBody Contact contact) {
        contactService.addContactInDB(contact);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<String> deleteContactInDB(@PathVariable long id) {
        contactService.deleteContactInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
