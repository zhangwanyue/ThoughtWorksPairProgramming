package com.thoughtworks.gameOfLife.models;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.*;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 */
public class CellMatrix {
    private int height;
    private int width;
    private int[][] matrix;

    public CellMatrix(int height, int width, int[][] matrix) {
        this.height = height;
        this.width = width;
        this.matrix = matrix;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}