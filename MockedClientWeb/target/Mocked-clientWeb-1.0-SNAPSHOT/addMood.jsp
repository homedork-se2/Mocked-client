<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="status.css">
    <title>Add Status Command</title>
    <script>
        let s;

        function addItem(id) {
            if (id!= null) {
                s = s + "," + id;
            }
        }

        function submitMood(names) {
            document.requestForm.action = "addMood";
            document.requestForm.download.value = s;
            document.n.name.value = names;
            document.requestForm.submit();
        }
    </script>
</head>
<body>
<body>
<div class="topMenuBar">
    <h1 id="topTitle">Home Dork</h1>
</div>

<div class="contentWrapper">
    <div class="sidebarLeft">
    </div>

    <div class="mainContent">
        <div class="contentHeader">
            <h1 id="contentTitle">Add Devices</h1>
        </div>
        <div class="deviceList">

            <form name="n" method="post">
                <label for="nameMood">Name:</label><br>
                <input type="text" id="nameMood" name="nameMood"><br>
            </form>

            <form name="requestForm" method="post">
                <input type="hidden" name="download">
            </form>
                <ul class="listTitle">

                    ${deviceList}

                </ul>

            <button onclick="submitMood(nameMood)">Create Status Command</button>
        </div>
    </div>

    <div class="sidebarRight">
    </div>
</div>
</body>
</body>
</html>
