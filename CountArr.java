/**
 * Java-2 Homework-5
 *
 * Класс потокового вычисления
 *
 * @author Timofei Tokarev
 * @version dated 30.08.18
 */


public class CountArr {
    private final int SIZE=10000000;  // Размер массива
    private int amountThreads=4;      // Кол-во потоков
    private float[]arr=new float[SIZE];

    public static void main(String[] args) {
        CountArr countArr=new CountArr();
    }
    CountArr(){
        for (int i=0;i<arr.length;i++){
            arr[i]=1;
        }
        oneThread(); // один поток без склейки(массива)
        multyThread(amountThreads); // несколько потоков со склейкой(массива)
    }
    private void oneThread(){
        long a=System.currentTimeMillis();
        for (int i=0;i<arr.length;i++){
            arr[i]=(float)(arr [ i ] * Math . sin ( 0.2f + i / 5 ) * Math . cos ( 0.2f + i / 5 ) *
                    Math . cos ( 0.4f + i / 2 ));
        }
        System.out.println("One thread ends in "+(System.currentTimeMillis()-a)+" millisec "+arr[SIZE-1]); // Информация о завершении + последний элемент для сверки
    }

    private void multyThread (int amount) {
        long a=System.currentTimeMillis();

        Thread[] threads=new Thread[amount];
        float[] arrey=new float[SIZE/amount];

        for (int i = 0; i < amount; i++) {

            System.arraycopy(arr,i*(arr.length/amount),arrey,0,arr.length/amount); // Дробление массива для вычисления по частям
            MultyThread multyThread = new MultyThread(Integer.toString(i+1), arrey);
            Thread thread = new Thread(multyThread); // Создание потока
            threads[i]=thread;
            thread.start();  // Запуск потока
            arrey=multyThread.getArr();
            System.arraycopy(arrey,0,arr,i*(arr.length/amount),arrey.length); // Склейка массива в один
        }
        try {
            for (int i = 0; i < amount; i++) {
                threads[i].join(); // Ожидание завершения потока
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(amount+" Threads ends in " + (System.currentTimeMillis()-a)+" millisec "+arr[SIZE-1]); // Информация о завершении + последний элемент для сверки
    }
}
