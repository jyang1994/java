select cust_id,cust_name from customers;
select * from customers;
-- ȥ��
select vend_id from vendors;
select DISTINCT vend_id, prod_name from products;
select DISTINCT vend_id from products;

-- ��ҳ
select * from products LIMIT 5;
select * from products LIMIT 0,5;
select * from products limit 5,5;
select * from products limit 10,5;

-- ����
select * from products ORDER BY prod_price; -- Ĭ����������
select * from products ORDER BY prod_price ASC;
select * from products ORDER BY prod_price DESC; 
select * from products ORDER BY prod_price DESC, prod_name DESC;

-- ����
select * from products where prod_price >= 2 and prod_price <= 10 ORDER BY prod_price limit 0, 5;
select * from products where prod_price between 2 and 10;

select * from products where prod_price <> 2.5;
select * from products where prod_price != 2.5;

select * from customers where cust_email is null;
select * from customers where cust_email is not null; 

-- and���ȼ�����or
select * from products where 
vend_id = 1001 or vend_id = 1003 and prod_price > 10;

select * from products where 
(vend_id = 1001 or vend_id = 1003) and prod_price > 10;

select * from products where 
vend_id in(1001,1003) and prod_price > 10;

select * from products where 
vend_id not in (1001,1003);

-- ģ����ѯ

select * from products 
where prod_name like '%ton%';

select * from products 
where prod_name like '__ton%';

select * from products 
where prod_name like '%ton%' and vend_id = 1001;

select * from products 
where vend_id = 1001 and prod_name like '%ton%';

-- ����
select prod_id AS '��ƷID',prod_name as
'��Ʒ����',prod_price as '��Ʒ����' 
from products;

select prod_id '��ƷID',prod_name
'��Ʒ����',prod_price '��Ʒ����' 
from products;

-- ��ѧ����
select order_num, order_item, quantity, item_price 
,quantity * item_price as total from orderitems;


-- �ı�����
select prod_name, LTRIM(prod_name),RTRIM(prod_name),TRIM( prod_name)
,lower(prod_name),UPPER(prod_name),
LENGTH(prod_name), LEFT(prod_name,3), RIGHT(prod_name,3) from products;

select CONCAT('i like ',prod_name,' very much') as 'message' from products;

-- ���ں���
select now();
select CURDATE();
select CURTIME();

select date(now());
select date('2008-08-08 20:08:08');
select time(now());
select time('2008-08-08 20:08:08');

select year('2008-08-08 20:08:08');

select DAYOFWEEK('2017-08-06');

select DATEDIFF(now(),'1990-01-01');
select ADDDATE('1996-12-27',40000); -- ʱ��滮��

select * from orders where date(order_date) = '2005-09-01';
select * from orders where left(order_Date,10) = '2005-09-01';
select * from orders where order_date like '2005-09-01%';
select * from orders where order_date >= '2005-09-01 00:00:00' 
and order_date <= '2005-09-01 23:59:59';

select * from orders where order_date >= '2005-09-01' 
and order_Date <= '2005-09-31';
select * from orders where year(order_date) = '2005'
and month(order_date) = '09';

