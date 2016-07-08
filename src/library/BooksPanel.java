/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import library.dao.BookDao;
import library.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import library.dao.LibrarianDao;
import library.model.TransactionHistory;
import library.model.Users;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class BooksPanel extends javax.swing.JFrame {

    /**
     * Creates new form Research
     */
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    String fileName = null;
    int s = 0;
    long bookId = 0;
    private Users borrower;
    private Book currentBook;

    private TransactionHistory transactionHistory;

    public BooksPanel() {
        initComponents();

        //candIdTxt.setEditable(false);
        conn = sqlconnect.ConnectDb();
        allBooks();
        allBorrowedBooks();
        allLibrarians();

        btnCheckIn.setEnabled(false);
        btnCheckOut.setEnabled(false);
        saveBtn.setEnabled(false);
        btnUpdateBook.setEnabled(false);
        btnDeleteBook.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        copyrightLabel = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        javax.swing.JPanel bookPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblIsbn = new javax.swing.JLabel();
        bookIsbn = new javax.swing.JTextField();
        bookTitle = new javax.swing.JTextField();
        bookAuthor = new javax.swing.JTextField();
        lblbookStatus = new javax.swing.JLabel();
        bookStatus = new javax.swing.JLabel();
        btnUpdateBook = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        libariansComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        javax.swing.JButton searchBtn = new javax.swing.JButton();
        borrowBookTitle = new javax.swing.JTextField();
        lblLibrarian = new javax.swing.JLabel();
        bookIsbnTF = new javax.swing.JTextField();
        btnCheckIn = new javax.swing.JButton();
        currentBookStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        menuBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        borrowedBooksTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Knowlegica LMS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        copyrightLabel.setBackground(new java.awt.Color(255, 255, 255));
        copyrightLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        copyrightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/copyrightsymbol.png"))); // NOI18N
        copyrightLabel.setText("2016 Knowlegica. All Rights Reserved.");
        copyrightLabel.setToolTipText("");
        getContentPane().add(copyrightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, 240, 20));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("KNOWLEGICA LMS: Manage Books");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        bookPanel.setBackground(new java.awt.Color(204, 204, 204));
        bookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Add Book");
        bookPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        lblCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCategory.setText("Category :");
        bookPanel.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        categoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accounting", "Information Technology", "Business", "Fiction", "Medicine", "Biography", "Do It Yourself", " " }));
        bookPanel.add(categoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 260, 30));

        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/Save-icon.png"))); // NOI18N
        saveBtn.setText("ADD BOOK");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        bookPanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 140, 30));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle.setText("Book Title :");
        bookPanel.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblAuthor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAuthor.setText("Author :");
        lblAuthor.setToolTipText("");
        bookPanel.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblIsbn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIsbn.setText("ISBN :");
        bookPanel.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        bookPanel.add(bookIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 260, 30));
        bookPanel.add(bookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 260, -1));
        bookPanel.add(bookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 260, -1));

        lblbookStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblbookStatus.setText("Book Status: ");
        bookPanel.add(lblbookStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        bookStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bookStatus.setForeground(new java.awt.Color(204, 0, 0));
        bookPanel.add(bookStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 240, 20));

        btnUpdateBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/Update.png"))); // NOI18N
        btnUpdateBook.setText("UPDATE BOOK");
        btnUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookActionPerformed(evt);
            }
        });
        bookPanel.add(btnUpdateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 30));

        btnDeleteBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/delete.png"))); // NOI18N
        btnDeleteBook.setText("DELETE BOOK");
        btnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookActionPerformed(evt);
            }
        });
        bookPanel.add(btnDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 140, 30));

        btnAddBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/book_blue_add.png"))); // NOI18N
        btnAddBook.setText("NEW BOOK");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });
        bookPanel.add(btnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, 30));

        getContentPane().add(bookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 290));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(libariansComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 260, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ISBN :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Book Title :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Book Status :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        btnCheckOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/borrow.png"))); // NOI18N
        btnCheckOut.setText("CHECK OUT");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, 40));

        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/2_006.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, 30));
        jPanel1.add(borrowBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 260, 30));

        lblLibrarian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLibrarian.setText("Librarian :");
        jPanel1.add(lblLibrarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel1.add(bookIsbnTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 30));

        btnCheckIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/return.png"))); // NOI18N
        btnCheckIn.setLabel("CHECK IN");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, 40));

        currentBookStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(currentBookStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 360, 260));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        booksTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booksTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 800, 270));

        menuBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuBtn.setText("BACK");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });
        getContentPane().add(menuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Candidates For Election");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Books Borrowed");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        borrowedBooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        borrowedBooksTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrowedBooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowedBooksTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(borrowedBooksTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 800, 220));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/images/plain-blue-background.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 650));

        setSize(new java.awt.Dimension(1229, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed

        AdminPanel menu = new AdminPanel();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuBtnActionPerformed

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked

        saveBtn.setEnabled(false);
        BookDao bookDao = new BookDao();

        try {
            int row = booksTable.getSelectedRow();
            String Table_click = (booksTable.getModel().getValueAt(row, 0).toString());

            currentBook = bookDao.findBookByID(Table_click);

            if (currentBook != null) {
                bookTitle.setText(currentBook.getTitle());

                categoryCombo.setSelectedItem(currentBook.getCategory());
                bookAuthor.setText(currentBook.getAuthor());
                bookIsbn.setText(currentBook.getIsbn());
                bookStatus.setText(currentBook.getStatus());

                if (currentBook.getStatus().equalsIgnoreCase("AVAILABLE")) {
                    bookStatus.setForeground(java.awt.Color.GREEN);
                } else {
                    bookStatus.setForeground(java.awt.Color.RED);
                }

                enableEditBookButtons();
                bookStatus.setText(currentBook.getStatus());
            } else {
                JOptionPane.showMessageDialog(null, "No Book was found", "Book Not Found", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_booksTableMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        BookDao bookDao = new BookDao();
        Book bookModel = new Book();

        if (fieldsAreValid()) {
            String category = String.valueOf(categoryCombo.getSelectedItem());
            bookModel.setTitle(bookTitle.getText().toUpperCase().toString());
            bookModel.setAuthor(bookAuthor.getText());
            bookModel.setIsbn(bookIsbn.getText());
            bookModel.setStatus("AVAILABLE");
            bookModel.setCategory(category);

            int reply = JOptionPane.showConfirmDialog(null, "Confirm Adding Book: \n" + bookModel.getTitle().toUpperCase());
            if (reply == JOptionPane.YES_OPTION) {
                try {
                    bookDao.save(bookModel);
                    JOptionPane.showMessageDialog(null, "Book Added Successfully into Library");
                    saveBtn.setEnabled(false);

                } catch (Exception ex) {
                    Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "You cancelled adding book");
            }

            allBooks();

        } else {
            JOptionPane.showMessageDialog(null, "Please fill in missing fields", "Missing Fields", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private boolean fieldsAreValid() {

        if (bookTitle.getText().equals(null) || bookTitle.getText().equals("")
                || bookAuthor.getText().equals(null) || bookTitle.getText().equals("")
                || bookIsbn.getText().equals(null) || bookTitle.getText().equals("")
                || categoryCombo.getSelectedItem().equals(null) || bookTitle.getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }
    private void borrowedBooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowedBooksTableMouseClicked

        LibrarianDao librarian = new LibrarianDao();
        BookDao bookDao = new BookDao();
        Users user;

        try {
            int row = borrowedBooksTable.getSelectedRow();
            String book_id = (borrowedBooksTable.getModel().getValueAt(row, 0).toString());

            currentBook = bookDao.findBookByID(book_id, true);

            if (currentBook != null) {
                borrowBookTitle.setText(currentBook.getTitle());

                user = librarian.findLibrarianById(currentBook.getLibarianID());
                libariansComboBox.setSelectedItem(user.getFirstName() + " " + user.getLastName());

                if (currentBook.getStatus().equalsIgnoreCase("AVAILABLE")) {

                    btnCheckOut.setEnabled(true);
                    currentBookStatus.setForeground(java.awt.Color.GREEN);
                } else {

                    btnCheckIn.setEnabled(true);
                    currentBookStatus.setForeground(java.awt.Color.RED);
                }

                currentBookStatus.setText(currentBook.getStatus());
            } else {
                JOptionPane.showMessageDialog(null, "No Book was found", "Book Not Found", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_borrowedBooksTableMouseClicked


    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed

        BookDao bookDao = new BookDao();
        currentBook.setStatus("BORROWED");
        currentBook.setLibarianID(borrower.getId());

        int reply = JOptionPane.showConfirmDialog(null, "Confirm Checking Out Book Status");
        if (reply == JOptionPane.YES_OPTION) {
            try {
                bookDao.checkOut(currentBook);
                JOptionPane.showMessageDialog(null, "Book Status Updated Successfully");

            } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You cancelled Checking Out book status");
        }

        btnCheckOut.setEnabled(false);
        btnCheckIn.setEnabled(true);

        allBooks();
        allBorrowedBooks();
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        if (bookIsbnTF.getText() == null || bookIsbnTF.getText() == "") {

            JOptionPane.showMessageDialog(null, " Please Enter Book ISBN", "Inavlid ISBN", JOptionPane.ERROR_MESSAGE);
            bookIsbnTF.setText("");
            bookIsbnTF.requestFocus(true);

        } else {

            BookDao bookDao = new BookDao();
            try {
                currentBook = bookDao.findBookByISBN(bookIsbnTF.getText().toString());

                if (currentBook != null) {
                    borrowBookTitle.setText(currentBook.getTitle());
                    currentBook.setLibarianID(borrower.getId());

                    if (currentBook.getStatus().equalsIgnoreCase("AVAILABLE")) {

                        btnCheckOut.setEnabled(true);
                        btnCheckIn.setEnabled(false);
                        currentBookStatus.setForeground(java.awt.Color.GREEN);
                    } else {

                        btnCheckIn.setEnabled(true);
                        currentBookStatus.setForeground(java.awt.Color.RED);
                    }

                    currentBookStatus.setText(currentBook.getStatus());
                } else {
                    JOptionPane.showMessageDialog(null, "No Book was found", "Book Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_searchBtnActionPerformed

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
        // TODO add your handling code here:

        clearFields();
        saveBtn.setEnabled(true);
    }//GEN-LAST:event_btnAddBookActionPerformed

    private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookActionPerformed
        // TODO add your handling code here:

        BookDao bookDao = new BookDao();
        Book bookModel = new Book();

        //Converting id which is data type String to Long
        Long currentbookId = this.bookId;

        String category = String.valueOf(categoryCombo.getSelectedItem());
        bookModel.setId(currentbookId);
        bookModel.setTitle(bookTitle.getText().toUpperCase().toString());
        bookModel.setAuthor(bookAuthor.getText());
        bookModel.setIsbn(bookIsbn.getText());
        bookModel.setStatus("AVAILABLE");
        bookModel.setCategory(category);

        int reply = JOptionPane.showConfirmDialog(null, "Confirm Updating Book in Libarary");
        if (reply == JOptionPane.YES_OPTION) {
            try {
                bookDao.update(bookModel);
                JOptionPane.showMessageDialog(null, "Book Updated Successfully in Libarary");

            } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You cancelled updating candidate");
        }
        allBooks();
    }//GEN-LAST:event_btnUpdateBookActionPerformed

    private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookActionPerformed
        // TODO add your handling code here:

        BookDao bookDao = new BookDao();

        int reply = JOptionPane.showConfirmDialog(null, "Confirm Deleting Book From Library");
        if (reply == JOptionPane.YES_OPTION) {
            try {
                bookDao.delete(currentBook);
                JOptionPane.showMessageDialog(null, "Book Deleted Book From Library");

            } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You cancelled deleting Book");
        }
        allBooks();
    }//GEN-LAST:event_btnDeleteBookActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        // TODO add your handling code here:

        BookDao bookDao = new BookDao();

        if (currentBook.equals(null)) {
            JOptionPane.showMessageDialog(null, " Book Not Found", "Inavlid ISBN", JOptionPane.ERROR_MESSAGE);
        } else {

        }
        currentBook.setStatus("AVAILABLE");

        int reply = JOptionPane.showConfirmDialog(null, "Confirm Checking In Book in Library");
        if (reply == JOptionPane.YES_OPTION) {
            try {
                bookDao.checkIn(currentBook);
                JOptionPane.showMessageDialog(null, "Book Checked In Successfully in Library");

            } catch (Exception ex) {
                Logger.getLogger(BooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "You cancelled Checking In Book");
        }
        allBooks();
        allBorrowedBooks();
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void clearFields() {
        bookTitle.setText("");
        bookAuthor.setText("");
        bookIsbn.setText("");

        btnUpdateBook.setEnabled(false);
        btnDeleteBook.setEnabled(false);
    }

    private void enableEditBookButtons() {
        btnUpdateBook.setEnabled(true);
        btnDeleteBook.setEnabled(true);
    }

    public void allLibrarians() {
        String sql = "SELECT * FROM USERS WHERE ROLE = 'LIBRARIAN'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                borrower = new Users();
                borrower.setFirstName(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));
                borrower.setId(rs.getLong("USER_ID"));
                libariansComboBox.addItem(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void allBooks() {
        String sql = "SELECT * FROM BOOKS WHERE STATUS = 'AVAILABLE'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            booksTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void allBorrowedBooks() {
        String sql = "SELECT * FROM BOOKS WHERE STATUS = 'BORROWED'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            borrowedBooksTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookAuthor;
    private javax.swing.JTextField bookIsbn;
    private javax.swing.JTextField bookIsbnTF;
    private javax.swing.JLabel bookStatus;
    private javax.swing.JTextField bookTitle;
    private static javax.swing.JTable booksTable;
    private javax.swing.JTextField borrowBookTitle;
    private static javax.swing.JTable borrowedBooksTable;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnUpdateBook;
    private javax.swing.JComboBox categoryCombo;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JLabel currentBookStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblLibrarian;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblbookStatus;
    private javax.swing.JComboBox libariansComboBox;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
