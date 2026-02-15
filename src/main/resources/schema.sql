create table if not exists Taco_Order(
    id identity primary key,
    delivery_name varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city varchar(50) not null,
    delivery_state varchar(2) not null,
    delivery_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
);

create table if not exists Taco(
    id identity primary key,
    name varchar(50) not null,
    taco_order bigint null,
    created_at timestamp not null,
    constraint fk_taco_order
        foreign key (taco_order)
        references Taco_Order(id)
);

create table if not exists Ingredient(
    id varchar(4) primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Ingredient_Ref(
    taco bigint not null,
    ingredient varchar(4) not null,
    constraint fk_ref_taco
        foreign key (taco) references Taco(id),
    constraint fk_ref_ingredient
        foreign key (ingredient) references Ingredient(id)
);
