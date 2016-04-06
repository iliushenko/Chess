package ua.albert.chesspieces;

/**
 * 1. ПЕШКА
 * Здесь описанны правила хода фигуры
 *
 * При первом ходе фигура может перескочить одну клетку, если она пустая
 * Каждый последующий ход можно сделать только на одну позицию вперед
 *
 * Не описаны ходы нападения на других
 *
 * Надо продумать ещё момент смены фигуры по достижению конца доски
 *
 * Хуйня полная... Надо переписать циклом...
 *
 */

import java.util.ArrayList;

import java.util.Arrays;

import ua.albert.Field;

public class Pawn extends ChessPieces {


    public Pawn(ChessPiecesColor color) {
        super(color);
    }

    public void setPosition(String position) {
    }

    public ArrayList<String> getAvailableMoves(Field field, String position) {

        ArrayList<String> moveList = new ArrayList<String>();

        int naprav = 1;
        if (super.getColor() == ChessPiecesColor.BLACK) {
            naprav = -1;
        }

        // Возможные ходы
        if (field.containCell("" + position.charAt(0) +
                              (char)(position.charAt(1) + naprav)) &&
            !field.isEmptyCell("" + position.charAt(0) +
                               (char)(position.charAt(1) + naprav))) {
            moveList.add("" + position.charAt(0) +
                         (char)(position.charAt(1) + naprav));
        }

        if (((position.charAt(1)) == '2' || (position.charAt(1)) == '7') &&
            !field.isEmptyCell("" + position.charAt(0) +
                               (char)(position.charAt(1) + naprav * 2)) &&
            !field.isEmptyCell("" + position.charAt(0) +
                               (char)(position.charAt(1) + naprav))) {
            moveList.add("" + position.charAt(0) +
                         (char)(position.charAt(1) + naprav * 2));
        }

        //Возможные ходы для удара (Ходит и бьет по разному)

        return moveList;
    }

    @Override
    public String toString() {
        return "P" + (super.getColor() == ChessPiecesColor.WHITE ? "W" : "B");
    }

}
