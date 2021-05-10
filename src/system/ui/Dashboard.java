package system.ui;

//imports
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import system.dao.StudentsDao;
import system.dao.impl.StudentsDaoImpl;
import system.model.Students;

public class Dashboard extends javax.swing.JFrame {
    
    private final StudentsDao studentsDao = new StudentsDaoImpl();
    private final String[] columns = new String[]{"Id", "Uid", "Name", "Contact", "Address", "Email", "Programme", "Batch", "Semester"};
    private final DefaultTableModel model = new DefaultTableModel();
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setUpTableModel();
        setUpPaddingInTextField();
        findAll();
    }

    private void save() throws NumberFormatException, HeadlessException {
        try {
            Students student = getValueFromTextField();
            int rowCount = studentsDao.save(student);
            if (rowCount >= 1) {
                showMessageDialog("Student added successfully");
                resetForm();
                findAll();
            } else {
                showMessageDialog("Something went wrong");
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            showMessageDialog(ex.getMessage());
        }
    }
    
    private void update() throws NumberFormatException {
        try {
            int selectedRow = studentsTable.getSelectedRow();
            int id = (int) studentsTable.getValueAt(selectedRow, 0);
            Students student = studentsDao.findOne(id);
            if (editOrUpdateButton.getText().equals("Edit")) {
                editOrUpdateButton.setText("Update");
                idTextField.setText(student.getUid());
                studentNameTextField.setText(student.getName());
                contactTextField.setText(String.valueOf(student.getContact()));
                addressTextField.setText(student.getAddress());
                emailTextField.setText(student.getEmail());
                programmeTextField.setText(student.getProgramme());
                batchTextField.setText(student.getBatch());
                semesterTextField.setText(student.getSemester());
            } else if (editOrUpdateButton.getText().equals("Update")) {
                student.setUid(idTextField.getText());
                student.setName(studentNameTextField.getText());
                student.setContact(contactTextField.getText());
                student.setAddress(addressTextField.getText());
                student.setEmail(emailTextField.getText());
                student.setProgramme(programmeTextField.getText());
                student.setBatch(batchTextField.getText());
                student.setSemester(semesterTextField.getText());
                int rowCount = studentsDao.update(student, id);

                if (rowCount >= 1) {
                    showMessageDialog("Student sucessfully updated");
                    resetForm();
                    findAll();
                    editOrUpdateButton.setText("Edit");
                } else {
                    showMessageDialog("Something went wrong");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }
    
    private void remove() {
        int selectedRow = studentsTable.getSelectedRow();
        int id = (int) studentsTable.getValueAt(selectedRow, 0);
        try {
            Students book = studentsDao.findOne(id);
            if (book != null) {
                int rowCount = studentsDao.remove(id);
                if (rowCount >= 1) {
                    showMessageDialog("Student sucessfully deleted");
                    findAll();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }
    
    private void findAll() {
        model.setRowCount(0);
        try {
            List<Students> students = studentsDao.findAll();
            for (Students student : students) {
                Object[] row = {student.getId(), student.getUid(), student.getName(), student.getContact(), student.getAddress(), student.getEmail(), student.getProgramme(), student.getBatch(), student.getSemester()};
                model.addRow(row);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }
    
    private void search() {
        String query = searchTextField.getText();
        if (query.length() == 0) {
            findAll();
        } else {
            model.setRowCount(0);
            try {
                List<Students> students = studentsDao.search(searchTextField.getText());
                for (Students student : students) {
                    Object[] row = {student.getId(), student.getUid(), student.getName(), student.getContact(), student.getAddress(), student.getEmail(), student.getProgramme(), student.getBatch(), student.getSemester()};
                    model.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                showMessageDialog(ex.getMessage());
            }
        }
    }
    
    private void setUpTableModel() {
        studentsTable.setModel(model);
        model.setColumnIdentifiers(columns);
    }

    private void setUpPaddingInTextField() {
        setUpBorderFactory(idTextField);
        setUpBorderFactory(studentNameTextField);
        setUpBorderFactory(contactTextField);
        setUpBorderFactory(addressTextField);
        setUpBorderFactory(emailTextField);
        setUpBorderFactory(programmeTextField);
        setUpBorderFactory(batchTextField);
        setUpBorderFactory(semesterTextField);
        setUpBorderFactory(searchTextField);
    }
    
    private void setUpBorderFactory(JTextField textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
    }
    
    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    private Students getValueFromTextField() throws NumberFormatException {
        String uid = idTextField.getText();
        String name = studentNameTextField.getText();
        String contact = contactTextField.getText();
        String address = addressTextField.getText();
        String email = emailTextField.getText();
        String programme = programmeTextField.getText();
        String batch = batchTextField.getText();
        String semester = semesterTextField.getText();
        Students student = new Students(uid, name, contact, address, email, programme, batch, semester);
        return student;
    }
    
    private void resetForm() {
        idTextField.setText("");
        studentNameTextField.setText("");
        contactTextField.setText("");
        addressTextField.setText("");
        emailTextField.setText("");
        programmeTextField.setText("");
        batchTextField.setText("");
        semesterTextField.setText("");
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentsTableScrollPane = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        inputPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        studentNameLabel = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        contactLabel = new javax.swing.JLabel();
        contactTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        programmeLabel = new javax.swing.JLabel();
        programmeTextField = new javax.swing.JTextField();
        batchLabel = new javax.swing.JLabel();
        batchTextField = new javax.swing.JTextField();
        semesterLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        editOrUpdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        semesterTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentsTableScrollPane.setViewportView(studentsTable);

        getContentPane().add(studentsTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 131, 780, 491));

        searchLabel.setText("Search:");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(searchLabel)
                .addGap(60, 60, 60)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 790, -1));

        idLabel.setText("Student ID:");

        studentNameLabel.setText("Name:");

        contactLabel.setText("Contact:");

        addressLabel.setText("Address:");

        emailLabel.setText("Email:");

        programmeLabel.setText("Programme:");

        batchLabel.setText("Batch:");

        semesterLabel.setText("Semester:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editOrUpdateButton.setText("Edit");
        editOrUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrUpdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(editOrUpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(editOrUpdateButton)
                    .addComponent(deleteButton))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(studentNameLabel)
                            .addComponent(contactLabel)
                            .addComponent(addressLabel)
                            .addComponent(emailLabel)
                            .addComponent(programmeLabel)
                            .addComponent(batchLabel)
                            .addComponent(semesterLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semesterTextField)
                            .addComponent(programmeTextField)
                            .addComponent(idTextField)
                            .addComponent(studentNameTextField)
                            .addComponent(contactTextField)
                            .addComponent(addressTextField)
                            .addComponent(emailTextField)
                            .addComponent(batchTextField))))
                .addContainerGap())
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLabel)
                    .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programmeLabel)
                    .addComponent(programmeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchLabel)
                    .addComponent(batchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semesterLabel)
                    .addComponent(semesterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(inputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        remove();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editOrUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrUpdateButtonActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_editOrUpdateButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_searchTextFieldKeyReleased
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JTextField batchTextField;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JTextField contactTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editOrUpdateButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel programmeLabel;
    private javax.swing.JTextField programmeTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JTextField semesterTextField;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JTable studentsTable;
    private javax.swing.JScrollPane studentsTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
