/**
 * Java-2 Homework-1
 *
 * Основной класс
 * в котором создаются объекты домашнего задания
 * и вызываются их методы
 *
 * @author Timofei Tokarev
 * @version dated 15.08.18
 */

public class TeamTest {

    public static void main(String[] args) {
        Course course=new Course(100,2.0f,100);
        Team team=new Team();
        team.run(course);  // Показалось логичнее чтобы участник знал о препятствии, а не препятствие об участнике
        team.showResult();
        System.out.println("---------------------");
        team.members();
    }
}
