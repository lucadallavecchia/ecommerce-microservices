-- Inserimento di ordini di prova
INSERT INTO orders (id, customer_id) VALUES (1, 101);
INSERT INTO orders (id, customer_id) VALUES (2, 102);

-- Inserimento di elementi dell'ordine di prova
INSERT INTO order_items (id, order_id, product_id, quantity, price_at_order) VALUES (1, 1, 101, 2, 19.99);
INSERT INTO order_items (id, order_id, product_id, quantity, price_at_order) VALUES (2, 1, 102, 1, 29.99);
INSERT INTO order_items (id, order_id, product_id, quantity, price_at_order) VALUES (3, 2, 103, 3, 9.99);