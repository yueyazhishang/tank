package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    private boolean moving ;
    private TankFrame tf =null;
    public Tank() {
    }

    public Tank(int x, int y, Dir dir ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf =tf ;
    }
    private void move(){
        if(!moving){
            return;
        }
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

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        System.out.println("paint" + dir.name());
        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
               g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            default:
                break;
        }

        move();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {

         tf.bulletList.add( new Bullet(x,y,dir ,tf));
    }
}
