/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controllers.ControllerReadWriteBinaryObject;
import controllers.ControllerReadWriteTextDistributor;
import controllers.ControllerReports;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ModelDistributor;
import model.bean.ModelDistributor;
import model.dao.ModelDistributorDAO;

/**
 *
 * @author luizg
 */
public class ViewRegisterDistributor extends javax.swing.JFrame {

    //Controller de relatórios
    public ControllerReports reports = new ControllerReports();
    
    private static ViewRegisterDistributor viewRegisterDistributor;
    public ControllerReadWriteTextDistributor controller = new ControllerReadWriteTextDistributor();
    ArrayList<ModelDistributor> list;

    public ControllerReadWriteBinaryObject controllerBinary = new ControllerReadWriteBinaryObject();

    private int count = 0;

    public ViewRegisterDistributor() {
        initComponents();
    }

    public static ViewRegisterDistributor getViewRegisterDistributor() {
        if (viewRegisterDistributor == null) {
            viewRegisterDistributor = new ViewRegisterDistributor();
        }
        return viewRegisterDistributor;
    }

    public void cleanFields() {
        jTextFieldName.setText("");
        jTextFieldCnpj.setText("");
        jTextFieldEmail.setText("");
        jTextFieldPhone.setText("");
        jTextFieldLoadType.setText("");
        jTextFieldSplitMaxCapacity.setText("");
        jTextFieldUnifiedMaxCapacity.setText("");
        jTextFieldState.setText("");
        jTextFieldCity.setText("");
        jTextFieldStreetName.setText("");
        jTextFieldNumber.setText(String.valueOf(""));
    }

    public void loadTable(List<ModelDistributor> distributorList) {
        DefaultTableModel tabela = (DefaultTableModel) jTableDistributor.getModel();
        tabela.setRowCount(0);

        int linha = 0;

        for (ModelDistributor model : distributorList) {
            tabela.insertRow(linha, new Object[]{
                model.getDistributorName(),
                model.getDistributorCNPJ(),
                model.getDistributosMail(),
                model.getPhoneNumber(),
                model.getLoadType(),
                model.getSplitMaxCapacity(),
                model.getUnitMaxCapacity(),
                model.getAdress().getState(),
                model.getAdress().getCity(),
                model.getAdress().getStreetName(),
                model.getAdress().getNumber()
            });
            linha++;
        }
    }

    public void loadTableDatabase() {
        DefaultTableModel tableModel = (DefaultTableModel) jTableDistributorDatabase.getModel();
        tableModel.setNumRows(0);
        ModelDistributorDAO modelDao = new ModelDistributorDAO();

        for (ModelDistributor model : modelDao.read()) {
            tableModel.addRow(new Object[]{
                model.getId(),
                model.getDistributorName(),
                model.getDistributorCNPJ(),
                model.getDistributosMail(),
                model.getPhoneNumber(),
                model.getLoadType(),
                model.getSplitMaxCapacity(),
                model.getUnitMaxCapacity(),
                model.getAdress().getState(),
                model.getAdress().getCity(),
                model.getAdress().getStreetName(),
                model.getAdress().getNumber(),});
        }
    }

    public int readTableDatabaseForId(int id) {
        DefaultTableModel tableModel = (DefaultTableModel) jTableDistributorDatabase.getModel();
        tableModel.setNumRows(0);
        ModelDistributorDAO modelDao = new ModelDistributorDAO();
        int i = 0;
        for (ModelDistributor model : modelDao.readID(id)) {
            tableModel.addRow(new Object[]{
                model.getId(),
                model.getDistributorName(),
                model.getDistributorCNPJ(),
                model.getDistributosMail(),
                model.getPhoneNumber(),
                model.getLoadType(),
                model.getSplitMaxCapacity(),
                model.getUnitMaxCapacity(),
                model.getAdress().getState(),
                model.getAdress().getCity(),
                model.getAdress().getStreetName(),
                model.getAdress().getNumber(),});
            i++;
        }

        return i;
    }

    public int readTableDatabaseForName(String name) {
        DefaultTableModel tableModel = (DefaultTableModel) jTableDistributorDatabase.getModel();
        tableModel.setNumRows(0);
        ModelDistributorDAO modelDao = new ModelDistributorDAO();
        int i = 0;
        for (ModelDistributor model : modelDao.readName(name)) {
            tableModel.addRow(new Object[]{
                model.getId(),
                model.getDistributorName(),
                model.getDistributorCNPJ(),
                model.getDistributosMail(),
                model.getPhoneNumber(),
                model.getLoadType(),
                model.getSplitMaxCapacity(),
                model.getUnitMaxCapacity(),
                model.getAdress().getState(),
                model.getAdress().getCity(),
                model.getAdress().getStreetName(),
                model.getAdress().getNumber(),});
            i++;
        }

        return i;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonRegister2 = new javax.swing.JButton();
        jButtonRegister1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldState = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldStreetName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldLoadType = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSplitMaxCapacity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUnifiedMaxCapacity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCnpj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jButtonClean = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonSaveBinary = new javax.swing.JButton();
        jButtonRegister = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDistributor = new javax.swing.JTable();
        jButtonClean1 = new javax.swing.JButton();
        jButtonSearchBinary = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonExcludeDatabank = new javax.swing.JButton();
        jButtonSearchDatabank = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonExcludeDatabank1 = new javax.swing.JButton();
        jRadioButtonId = new javax.swing.JRadioButton();
        jRadioButtonName = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDistributorDatabase = new javax.swing.JTable();
        jButtonClean2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemRegisterDistributor = new javax.swing.JMenuItem();
        jMenuIteSearchDistributor = new javax.swing.JMenuItem();
        jMenuItemClient = new javax.swing.JMenuItem();
        jMenuItemMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        productReports = new javax.swing.JMenu();
        viewProductsReport = new javax.swing.JMenuItem();
        viewSpecificProductReport = new javax.swing.JMenuItem();
        generateProductPdfReport = new javax.swing.JMenuItem();
        Clientes = new javax.swing.JMenu();
        viewClientsReport = new javax.swing.JMenuItem();
        viewSpecificClientsReport = new javax.swing.JMenuItem();
        viewGroupClientsReport1 = new javax.swing.JMenuItem();
        generateClientsPdfReport1 = new javax.swing.JMenuItem();
        Distribuidoras = new javax.swing.JMenu();
        viewDistributorsReport2 = new javax.swing.JMenuItem();
        viewSpecificDistributorReport = new javax.swing.JMenuItem();
        generateDistributorsPdfReport2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                handleSave(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de distribuidoras");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jButtonRegister2.setBackground(new java.awt.Color(255, 102, 0));
        jButtonRegister2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister2.setText("Cadastrar no banco");
        jButtonRegister2.setBorderPainted(false);
        jButtonRegister2.setFocusPainted(false);
        jButtonRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegister2ActionPerformed(evt);
            }
        });

        jButtonRegister1.setBackground(new java.awt.Color(255, 102, 0));
        jButtonRegister1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister1.setText("Atualizar no banco");
        jButtonRegister1.setBorderPainted(false);
        jButtonRegister1.setFocusPainted(false);
        jButtonRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegister1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Manipulação do banco:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jButtonRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonRegister2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 110));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setText("Estado");

        jTextFieldState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStateActionPerformed(evt);
            }
        });

        jLabel12.setText("Cidade");

        jTextFieldCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCityActionPerformed(evt);
            }
        });

        jLabel13.setText("Nome da rua");

        jTextFieldStreetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStreetNameActionPerformed(evt);
            }
        });

        jLabel10.setText("Número");

        jTextFieldNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumberActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de carga");

        jTextFieldLoadType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoadTypeActionPerformed(evt);
            }
        });

        jLabel8.setText("Capacidade dividida máxima");

        jTextFieldSplitMaxCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSplitMaxCapacityActionPerformed(evt);
            }
        });

        jLabel2.setText("Capacidade unitária máxima");

        jTextFieldUnifiedMaxCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUnifiedMaxCapacityActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome da distribuidora");

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabel4.setText("CNPJ");

        jTextFieldCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnpjActionPerformed(evt);
            }
        });

        jLabel5.setText("Email");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefone");

        jButtonClean.setBackground(new java.awt.Color(255, 102, 0));
        jButtonClean.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClean.setText("Limpar tabela");
        jButtonClean.setBorderPainted(false);
        jButtonClean.setFocusPainted(false);
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jTextFieldId.setEnabled(false);
        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jLabel15.setText("Id");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLoadType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSplitMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUnifiedMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButtonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldLoadType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldSplitMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldUnifiedMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonClean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 530, 260));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jButtonSave.setBackground(new java.awt.Color(255, 102, 0));
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("Descarregar em arquivo texto");
        jButtonSave.setBorderPainted(false);
        jButtonSave.setFocusPainted(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonSaveBinary.setBackground(new java.awt.Color(255, 102, 0));
        jButtonSaveBinary.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveBinary.setText("Descarregar em arquivo binário");
        jButtonSaveBinary.setBorderPainted(false);
        jButtonSaveBinary.setFocusPainted(false);
        jButtonSaveBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveBinaryActionPerformed(evt);
            }
        });

        jButtonRegister.setBackground(new java.awt.Color(255, 102, 0));
        jButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegister.setText("Armazenar na lista");
        jButtonRegister.setBorderPainted(false);
        jButtonRegister.setFocusPainted(false);
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        jLabel14.setText("Manipulação de arquivos:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jButtonSaveBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaveBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 250, 140));

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jButtonSearch.setBackground(new java.awt.Color(255, 102, 0));
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Carregar texto");
        jButtonSearch.setBorderPainted(false);
        jButtonSearch.setFocusPainted(false);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTableDistributor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CNPJ", "Email", "Telefone", "Tipo da carga", "Capacidade dividida máxima", "Capacidade unitária máxima", "Estado", "Cidade", "Rua", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDistributor);

        jButtonClean1.setBackground(new java.awt.Color(255, 102, 0));
        jButtonClean1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClean1.setText("Voltar");
        jButtonClean1.setBorderPainted(false);
        jButtonClean1.setFocusPainted(false);
        jButtonClean1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClean1ActionPerformed(evt);
            }
        });

        jButtonSearchBinary.setBackground(new java.awt.Color(255, 102, 0));
        jButtonSearchBinary.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearchBinary.setText("Carregar binário");
        jButtonSearchBinary.setBorderPainted(false);
        jButtonSearchBinary.setFocusPainted(false);
        jButtonSearchBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchBinaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClean1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearchBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClean1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar em Arquivos", jPanel3);

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setName("Buscar no banco"); // NOI18N

        jButtonExcludeDatabank.setBackground(new java.awt.Color(255, 102, 0));
        jButtonExcludeDatabank.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcludeDatabank.setText("Excluir");
        jButtonExcludeDatabank.setBorderPainted(false);
        jButtonExcludeDatabank.setFocusPainted(false);
        jButtonExcludeDatabank.setFocusable(false);
        jButtonExcludeDatabank.setVerifyInputWhenFocusTarget(false);
        jButtonExcludeDatabank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcludeDatabankActionPerformed(evt);
            }
        });

        jButtonSearchDatabank.setBackground(new java.awt.Color(255, 102, 0));
        jButtonSearchDatabank.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearchDatabank.setText("Buscar");
        jButtonSearchDatabank.setBorderPainted(false);
        jButtonSearchDatabank.setFocusPainted(false);
        jButtonSearchDatabank.setFocusable(false);
        jButtonSearchDatabank.setVerifyInputWhenFocusTarget(false);
        jButtonSearchDatabank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchDatabankActionPerformed(evt);
            }
        });

        jButtonExcludeDatabank1.setBackground(new java.awt.Color(255, 102, 0));
        jButtonExcludeDatabank1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcludeDatabank1.setText("Limpar tabela");
        jButtonExcludeDatabank1.setBorderPainted(false);
        jButtonExcludeDatabank1.setFocusPainted(false);
        jButtonExcludeDatabank1.setFocusable(false);
        jButtonExcludeDatabank1.setVerifyInputWhenFocusTarget(false);
        jButtonExcludeDatabank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcludeDatabank1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonId);
        jRadioButtonId.setSelected(true);
        jRadioButtonId.setText("Busca por id");

        buttonGroup1.add(jRadioButtonName);
        jRadioButtonName.setText("Busca por nome");

        jTableDistributorDatabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CNPJ", "Email", "Telefone", "Tipo da carga", "Capacidade dividida máxima", "Capacidade unitária máxima", "Estado", "Cidade", "Rua", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableDistributorDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDistributorDatabaseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDistributorDatabase);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonName)
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExcludeDatabank1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExcludeDatabank, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearchDatabank, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonId)
                    .addComponent(jRadioButtonName))
                .addGap(212, 212, 212)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcludeDatabank, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchDatabank, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcludeDatabank1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Buscar no banco", jPanel4);

        jButtonClean2.setBackground(new java.awt.Color(153, 153, 153));
        jButtonClean2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClean2.setText("Voltar");
        jButtonClean2.setBorderPainted(false);
        jButtonClean2.setFocusPainted(false);
        jButtonClean2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClean2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonClean2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClean2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        jMenu2.setText("Opções");

        jMenuItemSave.setText("Salvar");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSave);

        jMenuItemExit.setText("Sair");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExit);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Ir até");

        jMenuItemRegisterDistributor.setText("Distribuidoras");
        jMenu1.add(jMenuItemRegisterDistributor);

        jMenuIteSearchDistributor.setText("Produtos");
        jMenuIteSearchDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIteSearchDistributorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuIteSearchDistributor);

        jMenuItemClient.setText("Clientes");
        jMenuItemClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClient);

        jMenuItemMenu.setText("Menu");
        jMenuItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemMenu);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Relatórios");

        productReports.setText("Produtos");

        viewProductsReport.setText("Visualizar relatório de produtos");
        viewProductsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductsReportActionPerformed(evt);
            }
        });
        productReports.add(viewProductsReport);

        viewSpecificProductReport.setText("Visualizar produto específico");
        viewSpecificProductReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSpecificProductReportActionPerformed(evt);
            }
        });
        productReports.add(viewSpecificProductReport);

        generateProductPdfReport.setText("Gerar relatório em pdf");
        generateProductPdfReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateProductPdfReportActionPerformed(evt);
            }
        });
        productReports.add(generateProductPdfReport);

        jMenu3.add(productReports);

        Clientes.setText("Clientes");

        viewClientsReport.setText("Visualizar relatório de clientes");
        viewClientsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewClientsReportActionPerformed(evt);
            }
        });
        Clientes.add(viewClientsReport);

        viewSpecificClientsReport.setText("Visualizar cliente específico");
        viewSpecificClientsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSpecificClientsReportActionPerformed(evt);
            }
        });
        Clientes.add(viewSpecificClientsReport);

        viewGroupClientsReport1.setText("Visualizar cliente agrupado");
        viewGroupClientsReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGroupClientsReport1ActionPerformed(evt);
            }
        });
        Clientes.add(viewGroupClientsReport1);

        generateClientsPdfReport1.setText("Gerar relatório em pdf");
        generateClientsPdfReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateClientsPdfReport1ActionPerformed(evt);
            }
        });
        Clientes.add(generateClientsPdfReport1);

        jMenu3.add(Clientes);

        Distribuidoras.setText("Distribuidoras");

        viewDistributorsReport2.setText("Visualizar relatório de distribuidoras");
        viewDistributorsReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDistributorsReport2ActionPerformed(evt);
            }
        });
        Distribuidoras.add(viewDistributorsReport2);

        viewSpecificDistributorReport.setText("Visualizar distribuidora específica");
        viewSpecificDistributorReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSpecificDistributorReportActionPerformed(evt);
            }
        });
        Distribuidoras.add(viewSpecificDistributorReport);

        generateDistributorsPdfReport2.setText("Gerar relatório em pdf");
        generateDistributorsPdfReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDistributorsPdfReport2ActionPerformed(evt);
            }
        });
        Distribuidoras.add(generateDistributorsPdfReport2);

        jMenu3.add(Distribuidoras);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(860, 483));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuIteSearchDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIteSearchDistributorActionPerformed
        ViewRegisterProduct.getViewRegisterProduct().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuIteSearchDistributorActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "", JOptionPane.YES_NO_OPTION);
        if (sair == 0) {
            controller.writeDistributor(list, true);
            list = null;
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        controller.readDistributor();
        loadTable(controller.getDistributor());
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        if (list == null) {
            list = new ArrayList<>();
        }
        ModelDistributor model = new ModelDistributor();

        model.setDistributorName(jTextFieldName.getText());
        model.setDistributorCNPJ(jTextFieldCnpj.getText());
        model.setDistributosMail(jTextFieldEmail.getText());
        model.setPhoneNumber(jTextFieldPhone.getText());
        model.setLoadType(jTextFieldLoadType.getText());
        model.setSplitMaxCapacity(jTextFieldSplitMaxCapacity.getText());
        model.setUnitMaxCapacity(jTextFieldUnifiedMaxCapacity.getText());
        model.getAdress().setState(jTextFieldState.getText());
        model.getAdress().setCity(jTextFieldCity.getText());
        model.getAdress().setStreetName(jTextFieldStreetName.getText());
        model.getAdress().setNumber(Integer.parseInt(jTextFieldNumber.getText()));

        list.add(model);
        cleanFields();

        count++;
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        cleanFields();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jTextFieldSplitMaxCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSplitMaxCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSplitMaxCapacityActionPerformed

    private void jTextFieldLoadTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoadTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLoadTypeActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldStreetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStreetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStreetNameActionPerformed

    private void jTextFieldCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCityActionPerformed

    private void jTextFieldStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStateActionPerformed

    private void jTextFieldUnifiedMaxCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUnifiedMaxCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUnifiedMaxCapacityActionPerformed

    private void jTextFieldCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCnpjActionPerformed

    private void jTextFieldNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumberActionPerformed

    private void handleSave(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_handleSave
        if (count > 0) {
            int sair = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "", JOptionPane.YES_NO_OPTION);
            if (sair == 0) {
                controller.writeDistributor(list, true);
                list = null;
                System.exit(0);
            }
        }
    }//GEN-LAST:event_handleSave

    private void jButtonClean1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClean1ActionPerformed
        ViewMainPage.getViewMainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonClean1ActionPerformed

    private void jMenuItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMenuActionPerformed
        ViewMainPage.getViewMainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemMenuActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "", JOptionPane.YES_NO_OPTION);
        if (sair == 0) {
            controller.writeDistributor(list, true);
            list = null;
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jMenuItemClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientActionPerformed
        ViewRegisterDistributor.getViewRegisterDistributor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemClientActionPerformed

    private void jButtonClean2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClean2ActionPerformed
        ViewMainPage.getViewMainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonClean2ActionPerformed

    private void jButtonSaveBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveBinaryActionPerformed
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Cadastre algum Distributore antes de salvar.", "Aviso", JOptionPane.OK_OPTION);
        } else {
            int sair = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "", JOptionPane.YES_NO_OPTION);
            if (sair == 0) {
                controllerBinary.setFile("Salvar");
                if (controllerBinary.getFile() != null) {
                    List<Object> listObj = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        listObj.add((Object) list.get(i));
                    }
                    System.out.println("List salva: " + list);
                    System.out.println("ListObj salva: " + listObj);
                    controllerBinary.writeContentList(listObj, true);
                }
                list = null;
            }
        }
    }//GEN-LAST:event_jButtonSaveBinaryActionPerformed

    private void jButtonSearchBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchBinaryActionPerformed
        // Leitura limitada ao primeiro salvamento

        if (list == null) {
            list = new ArrayList<>();
        }

        controllerBinary.setFile("Abrir");
        if (controllerBinary.getFile() != null) {
            if (controllerBinary.readContentList()) {
                List<Object> listObj = controllerBinary.getListObject();
                List<Object> listListObj;

                System.err.println("Listobj inteiro: " + listObj);
                System.err.println("Listobj index = 0: " + listObj.get(0));

                listListObj = (List<Object>) listObj.get(0);

                System.err.println("listListObj inteiro: " + listListObj);

                for (int i = 0; i < listListObj.size(); i++) {
                    System.err.println(listListObj.get(i));
                    list.add((ModelDistributor) listListObj.get(i));
                }

                System.err.println("List: " + list);
                loadTable(list);
                list = null;
            }
        }
    }//GEN-LAST:event_jButtonSearchBinaryActionPerformed

    private void jButtonExcludeDatabankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcludeDatabankActionPerformed
        if (jTableDistributorDatabase.getSelectedRow() != -1) {
            int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Aviso", 1);
            if (sair == 0) {
                if (jTableDistributorDatabase.getSelectedRow() != -1) {
                    ModelDistributor model = new ModelDistributor();
                    ModelDistributorDAO modelDao = new ModelDistributorDAO();

                    model.setId(Integer.parseInt(String.valueOf(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 0))));

                    modelDao.delete(model);
                    loadTableDatabase();
                    cleanFields();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para excluir");
        }
    }//GEN-LAST:event_jButtonExcludeDatabankActionPerformed

    private void jButtonSearchDatabankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchDatabankActionPerformed
        if ("".equals(jTextFieldSearch.getText())) {
            jTextFieldSearch.setText("");
            loadTableDatabase();
        } else {
            if (jRadioButtonId.isSelected()) {
                try {
                    readTableDatabaseForId(Integer.parseInt(jTextFieldSearch.getText()));
                } catch (NumberFormatException num) {
                    JOptionPane.showMessageDialog(null, "Digite o id corretamente...");
                }
            }
            if (jRadioButtonName.isSelected()) {
                try {
                    readTableDatabaseForName(jTextFieldSearch.getText());
                } catch (NumberFormatException num) {
                    JOptionPane.showMessageDialog(null, "Digite o nome corretamente...");
                }
            }
        }
    }//GEN-LAST:event_jButtonSearchDatabankActionPerformed

    private void jButtonExcludeDatabank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcludeDatabank1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) jTableDistributorDatabase.getModel();
        tableModel.setNumRows(0);
    }//GEN-LAST:event_jButtonExcludeDatabank1ActionPerformed

    private void jButtonRegister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegister2ActionPerformed
        if ("".equals(jTextFieldName.getText()) || "".equals(jTextFieldCnpj.getText()) || "".equals(jTextFieldEmail.getText()) || "".equals(jTextFieldPhone.getText()) || "".equals(jTextFieldLoadType.getText()) || "".equals(jTextFieldSplitMaxCapacity.getText()) || "".equals(jTextFieldUnifiedMaxCapacity.getText()) || "".equals(jTextFieldState.getText()) || "".equals(jTextFieldCity.getText()) || "".equals(jTextFieldStreetName.getText()) || "".equals(jTextFieldNumber.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos para cadastrar...");
        } else if (!("".equals(jTextFieldId.getText()))) {
            if (readTableDatabaseForId(Integer.parseInt(jTextFieldId.getText())) > 0) {
                JOptionPane.showMessageDialog(null, "Distribuidora já cadastrada...");
            }
        } else {
            ModelDistributor model = new ModelDistributor();
            ModelDistributorDAO modelDao = new ModelDistributorDAO();

            try {                
                model.setDistributorName(jTextFieldName.getText());
                model.setDistributorCNPJ(jTextFieldCnpj.getText());
                model.setDistributosMail(jTextFieldEmail.getText());
                model.setPhoneNumber(jTextFieldPhone.getText());
                model.setLoadType(jTextFieldLoadType.getText());
                model.setSplitMaxCapacity(jTextFieldSplitMaxCapacity.getText());
                model.setUnitMaxCapacity(jTextFieldSplitMaxCapacity.getText());
                model.getAdress().setState(jTextFieldState.getText());
                model.getAdress().setCity(jTextFieldCity.getText());
                model.getAdress().setStreetName(jTextFieldStreetName.getText());
                model.getAdress().setNumber(Integer.valueOf(jTextFieldNumber.getText()));

                modelDao.Create(model);
                loadTableDatabase();
                cleanFields();

            } catch (NumberFormatException num) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar, o campo \"número\" deve ser um inteiro.");
            }
        }
    }//GEN-LAST:event_jButtonRegister2ActionPerformed

    private void jButtonRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegister1ActionPerformed
        if (jTableDistributorDatabase.getSelectedRow() != -1) {
            ModelDistributor model = new ModelDistributor();
            ModelDistributorDAO modelDao = new ModelDistributorDAO();

            try {

                model.setId(Integer.valueOf(jTextFieldId.getText()));
                model.setDistributorName(jTextFieldName.getText());
                model.setDistributorCNPJ(jTextFieldCnpj.getText());
                model.setDistributosMail(jTextFieldEmail.getText());
                model.setPhoneNumber(jTextFieldPhone.getText());
                model.setLoadType(jTextFieldLoadType.getText());
                model.setSplitMaxCapacity(jTextFieldSplitMaxCapacity.getText());
                model.setUnitMaxCapacity(jTextFieldSplitMaxCapacity.getText());
                model.getAdress().setState(jTextFieldState.getText());
                model.getAdress().setCity(jTextFieldCity.getText());
                model.getAdress().setStreetName(jTextFieldStreetName.getText());
                model.getAdress().setNumber(Integer.valueOf(jTextFieldNumber.getText()));

                modelDao.Update(model);
                loadTableDatabase();
                cleanFields();

            } catch (NumberFormatException num) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para atualizar");
        }
    }//GEN-LAST:event_jButtonRegister1ActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jTableDistributorDatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDistributorDatabaseMouseClicked
        if (jTableDistributorDatabase.getSelectedRow() != -1) {
            jTextFieldId.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 0).toString());
            jTextFieldName.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 1).toString());
            jTextFieldCnpj.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 2).toString());
            jTextFieldEmail.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 3).toString());
            jTextFieldLoadType.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 4).toString());
            jTextFieldSplitMaxCapacity.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 5).toString());
            jTextFieldUnifiedMaxCapacity.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 6).toString());
            jTextFieldPhone.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 7).toString());
            jTextFieldState.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 8).toString());
            jTextFieldCity.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 9).toString());
            jTextFieldStreetName.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 10).toString());
            jTextFieldNumber.setText(jTableDistributorDatabase.getValueAt(jTableDistributorDatabase.getSelectedRow(), 11).toString());
        }
    }//GEN-LAST:event_jTableDistributorDatabaseMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadTableDatabase();
    }//GEN-LAST:event_formWindowOpened

    private void viewProductsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductsReportActionPerformed
        reports.ProductReport(null, true);
    }//GEN-LAST:event_viewProductsReportActionPerformed

    private void viewSpecificProductReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSpecificProductReportActionPerformed
        reports.ProductReport(reports.buildParams("specificProduct", "Digite o identificador do produto:"), true);
    }//GEN-LAST:event_viewSpecificProductReportActionPerformed

    private void generateProductPdfReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateProductPdfReportActionPerformed
        reports.ProductReport(null, false);
    }//GEN-LAST:event_generateProductPdfReportActionPerformed

    private void viewClientsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewClientsReportActionPerformed
        reports.ClientReport(null, true);
    }//GEN-LAST:event_viewClientsReportActionPerformed

    private void viewSpecificClientsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSpecificClientsReportActionPerformed
        reports.ProductReport(reports.buildParams("specificClient", "Digite o identificador do cliente:"), true);
    }//GEN-LAST:event_viewSpecificClientsReportActionPerformed

    private void viewGroupClientsReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGroupClientsReport1ActionPerformed
        reports.groupClientReport(null, true);
    }//GEN-LAST:event_viewGroupClientsReport1ActionPerformed

    private void generateClientsPdfReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateClientsPdfReport1ActionPerformed
        reports.ClientReport(null, false);
    }//GEN-LAST:event_generateClientsPdfReport1ActionPerformed

    private void viewDistributorsReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDistributorsReport2ActionPerformed
        reports.DistributorReport(null, true);
    }//GEN-LAST:event_viewDistributorsReport2ActionPerformed

    private void viewSpecificDistributorReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSpecificDistributorReportActionPerformed
        reports.ProductReport(reports.buildParams("specificDistributor", "Digite o identificador da distribuidora:"), true);
    }//GEN-LAST:event_viewSpecificDistributorReportActionPerformed

    private void generateDistributorsPdfReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDistributorsPdfReport2ActionPerformed
        reports.DistributorReport(null, false);
    }//GEN-LAST:event_generateDistributorsPdfReport2ActionPerformed

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewRegisterDistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRegisterDistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRegisterDistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRegisterDistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegisterDistributor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Clientes;
    private javax.swing.JMenu Distribuidoras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem generateClientsPdfReport1;
    private javax.swing.JMenuItem generateDistributorsPdfReport2;
    private javax.swing.JMenuItem generateProductPdfReport;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonClean1;
    private javax.swing.JButton jButtonClean2;
    private javax.swing.JButton jButtonExcludeDatabank;
    private javax.swing.JButton jButtonExcludeDatabank1;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JButton jButtonRegister1;
    private javax.swing.JButton jButtonRegister2;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSaveBinary;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearchBinary;
    private javax.swing.JButton jButtonSearchDatabank;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuIteSearchDistributor;
    private javax.swing.JMenuItem jMenuItemClient;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemMenu;
    private javax.swing.JMenuItem jMenuItemRegisterDistributor;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButtonId;
    private javax.swing.JRadioButton jRadioButtonName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDistributor;
    private javax.swing.JTable jTableDistributorDatabase;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldCnpj;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLoadType;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldSplitMaxCapacity;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStreetName;
    private javax.swing.JTextField jTextFieldUnifiedMaxCapacity;
    private javax.swing.JMenu productReports;
    private javax.swing.JMenuItem viewClientsReport;
    private javax.swing.JMenuItem viewDistributorsReport2;
    private javax.swing.JMenuItem viewGroupClientsReport1;
    private javax.swing.JMenuItem viewProductsReport;
    private javax.swing.JMenuItem viewSpecificClientsReport;
    private javax.swing.JMenuItem viewSpecificDistributorReport;
    private javax.swing.JMenuItem viewSpecificProductReport;
    // End of variables declaration//GEN-END:variables
}
