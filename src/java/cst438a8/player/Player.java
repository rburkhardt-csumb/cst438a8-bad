/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.player;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rburkhardt
 */
public class Player implements Serializable
{
    private long playerId;
    private String username;
    private String firstName;
    private String lastName;
    private ArrayList<Score> playersScores;

    public Player()
    {
        playerId = 0;
        username = "";
        firstName = "";
        lastName = "";
        playersScores = null;
    }
    
    public Player(long playerId, String username, String firstName,
            String lastName, ArrayList<Score> playersScores)
    {
        this.playerId = playerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playersScores = playersScores;
    }

    public void setPlayerId(long playerId)
    {
        this.playerId = playerId;
    }

    public long getPlayerId()
    {
        return playerId;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setPlayersScores(ArrayList<Score> playersScores)
    {
        this.playersScores = playersScores;
    }

    public ArrayList<Score> getPlayersScores()
    {
        return playersScores;
    }
}
