package com.mashibing.tank;

import com.mashibing.tank.constant.Dir;
import com.mashibing.tank.constant.Group;

public class T {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        for(int i =0 ;i<5 ;i++){
            Tank tank = new Tank(50 + i * 50, 200, Dir.DOWN, tf, Group.BAD);
//            tank.fire();
            tf.tanks.add(tank);
        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
