package ua.albert;

import java.io.BufferedReader;
import java.io.Reader;

import java.util.ArrayList;
import java.util.Scanner;

import ua.albert.chesspieces.ChessPiecesColor;

public class StartGame {

    StartGame() {
        boolean gameOver = false;
        Field field = new Field();
        field.printField();

        String start, end;
        Scanner scan = new Scanner(System.in);


        while (!gameOver) {
            System.out.println("Введите данные: ");
            start = scan.next();
            if (start.equalsIgnoreCase("exit")) {
                gameOver = true;
                break;
            }
            end = scan.next();
            if (end.equalsIgnoreCase("exit")) {
                gameOver = true;
                break;
            }
            if (field.movePieces(start, end) != 0) {
                // Будет смена игрока и проверка на ШАХ, МАТ, ПАТ
            }
        }
    }

    public static void main(String[] args) {
        StartGame g = new StartGame();

		
		
//        int i1 = 1;
//        int i2 = 1;
//        for (int i = 0; i < 8; i++) {
//            i1 = (i1 * -1);
//            i2 = (i2 * i1);
//            int i3 = i1 * ((i == 4 || i == 7) ? 0 : 1);
//            int i4 = i2 * ((i == 5 || i == 6) ? 0 : 1);
//            System.out.println("i3=" + i3+" i4="+i4);
//        }

    }
}
