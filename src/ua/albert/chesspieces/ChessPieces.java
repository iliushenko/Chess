package ua.albert.chesspieces;

import java.util.ArrayList;

import ua.albert.Field;


public abstract class ChessPieces {
    private ChessPiecesColor color;

    public ChessPieces(ChessPiecesColor color) {
        super();
        this.color = color;
    }

    public void setColor(ChessPiecesColor color) {
        this.color = color;
    }

    public ChessPiecesColor getColor() {
        return color;
    }

    public abstract void setPosition(String position);

    public abstract ArrayList<String> getAvailableMoves(Field field, String position);

}
