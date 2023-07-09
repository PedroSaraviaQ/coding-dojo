use world;

-- * 1) Países que hablan sloveno

select countries.name, languages.language, languages.percentage
from countries join languages
on countries.id = languages.country_id
where languages.language = 'Slovene'
order by languages.percentage desc;

-- * 2) Número de ciudades por país

select countries.name, count(cities.name) as total
from countries join cities
on countries.id = cities.country_id
group by countries.name
order by total desc;

-- * 3) Ciudades de México con población mayor a 500,000 habitantes

select name, population from cities
where country_id = 136 and population > 500000
order by population desc;

-- * 4) Idiomas en países con un porcentaje mayor al 89%

select countries.name, languages.language, languages.percentage
from countries join languages
on countries.id = languages.country_id
where languages.percentage > 89
order by languages.percentage desc