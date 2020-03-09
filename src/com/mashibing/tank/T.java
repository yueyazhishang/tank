package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;

public class T {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        for(int i =00 ;i<5 ;i++){
            tf.tanks.add(new Tank(50 +i*40 ,200 , Dir.DOWN,tf));
        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
