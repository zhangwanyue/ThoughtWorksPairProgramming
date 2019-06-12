package com.thoughtworks.gameOfLife.models;

import com.thoughtworks.gameOfLife.utils.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellMatrixTest {
    @BeforeClass
    public void init(){
//        System.out.println("init");
    }


    @Test
    public void getSurroundLiveCellNumTest(){
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        int[][] case1Matrix = case1CellMatrix.getMatrix();
        Assert.assertEquals(CellMatrix.getSurroundLiveCellNum(case1Matrix, 0, 0), 0);
        Assert.assertEquals(CellMatrix.getSurroundLiveCellNum(case1Matrix, 4, 3), 1);
        Assert.assertEquals(CellMatrix.getSurroundLiveCellNum(case1Matrix, 4, 4), 3);
        Assert.assertEquals(CellMatrix.getSurroundLiveCellNum(case1Matrix, 5, 4), 2);
    }


}
