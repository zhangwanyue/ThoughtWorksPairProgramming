package com.thoughtworks.gameOfLife.ui;

import com.thoughtworks.gameOfLife.models.CellMatrix;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeInterface extends JFrame {
    private JPanel controlPanel;
    private JPanel cellPanel;
    private JButton startGameButton;
    private JButton chooseFileButton;
    private JButton pauseButton;
    private CellMatrix cellMatrix;

    public GameOfLifeInterface() throws HeadlessException {
        startGameButton = new JButton("开始游戏");
        startGameButton.setPreferredSize(new Dimension(200, 30));
        chooseFileButton = new JButton("选择文件");
        chooseFileButton.setPreferredSize(new Dimension(200, 30));
        pauseButton = new JButton("暂停游戏");
        pauseButton.setPreferredSize(new Dimension(200, 30));


        controlPanel = new JPanel();
        controlPanel.add(startGameButton);
        controlPanel.add(chooseFileButton);
        controlPanel.add(pauseButton);
        controlPanel.setPreferredSize(new Dimension(800, 30));

        cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(10, 10));
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){

            }
        }
        this.add("Center", cellPanel);

        this.add(controlPanel);
        this.setSize(800, 600);
    }
    // main class
    public static void main(String[] args)
    {
       new GameOfLifeInterface().show();

    }


    /**
     * 创建显示的gridlayout布局
     */
    private void initGridLayout() {
        int rows = cellMatrix.getHeight();
        int cols = cellMatrix.getWidth();
        cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(rows, cols));

        int[][] matrix = cellMatrix.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1){

//                    cellPanel.add(text);
                }

            }
        }
        add("Center", cellPanel);
    }
}
