/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.data;

import cst438a8.player.Player;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author rburkhardt
 */
public class playerDB
{
    public static Player selectPlayer(String username)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Player p " +
                "WHERE p.username = :username";
        TypedQuery<Player> q = em.createQuery(qString, Player.class);
        q.setParameter("username", username);
        try
        {
            Player player = q.getSingleResult();
            return player;
        } 
        catch (NoResultException e)
        {
            return  null;
        }
        finally
        {
            em.close();
        }
    }
    
    public static boolean playerExists(String username)
    {
        Player p = selectPlayer(username);
        return p != null;
    }
}
