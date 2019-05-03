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

    public Координата[] moveToPosition(Координата[] newКоордината, Координата[] oldКоордината, char symbol) {
        for (int i = 0; i < newКоордината.length; i++) {
            Координата координата = newКоордината[i];
            if (координата.getX() == 0 || координата.getX() == this.height - 1) {
                return oldКоордината;
            }
            if (координата.getY() == 0 || координата.getY() == this.width - 1) {
                return oldКоордината;
            }
        }
        for (int i = 0; i < oldКоордината.length; i++) {
            Координата координата = oldКоордината[i];
            this.field[координата.getX()][координата.getY()] = ' ';
        }
        for (int i = 0; i < newКоордината.length; i++) {
            Координата координата = newКоордината[i];
            this.field[координата.getX()][координата.getY()] = symbol;
        }
        return newКоордината;
    }

    public boolean находитьсяЛиВнизуПоляФигура(Координата[] координаты) {
        for (int i = 0; i < координаты.length; i++) {
            Координата координата = координаты[i];
            if (координата.getX() == this.height - 1) {
                return true;
            }
        }
        return false;
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
