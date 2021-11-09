INSERT INTO tipo_usuario (nombre) VALUES ('Cliente');
INSERT INTO tipo_usuario (nombre) VALUES ('Personal de limpieza');
INSERT INTO tipo_usuario (nombre) VALUES ('Administrador');

INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$yyfMs7yIs/UHnJ4D7r.diOc5ofJgOQKVVo10zMWAU0QTe3ngliK4O','cliente',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$BaK6uXKaDcb6e8vsfbapDuhPWQRZcoDKKUjx5dJXeFYHhr7rg775q','JuanC',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$VgdKdZ/.KeSw0JSBOiyUdeIUyhI2xAY4xQ/0Aljb39dNAFTYQhvLC','personal',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$7j0Of9blyHI8u7g68P2RQu0rY9.GgL4n59Bch8MiFY8w92iIdsaty','MartaP',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$UCGyX7aXX4jugVnQNt.9pOzEhOLD1z2KVzbZK/Bi1Dy6KZiqhZOy2','admin',3);

INSERT INTO administrador (apellidos,email,nombre,id_usuario) VALUES ('Pacheco Diaz','pachecoD@gmail.com','Alberto',5);

INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Torres Arias',978563412,'torresA@gmail.com','Ana',1);
INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Castillo Flores',975372412,'Juan1234@gmail.com','Juan',2);

INSERT INTO personal_limpieza (apellidos,celular,descripcion,email,nombre, habilitado,id_usuario) VALUES ('Paz Jara',918173446,'especialista en limpieza de suelo laminado','12345MP@gmail.com','Marta',true,4);
INSERT INTO personal_limpieza (apellidos,celular,descripcion,email,nombre, habilitado,id_usuario) VALUES ('Galvez Acosta',912433412,'10 aÃ±os de experiencia en limpieza','pedro123@gmail.com','Pedro',true,3);


INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_personal_limpieza) VALUES (true,true,true,true,true,true,true,2);
INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_personal_limpieza) VALUES (true,true,true,true,true,true,true,1);

INSERT INTO ambiente (nombre) VALUES ('Dormitorio');
INSERT INTO ambiente (nombre) VALUES ('Comedor');
INSERT INTO ambiente (nombre) VALUES ('Cocina');
INSERT INTO ambiente (nombre) VALUES ('Biblioteca');
INSERT INTO ambiente (nombre) VALUES ('Baño');
INSERT INTO ambiente (nombre) VALUES ('Sala');



INSERT INTO distrito (nombre) VALUES ('Ancon');
INSERT INTO distrito (nombre) VALUES ('Ate');
INSERT INTO distrito (nombre) VALUES ('Barranco');
INSERT INTO distrito (nombre) VALUES ('Breña');
INSERT INTO distrito (nombre) VALUES ('Carabayllo');
INSERT INTO distrito (nombre) VALUES ('Chaclacayo');
INSERT INTO distrito (nombre) VALUES ('Chorrillos');
INSERT INTO distrito (nombre) VALUES ('Cieneguilla');
INSERT INTO distrito (nombre) VALUES ('Comas');
INSERT INTO distrito (nombre) VALUES ('El Agustino');
INSERT INTO distrito (nombre) VALUES ('Independencia');
INSERT INTO distrito (nombre) VALUES ('Jesus Maria');
INSERT INTO distrito (nombre) VALUES ('La Molina');
INSERT INTO distrito (nombre) VALUES ('La Victoria');
INSERT INTO distrito (nombre) VALUES ('Lima');
INSERT INTO distrito (nombre) VALUES ('Lince');
INSERT INTO distrito (nombre) VALUES ('Los Olivos');
INSERT INTO distrito (nombre) VALUES ('Lurigancho');
INSERT INTO distrito (nombre) VALUES ('Lurin');
INSERT INTO distrito (nombre) VALUES ('Magdalena del Mar');
INSERT INTO distrito (nombre) VALUES ('Miraflores');
INSERT INTO distrito (nombre) VALUES ('Pachacamac');
INSERT INTO distrito (nombre) VALUES ('Pucusana');
INSERT INTO distrito (nombre) VALUES ('Pueblo Libre');
INSERT INTO distrito (nombre) VALUES ('Puente Piedra');
INSERT INTO distrito (nombre) VALUES ('Punta Hermosa');
INSERT INTO distrito (nombre) VALUES ('Punta Negra');
INSERT INTO distrito (nombre) VALUES ('Rimac');
INSERT INTO distrito (nombre) VALUES ('San Bartolo');
INSERT INTO distrito (nombre) VALUES ('San Borja');
INSERT INTO distrito (nombre) VALUES ('San Isidro');
INSERT INTO distrito (nombre) VALUES ('San Juan de Lurigancho');
INSERT INTO distrito (nombre) VALUES ('San Juan de Miraflores');
INSERT INTO distrito (nombre) VALUES ('San Luis');
INSERT INTO distrito (nombre) VALUES ('San Martin de Porres');
INSERT INTO distrito (nombre) VALUES ('San Miguel');
INSERT INTO distrito (nombre) VALUES ('Santa Anita');
INSERT INTO distrito (nombre) VALUES ('Santa Maria del Mar');
INSERT INTO distrito (nombre) VALUES ('Santa Rosa');
INSERT INTO distrito (nombre) VALUES ('Santiago de Surco');
INSERT INTO distrito (nombre) VALUES ('Surquillo');
INSERT INTO distrito (nombre) VALUES ('Villa El Salvador');
INSERT INTO distrito (nombre) VALUES ('Villa Maria del Triunfo');

INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Univeritaria N°123',2,3);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Las Acacias  N°23',1,5);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Tomas Valle N°44',1,6);

INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (2,'realizado','2019-07-17', '08:00',true,80,2,1);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (3,'realizado','2019-07-17', '08:00',true,90,2,2);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,2,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,4,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,5,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,1);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,2,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,3,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,4,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,2);

INSERT INTO parametro (nombre,valor,unidad) VALUES ('Tiempo de limpieza',45,'minutos');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo de promedio',15,'soles/hora');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo kit',50,'soles/hora');
