package com.thoughtworks.gameOfLife.models;

import com.thoughtworks.gameOfLife.utils.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellMatrixTest {
    @Before
    public void init(){
//        System.out.println("init");
    }

    @Test
    public void copyMatrixTest(){
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        int[][] case1MatrixCopy = case1CellMatrix.copyMatrix();
        Assert.assertArrayEquals(case1MatrixCopy, case1CellMatrix.getMatrix());
    }

    @Test
    public void getSurroundLiveCellNumTest(){
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        int[][] case1MatrixCopy = case1CellMatrix.copyMatrix();
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 0, 0), 0);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 4, 3), 4);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 4, 4), 3);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1MatrixCopy, 5, 4), 2);
    }

    @Test
    public void transformCellTest(){
        String rule1Path = "files/rule1.txt";
        CellMatrix rule1CellMatrix = FileUtils.readFileInitCellMatrix(rule1Path);
        int[][] rule1MatrixCopy = rule1CellMatrix.copyMatrix();
        int newStatus = rule1CellMatrix.transformCell(rule1MatrixCopy, 1,1);
        Assert.assertEquals(newStatus, 0);
    }


}
