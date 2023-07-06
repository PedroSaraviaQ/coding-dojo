var world = [
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
  [2, 0, 1, 2, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 2, 1, 2, 2, 2, 1, 2],
  [2, 1, 1, 2, 1, 2, 3, 2, 1, 2],
  [2, 1, 1, 2, 3, 2, 1, 2, 1, 2],
  [2, 1, 1, 2, 2, 2, 1, 2, 1, 2],
  [2, 1, 1, 1, 1, 1, 1, 2, 1, 2],
  [2, 1, 1, 1, 1, 1, 1, 1, 1, 2],
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
];

var pacman = {
  x: 1,
  y: 1,
};

var score = 0;

function displayWorld() {
  let output = "";

  for (let i = 0; i < world.length; i++) {
    output += "\n<div class='row'>\n";
    for (let j = 0; j < world[i].length; j++) {
      if (world[i][j] == 2) {
        output += "<div class='brick'></div>";
      } else if (world[i][j] == 1) {
        output += "<div class='coin'></div>";
      } else if (world[i][j] == 3) {
        output += "<div class='cherry'></div>";
      } else if (world[i][j] == 0) {
        output += "<div class='empty'></div>";
      }
    }
    output += "\n</div>";
  }
  // console.log(output)
  document.getElementById("world").innerHTML = output;
}

function displayPacman() {
  document.getElementById("pacman").style.left = pacman.x * 20 + "px";
  document.getElementById("pacman").style.top = pacman.y * 20 + "px";
}

function displayScore() {
  document.getElementById("score").innerHTML = score;
}

displayWorld();
displayPacman();
displayScore();

document.onkeydown = function (e) {
  var t = { ...pacman };

  // console.log(e.keyCode)
  if (e.keyCode == 37) {
    pacman.x--;
    document.getElementById("pacman").style.transform = "rotate(-180deg)";
  } else if (e.keyCode == 38) {
    pacman.y--;
    document.getElementById("pacman").style.transform = "rotate(-90deg)";
  } else if (e.keyCode == 39) {
    pacman.x++;
    document.getElementById("pacman").style.transform = "rotate(0deg)";
  } else if (e.keyCode == 40) {
    pacman.y++;
    document.getElementById("pacman").style.transform = "rotate(90deg)";
  }

  if (world[pacman.y][pacman.x] == 1) {
    world[pacman.y][pacman.x] = 0;
    score += 10;
  } else if (world[pacman.y][pacman.x] == 2) {
    pacman = t;
  } else if (world[pacman.y][pacman.x] == 3) {
    world[pacman.y][pacman.x] = 0;
    score += 50;
  }

  displayWorld();
  displayPacman();
  displayScore();
};
