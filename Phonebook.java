/**
 * Java-2 Homework-3
 *
 * Класс "Телефонная книга"
 * записывает и выводит фамилии и телефонные номера им приписанныые
 *
 * @author Timofei Tokarev
 * @version dated 23.08.18
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    private HashMap<String,ArrayList> phonebook=new HashMap<>();

    public static void main(String[] args) {
        Phonebook phone_book=new Phonebook();
        phone_book.add("Eckel","89610445432");
        phone_book.add("Eckel","89610445432");

        phone_book.add("Horstmann","89818445832");
        phone_book.add("Horstmann","89818445832");

        phone_book.add("Cornell","89998444832");
        phone_book.add("Cornell","89998442832");
        phone_book.add("Cornell","89998443832");

        phone_book.add("Schildt","89778145432");

        phone_book.get("Luigi");
        phone_book.get("Eckel");
        phone_book.get("Horstmann");
        phone_book.get("Cornell");
        phone_book.get("Schildt");

    }

    private void add(String surname,String  number) {
        if (!phonebook.containsKey(surname)) {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(number);
            phonebook.put(surname, numbers);
        } else if (!phonebook.get(surname).contains(number))
            phonebook.get(surname).add(number);
    }
    private void get(String surname){
        if (phonebook.containsKey(surname))
            System.out.println(surname+" "+phonebook.get(surname));
        else {
            System.out.println("Sorry we don\'t know him/her: "+surname);
        }

    }
}
