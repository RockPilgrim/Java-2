/**
 * Java-2 Homework-1
 *
 * Класс хранения параметров полосы препятствий
 * Коментарий автора"по техническому заданию подразумевалось
 * что класс будет выполнять какие-то действия, в итоге от этого
 * решил отказаться. Такую реализацию оставил т.к она показывает
 * возможности наследования"
 *
 * @author Timofei Tokarev
 * @version dated 15.08.18
 */

public class Course extends Obstacle {

    public Course(int distanceRun,float jumpHeight,int swim){
        super(distanceRun,jumpHeight,swim);
    }
}
