use world;

-- * 1) Países que hablan sloveno

select countries.name, languages.language, languages.percentage
from countries join languages on countries.id = languages.country_id
where languages.language = 'Slovene'
order by languages.percentage desc;

-- * 2) Número de ciudades por país

select countries.name, count(cities.name) as total
from countries join cities on countries.id = cities.country_id
group by countries.name
order by total desc;

-- * 3) Ciudades de México con población mayor a 500,000 habitantes

select name, population from cities
where country_id = 136 and population > 500000
order by population desc;

-- * 4) Idiomas en países con un porcentaje mayor al 89%

select countries.name, languages.language, languages.percentage
from countries join languages on countries.id = languages.country_id
where languages.percentage > 89
order by languages.percentage desc;

-- * 5) Países con un área de superficie inferior a 501 y población mayor a 100,000

select name, surface_area, population from countries
where surface_area < 501 and population > 100000;

-- * 6) Países con solo Monarquía Constitucional, un capital mayor a 200 y una esperanza de vida mayor a 75 años

select name, government_form, capital, life_expectancy from countries
where government_form = 'Constitutional Monarchy' and capital > 200 and life_expectancy > 75;

-- * 7) Ciudades de Argentina dentro del distrito de Buenos Aires y con una población mayor a 500,000 habitantes

select countries.name, cities.name, cities.district, cities.population
from countries join cities on countries.id = cities.country_id
where countries.name = 'Argentina' and cities.district = 'Buenos Aires' and cities.population > 500000;

-- * 8) Número de países por región

select region, count(name) as total from countries
group by region
order by total desc;