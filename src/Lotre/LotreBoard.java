package Lotre;

import java.util.Random;

public class LotreBoard {
    private final int rows = 4;
    private final int cols = 5;
    private final int totalSafe = 18;

    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private boolean gameOver;
    private int safeFoundCount;

    public LotreBoard() {
        board = new char[rows][cols];
        revealed = new boolean[rows][cols];
        data = new int[rows][cols];
        gameOver = false;
        safeFoundCount = 0;
    }

    public void generateBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }

        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < 2) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (data[r][c] == 0) {
                data[r][c] = 1;
                bombsPlaced++;
            }
        }
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Pilihan tidak valid!");
            return true;
        }

        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            System.out.println("Kotak Aman");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            gameOver = true;
            return false;
        } else {
            board[row][col] = 'O';
            safeFoundCount++;
            System.out.println("Kotak Aman");
            if (safeFoundCount == totalSafe) {
                gameOver = true;
            }
            return true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
