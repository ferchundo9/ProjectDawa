
insert into projectdawa.tarjeta values ('1111111111111111','12/21');
insert into projectdawa.tarjeta values ('2222222222222222','12/21');
insert into projectdawa.tarjeta values ('3333333333333333','12/21');
insert into projectdawa.tarjeta values ('4444444444444444','12/21');
insert into projectdawa.tarjeta values ('5555555555555555','12/21');


insert into projectdawa.usuario values('Admin','admin@mail.com','1234','falsa 1234', null,'admin','5555555555555555' );

insert into projectdawa.usuario (Nombre,Email,Contrasena,Direccion,VIP,Tarjeta)values('Miguel','miguel@mail.com','1111','falsa 1234',1,'1111111111111111' );
insert into projectdawa.usuario (Nombre,Email,Contrasena,Direccion,VIP,Tarjeta)values('Raquel','ra@mail.com','1111','falsa 1234', 1,'2222222222222222' );
insert into projectdawa.usuario (Nombre,Email,Contrasena,Direccion,Tarjeta)values('Carlos','carlos@mail.com','1111','falsa 1234','3333333333333333' );
insert into projectdawa.usuario (Nombre,Email,Contrasena,Direccion,Tarjeta)values('Fernando','fer@mail.com','1111','falsa 1234','4444444444444444' );


insert into projectdawa.item values(1,'3.5');
insert into projectdawa.item values(2,'3.5');
insert into projectdawa.item values(3,'4.60');
insert into projectdawa.item values(4,'13.2');

insert into projectdawa.cd values (1,'bohemian rhapsody','Queen','1975');
insert into projectdawa.cd values (2,'thriller','Michael Jackson','1982');
insert into projectdawa.cd values (3,'nevermind','Nirvana','1991');
insert into projectdawa.cd values (4,'highway to hell','ACDC','1979');

insert into projectdawa.inventario values(1,'5');
insert into projectdawa.inventario values(2,'3');
insert into projectdawa.inventario values(3,'8');
insert into projectdawa.inventario values(4,'1');

insert into projectdawa.pedido(precio,fecha,email) values(4.60,'02/04/2019','miguel@mail.com');
insert into projectdawa.pedido(precio,fecha,email) values(3.5,'12/03/2019','miguel@mail.com');

insert into projectdawa.pedido(precio,fecha,email) values(7,'02/04/2019','ra@mail.com');
insert into projectdawa.pedido(precio,fecha,email) values(16.7,'02/04/2019','carlos@mail.com');

insert into projectdawa.itemspedido values(1,3,1);
insert into projectdawa.itemspedido values(2,1,1);

insert into projectdawa.itemspedido values(3,2,2);
insert into projectdawa.itemspedido values(4,4,1);
insert into projectdawa.itemspedido values(4,2,1);

