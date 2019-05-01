package com.tetris;

import java.util.Random;

public class Фигура {
    private Координаты координаты;
    private Field field;
    private Random random;

    public Фигура(Координаты координаты, Field field) {
        this.координаты = координаты;
        this.field = field;
        this.random = new Random();
        moveRight();
    }

    public Координаты getКоординаты() {
        return координаты;
    }

    public void moveRandom() {
        int nextInt = random.nextInt(4);
        if (nextInt == 0) moveRight();
        if (nextInt == 1) moveLeft();
        if (nextInt == 2) moveDown();
        if (nextInt == 3) moveUp();
    }

    private void moveRight() {
        Координаты newКоординаты = new Координаты(координаты.getX() + 1, координаты.getY());
        координаты = field.moveToPosition(newКоординаты, координаты, 'Z');
    }

    private void moveLeft() {
        Координаты newКоординаты = new Координаты(координаты.getX() - 1, координаты.getY());
        координаты = field.moveToPosition(newКоординаты, координаты, 'Z');
    }

    private void moveUp() {
        Координаты newКоординаты = new Координаты(координаты.getX(), координаты.getY() - 1);
        координаты = field.moveToPosition(newКоординаты, координаты, 'Z');
    }

    private void moveDown() {
        Координаты newКоординаты = new Координаты(координаты.getX(), координаты.getY() + 1);
        координаты = field.moveToPosition(newКоординаты, координаты, 'Z');
    }
}
