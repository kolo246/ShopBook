package com.example.shop.gui;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Configuration
public class GUIMain {
    private JButton butAddUser;
    private JPanel panelMain;
    private JButton butBuyBook;
    private JButton butAddBook;
    private JButton butClose;

    public GUIMain() {
        butAddUser.addActionListener(e -> layout("Add User", new GUIUser().getUserPanel()));
        butAddBook.addActionListener(e -> layout("Add Book", new GUIAddBook().getPanelAddBook()));
        butBuyBook.addActionListener(e -> layout("Buy Book", new GUIBuy().getPanelBuyBook()));
        butClose.addActionListener(e -> {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        });
    }

    void layout(String name, JPanel panel) {
        JFrame frame = new JFrame(name);
        frame.setBounds(100, 100, 600, 400);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setVisible(true);
    }

    @PostConstruct
    public void post() {
        layout("app", panelMain);
    }
}
