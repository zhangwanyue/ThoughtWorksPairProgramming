package com.thoughtworks.gameOfLife.ui;

import com.thoughtworks.gameOfLife.models.CellMatrix;
import com.thoughtworks.gameOfLife.utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GameOfLifeInterface extends JFrame {
    //游戏状态
    private volatile boolean running = false;
    //默认动画间隔（默认时长为200）
    private static int DEFAULT_DURATION = 200;
    private int duration = DEFAULT_DURATION;
    //控件
    private JPanel controlPanel;
    private JPanel cellPanel;
    private JButton startGameButton;
    private JButton chooseFileButton;
    private JButton pauseButton;
    private JTextField durationTextField;
    //cellMatrix
    private volatile CellMatrix cellMatrix;

    public GameOfLifeInterface() throws HeadlessException {
        startGameButton = new JButton("开始游戏");
        startGameButton.setPreferredSize(new Dimension(200, 30));
        startGameButton.addActionListener(new StartGameActionListener());
        chooseFileButton = new JButton("选择文件");
        chooseFileButton.setPreferredSize(new Dimension(200, 30));
        chooseFileButton.addActionListener(new ChooseFileActionListener());
        pauseButton = new JButton("暂停游戏");
        pauseButton.setPreferredSize(new Dimension(200, 30));
        pauseButton.addActionListener(new pauseGameActionListener());
        durationTextField = new JTextField();
        durationTextField.setPreferredSize(new Dimension(200, 30));

        controlPanel = new JPanel();
        controlPanel.add(startGameButton);
        controlPanel.add(chooseFileButton);
        controlPanel.add(pauseButton);
        controlPanel.add(durationTextField);

        getContentPane().add("North", controlPanel);
        this.setSize(1000, 800);
    }


    public static void main(String[] args)
    {
       new GameOfLifeInterface().setVisible(true);
    }


    /**
     * 使用cellMatrix创建cellPanel布局
     */
    private void setCellPanel() {
        int rows = cellMatrix.getHeight();
        int cols = cellMatrix.getWidth();
        cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(rows, cols));

        int[][] matrix = cellMatrix.getMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton jButton = new JButton();
                if(matrix[i][j]==1){
                    jButton.setBackground(Color.BLACK);
                }else{
                    jButton.setBackground(Color.WHITE);
                }
                cellPanel.add(jButton);
            }
        }
        this.add(cellPanel);
        cellPanel.updateUI();
    }

    /**
     * 显示cellPanel的更新
     */
    private void updateCellPanel(){
        cellMatrix.transform();
        setCellPanel();
    }

    /**
     * 选择文件
     */
    private class ChooseFileActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 暂定游戏/游戏未开始
            running = false;
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setDialogTitle("请选择初始配置文件");
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                //读取文件，初始化cellMatrix
                String filepath = fileChooser.getSelectedFile().getPath();
                cellMatrix = FileUtils.readFileInitCellMatrix(filepath);
                //初始化cellPanel
                setCellPanel();
            }
        }
    }

    /**
     * 开始游戏
     */
    private class StartGameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!running) {
                //获取时间
                try {
                    duration = Integer.parseInt(durationTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                }
                new Thread(new GameControlTask()).start();
                running = true;
            }
        }
    }


    /**
     * 暂停游戏
     */
    private class pauseGameActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(running){
                running = false;
            }
        }
    }

    /**
     * 运行游戏
     */
    private class GameControlTask implements Runnable {
        @Override
        public void run() {
            while (running) {
                cellMatrix.transform();
                updateCellPanel();
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
