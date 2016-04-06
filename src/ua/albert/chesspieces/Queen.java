package ua.albert.chesspieces;

/**
 * 3. КОРОЛЕВА
 * 
 * Королева умеет ходить...
 * и бить...
 * 
 * Да это блядь шедевр алгоритмов!!!
 * 
 */

import java.util.ArrayList;

import ua.albert.Field;

public class Queen extends ChessPieces {


    public Queen(ChessPiecesColor color) {
        super(color);
    }

    public void setPosition(String position) {
    }

    public ArrayList<String> getAvailableMoves(Field field, String position) {
        ArrayList<String> moveList = new ArrayList<String>();
        char letter = position.charAt(0);
        char digit = position.charAt(1);
        int i1 = 1;
        int i2 = 1;
        for (int i = 0; i < 8; i++) {
            i1 = (i1 * -1);
            i2 = (i2 * i1);
            int i3 = i1 * ((i == 4 || i == 7) ? 0 : 1);
            int i4 = i2 * ((i == 5 || i == 6) ? 0 : 1);
            for (int j = 1; j < 8; j++) {
                String newPos =
                    "" + (char)(letter + j * i3) + (char)(digit + j * i4);
                if (field.containCell(newPos)) {
                    if (field.isEmptyCell(newPos) ||
                        field.getPiece(newPos).getColor() != this.getColor()) {
                        moveList.add(newPos);
                        //System.out.println(newPos);
                        if (!field.isEmptyCell(newPos) &&
                            field.getPiece(newPos).getColor() !=
                            this.getColor()) {
                            break;
                        }
                    } else
                        break;
                } else
                    break;
            }
        }

        return moveList;
    }

    @Override
    public String toString() {
        return "Q" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }
}
