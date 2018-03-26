-- 1.  �û�ע��
insert into t_member (nickname,name,email,address,tel,zip,password)
values ('snow','ѩŵ','snow@qq.com','king of north','13596325874','455000','123456');
-- 2.  �û���¼
select * from t_member where nickname = 'snow' and password = '123456';
-- 3.  �鿴������������鼮
select * from t_book where typeid in 
(select id from t_type where pid = 3);	

select * from t_book b, t_type t where 
b.typeid = t.id and t.pid = 3;

-- 4������һ���鼮����������ȡ�鼮�����ơ��۸񡢳��������ơ���������
	-- 4.1 ��ֵ��ѯ

select b.bookname ,b.price , p.publishname,a.`name` 
from t_book b ,t_publish p, t_author a 
where b.publish_id = p.id and b.author_id = a.id 
and b.id = 5;
	-- 4.2 ������
select b.bookname ,b.price , p.publishname,a.`name` 
from t_book b inner JOIN t_publish p 
on b.publish_id = p.id 
inner JOIN t_author a
on b.author_id = a.id
where b.id = 5;

-- 5�� ��ȡһ�����������������鼮
select * from t_book where author_id = (
select id from t_author where name = '��ж�');

-- 6�� �鿴һ����Ա�ղص��鼮
select b.bookname from t_fav f,t_member m, t_book b 
where f.mid = m.id and f.bid = b.id
and m.nickname = 'java007';
-- 7.  д���鼮��ķ�ҳ SQL��ÿҳ 3 ���鼮����д�������һҳ�͵���ҳ��
select * from t_book LIMIT 0,3;
select * from t_book limit 6,3;

-- 8�� �޸�һ����Ա������
update t_member set password = '12345' 
where nickname = 'snow' and `password` = '123456';

-- 9.  д��һ���鼮��Ӧ�����ۼ����۵Ļ�Ա����
select c.content,b.bookname,m.nickname from
t_commentary c left JOIN t_book b
on c.bid = b.id 
left join t_member m
on c.mid = m.id
where b.bookname = 'oracle�Ӿ�ͨ������';

-- 10��	��ѯһ��������Ӧ���鼮
select b.bookname from t_order_book ob ,t_book b
where ob.bid = b.id
and oid = 2;

-- 11��	ͳ��һ�����ڼ�������鼮�������ܶ�b.type_id , t.pid ,ROUND(SUM(b.price),2)
select ROUND(sum(b.price),2) from t_order_book ob
left join t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where pid = 3 and o.state = '�����' 
and DATEDIFF('2016-10-30',o.otime) <=30;


-- 12��	ͳ���������ڸ����鼮�����۶�
select ROUND(sum(b.price),2),t.pid,
(select name from t_type where id = t.pid) as '����'
 from t_order_book ob
left JOIN t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where o.state = '�����' 
and DATEDIFF('2016-10-30',o.otime) <=60
GROUP BY t.pid;


-- 13��	ͳ���������ڸ����鼮����������
select count(*),t.pid,
(select name from t_type where id = t.pid) as '����'
 from t_order_book ob
left JOIN t_book b on ob.bid = b.id
left JOIN t_order o  on ob.oid = o.id
left JOIN t_type t on b.typeid = t.id
where o.state = '�����' 
and DATEDIFF('2016-10-30',o.otime) <=60
GROUP BY t.pid;


-- 14��	ɾ��һ���û���Ӧ����������
delete from t_commentary where mid = (
SELECT id from t_member where nickname = 'kobe_lover');
	
-- 15��	�г�������ǰ�������鼮 

select count(*) as salenum,b.bookname from 
t_order_book ob ,t_book b
where ob.bid = b.id GROUP BY b.bookname
order by salenum desc limit 0,5;

-- 16��	�г�������ǰ�������鼮����
	select count(*) as salenum,t.pid,
(select name from t_type where id = t.pid) as '����'
from t_order_book ob ,t_book b, t_type t
where ob.bid = b.id and b.typeid = t.id
group by t.pid order by salenum desc limit 0,3;


-- 17��	�г���������������ǰ�������鼮
	SELECT count(*) ,ob.bid,
	b.bookname 
	from t_order_book ob INNER JOIN 
	t_book b on ob.bid = b.id
	INNER JOIN t_type t ON b.typeid = t.id
	WHERE t.pid = 3 GROUP BY (bid)
	ORDER BY count(*) DESC,bid limit 0,3;

-- 18��	�г���һ���顷���������֣���������
	SELECT COUNT(*),b.bookname FROM t_order_book ob ,t_book b 
	where ob.bid = b.id AND b.bookname='���μ�';
-- 19��	�г��鼮������ǰ���������� 
	select COUNT(*) as 'salenum',a.name
	FROM t_order_book ob ,t_book b,t_author a 
	where ob.bid = b.id AND b.author_id = a.id
	GROUP BY (ob.bid) 
	ORDER BY salenum DESC,bid ASC LIMIT 0,3;
-- 20��	���������������������֣��������鼮
	select b.bookname,a.`name` from t_book b ,t_author a where 
	b.author_id = a.id AND a.name='��־��';
-- 21��	�����鼮�����к��С�java�����鼮
	select * FROM t_book where bookname like '%java%';
-- 22��	��ȡ�鼮�����к��С�java�����鼮������
	select count(*) FROM t_book where bookname like '%java%';
-- 23��	��ȡһ���鼮����������
	SELECT count(*) from t_commentary c, t_book b 
	WHERE	c.bid = b.id AND b.bookname = '���μ�';