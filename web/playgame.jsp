<%-- 
    Document   : playgame
    Created on : May 30, 2017, 6:51:30 AM
    Author     : rburkhardt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hangman</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>the Hangman Game</h1>
        <h2>Hangman</h2>
        <!--<img src="h${gameState}.gif">
        <h2 style="font-family:'Lucida Console', monospace">${game.displayWord}</h2>
        <--c:choose>
            <--c:when test="${gameMessageCode != null}">
                <h2 style="font-family:'Lucida Console', monospace; color:red;">${gameMessage}</h2>
            <--/c:when>
            <--c:otherwise>
                <h2 style="font-family:'Lucida Console', monospace;">${gameMessage}</h2>
            <--/c:otherwise>
        <--/c:choose>
        <form action="" method="post">
            <label>Guess a character</label>
            <input type="text" name="guess"><br>
            <--c:choose>
                <--c:when test="${gameState < 7}">
                    <input type="submit" name="action" value="Play">
                <--/c:when>
                <--c:otherwise>
                    <input type="submit" name="action" value="New Game">
                <--/c:otherwise>
            <--/c:choose>            
            <input type="submit" name="action" value="Quit">
        </form>-->
    </body>
</html>