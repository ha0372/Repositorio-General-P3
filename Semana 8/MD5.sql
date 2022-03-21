select md5("Carlos") as password;

select md5('lopez');

select md5(md5('Lopez'));
select md5('ñ');

select md5('Hola');
select sha('Hola');
select sha2('Hola',512);

alter table clase.estudiante
add username varchar(75),
add passwordUser varchar(100);

select * from clase.estudiante;
select * from clase.nota;




