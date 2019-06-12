package com.thoughtworks.gameOfLife.models;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */
public class CellMatrix {
    private int height;
    private int width;
    private int[][] matrix;

    public CellMatrix(int height, int width, int[][] matrix) {
        this.height = height;
        this.width = width;
        this.matrix = matrix;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * 拷贝一个完全相同的matrix出来
     * @return
     */
    public int[][] copyMatrix(){
        return null;
    }

    /**
     * 获取坐标为(x,y)的细胞周围存活的细胞的数量
     * @param x
     * @param y
     * @return
     */
    public int getSurroundLiveCellNum(int x, int y){
        return 0;
    }

    /**
     * 下一个生命周期的matrix存活状态
     * @return
     */
    public CellMatrix transform(){
        return null;
    }


}