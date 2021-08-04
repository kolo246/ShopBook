package com.example.shop.gui;

import com.example.shop.config.ServiceContext;
import com.example.shop.entity.Books;
import com.example.shop.entity.Orders;
import com.example.shop.entity.Users;
import com.example.shop.service.books.BooksService;
import com.example.shop.service.orders.OrdersService;
import com.example.shop.service.users.UsersService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GUIBuy {
    private JTextField textISBN;
    private JPanel panelBuyBook;
    private JTextField textSurname;
    private JTextField textPhone;
    private JButton buyButton;
    private JButton closeButton;
    private JButton searchBookButton;
    private JTextArea textArea1;
    private JButton addToCartButton;
    private JButton butDeleteItem;
    private UsersService usersService;
    private BooksService booksService;
    private OrdersService ordersService;
    private Users user;
    private Books book;
    private Orders order;
    private final List<Books> cart = new ArrayList<>();

    public GUIBuy() {
        initServices();
        searchBookButton.addActionListener(e -> {
            Optional<Users> foundUser = usersService.findBySurnameAndPhone(textSurname.getText(), textPhone.getText());
            Optional<Books> foundBook = booksService.findByIsbn(Integer.parseInt(textISBN.getText()));
            if (!foundUser.isPresent()) {
                JOptionPane.showMessageDialog(new JFrame("Not Found User"), "Not Found User.\nAdd User to database.");
            } else {
                user = foundUser.get();
            }
            if (!foundBook.isPresent()) {
                JOptionPane.showMessageDialog(new JFrame("Not Found Book"), "Not Found Book or Quantity of Book is less than 1.");
            } else {
                book = foundBook.get();
            }
            String infoUser = "Surname: " + user.getSurname() + " Phone Number: " + user.getPhone();
            String infoBook = "ISBN:" + book.getIsbn() + " Title: " + book.getTitle();
            JOptionPane.showMessageDialog(new JFrame("Info"), infoBook + "\n" + infoUser);
        });
        addToCartButton.addActionListener(e -> {
            clearTextArea();
            if (book.getQuantity() < 1) {
                JOptionPane.showMessageDialog(new JFrame("Info"), "Quantity of book " + book.getIsbn() + " is less than 1");
            } else {
                cart.add(book);
                double totalPrice = cart.stream().mapToDouble(Books::getPrice).sum();
                textArea1.append("\nTotal price: " + totalPrice);
                textArea1.append("\nTotal number of items: " + cart.size());
                book.setQuantity(book.getQuantity() - 1);
                booksService.save(book);
            }
        });
        buyButton.addActionListener(e -> {
            clearTextArea();
            if (book.getQuantity() < 1) {
                JOptionPane.showMessageDialog(new JFrame("Info"), "Quantity of book " + book.getIsbn() + " is less than 1");
            } else if (cart.isEmpty()) {
                cart.add(book);
                book.setQuantity(book.getQuantity() - 1);
                booksService.save(book);
            } else {
                for (Books b : cart) {
                    b.setQuantity(b.getQuantity() - 1);
                    booksService.save(b);
                }
            }
            Optional<Orders> ordersOptional = ordersService.findOrders(user.getId());
            order = ordersOptional.orElseGet(() -> new Orders(user, cart.size()));
            order.setItems(order.getItems() + cart.size());
            ordersService.save(order);
            showCart(cart);
            cart.clear();
        });
        butDeleteItem.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame("Info"), "No items to delete.");

            } else {
                book = cart.get(cart.size() - 1);
                book.setQuantity(book.getQuantity() + 1);
                booksService.save(book);
                cart.remove(cart.size() - 1);
                JOptionPane.showMessageDialog(new JFrame("Info"), "Deleted: " + book.getIsbn() + "Left items: " + cart.size());
            }
        });
        closeButton.addActionListener(e -> {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        });
    }

    public JPanel getPanelBuyBook() {
        return panelBuyBook;
    }

    public void showCart(List<Books> cart) {
        textArea1.append("\nTotal cart: ");
        for (Books b : cart) {
            textArea1.append("\nTitle: " + b.getTitle());
            textArea1.append("\nAuthor: " + b.getAuthor());
            textArea1.append("\nISBN: " + b.getIsbn());
            textArea1.append("\n");
        }
        double totalPrice = cart.stream().mapToDouble(Books::getPrice).sum();
        totalPrice -= countDiscount(totalPrice);
        textArea1.append("\nTotal number of items: " + cart.size());
        textArea1.append("\nTotal price: " + totalPrice);
    }

    public double countDiscount(double totalPrice) {
        double discount = 0.0;
        int countOfItems = order.getItems();
        if (countOfItems % 10 == 0) {
            discount = totalPrice * 0.1;
            JOptionPane.showMessageDialog(new JFrame("Info"), "User: " + user.getSurname() +
                    " get discount: 10 %\n Price before discount: " + totalPrice +
                    "\n Price after discount: " + (totalPrice - discount));
        } else {
            JOptionPane.showMessageDialog(new JFrame("Info"), "Add " + extraValueToGetDiscount(countOfItems)
                    + " extra items to get DISCOUNT !!");
        }
        return discount;
    }

    public int extraValueToGetDiscount(int countOfItems) {
        int temp = countOfItems;
        while (countOfItems % 10 != 0) {
            countOfItems++;
        }
        return countOfItems - temp;
    }

    public void clearTextArea() {
        textArea1.selectAll();
        textArea1.replaceSelection("");
    }

    public void initServices() {
        booksService = (BooksService) ServiceContext.getBeanService(BooksService.class);
        usersService = (UsersService) ServiceContext.getBeanService(UsersService.class);
        ordersService = (OrdersService) ServiceContext.getBeanService(OrdersService.class);
    }
}
