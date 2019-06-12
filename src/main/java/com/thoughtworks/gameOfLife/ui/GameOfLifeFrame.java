//package com.thoughtworks.gameOfLife.ui;
//
//import com.thoughtworks.gameOfLife.models.CellMatrix;
//import com.thoughtworks.gameOfLife.utils.FileUtils;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;
//
//public class GameOfLifeFrame extends JFrame {
//
//    //游戏状态
//    private boolean isOn = false;
//    private boolean fileInit = false;
//    private boolean stop = false;
//    //默认动画间隔
//    private static final int DEFAULT_DURATION = 200;
//    //动画间隔
//    private int duration = DEFAULT_DURATION;
//
//    private JButton openFileButton = new JButton("选择文件");
//    private JButton startGameButton = new JButton("开始游戏");
//    private JButton pauseGameButton = new JButton("暂停游戏");
//    private JLabel durationLabel = new JLabel("动画间隔设置(ms为单位)");
//    private JTextField durationTextField = new JTextField();
//
//    private JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
//    private JPanel gridPanel = new JPanel();
//
//    private CellMatrix cellMatrix;
//
//    private JTextField[][] textMatrix;
//
//    public GameOfLifeFrame() {
//        setTitle("生命游戏");
//
//        openFileButton.addActionListener(new OpenFileActioner());
//        startGameButton.addActionListener(new StartGameActioner());
//        pauseGameButton.addActionListener(new pauseGameActoner());
//
//        buttonPanel.add(openFileButton);
//        buttonPanel.add(startGameButton);
//        buttonPanel.add(pauseGameButton);
//
//        buttonPanel.add(durationLabel);
//        buttonPanel.add(durationTextField);
//
//        buttonPanel.setBackground(Color.WHITE);
//
//        getContentPane().add("North", buttonPanel);
//
//        this.setSize(1000, 1200);
//        this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//
//    private void initGridLayout() {
//        int rows = this.cellMatrix.getHeight();
//        int cols = this.cellMatrix.getWidth();
//        gridPanel = new JPanel();
//        gridPanel.setLayout(new GridLayout(rows, cols));
//        textMatrix = new JTextField[rows][cols];
//        for (int y=0; y<rows; y++) {
//            for (int x=0; x<cols; x++) {
//                JTextField text = new JTextField();
//                textMatrix[y][x] = text;
//                gridPanel.add(text);
//            }
//        }
//        add("Center", gridPanel);
//    }
//
//    //显示girdFinal
//    private void showMatrix() {
//
//        int[][] matrix = cellMatrix.getMatrix();
//        for (int y = 0; y < matrix.length; y++) {
//            for (int x = 0; x < matrix[0].length; x++) {
//                if (matrix[y][x] == 1) {
//                    textMatrix[y][x].setBackground(Color.BLACK);
//                } else {
//                    textMatrix[y][x].setBackground(Color.WHITE);
//                }
//            }
//        }
//    }
//
//    private class OpenFileActioner implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JFileChooser fileChooser = new JFileChooser(".");
//            fileChooser.setDialogTitle("请选择初始配置文件");
//            int returnVal = fileChooser.showOpenDialog(null);
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//
//                //游戏状态为未开始
//                isOn = false;
//                startGameButton.setText("开始游戏");
//                fileInit = true;
//                String filepath = fileChooser.getSelectedFile().getPath();
//                cellMatrix = FileUtils.readFileInitCellMatrix(filepath);
//                initGridLayout();
//                showMatrix();
//                gridPanel.updateUI();
//            }
//        }
//
//
//    }
//    private class StartGameActioner implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (!isOn && fileInit == true) {
//                //获取时间
//                try {
//                    duration = Integer.parseInt(durationTextField.getText().trim());
//                } catch (NumberFormatException e1) {
//                    duration = DEFAULT_DURATION;
//                }
//
//                new Thread(new GameControlTask()).start();
//                isOn = true;
//            } else if(!isOn && fileInit == false){
//                //todo 随机生成数据
//                cellMatrix = FileUtils.randomInitMatrix();
//                initGridLayout();
//                showMatrix();
//                gridPanel.updateUI();
//                try {
//                    duration = Integer.parseInt(durationTextField.getText().trim());
//                } catch (NumberFormatException e1) {
//                    duration = DEFAULT_DURATION;
//                }
//
//                new Thread(new GameControlTask()).start();
//                isOn = true;
//            }
//        }
//    }
//
//    private class pauseGameActoner implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            if(isOn){
//                stop = true;
//                isOn = false;
//            }
//        }
//
//
//    }
//    private class GameControlTask implements Runnable {
//
//        @Override
//        public void run() {
//
//            while (isOn) {
//                cellMatrix.transform();
//                showMatrix();
//
//                try {
//                    TimeUnit.MILLISECONDS.sleep(duration);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame();
//    }
//}
//
