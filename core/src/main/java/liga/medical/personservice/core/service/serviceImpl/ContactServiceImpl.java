package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Contact;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        contactRepository.findAll().forEach(contactList::add);
        return contactList;
    }

    @Override
    public Contact getContactById(long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(long id) {
        contactRepository.deleteById(id);
    }

}
