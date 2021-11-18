INSERT INTO tipo_usuario (nombre) VALUES ('Cliente');
INSERT INTO tipo_usuario (nombre) VALUES ('Personal_de_Limpieza');
INSERT INTO tipo_usuario (nombre) VALUES ('Administrador');

INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$yyfMs7yIs/UHnJ4D7r.diOc5ofJgOQKVVo10zMWAU0QTe3ngliK4O','cliente',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$BaK6uXKaDcb6e8vsfbapDuhPWQRZcoDKKUjx5dJXeFYHhr7rg775q','JuanC',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$VgdKdZ/.KeSw0JSBOiyUdeIUyhI2xAY4xQ/0Aljb39dNAFTYQhvLC','personal',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$7j0Of9blyHI8u7g68P2RQu0rY9.GgL4n59Bch8MiFY8w92iIdsaty','MartaP',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$UCGyX7aXX4jugVnQNt.9pOzEhOLD1z2KVzbZK/Bi1Dy6KZiqhZOy2','admin',3);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$YoFCzLm1QmriVhTBKdE.8e7k.NRn16En9b3tmQIUx3L4FH1RicEbe','cliente2',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('$2a$10$YPqNo3suD2e0ZxJuS7Afq.KyWmoMFgrCG9QRUcW8mWthM.ThP/bHC','personal2',2);

INSERT INTO administrador (apellidos,email,nombre,id_usuario) VALUES ('Pacheco Diaz','pacheco@gmail.com','Alberto',5);

INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Torres Arias',978563412,'torres@gmail.com','Ana',1);
INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Castillo Flores',975372412,'Juan1234@gmail.com','Juan',2);
INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Galindo Torres',915300012,'JoseGT@gmail.com','Jose',6);

INSERT INTO personal_limpieza (apellidos,celular,descripcion,email,nombre, habilitado,id_usuario) VALUES ('Paz Jara',918173446,'especialista en limpieza de suelo laminado','12345mp@gmail.com','Marta',true,4);
INSERT INTO personal_limpieza (apellidos,celular,descripcion,email,nombre, habilitado,id_usuario) VALUES ('Galvez Acosta',912433412,'10 años de experiencia en limpieza','pedro123@gmail.com','Pedro',true,3);
INSERT INTO personal_limpieza (apellidos,celular,descripcion,email,nombre, habilitado,id_usuario) VALUES ('Acosta Granados',924516778,'especializata en limpiado de ventanas','pedroAG@gmail.com','Mario',true,7);


INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_personal_limpieza) VALUES (true,true,true,true,true,true,true,1);
INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_personal_limpieza) VALUES (false,true,true,true,true,true,true,2);
INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_personal_limpieza) VALUES (true,true,true,true,true,false,false,3);

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


INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Las Acacias  N°23',1,5);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Tomas Valle N°44',1,6);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Jr. Lampa 580',1,8);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('psje. Tello 258',1,18);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Univeritaria N°123',1,3);

INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Javier Prado N°12',2,13);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Jr. Carabaya',2,10);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Javier Prado N°12',2,13);

INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Av. Tomas Marsano',3,15);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Jr. Cailloma 477',3,9);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Psje. Martinetti 122',3,11);
INSERT INTO propiedad (direccion,id_cliente,id_distrito) VALUES ('Psje. Acuña 131',3,12);

INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (2,'realizado','2021-10-17', '08:00',true,80,2,1);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (3,'realizado','2021-10-19', '09:30',true,85,3,2);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (3,'realizado','2021-10-12', '10:00',false,100,1,3);

INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (3,'realizado','2021-10-20', '11:00',false,95,2,7);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (4,'realizado','2021-10-22', '08:30',false,85,3,8);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (2,'realizado','2021-10-25', '11:30',true,95,1,6);

INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (3,'realizado','2021-10-10', '10:45',false,95,2,10);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (4,'realizado','2021-10-27', '09:45',true,90,3,11);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (4,'realizado','2021-10-30', '08:45',true,100,1,12);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_personal_limpieza,id_propiedad) VALUES (2,'realizado','2021-10-15', '11:45',false,80,1,9);


INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,2,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,4,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,5,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,6,1);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,2,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,3,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,4,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,2);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,1,3);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,3);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,3,3);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,4,3);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,3);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,6,3);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (4,1,4);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,2,4);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,3,4);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,4,4);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,5,4);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,6,4);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,1,5);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,5);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,5);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,4,5);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,5,5);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,6,5);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (4,1,6);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,6);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,3,6);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,4,6);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,6);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,6,6);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,1,7);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,7);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,3,7);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,4,7);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,5,7);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,7);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (5,1,8);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,8);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,8);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,4,8);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,5,8);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,6,8);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,9);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,2,9);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,9);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,4,9);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,9);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,6,9);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,1,10);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,2,10);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,10);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (0,4,10);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,5,10);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,6,10);

INSERT INTO parametro (nombre,valor,unidad) VALUES ('Tiempo de limpieza',45,'minutos');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo de promedio',15,'soles/hora');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo kit',50,'soles/hora');
