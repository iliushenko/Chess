package ua.albert.chesspieces;

/**
 * 4. СЛОН
 * 
 * Сделан на основе королевы
 */

import java.util.ArrayList;

import ua.albert.Field;

public class Bishop extends ChessPieces {

    public Bishop(ChessPiecesColor color) {
        super(color);
    }

    public void setPosition(String position) {
    }

    public ArrayList<String> getAvailableMoves(Field field, String position) {
        ArrayList<String> moveList = new ArrayList<String>();
        char letter = (char)(position.charAt(0));
        char digit = (char)(position.charAt(1));
        int i1 = 1;
        int i2 = 1;
        for (int i = 0; i < 4; i++) {
            i1 = (i1 * -1);
            i2 = (i2 * i1);
            for (int j = 1; j < 8; j++) {
                String newPos =
                    "" + (char)(letter + j * i1) + (char)(digit + j * i2);
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
        return "B" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }
}
