package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x =200 ,y=200;
    public TankFrame()  {
        //设置宽、高
        this.setSize(800,600);
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
     * @param g
     */
    @Override
    public void paint(Graphics g){
        System.out.println("paint");
        g.fillRect(x,y,50,50);
        y+=10;
        x+=10;
    }

    class MyKeyListener extends KeyAdapter{


        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressd...");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released...");
        }
    }
}
