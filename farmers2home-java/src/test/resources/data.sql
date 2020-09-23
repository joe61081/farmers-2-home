insert into products(product_cat, product_desc, product_name, product_price, stock_quantity) values ('GENERALMERCHANDISE', 'Sample Description', 'Sample Name', 10, 99);

insert into customer(email_address, password, customer_address, customer_contact, customer_name) values('test@email.com', 'pass', 'Sample Address', '012345', 'Sample Name');

insert into customer_orders(order_date, order_price, order_status, subscription, fk_customer_id) values('2020-01-01', 99, 'SHIPPED', false, 1);

insert into payment(account_number, card_number, payment_date, payment_type, sort_code, total_paid) values('011401533', '4539393950884198', '2020-01-01', 'CREDIT', 123, 100);