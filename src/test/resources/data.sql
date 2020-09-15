insert into products(product_cat, product_desc, product_name, product_price, stock_quantity) values ('GENERALMERCHANDISE', 'Sample Description', 'Sample Name', 10, 99);

insert into customer(customer_address, customer_contact, customer_name) values('Sample Address', '012345', 'Sample Name');

insert into customer_orders(order_date, order_price, order_status, subscription, fk_customer_id) values('2020-01-01', 99, 'SHIPPED', false, 1);
