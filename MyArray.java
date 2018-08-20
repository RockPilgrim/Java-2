/**
 * Java-2 Homework-2
 *
 * Основной класс для создания массива,
 * и тестирования исключений
 *
 * @author Timofei Tokarev
 * @version dated 20.08.18
 */

import java.util.Scanner;

public class MyArray {

    private Scanner scan;
    public static final int ARRAY_LENGTH=4;
    public static final int ARRAY_LENGTH_WRONG=6;
    private String[][]arrey;
    private int[][]arrInt=new int[ARRAY_LENGTH][ARRAY_LENGTH];


    public static void main(String[] args) {
        MyArray myArray=new MyArray(ARRAY_LENGTH); // Правильный размер массива
//        MyArray myArray=new MyArray(ARRAY_LENGTH_WRONG); // Неправильный
        try {
            myArray.convertArrey(myArray.getArray());
        }catch (MySizeArrayExeption e){
            System.out.println(e.getMessage());
        }
    }
    public String [][] getArray(){
        return arrey;
    }
    MyArray(int length){
        String [][]arr=new String[length][length];
        scan=new Scanner(System.in);  // Для упрощения тестирования, мы вводим только первую строку
                                     // и повторяем её
        System.out.println("Input numbers "+(length));

        for (int i=0;i<arr.length;i++){
            arr[i][0]=scan.next();
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=arr[i][0];
            }
        }
        arrey=arr;
    }
    public void convertArrey(String [][] arrey)throws MySizeArrayExeption {
        if (arrey.length>ARRAY_LENGTH)throw new MySizeArrayExeption();
        int sum=0;
        for (int i=0;i<arrey.length;i++){
            for (int j=0;j<arrey[i].length;j++){
                try {
                    conv(i,j);
                }catch (MyArrayDataExeption e){
                    System.out.println(e.getMessage(i, j));
                }
                sum+=arrInt[i][j];
            }
        }
        System.out.println(sum);
    }
    public void conv(int i, int j)throws MyArrayDataExeption{
        try {
            arrInt[i][j]=Integer.parseInt(arrey[i][j]);
        }catch (NumberFormatException e) {
            throw new MyArrayDataExeption();
        }
    }

}
