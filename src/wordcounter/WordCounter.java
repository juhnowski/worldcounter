/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author 7634
 */
public class WordCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap slp1 = new HashMap();
        slp1.put("a", 0);
        slp1.put("A", 0);
        slp1.put("i", 0);
        slp1.put("I", 0);
        slp1.put("u", 0);
        slp1.put("U", 0);
        slp1.put("f", 0);
        slp1.put("F", 0);
        slp1.put("x", 0);
        slp1.put("X", 0);
        slp1.put("e", 0);
        slp1.put("E", 0);
        slp1.put("o", 0);
        slp1.put("O", 0);
        slp1.put("M", 0);
        slp1.put("H", 0);
        slp1.put("k", 0);
        slp1.put("K", 0);
        slp1.put("g", 0);
        slp1.put("G", 0);
        slp1.put("N", 0);
        slp1.put("c", 0);
        slp1.put("C", 0);
        slp1.put("j", 0);
        slp1.put("J", 0);
        slp1.put("Y", 0);
        slp1.put("w", 0);
        slp1.put("W", 0);
        slp1.put("q", 0);
        slp1.put("Q", 0);
        slp1.put("R", 0);
        slp1.put("t", 0);
        slp1.put("T", 0);
        slp1.put("d", 0);
        slp1.put("D", 0);
        slp1.put("n", 0);
        slp1.put("p", 0);
        slp1.put("P", 0);
        slp1.put("b", 0);
        slp1.put("B", 0);
        slp1.put("m", 0);
        slp1.put("y", 0);
        slp1.put("r", 0);
        slp1.put("l", 0);
        slp1.put("v", 0);
        slp1.put("S", 0);
        slp1.put("z", 0);
        slp1.put("s", 0);
        slp1.put("h", 0);

        HashMap slp2 = new HashMap();
        slp2.put("a", 0);
        slp2.put("A", 0);
        slp2.put("i", 0);
        slp2.put("I", 0);
        slp2.put("u", 0);
        slp2.put("U", 0);
        slp2.put("f", 0);
        slp2.put("F", 0);
        slp2.put("x", 0);
        slp2.put("X", 0);
        slp2.put("e", 0);
        slp2.put("E", 0);
        slp2.put("o", 0);
        slp2.put("O", 0);
        slp2.put("M", 0);
        slp2.put("H", 0);
        slp2.put("k", 0);
        slp2.put("K", 0);
        slp2.put("g", 0);
        slp2.put("G", 0);
        slp2.put("N", 0);
        slp2.put("c", 0);
        slp2.put("C", 0);
        slp2.put("j", 0);
        slp2.put("J", 0);
        slp2.put("Y", 0);
        slp2.put("w", 0);
        slp2.put("W", 0);
        slp2.put("q", 0);
        slp2.put("Q", 0);
        slp2.put("R", 0);
        slp2.put("t", 0);
        slp2.put("T", 0);
        slp2.put("d", 0);
        slp2.put("D", 0);
        slp2.put("n", 0);
        slp2.put("p", 0);
        slp2.put("P", 0);
        slp2.put("b", 0);
        slp2.put("B", 0);
        slp2.put("m", 0);
        slp2.put("y", 0);
        slp2.put("r", 0);
        slp2.put("l", 0);
        slp2.put("v", 0);
        slp2.put("S", 0);
        slp2.put("z", 0);
        slp2.put("s", 0);
        slp2.put("h", 0);

        String wil = "D:\\src_sanscr\\CORRECTIONS\\dictionaries\\WIL\\chksort2.txt";
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(new File(wil)))) {
                boolean flag = true;
                while (flag) {

                    String s = null;
                    s = br.readLine();
                    if (s == null) {
                        flag = false;
                    } else {

                        String[] sa = s.split(":");
                        String ch = sa[1].substring(0, 1);
                        slp1.put(ch, (Integer) slp1.get(ch) + 1);
                    }
                }
            }

            System.out.println("Counts Wilson in:" + wil);
            System.out.println(slp1.toString());
        } catch (Exception e) {
        }

        String sanhw = "D:\\src_sanscr\\CORRECTIONS\\sanhw1\\sanhw1.txt";
        try {
            try (BufferedReader br1 = new BufferedReader(new FileReader(new File(sanhw)))) {
                boolean flag1 = true;
                while (flag1) {
                    String st = null;
                    st = br1.readLine();
                    if (st == null) {
                        flag1 = false;
                    } else {
                        String ch1 = st.substring(0, 1);
                        slp2.put(ch1, (Integer) slp2.get(ch1) + 1);
                    }
                }
            }
        } catch (Exception e) {
        }
            System.out.println("Counts in: " + sanhw);
            System.out.println(slp2.toString());
            
            System.out.println("Diff:");
            HashMap res = new HashMap();
            Set keys = slp1.keySet();
            for(Object k : keys){
                int v1 = (Integer)slp1.get(k);
                int v2 = (Integer)slp2.get(k);
                res.put(k, v1-v2);
            }
            System.out.println(res.toString());
            
            System.out.println("Finished");
            
            

    }

}
