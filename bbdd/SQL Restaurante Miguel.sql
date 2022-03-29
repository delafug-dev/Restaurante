create table ingrediente(
	id int(10) auto_increment not null,
	nombre varchar(50) not null,
	primary key (id)
);

create table producto(
	id int(10) auto_increment not null,
	nombre varchar(50),
	precio double,
	primary key (id)
);

create table cliente(
	id int(10) auto_increment not null,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	direccion varchar(100) not null,
	telefono varchar(9) not null,
	primary key (id)
);

create table empleado(
	id int(10) auto_increment not null,
	nombre varchar(50) not null,
	apellidos varchar(50) not null,
	fecha_nacimiento date not null,
	direccion varchar(9) not null,
	telefono varchar(9) not null,
	tipo_empleado varchar(9) not null,
	primary key (id)
);

create table comanda(
	id int(10) auto_increment not null,
	id_cliente int(10) not null,
	id_empleado int(10) not null,
	codigo_comanda int(10) not null,
	numero_mesa int(10) not null,
	constraint comanda_fk1 foreign key (id_cliente) references cliente(id),
	constraint comanda_fk2 foreign key (id_empleado) references empleado(id),
	primary key (id)
);

create table producto_ingrediente(
	id_producto int(10) not null,
	id_ingrediente int(10) not null,
	constraint producto_ingrediente_fk1 foreign key (id_producto) references producto(id),
	constraint producto_ingrediente_fk2 foreign key (id_ingrediente) references ingrediente(id)
);

create table comanda_producto(
	id_comanda int(10) not null,
	id_producto int(10) not null,
	constraint comanda_producto_fk1 foreign key (id_comanda) references comanda(id),
	constraint comanda_producto_fk2 foreign key (id_producto) references producto(id)
);