package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;
import com.mashibing.tank.constant.Group;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 3;
    private boolean moving =true;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    private TankFrame tf =null;
    private boolean living = true ;
    private Group group;
    private Random random = new Random();
    public Tank() {
    }

    public Tank(int x, int y, Dir dir ,TankFrame tf ,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf =tf ;
        this.group = group;
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
        if(random.nextInt(10)>8 &&  this.group == Group.BAD){
            this.fire();
        }
    }

    public void paint(Graphics g) {
        if(!living){
            tf.tanks.remove(this);
        }
        if(this.x> TankFrame.GATE_WIDTH || this.y>TankFrame.GAME_HEIGHT){
            tf.tanks.remove(this);
        }
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

         tf.bulletList.add( new Bullet(x+Tank.WIDTH/2-Bullet.WIDTH/2,y+Tank.HEIGHT/2-Bullet.HEIGHT/2,dir ,tf,this.group));
    }

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
