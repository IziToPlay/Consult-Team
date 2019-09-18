INSERT INTO cargos (name) VALUES ('Recepcionista');
INSERT INTO cargos (name) VALUES ('Consultor de Viajes');

INSERT INTO empleados (nombreCompleto,dni,fechaNacimiento,correo, sexo, telefono, celular) VALUES ('José Luis Lovon Vega','74417486','1998-02-17','joslui1720082@gmail.com',true,6239326, 982087241);
INSERT INTO empleados (nombreCompleto,dni,fechaNacimiento,correo, sexo, telefono, celular) VALUES ('Miguel Angel Calderon','74417222','1998-03-20','miguelcalderon@gmail.com',true,6333000, 998523641);
INSERT INTO empleados (nombreCompleto,dni,fechaNacimiento,correo, sexo, telefono, celular) VALUES ('Alex Meza','744174309','1998-08-02','alexmeza@gmail.com',true,3680263, 963647894);

INSERT INTO buses (placa,asientos,disponible) VALUES ('ABC', 40, true);
INSERT INTO buses (placa,asientos,disponible) VALUES ('XYZ', 40, false);
INSERT INTO buses (placa,asientos,disponible) VALUES ('ABCDE', 40, true);
INSERT INTO buses (placa,asientos,disponible) VALUES ('YYY', 40, true);
INSERT INTO buses (placa,asientos,disponible) VALUES ('ZZZ', 40, false);

INSERT INTO departamentos (name) VALUES ('Lima');
INSERT INTO departamentos (name) VALUES ('Ayacucho');
INSERT INTO departamentos (name) VALUES ('Cuzco');
INSERT INTO departamentos (name) VALUES ('Madre de Dios');
INSERT INTO departamentos (name) VALUES ('Tacna');
INSERT INTO departamentos (name) VALUES ('Piura');
INSERT INTO departamentos (name) VALUES ('Arequipa');
INSERT INTO departamentos (name) VALUES ('Puno');

INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-12-30 12:38:00','2019-12-30 13:38:00', 2, 48.00, 1,2,1);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-12-10 07:00:00','2019-12-31 13:38:00', 1, 100.00, 1,3,2);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-10-26 12:38:00','2019-10-28 13:38:00', 5, 50.00, 2,7,1);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-04-12 12:38:00','2019-04-30 13:38:00', 2, 30.00, 4,8,2);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-05-10 12:38:00','2019-05-30 13:38:00', 3, 36.00, 2,4,2);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-05-14 12:38:00','2019-05-30 13:38:00', 5, 50.00, 1,5,1);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-08-12 12:38:00','2019-08-30 13:38:00', 1, 90.00, 6,7,2);
INSERT INTO viajes (fecha_inicio,fecha_final,bus_id,precio,departamento_origen_id,departamento_destino_id,empleado_id) VALUES ('2019-09-11 12:38:00','2019-09-30 13:38:00', 3, 80.00, 1,8,1);