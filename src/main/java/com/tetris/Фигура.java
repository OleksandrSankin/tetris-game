package com.tetris;

public abstract class Фигура {
    protected Координата[] координата;

    public abstract void перевернуть ();

    public abstract void двигатьсяВниз();

    public abstract void двигатьсяВправо();

    public abstract void двигатьсяВлево();

    public Координата[] взятьКоординаты() {
        return this.координата;
    }

}
