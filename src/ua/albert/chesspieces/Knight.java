package ua.albert.chesspieces;

import java.util.ArrayList;

import ua.albert.Field;

public class Knight extends ChessPieces {

    public Knight(ChessPiecesColor color) {
        super(color);
    }

    public void setPosition(String position) {
    }

    public ArrayList<String> getAvailableMoves(Field field, String position) {
        return null;
    }

    @Override
    public String toString() {
        return "k" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }
}
