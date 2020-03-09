package com.mashibing.tank;


import sun.net.www.content.image.gif;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceMgr {
    public static BufferedImage tankU ,tankL,tankD,tankR,bulletD,bulletU,bulletL,bulletR;
    static {
        try {
            tankU =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankL =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankD =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankR =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            bulletD =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
