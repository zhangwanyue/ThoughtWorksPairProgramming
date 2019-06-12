package com.thoughtworks.gameOfLife.ui;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeInterface extends JFrame {
    private JPanel controlPanel;
    private JTextField[][] gameField;
    private JButton startGameButton;
    private JButton chooseFileButton;
    private JButton pauseButton;

    public GameOfLifeInterface() throws HeadlessException {
        startGameButton = new JButton("开始游戏");
        startGameButton.setPreferredSize(new Dimension(200, 30));
        chooseFileButton = new JButton("选择文件");
        chooseFileButton.setPreferredSize(new Dimension(200, 30));
        pauseButton = new JButton("暂停游戏");
        pauseButton.setPreferredSize(new Dimension(200, 30));

        gameField = new JTextField[10][10];
        controlPanel = new JPanel();
        controlPanel.add(startGameButton);
        controlPanel.add(chooseFileButton);
        controlPanel.add(pauseButton);
        controlPanel.setPreferredSize(new Dimension(800, 30));


        this.add(controlPanel);
        this.setSize(800, 600);
    }
    // main class
    public static void main(String[] args)
    {
       new GameOfLifeInterface().show();
    }
}
