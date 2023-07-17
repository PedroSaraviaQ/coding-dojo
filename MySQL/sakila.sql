use sakila;

-- * 1) Listar los clientes que viven en la ciudad de id 312

select customer.first_name, customer.last_name, customer.email, address.address
from customer join address on customer.address_id = address.address_id
join city on address.city_id = city.city_id
where city.city_id = 312;

-- * 2) Listar las películas de la categoría "Comedia"

select film.title, film.description, film.release_year, film.rating, film.special_features, category.name
from film join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
where category.name = 'Comedy';

-- * 3) Listar las películas en las que participó el actor con id 5

select actor.actor_id, actor.first_name, actor.last_name, film.title, film.description, film.release_year
from film join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where actor.actor_id = 5;