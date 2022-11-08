package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.dto.model.Contact;
import liga.medical.personservice.core.dto.model.MedicalCard;
import liga.medical.personservice.core.dto.model.PersonData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDataRowMapper implements RowMapper<PersonData> {

    @Override
    public PersonData mapRow(ResultSet resultSet, int i) throws SQLException {
        PersonData personData = new PersonData();
        personData.setId(resultSet.getLong("id"));
        personData.setFirstName(resultSet.getString("first_name"));
        personData.setLastName(resultSet.getString("last_name"));
        personData.setBirthDate(resultSet.getDate("birth_date"));
        personData.setAge(resultSet.getLong("age"));
        personData.setSex(resultSet.getString("sex"));

        Contact contact = new Contact();
        contact.setId(resultSet.getLong("contact_id"));
        contact.setEmail(resultSet.getString("email"));
        contact.setPhoneNumber(resultSet.getString("phone_number"));
        contact.setProfileLink(resultSet.getString("profile_link"));

        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setId(resultSet.getLong("medical_card_id"));
        medicalCard.setClientStatus(resultSet.getString("client_status"));
        medicalCard.setMedStatus(resultSet.getString("med_status"));
        medicalCard.setRegistryDate(resultSet.getDate("registry_date"));
        medicalCard.setComment(resultSet.getString("comment"));

        List<PersonData> parents = new ArrayList<>();
        PersonData parent = new PersonData();

        parents.add(parent);

        personData.setContact(contact);
        personData.setMedicalCard(medicalCard);
        personData.setParents(parents);

        return personData;

    }
}
