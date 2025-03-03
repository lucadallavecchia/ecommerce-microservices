-- Inserimento di ordini di prova
INSERT INTO orders (customer_id) VALUES (101);
INSERT INTO orders (customer_id) VALUES (102);

-- Inserimento di elementi dell'ordine di prova
INSERT INTO order_items (order_id, product_id, quantity, price_at_order) VALUES (1, 1, 2, 999.99);
INSERT INTO order_items (order_id, product_id, quantity, price_at_order) VALUES (1, 2, 1, 599.99);
INSERT INTO order_items (order_id, product_id, quantity, price_at_order) VALUES (2, 3, 3, 199.99);