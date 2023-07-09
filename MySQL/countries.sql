use world;

-- * 1) Países que hablan sloveno

select countries.name, languages.language, languages.percentage
from countries join languages
on countries.code = languages.country_code
where language = 'Slovene'
order by languages.percentage desc;

-- * 2) Número de ciudades por país

select countries.name, count(cities.name)
from countries join cities
on countries.id = cities.country_id
group by countries.name