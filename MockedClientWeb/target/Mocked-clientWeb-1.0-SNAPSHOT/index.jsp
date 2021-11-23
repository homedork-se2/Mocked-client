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


        <script>
            function runSpeechRecognition() {
                const output = document.getElementById("output");
                const voiceButton = document.getElementById("voiceButton");
                var SpeechRecognition = SpeechRecognition || webkitSpeechRecognition;
                const recognition = new SpeechRecognition();

                recognition.onstart = function() {
                    voiceButton.textContent = "Listening..";
                };

                recognition.onspeechend = function() {
                    voiceButton.textContent = "Text to speech";
                    recognition.stop();
                }

                recognition.onresult = function(event) {
                    const transcript = event.results[0][0].transcript;
                    output.innerHTML = "<b>Text:</b> " + transcript;
                    output.classList.remove("hide");
                };

                recognition.start();
            }
        </script>
    </body>
</html>

