package com.tetris;

public class Field {
    private final int width;
    private final int height;
    private char[][] field;

    public Field(int width, int height) {
        this.field = createField(width, height);
        this.height = height;
        this.width = width;
    }

    private char[][] createField(int width, int height) {
        char[][] battleField = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                battleField[i][j] = ' ';
            }
        }
        return battleField;
    }

    public Координаты moveToPosition(Координаты newКоординаты, Координаты oldКоординаты, char symbol) {
        if (newКоординаты.getX() >= 0 && newКоординаты.getX() < this.width
                && newКоординаты.getY() >= 0 && newКоординаты.getY() < this.height) {
            field[oldКоординаты.getY()][oldКоординаты.getX()] = ' ';
            field[newКоординаты.getY()][newКоординаты.getX()] = symbol;
            return newКоординаты;
        } else {
            return oldКоординаты;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= this.width + 1; i++) {
            str = str + "-";
        }
        str += "\n";

        for (int i = 0; i < this.height; i++) {

            for (int j = 0; j < this.width; j++) {
                if (j == 0)
                    str += "|";
                str = str + field[i][j];
            }
            str += "|\n";
        }
        for (int i = 0; i <= this.width + 1; i++) {
            str = str + "-";
        }
        str += "\n";
        return str;
    }
}
