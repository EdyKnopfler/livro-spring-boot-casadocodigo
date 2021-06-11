delete from pedidos.pedido_itens;
delete from pedidos.pedido;
delete from pedidos.cliente;
delete from pedidos.item;

insert into pedidos.cliente (id, nome, endereco) values(1, 'Cornélio Amâncio', 'Rua dos Traídos');
insert into pedidos.cliente (id, nome, endereco) values(2, 'Cida Mandioqueira', 'Rua das Traídas');

insert into pedidos.item (id, nome, preco) values (1, 'Ração Premium', 60.0);
insert into pedidos.item (id, nome, preco) values (2, 'Brinquedo', 10.0);
