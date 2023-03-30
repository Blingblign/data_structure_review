package exer;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.function.ObjIntConsumer;

/**
 * @author bling
 * @create 2022-09-23 22:53
 * 模拟五子棋游戏：创建一个11*11的棋盘，0标识无棋子，1标识黑棋，2标识白棋
 */

public class SparseArray {
    @Test
    public void test1() throws IOException {
        int[][] curArray = new int[11][11];
        curArray[2][3] = 1;
        curArray[4][6] = 1;
        curArray[0][1] = 1;
        curArray[3][5] = 1;
        display(curArray);
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.printf("a[%d] = %s",123,"trssdfs");
        int count = 0;//记录棋子总数
        for (int i = 0; i < curArray.length; i++) {
            for (int j = 0; j < curArray[i].length; j++) {
                if (curArray[i][j] != 0) {
                    count++;
                }
            }
        }
        //创建一个稀疏数组保存数据
        int[][] sparseArr = new int[++count][3];//行 列 值
        sparseArr[0][0] = curArray.length;
        sparseArr[0][1] = curArray.length;
        sparseArr[0][2] = count-1;
        count = 0;//归零
        for (int i = 0; i < curArray.length; i++) {
            for (int j = 0; j < curArray[i].length; j++) {
                if (curArray[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = curArray[i][j];
                }
            }
        }
        display(sparseArr);
        System.out.println("+++++++++++++++++++++++++++++++++++");
//        int[][] resumeArr = resume(sparseArr);
//        display(resumeArr);
        sava(sparseArr);

    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        File file = new File("E://filetest/map.data");
        int[][] arr = read(file);
        display(arr);
    }
    /**
     * 显示棋盘
     * @param arr int
     */
    public void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+ "\t");
            }
            System.out.println();
        }

    }

    public int[][] resume(int[][] arr) {
        //恢复为原棋盘
        int size = arr[0][0];
        int[][] newArr = new int[size][size];
        for (int i = 1; i < arr.length; i++) {

                int x = arr[i][0];
                int y = arr[i][1];
                newArr[x][y] = arr[i][2];

        }
        return newArr;
    }

    /**
     * 1) 在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
     * 2) 恢复原来的数组时，读取 map.data 进行恢复
     */
    public void sava(int[][] arr) throws IOException {
        File file = new File("E://filetest/map.data");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(arr);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * 读取数据
     * @param file File
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int[][] read(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object arr = objectInputStream.readObject();
        return (int[][]) arr;
    }
}
