package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact saveContact(Contact contact);

    Contact getContactById(long id);

    void deleteContactById(long id);

}