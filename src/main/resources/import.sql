INSERT INTO domicilio (calle, nro_Calle, barrio, localidad) VALUES ('Puerto Argentino', '717','Pujato','La Quiaca');
SET @id := LAST_INSERT_ID();

INSERT INTO pacientes (dni, fecha_nacimiento, apellido, nacionalidad, localidad, nombre, telefono, domicilio_id) VALUES (45738293, '2004-04-28', 'Ricciardo','Argentino','La Quiaca','Daniel',1120323432, @id);
INSERT INTO pacientes (dni, fecha_nacimiento, apellido, nacionalidad, localidad, nombre, telefono, domicilio_id) VALUES (34928422, '2000-10-09', 'Sainz','Italiano','La Quiaca','Carlos',3886732673, @id);
INSERT INTO pacientes (dni, fecha_nacimiento, apellido, nacionalidad, localidad, nombre, telefono, domicilio_id) VALUES (23839233, '2010-03-23', 'Perez','Mexico','La Quiaca','Sergio',3889872351, @id);
INSERT INTO pacientes (dni, fecha_nacimiento, apellido, nacionalidad, localidad, nombre, telefono, domicilio_id) VALUES (12923378, '2001-02-12', 'Argentino','Argentina','La Quiaca','Franco',3886253276, @id);
INSERT INTO pacientes (dni, fecha_nacimiento, apellido, nacionalidad, localidad, nombre, telefono, domicilio_id) VALUES (43746325, '2002-01-02', 'Ulises','Colombia','La Quiaca','Bueno',3886109273, @id);
