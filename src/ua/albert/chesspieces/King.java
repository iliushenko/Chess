package ua.albert.chesspieces;

/**
 * 2. КОРОЛЬ
 *
 * Ходить уже умеет
 * 
 * Ходит на одну клетку в любом направлении, если она пустая или занята врагом.
 *
 */

import java.util.ArrayList;

import ua.albert.Field;

public class King extends ChessPieces {
    public King(ChessPiecesColor color) {
        super(color);
    }

    public void setPosition(String position) {
    }

    public ArrayList<String> getAvailableMoves(Field field, String position) {
        ArrayList<String> moveList = new ArrayList<String>();
        char letter = (char)(position.charAt(0) - 1);
        char digit = (char)(position.charAt(1) - 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String newPos = "" + (char)(letter + i) + (char)(digit + j);
                if (field.containCell(newPos) && !newPos.equals(position)) {
                    if ((field.getPiece(newPos) == null)  || (field.getPiece(newPos).getColor() != this.getColor())) {
                        moveList.add(newPos);
                    }
                } else break;
            }
        }
        return moveList;
    }

    @Override
    public String toString() {
        return "K" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }

}
