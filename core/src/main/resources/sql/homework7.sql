create view full_info_client as select pd.id,
                                       pd.first_name,
                                       pd.last_name,
                                       pd.age,
                                       pd.sex,
                                       ct.phone_number,
                                       ct.email,
                                       ad.city,
                                       ad.street
from person_data pd join contact ct on pd.contact_id = ct.id
                    join address ad on ad.contact_id = ct.id;