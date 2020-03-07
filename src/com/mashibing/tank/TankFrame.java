package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame()  {
        //设置宽、高
        this.setSize(800,600);
        //设置大小不可变
        this.setResizable(false);
        this.setTitle("tank war");
        //设置可见
        this.setVisible(true);
        //添加window监听器
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 窗口打开的时候调用
     * @param g
     */
    @Override
    public void paint(Graphics g){
//        System.out.println("paint");
        g.fillRect(200,200,50,50);
    }
}
