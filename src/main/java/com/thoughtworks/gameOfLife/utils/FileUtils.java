package com.thoughtworks.gameOfLife.utils;

import com.thoughtworks.gameOfLife.models.CellMatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    /**
     * 从文件中读取并初始化matrix
     * @param filePath
     * @return
     */
    public static CellMatrix readFileInitCellMatrix(String filePath){
        //File file = new File(fileName);
        BufferedReader reader = null;
        CellMatrix cellMatrix = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String tempString = null;

            //读取第一行
            tempString = reader.readLine();
            String [] size = tempString.split(" ");
            int height = Integer.parseInt(size[0]);
            int width = Integer.parseInt(size[1]);
            int [][] matrix = new int[height][width];

            // 读取剩余的行，直到读入null为文件结束
            for (int j=0; j<height; j++) {
                String[] row = reader.readLine().split(" ");
                if(row.length != width){
                    throw(new RuntimeException());
                }
                for(int i=0; i<width; i++){
                    if(!(row[i].equals("0") || row[i].equals("1"))){
                        throw new RuntimeException();
                    }
                    matrix[j][i] = Integer.parseInt(row[i]);
                }
            }

            cellMatrix = new CellMatrix(height, width, matrix);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return cellMatrix;
    }
}


