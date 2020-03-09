package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    //速度
    private static final int SPEED = 6;
    private int x ,y ;
    private Dir dir ;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private TankFrame tf ;
    private boolean living = true;
    public Bullet(int x, int y, Dir dir ,TankFrame tf ) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf ;
    }
    public void paint(Graphics g){
        if(!living){
            tf.bulletList.remove(this);
        }
        //如果子弹不活着就不需要画了
//        if(!living){
//            return;
//        }
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
            living = false;
        }
    }

    /**
     * 检测坦克和子弹是否相交
     * @param tank
     */
    public void collideWith(Tank tank) {
        //子弹的区域
        Rectangle rect1 = new Rectangle(this.x ,this.y ,WIDTH,HEIGHT);
        //子弹的区域
        Rectangle rect2 = new Rectangle(tank.getX() ,tank.getY() ,Tank.WIDTH,Tank.HEIGHT);
        if(rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
