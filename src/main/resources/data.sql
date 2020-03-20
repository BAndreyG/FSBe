DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM news;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (surname,name,patronymic,gender, password) VALUES
  ('Васёв','Вася','Васильевич','m', 'user'),
  ('Петров','Петя','Петрович','m', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO categorys(name)
VALUES ('mobile'),
       ('coronovirus'),
       ('travel'),
       ('fishing');

INSERT INTO user_category(user_id,category_id)
VALUES (100000,100002),
       (100000,100003),
       (100000,100004),
       (100001,100005);

INSERT INTO news (head,mintext,news,category_id,link)
VALUES ('Ёмобила','В Сколково изобрели новый телефон','...из наночастиц... наноразмеры... ищут...',100002,'www://skolkovo.ru'),
       ('Пандемия','Смертельная зараза на пороге','Китай чихал на весь мир, многии болеют...',100003,'www://medicina.ru'),
       ('Австралия','Сумчатые животные ','Коала объелась листьев эвкалипта и обогнала кенгуру',100004,'www://worldtravel.ru'),
       ('Спортивная рыбалка','На Амуре прошли соревнования по спортивной рыбалке','Победил рыбак поймавший больше всех рыбы',100005,'www://amur.ru'),
       ('Прекрасная Якутия','Самые лучшие экстремальные путешествия','Туристы со всей страны рвуться в Якутию посмотреть на её красоты',100004,'www://ykyti.ru');