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
        String casePath = "files/case1.txt";
        CellMatrix caseCellMatrix = FileUtils.readFileInitCellMatrix(casePath);
        int[][] caseMatrixCopy = caseCellMatrix.copyMatrix();
        Assert.assertArrayEquals(caseMatrixCopy, caseCellMatrix.getMatrix());
    }

    @Test
    public void getSurroundLiveCellNumTest() {
        String casePath = "files/case1.txt";
        CellMatrix caseCellMatrix = FileUtils.readFileInitCellMatrix(casePath);
        int[][] caseMatrixCopy = caseCellMatrix.copyMatrix();
        Assert.assertEquals(caseCellMatrix.getSurroundLiveCellNum(caseMatrixCopy, 0, 0), 0);
        Assert.assertEquals(caseCellMatrix.getSurroundLiveCellNum(caseMatrixCopy, 4, 3), 4);
        Assert.assertEquals(caseCellMatrix.getSurroundLiveCellNum(caseMatrixCopy, 4, 4), 3);
        Assert.assertEquals(caseCellMatrix.getSurroundLiveCellNum(caseMatrixCopy, 5, 4), 2);
    }

    @Test
    public void getSurroundLiveCellNumTest2() {
        String rulePath = "files/rule2.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        Assert.assertEquals(ruleCellMatrix.getSurroundLiveCellNum(ruleCellMatrix.copyMatrix(), 1, 1), 2);
    }


    //当前细胞为存活状态时，当周围的存活细胞低于2个时（不包含2个），该细胞变成死亡状态。（模拟生命数量稀少）
    @Test
    public void transformCellTestRule1() {
        String rulePath = "files/rule1.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        int[][] ruleMatrixCopy = ruleCellMatrix.copyMatrix();
        int newStatus = ruleCellMatrix.transformCell(ruleMatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 0);
    }

    //当前细胞为存活状态时，当周围有2个或3个存活细胞时，该细胞保持原样。
    @Test
    public void transformCellTestRule2() {
        String rulePath = "files/rule2.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        int[][] ruleMatrixCopy = ruleCellMatrix.copyMatrix();
        int newStatus = ruleCellMatrix.transformCell(ruleMatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 1);
    }

    //当前细胞为存活状态时，当周围有超过3个存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
    @Test
    public void transformCellTestRule3() {
        String rulePath = "files/rule3.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        int[][] ruleMatrixCopy = ruleCellMatrix.copyMatrix();
        int newStatus = ruleCellMatrix.transformCell(ruleMatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 0);
    }

    //当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。（模拟繁殖）
    @Test
    public void transformCellTestRule4() {
        String rulePath = "files/rule4.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        int[][] ruleMatrixCopy = ruleCellMatrix.copyMatrix();
        int newStatus = ruleCellMatrix.transformCell(ruleMatrixCopy, 1, 1);
        Assert.assertEquals(newStatus, 1);
    }

    //当前细胞为死亡状态时，当周围有非3个存活细胞时，该细胞状态不变
    @Test
    public void transformCellTestRule5() {
        String rulePath = "files/rule5.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        int[][] ruleMatrixCopy = ruleCellMatrix.copyMatrix();
        int newStatus = ruleCellMatrix.transformCell(ruleMatrixCopy, 1, 1);
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
        String rulePath = "files/rule1.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        CellMatrix transformCellMatrix = ruleCellMatrix.transform();
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

        String rulePath = "files/rule2.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        CellMatrix transformCellMatrix = ruleCellMatrix.transform();
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

        String rulePath = "files/rule3.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        CellMatrix transformCellMatrix = ruleCellMatrix.transform();
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
        String rulePath = "files/rule4.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        CellMatrix transformCellMatrix = ruleCellMatrix.transform();
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
        String rulePath = "files/rule5.txt";
        CellMatrix ruleCellMatrix = FileUtils.readFileInitCellMatrix(rulePath);
        CellMatrix transformCellMatrix = ruleCellMatrix.transform();
        Assert.assertArrayEquals(transformMatrix, transformCellMatrix.getMatrix());
    }
}
