DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS cadena;

CREATE TABLE cadena(
	id bigint NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(MAX),
	PRIMARY KEY(id)
);

CREATE TABLE producto(
	id bigint NOT NULL AUTO_INCREMENT,
	codigoproducto bigint,
	fechafinaplicacion datetime,
	fechainicioaplicacion datetime,
	identificadortarifa integer,
	moneda varchar(max),
	precio double,
	prioridad integer,
	cadena_id bigint,
	PRIMARY KEY(id),
	foreign key(cadena_id) references cadena(id)
);

insert into cadena (nombre) values ('ZARA');

insert into producto (cadena_id, codigoproducto, precio, fechainicioaplicacion, fechafinaplicacion, moneda, identificadortarifa, prioridad)
			   values(1, 35455, 35.50, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 'EUR', 1, 0),
			   		 (1, 35455, 25.45, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 'EUR', 2, 1),
			   		 (1, 35455, 30.50, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 'EUR', 3, 1),
			   		 (1, 35455, 38.95, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 'EUR', 4, 1);