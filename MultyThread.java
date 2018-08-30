/**
 * Java-2 Homework-5
 *
 * Класс для вычисления в одном потоке
 *
 * @author Timofei Tokarev
 * @version dated 30.08.18
 */


public class MultyThread implements Runnable {

    private float arr[];
    private String name;

    MultyThread(String name,float arr[]){
        this.name=name;
        this.arr=arr;
    }
    @Override
    public void run(){
        long a=System.currentTimeMillis();   // Засекаем время(начальное) выполнения отдельного потока

        for (int i=0;i<arr.length;i++){
            arr[i]=(float)(arr [ i ] * Math . sin ( 0.2f + i / 5 ) * Math . cos ( 0.2f + i / 5 ) *
                    Math . cos ( 0.4f + i / 2 ));
        }
        System.out.println("Thread_"+name+" finished in "+(System.currentTimeMillis()-a)+" mills"); // Выводим в консоль информацию об объекте
    }

    public float[] getArr() {
        return arr;
    }
}
