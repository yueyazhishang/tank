package com.mashibing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        //设置宽、高
        f.setSize(800,600);
        //设置大小不可变
        f.setResizable(false);
        f.setTitle("tank war");
        //设置可见
        f.setVisible(true);
        //添加window监听器
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
