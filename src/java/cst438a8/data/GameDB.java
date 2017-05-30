/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author rburkhardt
 */
public class GameDB
{
    public static ArrayList<String> retrieveWords()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT w.Word FROM Word w";
        TypedQuery<String> w = em.createQuery(qString, String.class);
        ArrayList<String> words;
        try
        {
            words = new ArrayList<>(w.getResultList());
            if (words.isEmpty())
            {
                words = null;
            }
        }
        finally
        {
            em.close();
        }
        return words;
    }
}
