use managementweb;

insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into user(username,password,fullname,status, roleid) values('admin','123456','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','nguyen van a',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','nguyen van b',1,2);

insert into category(name,count_use) values('Sự Kiện',0),('Xã hội',0),('Thế giới',0),('Kinh doanh',0),('Bất động sản',0),('Thể thao',0),
('Sức khỏe',0),('Pháp luật',0),('Khoa học',0),('Chuyện lạ',0);
