package com.thoughtworks.gameOfLife.utils;

import com.thoughtworks.gameOfLife.models.CellMatrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileUtilsTest {
    @Before
    public static void init(){

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
        String case1Path = "/home/vera/IdeaProjects/ThoughtWorksPairProgramming/files/case1.txt";
        CellMatrix case1CellMatrix = FileUtils.readFileInitCellMatrix(case1Path);
        // 正确读取高度
        Assert.assertEquals(10, case1CellMatrix.getHeight());
        // 正确读取宽度
        Assert.assertEquals(10, case1CellMatrix.getWidth());
        // 正确读取matrix
        Assert.assertArrayEquals(case1CellMatrix.getMatrix(), case1Matrix);
    }


}
