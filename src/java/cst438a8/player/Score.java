/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.player;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rburkhardt
 */
class Score implements Serializable
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private long scoreId;
    private long playerId;
    private String date;
    private Integer score;
    
    /*public Score()
    {
        Date today = new Date();
        date = sdf.format(today);
        score = 0;        
    }
    
    public Score(int score)
    {
        Date today = new Date();
        date = sdf.format(today);
        this.score = score;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setScoreId(long scoreId)
    {
        this.scoreId = scoreId;
    }

    public long getScoreId()
    {
        return scoreId;
    }

    public void setPlayerId(long playerId)
    {
        this.playerId = playerId;
    }

    public long getPlayerId()
    {
        return playerId;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void setDate()
    {
        Date today = new Date();
        date = sdf.format(today);
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public Integer getScore()
    {
        return score;
    }
}
