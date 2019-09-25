

INSERT INTO empleados (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('José', 'Lovon Vega','74417486','1998-02-17','joslui1720082@gmail.com',true, 982087241);
INSERT INTO empleados (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('Miguel Angel', 'Calderon','74417222','1998-03-20','miguelcalderon@gmail.com',true, 998523641);
INSERT INTO empleados (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('Alex', 'Meza','744174309','1998-08-02','alexmeza@gmail.com',true, 963647894);

INSERT INTO clientes (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('Maria', 'Lopez','75893615','1988-10-15','marialo88@gmail.com',false, 923619866);
INSERT INTO clientes (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('Pedro', 'Fierro Ramos','78152366','1990-01-27','pedrofierro27@gmail.com',true, 923651889);
INSERT INTO clientes (nombre,apellido,dni,fechaNacimiento,correo, sexo, celular) VALUES ('Juan', 'Pacheco','79856214','1999-05-16','pacheco05123@gmail.com',true, 993652784);

INSERT INTO departamentos (nombre) VALUES ('Lima');
INSERT INTO departamentos (nombre) VALUES ('Ayacucho');
INSERT INTO departamentos (nombre) VALUES ('Cusco');
INSERT INTO departamentos (nombre) VALUES ('Madre de Dios');
INSERT INTO departamentos (nombre) VALUES ('Tacna');
INSERT INTO departamentos (nombre) VALUES ('Piura');
INSERT INTO departamentos (nombre) VALUES ('Arequipa');
INSERT INTO departamentos (nombre) VALUES ('Puno');

INSERT INTO cargos (nombre) VALUES ('Recepcionista');
INSERT INTO cargos (nombre) VALUES ('Consultor de Viajes');

INSERT INTO buses (placa,cantAsiento) VALUES ('ABC526', 40);
INSERT INTO buses (placa,cantAsiento) VALUES ('XYZ158', 40);
INSERT INTO buses (placa,cantAsiento) VALUES ('AXH165', 40);
INSERT INTO buses (placa,cantAsiento) VALUES ('FJB635', 40);
INSERT INTO buses (placa,cantAsiento) VALUES ('BVR365', 40);

INSERT INTO asientos(piso,bus_id) VALUES (1,1);
INSERT INTO asientos(piso,bus_id) VALUES (1,2);
INSERT INTO asientos(piso,bus_id) VALUES (2,1);
INSERT INTO asientos(piso,bus_id) VALUES (2,1);
INSERT INTO asientos(piso,bus_id) VALUES (2,1);
INSERT INTO asientos(piso,bus_id) VALUES (2,1);
INSERT INTO asientos(piso,bus_id) VALUES (2,1);

INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-12-30 12:38:00','2019-12-30 20:38:00', 48.00,1, 1,2,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-12-10 07:00:00','2019-12-11 13:38:00', 100.00,2, 1,3,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-10-26 12:38:00','2019-10-28 06:38:00', 50.00,3, 2,7,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-04-12 12:38:00','2019-04-12 22:38:00', 30.00,4, 4,8,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-05-10 12:38:00','2019-05-11 12:38:00', 36.00,5, 2,4,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-05-14 12:38:00','2019-05-15 09:38:00', 50.00,3, 1,5,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-08-12 12:38:00','2019-08-12 23:38:00', 90.00,1, 6,7,3);
INSERT INTO viajes (fechaInicio,fechaFinal,precio,bus_id,dptoOrigen_id,dptoDestino_id,empleado_id) VALUES ('2019-09-11 12:38:00','2019-09-12 11:38:00', 80.00,2, 1,8,3);

INSERT INTO usuarios(nombre,clave,cargo_id,empleado_id) VALUES ('lovon98','123456',1,1);
INSERT INTO usuarios(nombre,clave,cargo_id,empleado_id) VALUES ('angelupc','123456',1,2);
INSERT INTO usuarios(nombre,clave,cargo_id,empleado_id) VALUES ('mezacuba','123456',2,3);

INSERT INTO boletas(monto,fechaEmision,cliente_id,viaje_id,empleado_id,asiento_id,bus_id) VALUES (80.00,'2019-08-10 09:03:00',1,1,1,1,5);
INSERT INTO boletas(monto,fechaEmision,cliente_id,viaje_id,empleado_id,asiento_id,bus_id) VALUES (100.00,'2019-08-10 09:10:00',2,2,1,1,2);
INSERT INTO boletas(monto,fechaEmision,cliente_id,viaje_id,empleado_id,asiento_id,bus_id) VALUES (100.00,'2019-08-10 10:03:00',3,2,1,2,2);





