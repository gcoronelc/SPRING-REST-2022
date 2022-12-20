
create database DEMOJPA;
go

select * from organizacion;
go

select * from proyecto;
go

select * from estudiante;
go

insert into proyecto values('proyecto 1',1);
insert into proyecto values('proyecto 2',1);
insert into proyecto values('proyecto 3',1);
insert into proyecto values('proyecto 4',1);
insert into proyecto values('proyecto 5',1);
go

alter table proyecto 
       add constraint FKsvqvx6se8qm0d57x1k8e448j8 
       foreign key (est_id) 
       references estudiante



