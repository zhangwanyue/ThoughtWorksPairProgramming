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
        int[][] case1Matrix = case1CellMatrix.getMatrix();
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1Matrix, 0, 0), 0);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1Matrix, 4, 3), 4);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1Matrix, 4, 4), 3);
        Assert.assertEquals(case1CellMatrix.getSurroundLiveCellNum(case1Matrix, 5, 4), 2);
    }


}
