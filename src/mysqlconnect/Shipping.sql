drop database if exists Shipping_Control;
create database Shipping_Control;
use Shipping_Control;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     21/12/2021 2:37:42 p.�m.                     */
/*==============================================================*/


drop table if exists CARGO;

drop table if exists EMBARCACION;

drop table if exists USUARIOS;

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO
(
   ID_CARGO             int not null,
   IMO_NUMBER           varchar(7),
   primary key (ID_CARGO)
);

/*==============================================================*/
/* Table: EMBARCACION                                           */
/*==============================================================*/
create table EMBARCACION
(
   IMO_NUMBER           varchar(7) not null,
   NOMBRE_EMBARCACION   varchar(1000) not null,
   BANDERA              varchar(100) not null,
   TIPO_DE_EMBARCACION  smallint not null default 1,
   CAPACIDAD_TOTAL      bigint not null,
   CAPACIDADACTUAL      bigint not null,
   DISPONIBILIDAD       bool not null,
   primary key (IMO_NUMBER)
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS
(
   ID_SERIAL_USUARIO    int not null auto_increment,
   NOMBRE_USUARIO       varchar(100) not null,
   CONTRASENA           varchar(100) not null,
   primary key (ID_SERIAL_USUARIO)
);

alter table CARGO add constraint FK_EMBARCACION_CARGO foreign key (IMO_NUMBER)
      references EMBARCACION (IMO_NUMBER) on delete restrict on update restrict;