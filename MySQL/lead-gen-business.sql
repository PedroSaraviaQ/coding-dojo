use lead_gen_business;

-- * 1) Ingresos totales del mes de marzo de 2012

select sum(amount) as total from billing
where charged_datetime >= "2012/03/01" and charged_datetime < "2012/04/01";

-- * 2) Ingresos totales del cliente con id 2

select clients.client_id, sum(amount)
from billing join clients on billing.client_id = clients.client_id
where clients.client_id = 2;

-- * 3) Lista de sitios del cliente con id 10

select sites.domain_name, clients.client_id
from sites join clients on sites.client_id = clients.client_id
where clients.client_id = 10;

-- * 4) Lista de sitios creados por mes por año del cliente con id 1 (y del cliente con id 20)

select clients.client_id, count(*) as total,
year(sites.created_datetime) as year, monthname(sites.created_datetime) as month
from sites join clients on sites.client_id = clients.client_id
where clients.client_id = 1
group by year, month;
select clients.client_id, count(*) as total,
year(sites.created_datetime) as year, monthname(sites.created_datetime) as month
from sites join clients on sites.client_id = clients.client_id
where clients.client_id = 20
group by year, month;