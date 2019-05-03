package com.tetris;

public abstract class Фигура {
    protected Координата[] координата;

    public abstract void перевернутьВлево();

    public abstract void перевернутьВправо();

    public abstract void перевернуть180();

    public abstract void двигатьсяВниз();

    public abstract void двигатьсяВправо();

    public Координата [] взятьКоординаты () {
        return this.координата;
    }

}
