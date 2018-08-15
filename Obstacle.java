
/**
 * Java-2 Homework-1
 *
 * Класс препятствий
 * хранения параметров полосы препятствий
 *
 * @author Timofei Tokarev
 * @version dated 15.08.18
 */

public abstract class Obstacle {

    private int distanceRun;
    private float jumpHeight;
    private int swim;

    public Obstacle(int distanceRun,float jumpHeight,int swim){
        this.distanceRun=distanceRun;
        this.jumpHeight=jumpHeight;
        this.swim=swim;
    }
    public int getDistanceRun() {
        return distanceRun;
    }
    public float getJumpHeight() {
        return jumpHeight;
    }
    public int getSwim() {
        return swim;
    }
}
