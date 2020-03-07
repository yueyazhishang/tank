package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    //速度
    private static final int SPEED = 3;
    private int x ,y ;
    private Dir dir ;
    private static final  int WIDTH =10 ,HEIGTH=10;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGTH);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }
}
