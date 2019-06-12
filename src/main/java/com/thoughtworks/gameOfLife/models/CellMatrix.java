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
    public int getSurroundLiveCellNum(int[][] matrix, int x, int y){

        int num = 0;
        //左上
        num = countLiveCell(num, x-1, y-1);
        //上方
        num = countLiveCell(num, x-1, y);
        //右上
        num = countLiveCell(num, x-1, y+1);
        //左边
        num = countLiveCell(num, x, y-1);
        //右边
        num = countLiveCell(num, x, y+1);
        //左下
        num = countLiveCell(num, x+1, y-1);
        //下方
        num = countLiveCell(num , x+1, y);
        //右下
        num = countLiveCell(num, x+1, y+1);
        return num;
    }

    /**
     * 判断该位置是否超过边界，如果没有超过边界，则统计该位置的存活细胞
     * @param num
     * @param x
     * @param y
     * @return
     */
    public int countLiveCell(int num, int x, int y){
        if(x>0 && x<this.height && y>0 && y<this.width){
            return (num + matrix[x][y]);
        }
        return num;
    }

    /**
     * 下一个生命周期的matrix存活状态
     * @return
     */
    public CellMatrix transform(){
        return null;
    }


}