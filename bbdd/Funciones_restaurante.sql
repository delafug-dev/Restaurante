-- Funciones --


select * from empleado;
-- Crear camarero --
delimiter **
create or replace function crear_camarero(v_codigo int(10), v_nombre varchar(50), v_apellidos varchar(100)) returns int(10)
begin 
	
	declare camarero_existe int(1) default 0;
	declare nuevo_id int(10);
	-- comprobar que existe camarero. --
	select 1 into camarero_existe from empleado where v_codigo = codigo_empleado and v_nombre = nombre;

	-- nuevo id para nuevo empleado. --
	select id + 1 into nuevo_id from empleado order by id desc limit 1 ;

	-- Si no existe camarero se crea--
	if camarero_existe = 0 then
		insert into empleado(codigo_empleado, nombre, apellidos)
		values(v_codigo, v_nombre, v_apellidos);
	else
		return 0;
	end if;
	return nuevo_id;
end**
delimiter

select * from producto p ;
select * from tipo_plato_producto tpp ;

-- Crear producto --
delimiter &&
create or replace function crear_producto(v_descripcion varchar(150), v_tipo int(1), v_tipo_producto int(1), v_media_racion double, 
v_racion double, v_tapa double, v_bebida_pequeña double, v_bebida_media double, v_bebida_grande double)
returns int(10)
begin 
	declare producto_existe int(1) default 0;
	declare nuevo_id int(10);
	declare nuevo_id_tipo_plato int(10);
	declare nuevo_id_bebida int(10);
	
	-- Comprobar si existe producto --
	select 1 into producto_existe from producto where v_descripcion = descripcion and v_tipo_producto = tipo_producto;

	-- Nuevo id para producto--
	select id+1 into nuevo_id from producto order by id desc limit 1;

	-- Nuevo id tipo producto --
	select id+1 into nuevo_id_tipo_plato from tipo_plato_producto tpp  order by id desc limit 1;

	-- Nuevo id tipo bebida --
	select id+1 into nuevo_id_bebida from tipo_bebida_producto tbp  order by id desc limit 1;

	-- Si no existe producto se crea --
	if producto_existe = 0 then 
		-- Si es comida --
		if v_tipo_producto = 1 then
			-- insercion de datos en tipo de productos
			insert into tipo_plato_producto(id, media_racion, racion, tapa, id_producto)
			values(nuevo_id_tipo_plato, v_media_racion, v_racion, v_tapa, nuevo_id);
		else
			-- inserción de datos en tipos de bebidas.
			insert into tipo_bebida_producto(id, bebida_pequeña, bebida_media, bebida_grande, id_producto)
			values(nuevo_id_bebida, v_bebida_pequeña, v_bebida_media, v_bebida_grande, nuevo_id);
		end if;
		-- insercion de datos en productos.
		insert into producto(descripcion, tipo, tipo_producto)
		values(v_descripcion, v_tipo, v_tipo_producto);
	else 
		return 0;
	end if;
	return nuevo_id;
end&&
delimiter



