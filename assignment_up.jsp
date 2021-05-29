
<%
            String[] user1 = (String[]) session.getAttribute("user1");
            String cls = user1[2];
            String sub = user1[3];
            String u = user1[4];
            String name = user1[0];
%>
<!DOCTYPE html>
<html>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .w3-theme {color:#fff !important;background-color:#4CAF50 !important}
        .w3-btn {background-color:#4CAF50;margin-bottom:4px}
        .w3-code{border-left:4px solid #4CAF50}
        .myMenu {margin-bottom:150px}
    </style>
    <body>

        <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="margin-top:50px;  background-color: black; color: white; display:none" id="mySidebar">
            <button class="w3-bar-item w3-button w3-large"
                    onclick="w3_close()">Close &times;</button>
            <a class="w3-bar-item w3-button" href="#">Class 1</a>
            <a class="w3-bar-item w3-button" href="#">Class 2</a>
            <a class="w3-bar-item w3-button" href="#">Class 3</a>
            <a class="w3-bar-item w3-button" href="#">Class 4</a>
            <a class="w3-bar-item w3-button" href="#">Class 5</a>
        </div>

        <div id="main">

            <div class="w3-bar w3-theme w3-large">
                <div class="w3-center  w3-padding" style="background-color: black; color: white;">
                    <div class=" w3-margin-top w3-wide w3-hide-medium w3-hide-small"><div class="w3-center">Digi<b>Sight</b></div></div>
                </div>
                <button class="w3-bar-item w3-button w3-xlarge" onclick="w3_open()" id="openNav">&#9776;</button>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16" href="teacher.html">Home</a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16" href="posts">Posts</a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right"></a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right" href="login.html">Logout</a>
            </div>


            <script>
                function w3_open() {
                    document.getElementById("main").style.marginLeft = "25%";
                    document.getElementById("mySidebar").style.width = "25%";
                    document.getElementById("mySidebar").style.display = "block";
                    document.getElementById("openNav").style.display = 'none';
                }
                function w3_close() {
                    document.getElementById("main").style.marginLeft = "0%";
                    document.getElementById("mySidebar").style.display = "none";
                    document.getElementById("openNav").style.display = "inline-block";
                }
            </script>



            <div id="main">
                <!-- Sidebar -->

                <!-- Overlay effect when opening sidebar on small screens -->
                <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

                <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->
                <div class="w3-main w3-container" style="margin-left:300px;margin-top:50px;margin-right:300px;">

                    <div class="w3-panel w3-padding-large w3-card-4 w3-light-grey w3-border" style="border 2px grey;">
                        <h1 class="w3-xlarge">Upload Assignment</h1>
                       <form action="testfile" method="post" enctype="multipart/form-data">
                           <table>
                               <tr><td><br>Assignment name: </td><td><br><input type="text" placeholder="class" name="asname"></td></tr>
                               <tr><td><br>Class: </td><td><br><input type="text" placeholder="class" name="cls"></td></tr>
                               <tr><td><br>Deadline: </td><td><br><input type="text" placeholder="YYYY-MM-DD" name="date"></td></tr>
                               <tr><td><br>Select File:</td><td><br><input type="file" name="fname"/><br/></td></tr>  
                               <tr><td><br><input class="w3-button w3-theme w3-hover-white" type="submit" value="upload"/> <br></td></tr> 
                        </table>
                       </form>
                      </div>

                        <!-- END MAIN -->
                </div>

                <script>
                    // Script to open and close the sidebar
                    function w3_open() {
                        document.getElementById("mySidebar").style.display = "block";
                        document.getElementById("myOverlay").style.display = "block";
                    }

                    function w3_close() {
                        document.getElementById("mySidebar").style.display = "none";
                        document.getElementById("myOverlay").style.display = "none";
                    }

                    function w3_show_nav(name) {
                        document.getElementById("menuTut").style.display = "none";
                        document.getElementById("menuRef").style.display = "none";
                        document.getElementById(name).style.display = "block";
                        w3 - open();
                    }
                </script>

                <script src="https://www.w3schools.com/lib/w3codecolor.js"></script>

                <script>
                    w3CodeColor();
                </script>

                </body>
                </html>
