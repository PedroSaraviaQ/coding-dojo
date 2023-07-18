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

-- * 5) Lista de usuarios generados por sitio entre el 1 de enero de 2011 y el 15 de febrero de 2011

select count(*) as total_leads, sites.domain_name
from leads join sites on leads.site_id = sites.site_id
where leads.registered_datetime >= "2011/01/01" and leads.registered_datetime <= "2011/02/15"
group by sites.domain_name;

-- * 6) Lista de usuarios generados por cliente en el año 2011

select clients.first_name, clients.last_name, count(*) as total_leads
from clients join sites on clients.client_id = sites.client_id
join leads on sites.site_id = leads.site_id
where leads.registered_datetime >= "2011/01/01" and leads.registered_datetime <= "2011/12/31"
group by clients.client_id;

-- * 7) Lista de usuarios generados por cliente por mes en el primer semestre del año 2011

select clients.first_name, clients.last_name, count(*) as total_leads,
monthname(leads.registered_datetime) as month, year(leads.registered_datetime) as year
from clients join sites on clients.client_id = sites.client_id
join leads on sites.site_id = leads.site_id
where year(leads.registered_datetime) = 2011 and month(leads.registered_datetime) between 1 and 6
group by month, year, clients.client_id;