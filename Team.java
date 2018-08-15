/**
 * Java-2 Homework-1
 *
 * Класс создания команды
 * создаются члены команды с их параметрами
 * объявленные методы проверяют участников на прохождение Препятствия
 * и выводят их параметры
 *
 * @author Timofei Tokarev
 * @version dated 15.08.18
 */

public class Team {
    private Person[] team={
            new Person("Zrya",100,2.3f,400),
            new Person("Widow",150,2.0f,350),
            new Person("Tracer",300,1.8f,240),
            new Person("Reaper",200,1.9f,50),
            new Person("Sombra",250,2.5f,250)
    };
    private int[] losersNum=new int[team.length];

    public void run(Course course){
        for (int i=0;i<team.length;i++){
            if(team[i].getDistanceRun()<course.getDistanceRun()||
                    team[i].getJumpHeight()<course.getJumpHeight()||
                    team[i].getSwim()<course.getSwim())
                losersNum[i]=1;
        }
    }
    public void showResult(){
        for (int i=0;i<losersNum.length;i++){
            if (losersNum[i]!=1)
                System.out.println(team[i].getName()+" win!");
        }
    }
    public void members(){
        for (Person p:team) {
            System.out.println(p);
        }
    }
}
