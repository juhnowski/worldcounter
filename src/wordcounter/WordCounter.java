/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 7634
 */
public class WordCounter {

    public static boolean checkFirst = true;
    public static String sanhw = "C:\\src_sanscrit\\CORRECTIONS\\sanhw1\\sanhw1.txt";

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
        slp1.put("L", 0); //!!!!!!!!!!!!!

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
        slp2.put("L", 0); //!!!!!!!!!!!!!

        HashMap dicMap = new HashMap();
        HashMap dicCnt = new HashMap();

        int cnt2 = 0;
        int cnt1 = 0;
        String st = null;
        try {
            try (BufferedReader br1 = new BufferedReader(new FileReader(new File(sanhw)))) {
                boolean flag1 = true;
                while (flag1) {

                    st = br1.readLine();
                    if ((st == null) || (st.startsWith("{%pratipakshita:BEN"))) {
                        flag1 = false;
                    } else {
                        String[] liball = st.split(":");
                        String ch1;
                        if (checkFirst) {
                            ch1 = st.substring(0, 1); //проверка по первым буквам
                        } else {
                            ch1 = liball[0].substring(liball[0].length() - 1); //проверка по последним
                            if (ch1.equals(" ") || ch1.equals("~")) {
                                ch1 = liball[0].substring(liball[0].length() - 2, liball[0].length() - 1);
                            }
                        }
                        slp2.put(ch1, (Integer) slp2.get(ch1) + 1);
                        cnt2++;

                        //проверка на WIL
                        CharSequence wil = "WIL";
                        if (liball[1].contains(wil)) {
                            slp1.put(ch1, (Integer) slp1.get(ch1) + 1);
                            cnt1++;
                        }

                        //получение словарей для записи
                        List<String> dics = Arrays.asList(liball[1].split("\\s*,\\s*"));
                        for (Object stk : dics) {
                            if (dicMap.keySet().contains(stk)) {
                                //в мапе словарей есть уже такой словарь
                                HashMap md = (HashMap) dicMap.get(stk);
                                try {
                                    md.put(ch1, (Integer) md.get(ch1) + 1);
                                } catch (Exception e) {
                                    System.out.println("*******" + ch1 + "*******");
                                }
                                dicCnt.put(stk, (Integer) dicCnt.get(stk) + 1);
                            } else {
                                //добавляем словарь
                                dicMap.put(stk, new HashMap());
                                HashMap m = (HashMap) dicMap.get(stk);
                                //Добавляем счетчики
                                dicCnt.put(stk, 0);
                                //Инициализируем счетчики
                                m.put("a", 0);
                                m.put("A", 0);
                                m.put("i", 0);
                                m.put("I", 0);
                                m.put("u", 0);
                                m.put("U", 0);
                                m.put("f", 0);
                                m.put("F", 0);
                                m.put("x", 0);
                                m.put("X", 0);
                                m.put("e", 0);
                                m.put("E", 0);
                                m.put("o", 0);
                                m.put("O", 0);
                                m.put("M", 0);
                                m.put("H", 0);
                                m.put("k", 0);
                                m.put("K", 0);
                                m.put("g", 0);
                                m.put("G", 0);
                                m.put("N", 0);
                                m.put("c", 0);
                                m.put("C", 0);
                                m.put("j", 0);
                                m.put("J", 0);
                                m.put("Y", 0);
                                m.put("w", 0);
                                m.put("W", 0);
                                m.put("q", 0);
                                m.put("Q", 0);
                                m.put("R", 0);
                                m.put("t", 0);
                                m.put("T", 0);
                                m.put("d", 0);
                                m.put("D", 0);
                                m.put("n", 0);
                                m.put("p", 0);
                                m.put("P", 0);
                                m.put("b", 0);
                                m.put("B", 0);
                                m.put("m", 0);
                                m.put("y", 0);
                                m.put("r", 0);
                                m.put("l", 0);
                                m.put("v", 0);
                                m.put("S", 0);
                                m.put("z", 0);
                                m.put("s", 0);
                                m.put("h", 0);
                                m.put("L", 0);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(st);
            e.printStackTrace();
        }

        System.out.println("Counts in: " + sanhw);
        System.out.println(slp2.toString());
        System.out.println(cnt2);

        System.out.println("Counts WIL:");
        System.out.println(slp1.toString());
        System.out.println(cnt1);

        System.out.println("Diff ALL-WIL:");
        HashMap res = new HashMap();
        Set keys = slp1.keySet();
        for (Object k : keys) {
            int v1 = (Integer) slp1.get(k);
            int v2 = (Integer) slp2.get(k);
            res.put(k, v2 - v1);
        }
        System.out.println(res.toString());

        System.out.println("Counts: a;A;b;B;v;g;G;h;O");
        ArrayList chars = new ArrayList();
        chars.add("a");
        chars.add("A");
        chars.add("b");
        chars.add("B");
        chars.add("v");
        chars.add("g");
        chars.add("G");
        chars.add("h");
        chars.add("O");
        int cntchars1 = 0;
        int cntchars2 = 0;
        int cntchars3 = 0;
        for (Object c : chars) {

            cntchars1 += (Integer) slp1.get(c);
            cntchars2 += (Integer) slp2.get(c);
        }
        System.out.println("ALL: " + cntchars2);
        System.out.println("WIL: " + cntchars1);
        cntchars3 = cntchars2 - cntchars1;
        System.out.println("ALL-WIL: " + cntchars3);

        System.out.println("___________________________________________________");
        System.out.println("Words in dict:");
        System.out.println(dicCnt);
        System.out.println("___________________________________________________");
        System.out.println("Counts first chars in dict:");
        System.out.println(dicMap);
        System.out.println("___________________________________________________");
        System.out.println("Finished");

    }

}
