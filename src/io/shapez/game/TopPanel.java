package io.shapez;

import io.shapez.core.Resources;
import io.shapez.managers.SerializeManager;
import io.shapez.managers.SettingsManager;
import io.shapez.managers.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TopPanel extends JPanel {
    JButton settingsButton = new JButton();
    JButton saveButton = new JButton();
    JButton loadButton = new JButton();

    public static JLabel selectedILabel_Name = new JLabel();
    public static JLabel selectedILabel_Description = new JLabel();
    public static JLabel selectedILabel_Hotkey = new JLabel();

    void showSettings() {
        SoundManager.playSound(Resources.uiClickSound);
        SettingsManager.initSettingsWnd();
    }

    public TopPanel() throws IOException {
        setOpaque(false);
        setLayout(new BorderLayout());
        JPanel L_innerPanel = new JPanel();
        JPanel L_morePanel = new JPanel();
        L_innerPanel.setOpaque(false);
        L_innerPanel.setLayout(new BoxLayout(L_innerPanel, BoxLayout.Y_AXIS));

        L_morePanel.setOpaque(false);
        L_morePanel.setLayout(new BoxLayout(L_morePanel, BoxLayout.Y_AXIS));

        Dimension d = new Dimension(70, 70);
        Dimension _d = new Dimension(50, 50);

        settingsButton.addActionListener(e ->
                showSettings()
        );
        settingsButton.setFocusable(false);
        settingsButton.setIcon(new ImageIcon(Resources.settingsImage.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH)));
        settingsButton.setPreferredSize(d);
        settingsButton.setMaximumSize(d);

        saveButton.addActionListener((ActionEvent e) -> SerializeManager.saveAll(Board.usedChunks));
        saveButton.setFocusable(false);
        saveButton.setIcon(new ImageIcon(Resources.missingTexture.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH)));
        saveButton.setPreferredSize(d);
        saveButton.setMaximumSize(d);

        loadButton.addActionListener((ActionEvent e) -> SerializeManager.loadAll());
        loadButton.setFocusable(false);
        loadButton.setIcon(new ImageIcon(Resources.missingTexture.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH)));
        loadButton.setPreferredSize(d);
        loadButton.setMaximumSize(d);

        selectedILabel_Name.setFocusable(false);
        selectedILabel_Name.setText("");
        selectedILabel_Name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        selectedILabel_Description.setFocusable(false);
        selectedILabel_Description.setText("");
        selectedILabel_Description.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        selectedILabel_Hotkey.setFocusable(false);
        selectedILabel_Hotkey.setText("");
        selectedILabel_Hotkey.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

        L_innerPanel.add(selectedILabel_Name, BorderLayout.WEST);
        L_innerPanel.add(selectedILabel_Description, BorderLayout.WEST);
        L_innerPanel.add(selectedILabel_Hotkey, BorderLayout.SOUTH);

        L_morePanel.add(saveButton, BorderLayout.NORTH);
        L_morePanel.add(loadButton, BorderLayout.NORTH);

        add(settingsButton, BorderLayout.EAST);


        add(L_innerPanel);
        add(L_morePanel);

    }
}
