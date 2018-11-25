/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dominio.Date;
import dominio.Device;
import dominio.FileReader;
import dominio.Tree_insiders;
import dominio.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Henrique
 */
public class Home extends javax.swing.JFrame {

    File[] filesUsers;
    File[] filesData;
    Tree_insiders tree;
    FileReader filereader;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        tree = new Tree_insiders();
        filereader = new FileReader();

        btnGerar.setEnabled(false);
        btnUtilizacao.setEnabled(false);
        btnEnviarDados.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbFiltro = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblSelectFiles = new javax.swing.JLabel();
        btnSelectFiles = new javax.swing.JButton();
        lblObsFiles = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUtilizacao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnOKUsers = new javax.swing.JButton();
        btnEnviarDados = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblDataInicio = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        lblDatasInfo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblVersion = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rbData = new javax.swing.JRadioButton();
        rbPeriodo = new javax.swing.JRadioButton();
        rbTudo = new javax.swing.JRadioButton();
        lblOrdenar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnGerar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inside Threat");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectFiles.setText("1. Selecione todos os arquivos de log:");

        btnSelectFiles.setText("Selecionar...");
        btnSelectFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectFilesMouseClicked(evt);
            }
        });

        lblObsFiles.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblObsFiles.setText("Obs.: Para selecionar todos os arquivos pressione a tecla CTRL.");

        jLabel1.setText("Users:");

        jLabel2.setText("Selecione os arquivos com os dados de usuários.");

        jLabel3.setText("Dados:");

        btnUtilizacao.setText("Selecionar...");
        btnUtilizacao.setEnabled(false);
        btnUtilizacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUtilizacaoMouseClicked(evt);
            }
        });

        jLabel4.setText("Selecione os dados de utilização dos usuários.");

        btnOKUsers.setText("Enviar");
        btnOKUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKUsersMouseClicked(evt);
            }
        });

        btnEnviarDados.setText("Enviar");
        btnEnviarDados.setEnabled(false);
        btnEnviarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarDadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelectFiles)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(btnUtilizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btnSelectFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOKUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(btnEnviarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addComponent(lblObsFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectFiles)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectFiles)
                    .addComponent(jLabel1)
                    .addComponent(btnOKUsers)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnUtilizacao)
                    .addComponent(btnEnviarDados)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObsFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblDataInicio.setText("Data (início):");

        lblDataFim.setText("Data(fim):");

        txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        lblDatasInfo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDatasInfo.setText("Insira as datas no formato: dd/MM/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataInicio)
                    .addComponent(lblDataFim)
                    .addComponent(lblDatasInfo))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataInicio)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataFim)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDatasInfo)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblVersion.setText("Versão 0.2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(lblVersion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addContainerGap())
        );

        jPanel6.setBackground(java.awt.Color.white);

        rbData.setBackground(new java.awt.Color(255, 255, 255));
        rbFiltro.add(rbData);
        rbData.setText("Data específica");
        rbData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbDataItemStateChanged(evt);
            }
        });
        rbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDataActionPerformed(evt);
            }
        });

        rbPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        rbFiltro.add(rbPeriodo);
        rbPeriodo.setSelected(true);
        rbPeriodo.setText("Período entre datas");
        rbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPeriodoActionPerformed(evt);
            }
        });

        rbTudo.setBackground(new java.awt.Color(255, 255, 255));
        rbFiltro.add(rbTudo);
        rbTudo.setText("Tudo");
        rbTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTudoActionPerformed(evt);
            }
        });

        lblOrdenar.setText("2. Como deseja filtrar?");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOrdenar)
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbData)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rbPeriodo)
                        .addGap(52, 52, 52)
                        .addComponent(rbTudo)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPeriodo)
                    .addComponent(rbTudo)
                    .addComponent(lblOrdenar))
                .addGap(9, 9, 9)
                .addComponent(rbData))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("INSIDE THREAT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel6)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("3. Insira o id do(os) usuário(os):");

        jLabel11.setText("Usuário 1:*");

        jLabel12.setText("Usuário 2:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnGerar.setText("Gerar Relatório");
        btnGerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGerarMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("* é obrigatório");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(btnGerar)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jTextField5)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Salvar Perfis");

        jButton3.setText("Abrir Perfis");
        jButton3.setMaximumSize(new java.awt.Dimension(93, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(93, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(93, 23));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGerarMouseClicked
        //tree.createDiagram();

        final HistogramLines demo = new HistogramLines("Ações do Usuário", "Segurança");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        
        /*try {

            if (filesData.length == 3 && filesData != null && filesUsers != null) {

                if (rbPeriodo.isSelected()) {
                    if (txtDataFinal.getText().isEmpty() || txtDataInicio.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Verifique a data de inicio e final!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        // Do Something.
                    }

                } else if (rbData.isSelected()) {
                    if (txtDataInicio.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Há data faltando!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    } else {

                        // Do Something.
                    }
                }

                System.out.println("Terminou de ler tudo!");
                tree.users();

            } else {
                if (filesData.length < 3 || filesData == null) {
                    JOptionPane.showMessageDialog(this, "Você não selecionou todos os arquivos", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "São 3 arquivos, você inseriu mais!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Não foi selecionado nenhum arquivo!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
         */
    }//GEN-LAST:event_btnGerarMouseClicked

    /**
     * Working with the radio buttons. Make that the user only use what's
     * necessary.
     */
    private void rbDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbDataItemStateChanged
        /*int data_esp = 0;

        if (rbData.isSelected()) {
            data_esp = 1;
            System.out.println("Data");
        } else if (rbPeriodo.isSelected()) {
            data_esp = 0;
            System.out.println("Periodo");
        } else if (rbTudo.isSelected()) {
            data_esp = 2;
            System.out.println("Tudo");
        }

        switch (data_esp) {
            case 1:
                lblDataInicio.setText("Data:");
                txtDataFinal.setEnabled(false);
                txtDataInicio.setEnabled(true);
                break;
            case 0:
                lblDataInicio.setText("Data(início):");
                txtDataFinal.setEnabled(true);
                txtDataInicio.setEnabled(true);
                break;
            case 2:
                if (txtDataFinal.isEnabled() && txtDataInicio.isEnabled()) {
                    txtDataFinal.setEnabled(false);
                    txtDataInicio.setEnabled(false);
                }
                break;
            default:
                break;
        }*/

    }//GEN-LAST:event_rbDataItemStateChanged

    /**
     * Open a JFrame to select multiple files about the Users informations.
     */
    private void btnSelectFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectFilesMouseClicked
        if (btnSelectFiles.isEnabled()) {
            try {
                JFileChooser fc = new JFileChooser();
                fc.setMultiSelectionEnabled(true);
                fc.addChoosableFileFilter(new FilterJFileChooser());
                fc.showOpenDialog(this);
                filesUsers = fc.getSelectedFiles();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnSelectFilesMouseClicked

    /**
     * Open a JFrame to select multiple files about others informations.
     */
    private void btnUtilizacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUtilizacaoMouseClicked
        if (btnUtilizacao.isEnabled()) {
            try {
                JFileChooser fc = new JFileChooser();
                fc.setMultiSelectionEnabled(true);
                fc.addChoosableFileFilter(new FilterJFileChooser());
                fc.showOpenDialog(this);
                filesData = fc.getSelectedFiles();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUtilizacaoMouseClicked

    /**
     * Read the LDAP files and switch the buttons enabled.
     */
    private void btnOKUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKUsersMouseClicked

        if (filesUsers != null && btnOKUsers.isEnabled()) {
            System.out.println("Começou a ler o LDAP");
            for (File f : filesUsers) {
                filereader.read_ldap(tree, f);
            }
            System.out.println("Terminou de ler o LDAP");

            btnUtilizacao.setEnabled(true);
            btnOKUsers.setEnabled(false);
            btnEnviarDados.setEnabled(true);
            btnSelectFiles.setEnabled(false);
        }
    }//GEN-LAST:event_btnOKUsersMouseClicked

    /**
     * Read each information about the others data then users information.
     */
    private void btnEnviarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarDadosMouseClicked
        if (btnEnviarDados.isEnabled()) {
            try {
                if (filesData.length == 3 && filesData != null) {
                    for (File f : filesData) {
                        if (f.getName().equals("device.csv")) {
                            filereader.read_input(tree, f);
                            System.out.println("Terminou de ler o DEVICE");
                        }
                        if (f.getName().equals("http.csv")) {
                            filereader.read_http(tree, f);
                            System.out.println("Terminou de ler o HTTP");
                        }
                        if (f.getName().equals("logon.csv")) {
                            filereader.read_logon(tree, f);
                            System.out.println("Terminou de ler o LOGON");
                        }
                    }

                    btnUtilizacao.setEnabled(false);
                    btnGerar.setEnabled(true);
                    btnEnviarDados.setEnabled(false);
                    System.out.println("Leitura realizada de tudo!");
                }
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Você não selecionou os 3 arquivos necessários.", "Erro na leitura!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnEnviarDadosMouseClicked

    private void rbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPeriodoActionPerformed
        txtDataFinal.setEnabled(true);
        txtDataInicio.setEnabled(true);
        txtDataInicio.setEditable(true);
        lblDataInicio.setText("Data (início):");
    }//GEN-LAST:event_rbPeriodoActionPerformed

    private void rbTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTudoActionPerformed
        txtDataFinal.setEnabled(false);
        txtDataInicio.setEnabled(false);
    }//GEN-LAST:event_rbTudoActionPerformed

    private void rbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataActionPerformed
        txtDataFinal.setEnabled(false);
        txtDataInicio.setEnabled(true);
        lblDataInicio.setText("Data:");
    }//GEN-LAST:event_rbDataActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarDados;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnOKUsers;
    private javax.swing.JButton btnSelectFiles;
    private javax.swing.JButton btnUtilizacao;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDatasInfo;
    private javax.swing.JLabel lblObsFiles;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JLabel lblSelectFiles;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JRadioButton rbData;
    private javax.swing.ButtonGroup rbFiltro;
    private javax.swing.JRadioButton rbPeriodo;
    private javax.swing.JRadioButton rbTudo;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicio;
    // End of variables declaration//GEN-END:variables
}
