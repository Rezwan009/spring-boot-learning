delete
from Ingredient_Ref;
delete
from Taco;
delete
from Taco_Order;
delete
from Ingredient;
insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP'),
       ('COTO', 'Corn Tortilla', 'WRAP'),
       ('GRBF', 'Ground Beef', 'PROTEIN'),
       ('CARN', 'Carnitas', 'PROTEIN'),
       ('TMTO', 'Diced Tomatoes', 'VEGETABLE'),
       ('LETC', 'Lettuce', 'VEGETABLE'),
       ('CHED', 'Cheddar', 'CHEESE'),
       ('JACK', 'Monterrey Jack', 'CHEESE'),
       ('SLSA', 'Salsa', 'SAUCE'),
       ('SRCR', 'Sour Cream', 'SAUCE');