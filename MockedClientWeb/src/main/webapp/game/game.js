const character = document.getElementById("character");
const block = document.getElementById("block");
const game = document.getElementsByClassName("game")[0];
const gameOver = document.getElementById("gameOver");
const score = document.getElementById("scoreSpan");
let counter = 0;

document.getElementById("highScore").innerHTML = localStorage.getItem("highscore");

function jump() {
    if (character.classList.contains("animate")) {
        return
    }
    character.classList.add("animate");
    setTimeout(function () {
        character.classList.remove("animate");
    }, 600);
}

function changeCharacter(src) {
    character.src = src;
    localStorage.setItem("character", src);
}

setInterval(function () {
    if (counter === 0) {
        character.src = localStorage.getItem("character");
    }
    let characterTop = parseInt(window.getComputedStyle(character).getPropertyValue("top"));
    let blockLeft = parseInt(window.getComputedStyle(block).getPropertyValue("left"));
    if (blockLeft < 20 && blockLeft > -20 && characterTop >= 250) {
        block.style.animation = "none";
        checkHighScore(Math.floor(counter / 100));
        score.style.display = "none";

        game.addEventListener("click", function() {
            block.style.animation = "block 1.5s infinite linear";
            gameOver.innerHTML = "";
            location.reload();
            counter = 0;
        });

    } else {
        counter++;
        score.innerHTML = Math.floor(counter / 100).toString();
        if (Math.floor(counter / 100) > 50) {
            block.style.animation = "block 1s infinite linear";
        }
        if (Math.floor(counter / 100) > 100) {
            block.style.animation = "block 0.8s infinite linear";
        }
    }
}, 10);


function checkHighScore(score) {
    let highscore = localStorage.getItem("highscore");

    if (highscore !== null) {
        if (score > highscore) {
            localStorage.setItem("highscore", score);
            gameOver.innerHTML = "Your score was a highscore! Press character to restart game";
        } else {
            gameOver.innerHTML = "Your score was " + score + ". Press character to restart game";;
        }
    }
    else {
        localStorage.setItem("highscore", score);
        gameOver.innerHTML = "Your score was a highscore! Press character to restart game";;
    }
}
