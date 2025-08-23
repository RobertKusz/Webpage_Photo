insert into users (
    id, email, password, first_name, last_name, face_book, instagram,
    logo_home_filename, miniature_filename, home_page_id, about_me_page_id, contact_page_id, portfolio_page_id, portfolio_description,photographing_type
) values
(1, 'admin@example.com', '{noop}adminpass', 'Admin', 'Root', null,null,null,null,null,null, NULL,NULL,null,null),
(2, 'user@example.com', '{noop}userpass', 'User', 'Normal', null,null,null,null,null,null, NULL,NULL,null,null),
(3, 'robert.kusz1998@example.com', '{noop}robert.kusz1998', 'Robert', 'Kusz', 'fb.com/robert.kusz', 'instagram.com/robertkusz', 'empty-logo.png', 'empty_img.jpg', 1, NULL, NULL, NULL, 'Profesjonalny fotograf ślubny','wedding'),
(4, 'robinkusz11@example.com', '{noop}robinkusz11', 'Robin', 'Kusz', 'fb.com/robinkusz', 'instagram.com/robinkusz11', 'empty-logo.png', 'empty_img.jpg', 2, NULL, NULL, NULL, 'Fotograf portretowy z pasją','portrait'),
(5, 'demmon11@example.com', '{noop}demmon11', 'Damian', 'Emmon', 'fb.com/demmon', 'instagram.com/demmon11', 'empty-logo.png', 'empty_img.jpg', 3, NULL, NULL, NULL, 'Zajmuję się fotografią sportową','landscape');

insert into
    user_role (name, description)
values
    ('ADMIN', 'pełne uprawnienia'),   -- 1
    ('USER', 'podstawowe uprawnienia, możliwość odeny i dodawanie komentarzy'),   -- 2
    ('PHOTOGRAPH', 'podstawowe uprawnienia + możliwość zarządzania treściami');   -- 3

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 3),
    (5, 3);