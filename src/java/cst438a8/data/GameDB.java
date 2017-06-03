/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8.data;

import cst438a8.game.Word;
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
    public static ArrayList<Word> retrieveWords()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT w.Word FROM Word w";
        TypedQuery<Word> w = em.createQuery(qString, Word.class);
        ArrayList<Word> words;
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
