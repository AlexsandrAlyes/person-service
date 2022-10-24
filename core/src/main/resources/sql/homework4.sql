--Добавление дубликатов
insert into address (id, country_id, city, index, street, building, flat, contact_id) values (55, 40, 'Santa Helena', 6463, '7482 Esker Street', '47.43.111.42', '81', 46);
insert into address (id, country_id, city, index, street, building, flat, contact_id) values (54, 23, 'Kupino', 8607, '550 Brickson Park Hill', '170.65.138.126', '17087', 47);
insert into address (id, country_id, city, index, street, building, flat, contact_id) values (53, 28, 'Bobadela', 5232, '43 Oak Place', '69.226.171.92', '62282', 48);
insert into address (id, country_id, city, index, street, building, flat, contact_id) values (52, 69, 'Helsingborg', 6363, '5796 Knutson Pass', '156.212.58.7', '3757', 49);
insert into address (id, country_id, city, index, street, building, flat, contact_id) values (51, 98, 'Zürich', 8917, '285 Cottonwood Point', '50.214.68.167', '69', 50);

--удаление дубликатов
delete from address where id not in (
    select id from (
                     select min(id) as id
                     from address
                     group by country_id, city, index,street,building,flat) unique_rows
);