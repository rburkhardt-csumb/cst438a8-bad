/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.game;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rburkhardt
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet
{
    private Game game = new Game();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String url = "/playgame.jsp";
        String message = "";
        Integer messageCode = null;
        
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "New Game";
        }
        
        if (action.equals("play"))
        {
            String guess = request.getParameter("guess");
            if (goodInput(guess))
            {
                char charGuess = guess.charAt(0);
                int result = game.playGame(charGuess);
                switch (result)
                {
                    case 0:
                        message = "Good Job, One Letter Down!";
                        messageCode = null;
                        break;
                    case 1:
                        message = "Congratulations, You Won!";
                        messageCode = null;
                        break;
                    case 2:
                        message = "Sorry that was not a good guess";
                        messageCode = 1;
                        break;
                    case 3:
                        message = "Sorry, you have been Hung!";
                        messageCode = 1;
                        break;
                }
            }
            else
            {
                message = "Invalid guess, try again!";
                messageCode = 1;
            }
            
            session.setAttribute("gameState", game.getState());
            session.setAttribute("gameWord", game.getDisplayWord());
            session.setAttribute("gameMessage", message);
            session.setAttribute("gameMessageCode", messageCode);
            session.setAttribute("gameScore", 0);
        }
        else if (action.equals("New Game"))
        {
            game.startNewGame();
            message = "Make your first guess!";
            messageCode = null;
            session.setAttribute("gameState", game.getState());
            session.setAttribute("gameWord", game.getDisplayWord());
            session.setAttribute("gameMessage", message);
            session.setAttribute("gameMessageCode", messageCode);
            session.setAttribute("gameScore", 0);
        }
        else if (action.equals("Quit"))
        {
            // save score added here
            url = "/index.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
    }
    
    private boolean goodInput (String guess)
    {
        if ( guess.isEmpty() || guess.length() > 1 )
        {
            return false;
        }
        else
        {
            char userChoice = guess.charAt(0);
            return Character.isLetter(userChoice);
        }
    }

}
