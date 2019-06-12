package com.thoughtworks.gameOfLife.utils;

import com.thoughtworks.gameOfLife.models.CellMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

public class FileUtilsTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init(){

    }

    @Test
    public void whenReadFileSuccess(){
        int[][] case1Matrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        String case1Path = "files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        // 正确读取高度
        Assert.assertEquals(10, case1CellMatrix.getHeight());
        // 正确读取宽度
        Assert.assertEquals(10, case1CellMatrix.getWidth());
        // 正确读取matrix
        Assert.assertArrayEquals(case1CellMatrix.getMatrix(), case1Matrix);
    }

    @Test
    public void whenReadFileNotLegalNumThenException(){
        String caseExceptionPath = "files/caseException.txt";
        expectedException.expect(RuntimeException.class);
        CellMatrix caseExceptionCellMatrix = FileUtils.readFileInitCellMatrix(caseExceptionPath);
    }

}
