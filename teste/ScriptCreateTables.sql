
/*Não há nescecidade do script de criação das tabelas, 
 * pois esta configurado a criação automatica nas propriedades
 * da aplicação "application.properties".*/

create schema capitani ;
use capitani;
  create table pedido (
        numero_controle bigint not null,
        codigo_cliente bigint not null,
        data_cadastro tinyblob not null,
        nome varchar(50) not null,
        quantidade bigint not null,
        valor double precision not null,
        valor_total double precision not null,
        primary key (numero_controle)
    ) ENGINE=InnoDBDB