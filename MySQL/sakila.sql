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

-- * 4) Listar los clientes de la tienda con id 1 y que viven en las ciudades de id 1, 42, 312, 459

select customer.first_name, customer.last_name, customer.email, address.address
from customer join address on customer.address_id = address.address_id
join city on address.city_id = city.city_id
where store_id = 1 and
(city.city_id = 1 or city.city_id = 42 or city.city_id = 312 or city.city_id = 459);

-- * 5) Listar las películas con calificación "G", que tengan "Behind the Scenes", y del actor con id 15

select film.title, film.description, film.release_year, film.rating, film.special_features
from film join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where rating = "G" and special_features like "%Behind the Scenes%" and actor.actor_id = 15;

-- * 6) Listar los actores que participaron en la película con id 369

select film.film_id, film.title, actor.actor_id, actor.first_name, actor.last_name
from film join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where film.film_id = 369;

-- * 7) Listar las películas de la categoría "Drama" y con precio de renta de 2.99

select film.title, film.description, film.release_year, film.rating, film.special_features, category.name
from film join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
where category.name = "Drama" and film.rental_rate = "2.99";

-- * 8) Listar las películas de acción en las que participó Sandra Kilmer

select title, description, release_year, rating, special_features, name, first_name, last_name
from film join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where category.name = "Action" and actor.actor_id = 23;