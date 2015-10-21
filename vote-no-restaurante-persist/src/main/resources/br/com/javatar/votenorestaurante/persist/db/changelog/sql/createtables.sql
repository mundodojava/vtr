    create table pessoa (
        id bigint not null,
        nome varchar(255) not null,
        primary key (id)
    );
    
    create table ranking (
        id bigint not null,
        usuario_id varchar(255) not null,
        primary key (id)
    );
    
    create table ranking_votos (
        ranking bigint not null,
        votos bigint not null,
        primary key (ranking, votos)
    );
    
    create table restaurante (
        id bigint not null,
        banner varchar(500000) not null,
        logo varchar(500000) not null,
        nome varchar(255) not null,
        primary key (id)
    );
    
    create table usuario (
        id varchar(255) not null,
        pessoa_id bigint not null,
        primary key (id)
    );
    
    create table voto (
        id bigint not null,
        nota integer not null,
        tipo_voto varchar(255) not null,
        restaurante_id bigint not null,
        primary key (id)
    );
    
    alter table ranking_votos 
        add constraint UK_c2cctb2pwy6fdfe9iak3fso5i unique (votos);
        
    alter table ranking 
        add constraint FK_25758bs2emn7kip8o039qp3jn 
        foreign key (usuario_id) 
        references usuario;

    alter table ranking_votos 
        add constraint FK_c2cctb2pwy6fdfe9iak3fso5i 
        foreign key (votos) 
        references voto;
        
    alter table ranking_votos 
        add constraint FK_32u4bofpcogkgoupi4xu4foao 
        foreign key (ranking) 
        references ranking;
        
    alter table usuario 
        add constraint FK_r3paqktjbbb5iuok1mvu0s8xg 
        foreign key (pessoa_id) 
        references pessoa;
        
    alter table voto 
        add constraint FK_qogrgjui0yvot7w403t1743lh 
        foreign key (restaurante_id) 
        references restaurante;