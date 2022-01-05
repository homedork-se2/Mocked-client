<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="status.css">
    <title>Personalized Status Commands</title>
    <script>

        function addMood(){
            window.location = "addMood";
        }

        function transferCallToServlet(i)
        {
            document.requestForm.action = "status";
            document.requestForm.download.value=i;
            document.requestForm.submit();


        }
    </script>
</head>
<body>
    <div class="topMenuBar">
        <h1 id="topTitle">Home Dork</h1>
    </div>

    <div class="contentWrapper">
        <div class="sidebarLeft">
        </div>

        <div class="mainContent">
            <div class="contentHeader">
                <h1 id="contentTitle">Personalized Status Commands</h1>
            </div>

            <div class="statusCommands">
                <form name="requestForm" method="post">
                    <input type="hidden" name="download" >

                        ${moodButtons}

                        <div class="rectangleAdd">
                            <p id="moodAddText">Add Status Command</p>
                            <img onclick="addMood()" id="addImage" src="add.png"/>
                        </div>
                </form>
            </div>
        </div>

        <div class="sidebarRight">
        </div>
    </div>
</body>
</html>
