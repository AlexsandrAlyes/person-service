package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.ContactMapper;
import liga.medical.personservice.core.dto.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMapper contactMapper;

    public List<Contact> getAllContacts() {
        return contactMapper.listContacts();
    }

    public Contact getContactById(long id) {
        return contactMapper.getContactById(id);
    }

    public void addContactInDB(Contact contact) {
        contactMapper.addContactInDB(contact);
    }

    public void deleteContactInDB(long id) {
        contactMapper.deleteContactById(id);
    }
}
