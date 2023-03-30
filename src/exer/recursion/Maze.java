package exer.recursion;

import java.util.concurrent.ForkJoinPool;

/**迷宫问题
 * 1.创建一个二维数组表示迷宫，1代表墙，2代表可以走的路，3代表此路不通
 * 2.按照下-右-上-左的策略
 * @author bling
 * @create 2022-09-26 15:23
 */
public class Maze {
    int[][] maze;
    public void getMaze() {
        maze = new int[8][7];
        //四周为墙
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        for (int i = 1; i < maze[0].length-1; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        //设置障碍
        maze[2][1] = 1;
        maze[2][2] = 1;
        maze[2][4] = 1;
        maze[3][4] = 1;
        maze[4][4] = 1;
        maze[4][3] = 1;
        maze[4][2] = 1;
        maze[5][2] = 1;
        maze[6][2] = 1;

    }
    /**
     * 按照下-右-上-左的策略
     * i,j表示起始位置
     */

    public boolean setWay(int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        }
        if (maze[i][j] == 0) {
            maze[i][j] = 2;//假设该点能继续走

            if (setWay(i+1,j)) {
                //向下走
                return true;
            } else if (setWay(i,j+1)) {
                //向右走
                return true;
            } else if (setWay(i-1,j)) {
                //向上走
                return true;
            } else if (setWay(i,j-1)) {
                //向左走
                return true;
            } else {
                //该点走不通，进行回溯
                maze[i][j] = 3;
                return false;
            }
        }
        return false;
    }
    public void show() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+ "  ");
            }
            System.out.println();
        }
    }
}
