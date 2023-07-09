use world;

-- * 1) Países que hablan sloveno

select countries.name, languages.language, languages.percentage
from countries join languages
on countries.code=languages.country_code
where language = 'Slovene'
order by languages.percentage desc;