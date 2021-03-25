package io.shapez.ui;

import io.shapez.core.Tile;
import io.shapez.game.Board;
import io.shapez.util.UIUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static io.shapez.core.Resources.*;
import static io.shapez.managers.providers.MiscProvider.*;

public class BottomPanel extends JPanel {
    private final Board board;
    public static JButton beltButton = new JButton();
    public static JButton minerButton = new JButton();
    public static JButton trashButton = new JButton();
    public static JButton rotatorButton = new JButton();

    public BottomPanel(Board board) throws IOException {
        this.board = board;
        setOpaque(false);
        JPanel innerPanel = new JPanel();
        innerPanel.setOpaque(false);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));


        beltButton.addActionListener(e ->
                selectItem(Tile.Belt));
        beltButton.setFocusable(false);
        beltButton.setIcon(new ImageIcon(ui_beltImage.getScaledInstance(defDimensionBtn.width, defDimensionBtn.height, Image.SCALE_SMOOTH)));
        beltButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        beltButton.setPreferredSize(defDimensionBtn);
        beltButton.setMaximumSize(defDimensionBtn);
        innerPanel.add(beltButton, BorderLayout.SOUTH);

        minerButton.addActionListener(e ->
                selectItem(Tile.Miner)
        );
        minerButton.setFocusable(false);
        minerButton.setIcon(new ImageIcon(ui_minerImage.getScaledInstance(defDimensionBtn.width, defDimensionBtn.height, Image.SCALE_SMOOTH)));
        minerButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        minerButton.setPreferredSize(defDimensionBtn);
        minerButton.setMaximumSize(defDimensionBtn);
        innerPanel.add(minerButton, BorderLayout.SOUTH);

        trashButton.addActionListener(e -> selectItem(Tile.Trash));
        trashButton.setFocusable(false);
        trashButton.setIcon(new ImageIcon(ui_trashImage.getScaledInstance(defDimensionBtn.width, defDimensionBtn.height, Image.SCALE_SMOOTH)));
        trashButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        trashButton.setPreferredSize(defDimensionBtn);
        trashButton.setMaximumSize(defDimensionBtn);
        innerPanel.add(trashButton, BorderLayout.SOUTH);

        rotatorButton.addActionListener(e -> selectItem(Tile.Rotator));
        rotatorButton.setFocusable(false);
        rotatorButton.setIcon(new ImageIcon(ui_rotatorImage.getScaledInstance(defDimensionBtn.width, defDimensionBtn.height, Image.SCALE_SMOOTH)));
        rotatorButton.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        rotatorButton.setPreferredSize(defDimensionBtn);
        rotatorButton.setMaximumSize(defDimensionBtn);
        innerPanel.add(rotatorButton, BorderLayout.SOUTH);

        this.add(innerPanel);
    }



    public void selectItem(Tile item) {
        if (Board.item == item) {
            Board.item = Tile.None;
            board.hasItemSelected = false;
            System.out.println("Already selected. Now selected: " + board.item.toString());
            UIUtil.updateButtonAppearance();
            return;
        }
        Board.item = item;
        board.hasItemSelected = Board.item != Tile.None;
        System.out.println("Selected: " + item.toString());
        UIUtil.updateButtonAppearance();
    }
}