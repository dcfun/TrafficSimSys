package dto;

import ui.FrameMain;

/**
 * Created by uu789 on 2015/10/25.
 */
public class MapArray {

    static int width = FrameMain.WIDTH;
    static int height = FrameMain.HEIGHT;
    private int[][] Map = new int[width][height];

    private int Cross1_x = width / 3;
    private int Cross2_x = width / 3 * 2;
    private int Cross1_y = height / 2;
    private int Cross2_y = Cross1_y;

    public int[][] init() {
        // 数组初始化
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Map[i][j] = 0;
            }
        }
        /* 初始化 道路部分 置为 1
           绿化带部分置为 2
        */
        //一条横向
        for (int i = 0; i < width; i++) {
            for (int j = Cross1_y - 25; j < Cross1_y + 25; j++) {
                Map[i][j] = 1;
            }
            for (int j = Cross1_y - 5; j < Cross1_y + 5; j++) {
                Map[i][j] = 2;
            }
        }
        //两条竖向
        for (int j = 0; j < height; j++) {
            for (int i = Cross1_x - 25; i < Cross1_x + 25; i++) {
                Map[i][j] = 1;
            }
            for (int i = Cross2_x - 25; i < Cross2_x + 25; i++) {
                Map[i][j] = 1;
            }

            for (int i = Cross1_x - 5; i < Cross1_x + 5; i++) {
                Map[i][j] = 2;
            }
            for (int i = Cross2_x - 5; i < Cross2_x + 5; i++) {
                Map[i][j] = 2;
            }
        }

        // 修改 被覆盖的十字路口
        for (int i = Cross1_x - 25; i < Cross1_x + 25; i++) {
            for (int j = Cross1_y - 25; j < Cross1_y + 25; j++) {
                Map[i][j] = 1;
            }
        }
        for (int i = Cross2_x - 25; i < Cross2_x + 25; i++) {
            for (int j = Cross2_y - 25; j < Cross2_y + 25; j++) {
                Map[i][j] = 1;
            }
        }
        return Map;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        MapArray.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        MapArray.height = height;
    }

    public int[][] getMap() {
        return Map;
    }

    public void setMap(int[][] map) {
        Map = map;
    }

    public int getCross1_x() {
        return Cross1_x;
    }

    public void setCross1_x(int cross1_x) {
        Cross1_x = cross1_x;
    }

    public int getCross2_x() {
        return Cross2_x;
    }

    public void setCross2_x(int cross2_x) {
        Cross2_x = cross2_x;
    }

    public int getCross1_y() {
        return Cross1_y;
    }

    public void setCross1_y(int cross1_y) {
        Cross1_y = cross1_y;
    }

    public int getCross2_y() {
        return Cross2_y;
    }

    public void setCross2_y(int cross2_y) {
        Cross2_y = cross2_y;
    }
}
