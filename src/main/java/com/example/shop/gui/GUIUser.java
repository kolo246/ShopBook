package com.example.shop.gui;

import com.example.shop.config.ServiceContext;
import com.example.shop.entity.Users;
import com.example.shop.service.users.UsersService;

import javax.swing.*;
import java.awt.*;

public class GUIUser {
    private JTextField textName;
    private JTextField textAge;
    private JTextField textSurname;
    private JTextField textCity;
    private JTextField textEmail;
    private JTextField textPhone;
    private JButton butAddUser;
    private JButton closeButton;
    private JPanel userPanel;
    private UsersService usersService;

    public GUIUser() {
        butAddUser.addActionListener(e -> {
            Users users = new Users.Builder()
                    .name(textName.getText())
                    .surname(textSurname.getText())
                    .email(textEmail.getText())
                    .city(textCity.getText())
                    .phoneNumber(textPhone.getText())
                    .age(Integer.parseInt(textAge.getText()))
                    .build();

            usersService = (UsersService) ServiceContext.getBeanService(UsersService.class);
            usersService.save(users);
        });
        closeButton.addActionListener(e -> {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        });
    }

    public JPanel getUserPanel() {
        return userPanel;
    }
}
