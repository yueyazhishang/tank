package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;
import sun.awt.image.ImageAccessException;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200, Dir.DOWN ,this);
    Bullet b = new Bullet(300,300,Dir.DOWN);
    static final int GATE_WIDTH =800 ,GAME_HEIGHT=500;
    public TankFrame() {
        //设置宽、高
        this.setSize(GATE_WIDTH, GAME_HEIGHT);
        //设置大小不可变
        this.setResizable(false);
        this.setTitle("tank war");
        //设置可见
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());
        //添加window监听器
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 每次触发前会先清空画板
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        b.paint(g);
    }

    /**
     * update 在paint之前调用
     * 解决 画面闪烁 ，在内存中构建新的图片，等内存中处理完成后再一次性在评估上画
     *
     */
    Image offScreenImage = null ;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null ){
            offScreenImage = this.createImage(GATE_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GATE_WIDTH,GAME_HEIGHT);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }
    class MyKeyListener extends KeyAdapter {
        // 组合标记，用于确定坦克（左下、右下等）
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressd...");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                    //按住control时 发射子弹
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bL && !bR && !bU && !bD){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
            }
            if (bL) {
                myTank.setDir(Dir.LEFT);
            }
            if (bR) {
                myTank.setDir(Dir.RIGHT);
            }
            if (bU) {
                myTank.setDir(Dir.UP);
            }
            if (bD) {
                myTank.setDir(Dir.DOWN);
            }

        }
    }


}
