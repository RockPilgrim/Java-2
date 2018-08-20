/**
 * Java-2 Homework-2
 *
 * Класс исключения "неверное преобразование"
 *
 * @author Timofei Tokarev
 * @version dated 20.08.18
 */

public class MyArrayDataExeption extends NumberFormatException {

    public String getMessage(int i, int j){
        return "Data Exception in ["+i+"] ["+j+"]";
    }
}
