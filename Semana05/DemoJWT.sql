create database DEMOJWT;
go

use DEMOJWT;
go

-- TABLA: CONTACTO

create table contacto(
	idcontacto int identity(1,1),
	nombre varchar(100),
	fechanac Date,
	celular varchar(20),
	email varchar(100),
	constraint pk_contacto primary key(idcontacto)
);

-- SET IDENTITY_INSERT to ON
SET IDENTITY_INSERT dbo.contacto ON;  
GO

-- DATOS DE CONTACTOS

insert into contacto(idcontacto,nombre,fechanac,celular,email) 
values(1,'Gustavo Coronel','20000728','546798234','gustavo@gmail.com');

insert into contacto(idcontacto,nombre,fechanac,celular,email) 
values(2,'Pedro Vargas','19980508','898456325','pedro@gmail.com');

insert into contacto(idcontacto,nombre,fechanac,celular,email) 
values(3,'Hector Torres','20010318','908734921','hector@gmail.com');

insert into contacto(idcontacto,nombre,fechanac,celular,email) 
values(4,'Eliana Vergara','19990910','985683561','eliana@gmail.com');

insert into contacto(idcontacto,nombre,fechanac,celular,email) 
values(5,'Claudia Herrera','20021005','985623904','claudia@gmail.com');

GO

-- SET IDENTITY_INSERT to OFF
SET IDENTITY_INSERT dbo.contacto OFF;  
GO


-- TABLA: USUARIO

create table usuario(
	idusuario int identity(1,1),
	nombre varchar(100),
	email varchar(100),
	password varchar(100),
	constraint pk_usuario primary key(idusuario)
);


-- SET IDENTITY_INSERT to ON
SET IDENTITY_INSERT dbo.usuario ON;  
GO


-- Datos
--insert into usuario(idusuario,nombre,email,password) values(


-- SET IDENTITY_INSERT to OFF
SET IDENTITY_INSERT dbo.usuario OFF;  
GO