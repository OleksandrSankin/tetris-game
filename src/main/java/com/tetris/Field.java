package com.tetris;

import java.util.*;

public class Field {
    private final int width;
    private final int height;
    private char[][] field;

    private List<Координата> занятыеКоординаты = new ArrayList<>();

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
            if (координата.getX() == 0 || координата.getX() == this.height) {
                return oldКоордината;
            }
            if (координата.getY() == 0 || координата.getY() == this.width) {
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

    public boolean можетЛиФигураДвигатьсяВниз(Координата[] координаты) {
        for (int i = 0; i < координаты.length; i++) {
            Координата координата = координаты[i];
            if (координата.getX() == this.height - 1) {
                return false;
            }
        }
        for (int i = 0; i < координаты.length; i++) {
            for (int j = 0; j < занятыеКоординаты.size(); j++) {
                Координата занятаяКоордината = занятыеКоординаты.get(j);
                Координата желаемаяКоордината = координаты[i];

                if (занятаяКоордината.getY() == желаемаяКоордината.getY() &&
                        занятаяКоордината.getX() == желаемаяКоордината.getX() + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void удалитьСтрокиЕслиВозможно() {
        Map<Integer, Integer> map = посчитатьКоличествоЗанятыхКоординат();
        for (Map.Entry<Integer, Integer> счетчик : map.entrySet()) {
            if (счетчик.getValue() == width - 1) {
                Iterator<Координата> iterator = занятыеКоординаты.iterator();
                while (iterator.hasNext()) {
                    Координата координата = iterator.next();
                    if (координата.getX() == счетчик.getKey()) {
                        this.field[координата.getX()][координата.getY()] = ' ';
                        iterator.remove();
                    } else if (координата.getX() < счетчик.getKey()) {
                        this.field[координата.getX()][координата.getY()] = ' ';
                        координата.setX(координата.getX() + 1);
                        this.field[координата.getX()][координата.getY()] = 'Z';
                    }
                }
            }
        }
    }

    private Map<Integer, Integer> посчитатьКоличествоЗанятыхКоординат() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < занятыеКоординаты.size(); i++) {
            Координата координата = занятыеКоординаты.get(i);
            if (map.containsKey(координата.getX())) {
                int count = map.get(координата.getX()) + 1;
                map.put(координата.getX(), count);
            } else {
                map.put(координата.getX(), 1);
            }
        }
        return map;
    }

    public void зафиксироватьФигуру(Координата[] координаты) {
        for (int i = 0; i < координаты.length; i++) {
            занятыеКоординаты.add(координаты[i]);
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
