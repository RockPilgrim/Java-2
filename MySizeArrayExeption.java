/**
 * Java-2 Homework-2
 *
 * Класс исключения, "неверный размер"
 *
 * @author Timofei Tokarev
 * @version dated 20.08.18
 */

public class MySizeArrayExeption extends Exception {

    @Override
    public String getMessage(){
        return "Size Exception";
    }
}
