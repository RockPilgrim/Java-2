/**
 * Java-2 Homework-3
 *
 * Класс выполняющий первое задание домашней работы
 * находит уникальные имена и количество повторений их в списке
 *
 * @author Timofei Tokarev
 * @version dated 23.08.18
 */

import java.util.*;

public class ArrayTest {

    private ArrayList<String> words=new ArrayList<>();
    private HashMap<String, Integer> hm = new HashMap<>();
    private String name1="Cay S. Horstmann";
    private String name2="Gary Cornell";
    private String name3="Bruce Eckel";
    private String name4="Herbert Schildt";

    public static void main(String[] args) {
        ArrayTest arrayTest=new ArrayTest();
    }
    ArrayTest(){

        setWords();

        words.sort(String::compareToIgnoreCase);   // Сортирую чтобы легче было найти одинаковые
        System.out.println(words);
        hm.put(words.get(0),0);

        for (int i=0;i<words.size();i++){
            if (hm.containsKey(words.get(i))){
                int value=hm.get(words.get(i));
                hm.put(words.get(i),value+1);
            }else
                hm.put(words.get(i),1);
        }
        System.out.println(hm);
    }
    private void setWords(){
        words.add(name1);

        words.add(name3);

        words.add(name1);
        words.add(name1);

        words.add(name4);

        words.add(name2);
        words.add(name2);

        words.add(name3);
        words.add(name3);

        words.add(name4);
        words.add(name4);
        words.add(name4);
    }
}
