insert into
    users (email, password, webpage_id)
values
    ('admin@example.com', '{noop}adminpass', null),   -- 1
    ('user@example.com', '{noop}userpass', null),     -- 2
    ('robert.kusz1998@example.com', '{noop}robert.kusz1998', 1), -- 3
    ('robinkusz11@example.com', '{noop}robinkusz11', 2), -- 3
    ('demmon11@example.com', '{noop}demmon11', 3); -- 3

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