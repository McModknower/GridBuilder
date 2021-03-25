package io.shapez.core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resources {

    // Logo/UI
    public static ImageIcon logo;
    public static BufferedImage settingsImage;
    public static BufferedImage saveImage;
    public static BufferedImage loadImage;
    public static BufferedImage clearImage;
    public static BufferedImage ui_beltImage;
    public static BufferedImage ui_minerImage;
    public static BufferedImage ui_trashImage;
    public static BufferedImage ui_rotatorImage;

    // Textures
    public static BufferedImage belt;
    public static BufferedImage miner;
    public static BufferedImage trash;
    public static BufferedImage rotator;
    public static Image missingTexture;
    public static BufferedImage vignette;


    // Sounds
    public static File beltPlaceSound; // WIP
    public static File generic_placeTileSound;
    public static File generic_destroyTileSound;
    public static File uiClickSound;
    public static File uiSuccessSound;
    public static File uiDenySound;


    // Make sure to run with these jvm options:
//    -Dsun.java2d.d3d=true -Dsun.java2d.translaccel=true -Dsun.java2d.ddforcevram=true -Dsun.java2d.accthreshold=1

    // This will provide a insane performance boost, but on low-end systems it might overwhelm the hardware
    static {
        try {
            logo = new ImageIcon("resources/ui/logo.png");
            settingsImage = ImageIO.read(new File("resources/ui/settings.png"));
            saveImage = ImageIO.read(new File("resources/ui/save.png"));
            loadImage = ImageIO.read(new File("resources/ui/open.png"));
            clearImage = ImageIO.read(new File("resources/ui/remove.png"));
            ui_beltImage = ImageIO.read(new File("resources/ui/belt.png"));
            ui_minerImage = ImageIO.read(new File("resources/ui/miner.png"));
            ui_trashImage = ImageIO.read(new File("resources/ui/trash.png"));
            ui_rotatorImage = ImageIO.read(new File("resources/ui/rotator.png"));

            beltPlaceSound = new File("resources/sound/place_belt.wav");
            generic_placeTileSound = new File("resources/sound/place_building.wav");
            generic_destroyTileSound = new File("resources/sound/destroy_building.wav");
            uiClickSound = new File("resources/sound/uiclick.wav");
            uiSuccessSound = new File("resources/sound/uisuccess.wav");
            uiDenySound = new File("resources/sound/uierror.wav");

            vignette = ImageIO.read(new File("resources/vignette.lossless.png"));
            missingTexture = ImageIO.read(new File("resources/missing.png"));
            belt = ImageIO.read(new File("resources/tiles/belt.png"));
            miner = ImageIO.read(new File("resources/tiles/miner.png"));
            trash = ImageIO.read(new File("resources/tiles/trash.png"));
            rotator = ImageIO.read(new File("resources/tiles/rotator.png"));
        } catch (IOException e) {
            System.out.println("Resource(s) missing");
            // e.printStackTrace();
        }
    }
}
