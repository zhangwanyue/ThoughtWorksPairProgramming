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
        int[][] copy_matrix = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                copy_matrix[i][j] = matrix[i][j];
            }
        }
        return copy_matrix;
    }

    /**
     * 获取坐标为(x,y)的细胞周围存活的细胞的数量
     * @param x
     * @param y
     * @return
     */
    public int getSurroundLiveCellNum(int[][] matrixCopy, int x, int y){
        int num = 0;
        //左上
        num = countLiveCell(matrixCopy, num, x-1, y-1);
        //上方
        num = countLiveCell(matrixCopy, num, x-1, y);
        //右上
        num = countLiveCell(matrixCopy, num, x-1, y+1);
        //左边
        num = countLiveCell(matrixCopy, num, x, y-1);
        //右边
        num = countLiveCell(matrixCopy, num, x, y+1);
        //左下
        num = countLiveCell(matrixCopy, num, x+1, y-1);
        //下方
        num = countLiveCell(matrixCopy, num , x+1, y);
        //右下
        num = countLiveCell(matrixCopy, num, x+1, y+1);
        return num;
    }

    /**
     * 判断该位置是否超过边界，如果没有超过边界，则统计该位置的存活细胞
     * @param num
     * @param x
     * @param y
     * @return
     */
    public int countLiveCell(int[][] matrixCopy, int num, int x, int y){
        if(x>=0 && x<this.height && y>=0 && y<this.width){
            return (num + matrixCopy[x][y]);
        }
        return num;
    }

    /**
     * 下一个生命周期的matrix存活状态
     * @return
     */
    public CellMatrix transform(){
        int[][] copy_matrix = copyMatrix();
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                matrix[i][j] = transformCell(copy_matrix, i, j);
            }
        }
        return this;
    }

    /**
     * 某个细胞下一个生命周期的存活状态
     * @param
     * @return
     */
    public int transformCell(int[][] matrixCopy, int x, int y){
        int num = getSurroundLiveCellNum(matrixCopy, x, y);
        int cellStatus = matrixCopy[x][y];

        //rule1：当前细胞为存活状态时，当周围的存活细胞低于2个时（不包含2个），该细胞变成死亡状态。（模拟生命数量稀少）
        if(num<2 && cellStatus==1){
            cellStatus = 0;
            return cellStatus;
        }

        //rule2：当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
        if((num==2 || num==3) && cellStatus==1){
            cellStatus = cellStatus;
            return cellStatus;
        }

        //rule3：当前细胞为存活状态时，当周围有超过3个存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
        if(num>3 && cellStatus==1){
            cellStatus = 0;
            return cellStatus;
        }

        //rule4：当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）
        if(num==3 && cellStatus==0){
            cellStatus = 1;
            return cellStatus;
        }

        //rule5：当前细胞为死亡状态时，当周围有非3个存活细胞时，该细胞状态不变
        return cellStatus;
    }

}