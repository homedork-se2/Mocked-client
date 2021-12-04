<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>MOCK web client</title>
    </head>
    <body>
        <h1>Welcome to HomeDork</h1>

        <button>Press me</button>

        <button id="voiceButton" style="margin-left: 5vh" onclick="runSpeechRecognition()">Text to speech</button>

        <span id="action"></span></p>
        <div id="output" class="hide"></div>

        <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
            nisi ut aliquip ex ea commodo consequat.
            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
            dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>


        <button id="disco-button" onclick="discoMode()">Turn on disco mode</button>

        <div class="disco-lamps"
             style="display: none; flex-direction: row; margin-top: 10vh; justify-content: space-around; max-width: 100vh">
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
            <div class="light" style="width: 20px; height: 20px"></div>
        </div>

        <script>

            function discoMode() {
                const lights = document.querySelectorAll('.light');
                const disco = document.querySelector('.disco-lamps');
                const discoButton = document.getElementById('disco-button')

                if (disco.style.display === "none") {
                    discoButton.innerHTML = "Turn off disco mode";
                    disco.style.display = "flex";
                } else {
                    discoButton.innerHTML = "Turn on disco mode";
                    disco.style.display = "none";
                }
                setInterval(() => {
                    lights.forEach(function (self) {
                        let color = getRandomHEX();
                        self.style.backgroundColor = color;
                        self.style["boxShadow"] =
                            "0 0 0 rgba(255,255,255,0.2), 0 20px 100px 8px " +
                            color +
                            ", 0 10px 50px 0 #fff";
                    });
                }, 300);
            }

            function getRandomHEX() {
                let letters = "0123456789ABCDEF",
                    value = "#";
                for (let i = 0; i < 6; i++) {
                    value += letters[Math.floor(Math.random() * 16)];
                }
                return value;
            }


            function runSpeechRecognition() {
                const output = document.getElementById("output");
                const voiceButton = document.getElementById("voiceButton");
                var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
                const recognition = new SpeechRecognition();

                recognition.onstart = function () {
                    voiceButton.textContent = "Listening..";
                };

                recognition.onspeechend = function () {
                    voiceButton.textContent = "Text to speech";
                    recognition.stop();
                }

                recognition.onresult = function (event) {
                    const transcript = event.results[0][0].transcript;
                    output.innerHTML = "<b>Text:</b> " + transcript;
                    output.classList.remove("hide");
                };

                recognition.start();
            }
        </script>
    </body>
</html>

