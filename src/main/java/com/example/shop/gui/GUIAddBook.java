package com.example.shop.gui;

import com.example.shop.config.ServiceContext;
import com.example.shop.entity.Books;
import com.example.shop.service.books.BooksService;

import javax.swing.*;
import java.awt.*;

public class GUIAddBook {
    private JPanel panelAddBook;
    private JTextField textTitle;
    private JTextField textQuantity;
    private JTextField textAuthor;
    private JTextField textISBN;
    private JButton saveButton;
    private JButton closeButton;
    private JTextField textPrice;
    private BooksService booksService;

    public GUIAddBook() {
        saveButton.addActionListener(e -> {
            Books book = new Books();
            book.setTitle(textTitle.getText());
            book.setAuthor(textAuthor.getText());
            book.setIsbn(Integer.parseInt(textISBN.getText()));
            book.setQuantity(Integer.parseInt(textQuantity.getText()));
            book.setPrice(Float.parseFloat(textPrice.getText()));

            booksService = (BooksService) ServiceContext.getBeanService(BooksService.class);
            booksService.save(book);
        });
        closeButton.addActionListener(e -> {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        });
    }

    public JPanel getPanelAddBook() {
        return panelAddBook;
    }
}
