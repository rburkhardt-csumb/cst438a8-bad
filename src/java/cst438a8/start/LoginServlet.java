/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.start;

import cst438a8.data.playerDB;
import cst438a8.player.Player;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rburkhardt
 */
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String url = "/index.jsp";
        
        // get current for index.jsp
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "login_user";
        }
        
        // perform action and set URL to the appropriate page, request and session values.
        if (action.equals("login_user"))
        {
            String username = (String) request.getAttribute("username");
            Player player;
            if (playerDB.playerExists(username))
            {
                player = playerDB.selectPlayer(username);
                log(username);
                request.setAttribute("player", player);
            }
            else
            {
                String message = "Invalid player, please try again or create user profile.";
                request.setAttribute("player", null);
                request.setAttribute("message", message);
            }
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
