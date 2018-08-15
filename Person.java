/**
 * Java-2 Homework-1
 *
 * Класс хранения параметров участника
 *
 * @author Timofei Tokarev
 * @version dated 15.08.18
 */

public class Person extends Obstacle {

    private String name;
    private int age;

    public Person(String name,int distanceRun,float jumpHeight,int swim){
        super(distanceRun,jumpHeight,swim);
        this.name=name;
    }
    public void setAge(int age){
        if (age>0 && age<100)
            this.age=age;
    }
    @Override
    public String toString(){
        return name+" run:"+getDistanceRun()+" jump:"+getJumpHeight()+" swim:"+getSwim();
    }

    public String getName() {
        return name;
    }
}
