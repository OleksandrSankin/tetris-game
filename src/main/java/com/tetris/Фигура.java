package com.tetris;


public class Фигура {
    private Координата[] координата;
    private Field field;

    public Фигура(Field field) {

        координата = new Координата[3];
        координата[0] = new Координата(0, 3);
        координата[1] = new Координата(0, 4);
        координата[2] = new Координата(0, 5);

        this.field = field;
        moveDown();
    }

    public Координата[] getКоордината() {
        return координата;
    }

    public void moveDown() {
        Координата[] новаяКоордината = new Координата[3];
        новаяКоордината[0] = new Координата(this.координата[0].getX()+1, this.координата[0].getY());
        новаяКоордината[1] = new Координата(this.координата[1].getX()+1, this.координата[1].getY());
        новаяКоордината[2] = new Координата(this.координата[2].getX()+1, this.координата[2].getY());
        this.координата = field.moveToPosition(новаяКоордината, this.координата, 'Z');
    }
}
