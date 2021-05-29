/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 123
 */
public class record extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String[] user1 = (String[]) session.getAttribute("user1");
            String name = user1[0];

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>"
                    + "    <title>Home</title>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                    + "    <style>\n"
                    + "        .w3-theme {color:#fff !important;background-color:#e65c00 !important}\n"
                    + "        .w3-btn {background-color:#4CAF50;margin-bottom:4px}\n"
                    + "        .w3-code{border-left:4px solid #4CAF50}\n"
                    + "        .myMenu {margin-bottom:150px}\n"
                    + "         .grid-container {\n"
                    + "                 display: grid;\n"
                    + "                 position:relative;\n"
                    + "                 grid-column-gap: 0px;\n"
                    + "                 grid-template-columns: auto auto auto auto;\n"
                    + "                 grid-row-gap: 10px;\n"
                    + "                 }\n"
                    + "         .grid-item {\n"
                    + "                 font-size: 30px;\n"
                    + "                 text-align: center;\n"
                    + "                 }"
                    + "             .holder {\n"
                    + "                background-color: #4c474c;\n"
                    + "                background-image: -webkit-gradient(linear, left bottom, left top, from(#4c474c), to(#141414));\n"
                    + "                background-image: -o-linear-gradient(bottom, #4c474c 0%, #141414 100%);\n"
                    + "                background-image: linear-gradient(0deg, #4c474c 0%, #141414 100%);\n"
                    + "                border-radius: 50px;\n"
                    + "            }\n"
                    + "            [data-role=\"controls\"] > button {\n"
                    + "                margin: 50px auto;\n"
                    + "                outline: none;\n"
                    + "                display: block;\n"
                    + "                border: none;\n"
                    + "                background-color: #D9AFD9;\n"
                    + "                background-image: -webkit-gradient(linear, left bottom, left top, from(#D9AFD9), to(#97D9E1));\n"
                    + "                background-image: -o-linear-gradient(bottom, #D9AFD9 0%, #97D9E1 100%);\n"
                    + "                background-image: linear-gradient(0deg, #D9AFD9 0%, #97D9E1 100%);\n"
                    + "                width: 70px;\n"
                    + "                height: 100px;\n"
                    + "                border-radius: 50%;\n"
                    + "                text-indent: -1000em;\n"
                    + "                cursor: pointer;\n"
                    + "                -webkit-box-shadow: 0px 5px 5px 2px rgba(0,0,0,0.3) inset, \n"
                    + "                    0px 0px 0px 30px #fff, 0px 0px 0px 35px #333;\n"
                    + "                        box-shadow: 0px 5px 5px 2px rgba(0,0,0,0.3) inset, \n"
                    + "                    0px 0px 0px 30px #fff, 0px 0px 0px 35px #333;\n"
                    + "            }\n"
                    + "            [data-role=\"controls\"] > button:hover {\n"
                    + "                background-color: #ee7bee;\n"
                    + "                background-image: -webkit-gradient(linear, left bottom, left top, from(#ee7bee), to(#6fe1f5));\n"
                    + "                background-image: -o-linear-gradient(bottom, #ee7bee 0%, #6fe1f5 100%);\n"
                    + "                background-image: linear-gradient(0deg, #ee7bee 0%, #6fe1f5 100%);\n"
                    + "            }\n"
                    + "            [data-role=\"controls\"] > button[data-recording=\"true\"] {\n"
                    + "                background-color: #ff2038;\n"
                    + "                background-image: -webkit-gradient(linear, left bottom, left top, from(#ff2038), to(#b30003));\n"
                    + "                background-image: -o-linear-gradient(bottom, #ff2038 0%, #b30003 100%);\n"
                    + "                background-image: linear-gradient(0deg, #ff2038 0%, #b30003 100%);\n"
                    + "            }\n"
                    + "            [data-role=\"recordings\"] > .row {\n"
                    + "                width: auto;\n"
                    + "                height: auto;\n"
                    + "                padding: 20px;\n"
                    + "            }\n"
                    + "            [data-role=\"recordings\"] > .row > audio {\n"
                    + "                outline: none;\n"
                    + "            }\n"
                    + "            [data-role=\"recordings\"] > .row > a {\n"
                    + "                display: inline-block;\n"
                    + "                text-align: center;\n"
                    + "                font-size: 20px;\n"
                    + "                line-height: 50px;\n"
                    + "                vertical-align: middle;\n"
                    + "                width: 50px;\n"
                    + "                height: 50px;\n"
                    + "                border-radius: 20px;\n"
                    + "                color: #fff;\n"
                    + "                font-weight: bold;\n"
                    + "                text-decoration: underline;\n"
                    + "                background-color: #0093E9;\n"
                    + "                background-image: -webkit-gradient(linear, left bottom, left top, from(#0093E9), to(#80D0C7));\n"
                    + "                background-image: -o-linear-gradient(bottom, #0093E9 0%, #80D0C7 100%);\n"
                    + "                background-image: linear-gradient(0deg, #0093E9 0%, #80D0C7 100%);\n"
                    + "                float: right;\n"
                    + "                margin-left: 20px;\n"
                    + "                cursor: pointer;\n"
                    + "            }\n"
                    + "            [data-role=\"recordings\"] > .row > a:hover {\n"
                    + "                text-decoration: none;\n"
                    + "            }\n"
                    + "            [data-role=\"recordings\"] > .row > a:active {\n"
                    + "                background-image: -webkit-gradient(linear, left top, left bottom, from(#0093E9), to(#80D0C7));\n"
                    + "                background-image: -o-linear-gradient(top, #0093E9 0%, #80D0C7 100%);\n"
                    + "                background-image: linear-gradient(180deg, #0093E9 0%, #80D0C7 100%);\n"
                    + "            }"
                    + "    </style>\n"
                    + "         <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://stephino.github.io/dist/recorder.js\"></script>\n"
                    + "        <script>\n"
                    + "            jQuery(document).ready(function () {\n"
                    + "                var $ = jQuery;\n"
                    + "                var myRecorder = {\n"
                    + "                    objects: {\n"
                    + "                        context: null,\n"
                    + "                        stream: null,\n"
                    + "                        recorder: null\n"
                    + "                    },\n"
                    + "                    init: function () {\n"
                    + "                        if (null === myRecorder.objects.context) {\n"
                    + "                            myRecorder.objects.context = new (\n"
                    + "                                    window.AudioContext || window.webkitAudioContext\n"
                    + "                                    );\n"
                    + "                        }\n"
                    + "                    },\n"
                    + "                    start: function () {\n"
                    + "                        var options = {audio: true, video: false};\n"
                    + "                        navigator.mediaDevices.getUserMedia(options).then(function (stream) {\n"
                    + "                            myRecorder.objects.stream = stream;\n"
                    + "                            myRecorder.objects.recorder = new Recorder(\n"
                    + "                                    myRecorder.objects.context.createMediaStreamSource(stream),\n"
                    + "                                    {numChannels: 1}\n"
                    + "                            );\n"
                    + "                            myRecorder.objects.recorder.record();\n"
                    + "                        }).catch(function (err) {});\n"
                    + "                    },\n"
                    + "                    stop: function (listObject) {\n"
                    + "                        if (null !== myRecorder.objects.stream) {\n"
                    + "                            myRecorder.objects.stream.getAudioTracks()[0].stop();\n"
                    + "                        }\n"
                    + "                        if (null !== myRecorder.objects.recorder) {\n"
                    + "                            myRecorder.objects.recorder.stop();\n"
                    + "\n"
                    + "                            // Validate object\n"
                    + "                            if (null !== listObject\n"
                    + "                                    && 'object' === typeof listObject\n"
                    + "                                    && listObject.length > 0) {\n"
                    + "                                // Export the WAV file\n"
                    + "                                myRecorder.objects.recorder.exportWAV(function (blob) {\n"
                    + "                                    var url = (window.URL || window.webkitURL)\n"
                    + "                                            .createObjectURL(blob);\n"
                    + "\n"
                    + "                                    // Prepare the playback\n"
                    + "                                    var audioObject = $('<audio controls></audio>')\n"
                    + "                                            .attr('src', url);\n"
                    + "\n"
                    + "                                    // Prepare the download link\n"
                    + "                                    var downloadObject = $('<a>&#9660;</a>')\n"
                    + "                                            .attr('href', url)\n"
                    + "                                            .attr('download', new Date().toUTCString() + '.wav');\n"
                    + "\n"
                    + "                                    // Wrap everything in a row\n"
                    + "                                    var holderObject = $('<div class=\"row\"></div>')\n"
                    + "                                            .append(audioObject)\n"
                    + "                                            .append(downloadObject);\n"
                    + "\n"
                    + "                                    // Append to the list\n"
                    + "                                    listObject.append(holderObject);\n"
                    + "                                });\n"
                    + "                            }\n"
                    + "                        }\n"
                    + "                    }\n"
                    + "                };\n"
                    + "\n"
                    + "                // Prepare the recordings list\n"
                    + "                var listObject = $('[data-role=\"recordings\"]');\n"
                    + "\n"
                    + "                // Prepare the record button\n"
                    + "                $('[data-role=\"controls\"] > button').click(function () {\n"
                    + "                    // Initialize the recorder\n"
                    + "                    myRecorder.init();\n"
                    + "\n"
                    + "                    // Get the button state \n"
                    + "                    var buttonState = !!$(this).attr('data-recording');\n"
                    + "\n"
                    + "                    // Toggle\n"
                    + "                    if (!buttonState) {\n"
                    + "                        $(this).attr('data-recording', 'true');\n"
                    + "                        myRecorder.start();\n"
                    + "                    } else {\n"
                    + "                        $(this).attr('data-recording', '');\n"
                    + "                        myRecorder.stop(listObject);\n"
                    + "                    }\n"
                    + "                });\n"
                    + "            });\n"
                    + "        </script>"
                    + " </head>"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">\n"
                    + "            <button class=\"w3-bar-item w3-button w3-large\"\n"
                    + "                    onclick=\"w3_close()\">Close &times;</button>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"assignments\">Asignments</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Classes</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Messages</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"#\">Calander</a>\n"
                    + "            <a class=\"w3-bar-item w3-button\" href=\"Stsettings\">Settings</a>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div id=\"main\">\n"
                    + "\n"
                    + "            <div class=\"w3-bar w3-theme w3-large\">\n"
                    + "                <div class=\"w3-center  w3-padding\" style=\"background-color: black; color: white;\">\n"
                    + "                    <div class=\" w3-margin-top w3-wide w3-hide-medium w3-hide-small\"><div class=\"w3-center\">Digi<b>Sight</b></div></div>\n"
                    + "                </div>\n"
                    + "                <button class=\"w3-bar-item w3-button w3-xlarge\" onclick=\"w3_open()\" id=\"openNav\">&#9776;</button>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16\" href=\"student\">Home</a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16\" href=\"javascript:void(0)\">Posts</a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\"><b>" + name + "</b></a>\n"
                    + "                <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\" href=\"logout\">Logout</a>\n"
                    + "            </div>\n"
                    + "\n"
                    + "\n"
                    + "            <script>\n"
                    + "                function w3_open() {\n"
                    + "                    document.getElementById(\"main\").style.marginLeft = \"25%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.width = \"25%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                    document.getElementById(\"openNav\").style.display = 'none';\n"
                    + "                }\n"
                    + "                function w3_close() {\n"
                    + "                    document.getElementById(\"main\").style.marginLeft = \"0%\";\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                    document.getElementById(\"openNav\").style.display = \"inline-block\";\n"
                    + "                }\n"
                    + "            </script>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "            <div id=\"main\">\n"
                    + "                <!-- Sidebar -->\n"
                    + "\n"
                    + "                <!-- Overlay effect when opening sidebar on small screens -->\n"
                    + "                <div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n"
                    + "\n"
                    + "                <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->\n"
                    + "                <div class=\"w3-main w3-container\" style=\"margin-left:300px;margin-top:50px;margin-right:300px;\">\n"
                    + "\n"
                    + "                   <div class=\"holder\">\n"
                    + "            <div data-role=\"controls\">\n"
                    + "                <button>Record</button>\n"
                    + "            </div>\n"
                    + "            <div data-role=\"recordings\"></div>\n"
                    + "        </div>"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "                    <footer class=\"w3-panel w3-padding-32 w3-card-4 w3-light-grey w3-center w3-opacity\">\n"
                    + "                        <p><nav>\n"
                    + "                            <a href=\"/forum/default.asp\" target=\"_blank\">FORUM</a> |\n"
                    + "                            <a href=\"/about/default.asp\" target=\"_top\">ABOUT</a>\n"
                    + "                        </nav></p>\n"
                    + "                    </footer>\n"
                    + "\n"
                    + "                    <!-- END MAIN -->\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <script>\n"
                    + "                    // Script to open and close the sidebar\n"
                    + "                    function w3_open() {\n"
                    + "                        document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                        document.getElementById(\"myOverlay\").style.display = \"block\";\n"
                    + "                    }\n"
                    + "\n"
                    + "                    function w3_close() {\n"
                    + "                        document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                        document.getElementById(\"myOverlay\").style.display = \"none\";\n"
                    + "                    }\n"
                    + "\n"
                    + "                    function w3_show_nav(name) {\n"
                    + "                        document.getElementById(\"menuTut\").style.display = \"none\";\n"
                    + "                        document.getElementById(\"menuRef\").style.display = \"none\";\n"
                    + "                        document.getElementById(name).style.display = \"block\";\n"
                    + "                        w3 - open();\n"
                    + "                    }\n"
                    + "                </script>\n"
                    + "\n"
                    + "                <script src=\"https://www.w3schools.com/lib/w3codecolor.js\"></script>\n"
                    + "\n"
                    + "                <script>\n"
                    + "                    w3CodeColor();\n"
                    + "                </script>\n"
                    + "\n"
                    + "                </body>\n"
                    + "                </html>\n"
                    + "");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
