/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.player;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    /*public Player()
    {
        playerId = 0;
        username = "";
        firstName = "";
        lastName = "";
    }
    
    public Player(long playerId, String username, String firstName,
            String lastName)
    {
        this.playerId = playerId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
