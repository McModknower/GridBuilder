package io.shapez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class SettingsManager {

    public static final String path = (System.getenv("APPDATA") + "\\.jshapez\\");

    public static JFrame settingsFrame;
    public static JPanel mainPanel;

    public static JCheckBox chk1;
    public static JCheckBox chk2;

    public static boolean allowSound;
    public static boolean drawChunkEdges;

    public static void save() throws IOException {
        System.out.println("Saving settings in unsafe environment");
        FileOutputStream fs = new FileOutputStream(path);
        DataOutputStream ds = new DataOutputStream(fs);

        ds.writeBoolean(allowSound); // 8 bytes (64-bit jvm)
        ds.writeBoolean(drawChunkEdges);

        ds.close();
    }
    public static void load(boolean internal) throws IOException {

        System.out.println("Loading settings in unsafe environment");


        FileInputStream fs = new FileInputStream(path);

        DataInputStream ds = new DataInputStream(fs);

        while(ds.available() > 0) {
            allowSound = ds.readBoolean();
            drawChunkEdges = ds.readBoolean();
        }
        if(internal){
        chk1.setSelected(allowSound);
        chk2.setSelected(drawChunkEdges);
        }

        ds.close();
    }


    public static void initSettingsWnd(){
        settingsFrame = new JFrame("GridBuilder - Settings");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));

        chk1 = new JCheckBox();
        chk1.setSelected(allowSound);
        chk1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                allowSound = chk1.isSelected();
                System.out.println(e.getSource());
                try {
                    System.out.println("Saving settings...");
                    save(); // load settings
                } catch (IOException ee) {
                    System.err.println("Error saving settings");
                    ee.printStackTrace();
                }
            }
        });
        chk1.setText("Enable Sound");
        chk1.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        chk1.setFocusPainted(false); // this can be considered a hack such as ActiveControl = null


        chk2 = new JCheckBox();
        chk2.setSelected(drawChunkEdges);
        chk2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                drawChunkEdges = chk2.isSelected();
                try {
                    System.out.println("Saving settings...");
                    save(); // load settings
                } catch (IOException ee) {
                    System.err.println("Error saving settings");
                    ee.printStackTrace();
                }
            }
        });
        chk2.setText("Draw Chunk Edges");
        chk2.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        chk2.setFocusPainted(false); // this can be considered a hack such as ActiveControl = null


        mainPanel.add(chk1, BorderLayout.WEST);
        mainPanel.add(chk2, BorderLayout.WEST);


        settingsFrame.add(mainPanel);
        settingsFrame.setResizable(false);

        settingsFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    System.out.println("Saving settings...");
                    save();
                } catch (IOException e) {
                    System.err.println("Error saving settings");
                    e.printStackTrace();
                }
            }
        });
        settingsFrame.setSize(300, 100);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Free frame on close ...
                                                                         // style 1 (exit on close) also terminates process...

        settingsFrame.setVisible(true);

        try {
            load(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}