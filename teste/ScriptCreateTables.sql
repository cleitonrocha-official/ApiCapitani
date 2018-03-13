
/*Não há nescecidade do script'Criação das Tabelas', 
 * pois esta configurado a criação automatica nas propriedades
 * da aplicação "application.properties".*/

/*Criação de Tabelas*/
create schema capitani ;
use capitani;
create table cliente (
        codigo_cliente bigint not null,
        nome varchar(50),
        primary key (codigo_cliente)
    ) ENGINE=InnoDB;
 create table pedido (
        numero_controle bigint not null,
        data_cadastro tinyblob,
        nome varchar(50),
        quantidade bigint not null,
        valor double precision not null,
        valor_total double precision not null,
        codigo_cliente bigint,
        primary key (numero_controle)
    ) ENGINE=InnoDB;
    
 /*Popula 10 Clientes*/   
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('1', 'CLeiton');    
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('2', 'Mariana');    
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('3', 'Wesley');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('4', 'Diego');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('5', 'Alexandre');    
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('6', 'Patricia');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('7', 'Danieli');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('8', 'Beatriz');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('9', 'Ronaldo');
INSERT INTO `cliente` (`codigo_cliente`, `nome`) VALUES ('10', 'Sônia');