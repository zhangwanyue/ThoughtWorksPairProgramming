package com.thoughtworks.gameOfLife.models;

import com.thoughtworks.gameOfLife.utils.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellMatrixTest {
    @Before
    public void init() {
    }

    @Test
    public void copyMatrixTest() {
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        int[][] case1MatrixCopy = case1CellMatrix.copyMatrix();
        Assert.assertArrayEquals(case1MatrixCopy, case1CellMatrix.getMatrix());
    }

    @Test
    public void getSurroundLiveCellNumTest() {
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        int[][] case1MatrixCopy = case1CellMatrix.copyMatrix();
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 0, 0), 0);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 4, 3), 4);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 4, 4), 3);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 5, 4), 2);
    }

    @Test
    public void getSurroundLiveCellNumTest2() {
        String rule2Path = "files/rule2.txt";
        CellMatrix rule2CellMatrix = FileUtils.readFileInitCellMatrix(rule2Path);
        Assert.assertEquals(rule2CellMatrix.getSurroundLiveCellNum(rule2CellMatrix.copyMatrix(), 1, 1), 2);
    }


    //当前细胞为存活状态时，当周围的存活细胞低于2个时（不包含2个），该细胞变成死亡状态。（模拟生命数量稀少）
    @Test
    public void transformCellTestRule1() {
        String rule1Path = "files/rule1.txt";
        CellMatrix rule1CellMatrix = FileUtils.readFileInitCellMatrix(rule1Path);
        int[][] rule1MatrixCopy = rule1CellMatrix.copyMatrix();
        int newStatus = rule1CellMatrix.transformCell(rule1MatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 0);
    }

    //当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
    @Test
    public void transformCellTestRule2() {
        String rule2Path = "files/rule2.txt";
        CellMatrix rule2CellMatrix = FileUtils.readFileInitCellMatrix(rule2Path);
        int[][] rule2MatrixCopy = rule2CellMatrix.copyMatrix();
        int newStatus = rule2CellMatrix.transformCell(rule2MatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 1);
    }

    //当前细胞为存活状态时，当周围有超过3个存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
    @Test
    public void transformCellTestRule3() {
        String rule3Path = "files/rule3.txt";
        CellMatrix rule3CellMatrix = FileUtils.readFileInitCellMatrix(rule3Path);
        int[][] rule3MatrixCopy = rule3CellMatrix.copyMatrix();
        int newStatus = rule3CellMatrix.transformCell(rule3MatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 0);
    }

    //当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）
    @Test
    public void transformCellTestRule4() {
        String rule4Path = "files/rule4.txt";
        CellMatrix rule4CellMatrix = FileUtils.readFileInitCellMatrix(rule4Path);
        int[][] rule4MatrixCopy = rule4CellMatrix.copyMatrix();
        int newStatus = rule4CellMatrix.transformCell(rule4MatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 1);
    }

    //当前细胞为死亡状态时，当周围有非3个存活细胞时，该细胞状态不变
    @Test
    public void transformCellTestRule5() {
        String rule5Path = "files/rule5.txt";
        CellMatrix rule5CellMatrix = FileUtils.readFileInitCellMatrix(rule5Path);
        int[][] rule5MatrixCopy = rule5CellMatrix.copyMatrix();
        int newStatus = rule5CellMatrix.transformCell(rule5MatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 0);
    }

    @Test
    public void transformTestRule1() {
//        int[][] originMatrix = {{0, 1, 0},
//                {0, 1, 0},
//                {0, 0, 0}};
        int[][] transformMatrix = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        String rule1Path = "files/rule1.txt";
        CellMatrix rule1CellMatrix = FileUtils.readFileInitCellMatrix(rule1Path);
        CellMatrix transformCellMatrix = rule1CellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }

    @Test
    public void transformTestRule2(){
//        int[][] originMatrix = {{0, 1, 0},
//                {0, 1, 0},
//                {0, 1, 0}};
        int[][] transformMatrix = {{0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}};

        String rule2Path = "files/rule2.txt";
        CellMatrix rule2CellMatrix = FileUtils.readFileInitCellMatrix(rule2Path);
        CellMatrix transformCellMatrix = rule2CellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }

    @Test
    public void transformTestRule3(){
//        int[][] originMatrix = {{0, 1, 0},
//                {0, 1, 1},
//                {0, 1, 1}};
        int[][] transformMatrix = {{0, 1, 1},
                {1, 0, 0},
                {0, 1, 1}};

        String rule3Path = "files/rule3.txt";
        CellMatrix rule3CellMatrix = FileUtils.readFileInitCellMatrix(rule3Path);
        CellMatrix transformCellMatrix = rule3CellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }

    @Test
    public void transformTestRule4(){
//        int[][] originMatrix = {{0, 1, 0},
//                {0, 0, 1},
//                {0, 1, 0}};
        int[][] transformMatrix = {{0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}};
        String rule4Path = "files/rule4.txt";
        CellMatrix rule4CellMatrix = FileUtils.readFileInitCellMatrix(rule4Path);
        CellMatrix transformCellMatrix = rule4CellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }

    @Test
    public void transformTestRule5(){
//        int[][] originMatrix = {{0, 0, 0},
//                {0, 0, 0},
//                {0, 1, 0}};
        int[][] transformMatrix = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        String rule5Path = "files/rule5.txt";
        CellMatrix rule5CellMatrix = FileUtils.readFileInitCellMatrix(rule5Path);
        CellMatrix transformCellMatrix = rule5CellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }
}
