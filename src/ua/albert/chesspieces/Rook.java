package ua.albert.chesspieces;

/**
 * 5. ЛАДЬЯ
 *
 * Сделана на основе королевы
 */

import java.util.ArrayList;

import ua.albert.Field;

public class Rook extends ChessPieces {

    public Rook(ChessPiecesColor color) {
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
            int i3 = i1 * ((i == 0 || i == 3) ? 0 : 1);
            int i4 = i2 * ((i == 1 || i == 2) ? 0 : 1);
            for (int j = 1; j < 8; j++) {
                String newPos =
                    "" + (char)(letter + j * i3) + (char)(digit + j * i4);
                if (field.containCell(newPos)) {
                    if (field.isEmptyCell(newPos) ||
                        field.getPiece(newPos).getColor() != this.getColor()) {
                        moveList.add(newPos);
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
        return "R" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }
}
