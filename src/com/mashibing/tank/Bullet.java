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
    private TankFrame tf ;
    private boolean live = true;
    public Bullet(int x, int y, Dir dir ,TankFrame tf ) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf ;
    }
    public void paint(Graphics g){
        if(!live){
            tf.bulletList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGTH);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
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
        if(x<0 || y<0 || (x>TankFrame.GATE_WIDTH || y>TankFrame.GAME_HEIGHT)){
            live = false;
        }
    }
}
