use friends;

-- * Lista de usuarios y sus amigos

select users.first_name, users.last_name,
users_2.first_name as friend_first_name, users_2.last_name as friend_last_name
from users join friendships on users.id = friendships.user_id
join users as users_2 on friendships.friend_id = users_2.id;