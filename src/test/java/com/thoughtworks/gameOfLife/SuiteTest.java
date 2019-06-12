package com.thoughtworks.gameOfLife;

import com.thoughtworks.gameOfLife.models.CellMatrixTest;
import com.thoughtworks.gameOfLife.utils.FileUtilsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value=Suite.class)
@Suite.SuiteClasses(value={CellMatrixTest.class, FileUtilsTest.class})
public class SuiteTest {
}
