package Lotre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();
        lotre.generateBoard();

        System.out.println("Welcome to E-Lottery Gosok");

        while (!lotre.isGameOver()) {
            lotre.displayBoard();
            System.out.print("\nMasukkan tebakan anda (baris dan kolom) : ");
            int row = input.nextInt();
            int col = input.nextInt();

            boolean safe = lotre.guess(row, col);

            if (!safe) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                lotre.displayBoard();
                break;
            } else if (lotre.isGameOver()) {
                System.out.println("Selamat anda menang");
                lotre.displayBoard();
                break;
            }
        }

        input.close();
    }
}
