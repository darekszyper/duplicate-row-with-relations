-- Wstawianie danych do tabeli person
INSERT INTO public.person(id, first_name, last_name, pesel)
VALUES (1, 'John', 'Doe', '12345678901');

-- Wstawianie danych do tabeli address (adres 1)
INSERT INTO public.address(city, country, house_number, street, person_id)
VALUES ('Warsaw', 'Poland', '123', 'Main Street', 1);

-- Wstawianie danych do tabeli address (adres 2)
INSERT INTO public.address(city, country, house_number, street, person_id)
VALUES ('New York', 'USA', '456', 'Broadway', 1);

-- Wstawianie danych do tabeli document (dokument 1)
INSERT INTO public.document(expiration_date, series_number, type, person_id)
VALUES ('2023-12-31', 'ABC123', 'Passport', 1);

-- Wstawianie danych do tabeli document (dokument 2)
INSERT INTO public.document(expiration_date, series_number, type, person_id)
VALUES ('2024-06-30', 'DEF456', 'Drivers License', 1);

SELECT setval('person_id_seq', 1, true);