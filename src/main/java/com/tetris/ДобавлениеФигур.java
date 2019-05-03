package com.tetris;

import java.util.Random;

public class ДобавлениеФигур {
    private Random random = new Random(System.currentTimeMillis());
    public Фигура создатьФигуру (Field field) {
        Фигура фигура ;

        int новаяФигура = random.nextInt(5);
        if (новаяФигура == 0) {
            фигура = new Линия(field);
        } else if (новаяФигура == 1) {
            фигура = new ФигураГ(field);
        } else if (новаяФигура == 2) {
            фигура  = new ФигураКвадрат(field);
        } else if (новаяФигура == 3) {
            фигура  = new ФигураСтупенька(field);
        } else if (новаяФигура == 4) {
            фигура = new ФигураТ(field);
        } else {
            throw new RuntimeException("");
        }
        return фигура;
    }
}
