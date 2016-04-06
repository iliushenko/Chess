package ua.albert;


import java.util.ArrayList;
import java.util.TreeMap;


import ua.albert.chesspieces.Bishop;
import ua.albert.chesspieces.ChessPieces;
import ua.albert.chesspieces.ChessPiecesColor;
import ua.albert.chesspieces.King;
import ua.albert.chesspieces.Knight;
import ua.albert.chesspieces.Pawn;
import ua.albert.chesspieces.Queen;
import ua.albert.chesspieces.Rook;


public class Field {

    private static TreeMap<String, ChessPieces> field =
        new TreeMap<String, ChessPieces>();


    public Field() {
        createNewField();
        loadNewField();
    }

    public ChessPieces getPiece(String position) {
        if (field.containsKey(position)) {
            return field.get(position);
        }
        return null;
    }

    public boolean containCell(String cell) {
        return field.containsKey(cell);
    }

    private void createNewField() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field.put("" + (char)('a' + i) + (int)(j + 1), null);
            }
        }
    }

    private void loadNewField() {
        //Load Pawn
        for (int i = 0; i < 8; i++) {
            field.put("" + (char)('a' + i) + 2,
                      new Pawn(ChessPiecesColor.WHITE));
            field.put("" + (char)('a' + i) + 7,
                      new Pawn(ChessPiecesColor.BLACK));
        }

        //Load Rook
        field.put("a1", new Rook(ChessPiecesColor.WHITE));
        field.put("h1", new Rook(ChessPiecesColor.WHITE));
        field.put("a8", new Rook(ChessPiecesColor.BLACK));
        field.put("h8", new Rook(ChessPiecesColor.BLACK));

        //Load Knight
        field.put("b1", new Knight(ChessPiecesColor.WHITE));
        field.put("g1", new Knight(ChessPiecesColor.WHITE));
        field.put("b8", new Knight(ChessPiecesColor.BLACK));
        field.put("g8", new Knight(ChessPiecesColor.BLACK));

        //Load Bishop
        field.put("c1", new Bishop(ChessPiecesColor.WHITE));
        field.put("f1", new Bishop(ChessPiecesColor.WHITE));
        field.put("c8", new Bishop(ChessPiecesColor.BLACK));
        field.put("f8", new Bishop(ChessPiecesColor.BLACK));

        //Load Queen
        field.put("e1", new Queen(ChessPiecesColor.WHITE));
        field.put("e8", new Queen(ChessPiecesColor.BLACK));

        //Load King
        field.put("d1", new King(ChessPiecesColor.WHITE));
        field.put("d8", new King(ChessPiecesColor.BLACK));
        
        // Тестовые фигуры

        field.put("c5", new Rook(ChessPiecesColor.WHITE));
    }

    public void printField() {
        for (int i = 8; i >= 1; i--) {
            System.out.print(i);
            for (int j = 0; j < 8; j++) {
                String s =
                    (field.get("" + (char)('a' + j) + i) == null ? "  " :
                     field.get("" + (char)('a' + j) + i).toString());
                System.out.print("   " + s);
            }
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < 8; i++) {
            System.out.print("    " + (char)('a' + i));
        }
        System.out.println();
    }

    public int movePieces(String start, String end) {

        if (!field.containsKey(start)) {
            System.out.println("Несуществующая начальная позиция!!!");
            return 100;
        }

        if (!field.containsKey(end) || !field.containsKey(start)) {
            System.out.println("Несуществующая конечная позиция!!!");
            return 101;
        }

        ArrayList<String> listMove =
            field.get(start).getAvailableMoves(this, start);

        if (listMove.contains(end)) {
            System.out.println("Ход сделан");
            field.put(end, field.get(start));
            field.put(start, null);
            this.printField();
        } else {
            System.out.println("Невозможно пойти в выбранную позицию");
            for (String s : listMove) {
                System.out.println(s);
            }
            return 200;
        }

        return 0;
    }

    public boolean isEmptyCell(String position) {
        return field.get(position) == null;
    }

}
