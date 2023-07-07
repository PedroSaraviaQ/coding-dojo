var hero = {
  x: 300,
  y: 400,
};

var enemies = [
  { x: 50, y: 50 },
  { x: 250, y: 50 },
  { x: 450, y: 250 },
  { x: 550, y: 50 },
  { x: 700, y: 100 },
];

var bullets = [];

function displayHero() {
  document.getElementById("hero").style.top = hero.y + "px";
  document.getElementById("hero").style.left = hero.x + "px";
}

function displayEnemies() {
  var output = "";

  for (var i = 0; i < enemies.length; i++) {
    output += "<div class='enemy1' style='top:" + enemies[i].y + "px; left:" + enemies[i].x + "px;'></div>";
  }
  document.getElementById("enemies").innerHTML = output;
}

function displayBullets() {
  var output = "";

  for (var i = 0; i < bullets.length; i++) {
    output += "<div class='bullet' style='top:" + bullets[i].y + "px; left:" + bullets[i].x + "px;'></div>";
  }
  document.getElementById("bullets").innerHTML = output;
}

function moveEnemies() {
  for (var i = 0; i < enemies.length; i++) {
    enemies[i].y += 5;

    if (enemies[i].y > 540) {
      enemies[i].y = 0;
      enemies[i].x = Math.random() * 700;
    }
  }
  displayEnemies();
}

function moveBullets() {
  for (var i = 0; i < bullets.length; i++) {
    bullets[i].y -= 5;
  }
  for (var i = 0; i < bullets.length; i++) {
    if (bullets[i].y < 0) {
      bullets[i] = bullets[bullets.length - 1];
      bullets.pop();
    }
  }
  displayBullets();
}

function gameLoop() {
  moveEnemies();
  moveBullets();
}

setInterval(gameLoop, 50);

document.onkeydown = function (e) {
  if (e.keyCode == 37) {
    hero.x -= 10;
  } else if (e.keyCode == 38) {
    hero.y -= 10;
  } else if (e.keyCode == 39) {
    hero.x += 10;
  } else if (e.keyCode == 40) {
    hero.y += 10;
  } else if (e.keyCode == 32) {
    bullets.push({ x: hero.x + 5.5, y: hero.y - 13 });
  }

  // console.log(e.keyCode)
  displayHero();
  displayBullets();
};

displayHero();
displayEnemies();
