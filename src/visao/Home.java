/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.InvalidDate;
import controle.NullSpecificUser;
import dominio.Date;
import dominio.Device;
import dominio.Distance;
import dominio.FileReader;
import dominio.Tree_insiders;
import dominio.User;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
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
    User user1;
    User user2;
    private Cursor waitCursor;
    private Cursor defaultCursor;

    /**
     * Cria novo JForm, além de adicionar o icone e realizar as configurações
     * iniciais como inicializar a árvore e o leitor dos arquivos; configurar os
     * cursores e o estado de acesso de cada botão.
     */
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            setIcon();
        } catch (NullPointerException ex) {
            //Nothing, it's not important.
        }
        tree = new Tree_insiders();
        filereader = new FileReader();

        waitCursor = new Cursor(Cursor.WAIT_CURSOR);
        defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        btnNext.setEnabled(false);
        btnUtilizacao.setEnabled(false);
        btnEnviarDados.setEnabled(false);
        btnInsiders.setEnabled(false);
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
        btnEnviarDados = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        rbData = new javax.swing.JRadioButton();
        rbPeriodo = new javax.swing.JRadioButton();
        rbTudo = new javax.swing.JRadioButton();
        lblOrdenar = new javax.swing.JLabel();
        btnOKUsers = new javax.swing.JButton();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        lblDatasInfo = new javax.swing.JLabel();
        lblDataFim = new javax.swing.JLabel();
        lblDataInicio = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblVersion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnInsiders = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtRoleUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        btnEnviarDados.setText("Enviar");
        btnEnviarDados.setEnabled(false);
        btnEnviarDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarDadosMouseClicked(evt);
            }
        });

        jPanel6.setBackground(java.awt.Color.white);

        rbData.setBackground(new java.awt.Color(255, 255, 255));
        rbFiltro.add(rbData);
        rbData.setText("Data específica");
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

        btnOKUsers.setText("Ler dados dos usuários");
        btnOKUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKUsersMouseClicked(evt);
            }
        });

        txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        lblDatasInfo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDatasInfo.setText("Insira as datas no formato: MM/dd/yyyy");

        lblDataFim.setText("Data(fim):");

        lblDataInicio.setText("Data (início):");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOrdenar)
                        .addGap(39, 39, 39)
                        .addComponent(rbPeriodo)
                        .addGap(18, 18, 18)
                        .addComponent(rbData)
                        .addGap(18, 18, 18)
                        .addComponent(rbTudo))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataInicio)
                            .addComponent(lblDataFim)
                            .addComponent(lblDatasInfo))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDataInicio)
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnOKUsers)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPeriodo)
                    .addComponent(lblOrdenar)
                    .addComponent(rbData)
                    .addComponent(rbTudo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOKUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataInicio)
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataFim)
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDatasInfo)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnUtilizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSelectFiles)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblObsFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectFiles)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectFiles)
                    .addComponent(jLabel1)
                    .addComponent(lblObsFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnUtilizacao)
                    .addComponent(btnEnviarDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVersion.setText("Versão 0.2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lblVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INSIDE THREAT");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logopequena.png"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel5.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnNext.setText("Próximo");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnInsiders.setText("Buscar Threats");
        btnInsiders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsidersMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setText("Insira o nome da profissão:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRoleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsiders)
                .addGap(48, 48, 48))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInsiders, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre uma caixa de diálogo para selecionar os arquivos que contém as
     * informações dos usuários.
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
     * Abre uma caixa de diálogo para selecionar os arquivos contendo as ações
     * de cada usuário.
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
     * Botão para a realização da leitura das informações dos usuários
     * selecionadas, assim como a lógica pelo sistema de datas. Além de
     * configurar os estados dos botões.
     */
    private void btnOKUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKUsersMouseClicked
        boolean validas = validardatas();
        if (filesUsers != null && btnOKUsers.isEnabled() && validas) {
            this.setCursor(waitCursor);
            System.out.println("Começou a ler o LDAP");

            String dataInicio = "";
            String dataFinal = "";

            if (rbPeriodo.isSelected()) {
                dataInicio = txtDataInicio.getText();
                dataFinal = txtDataFinal.getText();
            } else if (rbData.isSelected()) {
                dataInicio = txtDataInicio.getText();
                dataFinal = txtDataInicio.getText();
            } else {
                dataInicio = "01/01/1900";
                dataFinal = "11/25/2018";
            }

            for (File f : filesUsers) {
                filereader.read_ldap(tree, f, dataInicio, dataFinal);
            }
            System.out.println("Terminou de ler o LDAP");

            btnUtilizacao.setEnabled(true);
            btnOKUsers.setEnabled(false);
            btnEnviarDados.setEnabled(true);
            btnSelectFiles.setEnabled(false);
            this.setCursor(defaultCursor);
        }
    }//GEN-LAST:event_btnOKUsersMouseClicked

    /**
     * Lê os dados de ações dos usuários, como o dispositivo, urls acessadas, e
     * quais os dispositivos inseridos na máquina.
     */
    private void btnEnviarDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarDadosMouseClicked
        if (btnEnviarDados.isEnabled()) {
            this.setCursor(waitCursor);
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
                    btnNext.setEnabled(true);
                    btnInsiders.setEnabled(true);
                    btnEnviarDados.setEnabled(false);
                    System.out.println("Leitura realizada de tudo!");
                    this.setCursor(defaultCursor);
                    tree.createDiagram();
                }
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Você não selecionou os 3 arquivos necessários.", "Erro na leitura!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnEnviarDadosMouseClicked

    /**
     * Configurar os estados de inserção nas caixas de textos, caso selecionado
     * o período entre datas.
     */
    private void rbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPeriodoActionPerformed
        txtDataFinal.setEnabled(true);
        txtDataInicio.setEnabled(true);
        txtDataInicio.setEditable(true);
        lblDataInicio.setText("Data (início):");
    }//GEN-LAST:event_rbPeriodoActionPerformed

    /**
     * Configurar os estados de inserção nas caixas de textos, caso selecionado
     * tudo.
     */
    private void rbTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTudoActionPerformed
        txtDataFinal.setEnabled(false);
        txtDataInicio.setEnabled(false);
    }//GEN-LAST:event_rbTudoActionPerformed

    /**
     * Configurar os estados de inserção nas caixas de textos, caso selecionado
     * uma data específica.
     */
    private void rbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDataActionPerformed
        txtDataFinal.setEnabled(false);
        txtDataInicio.setEnabled(true);
        lblDataInicio.setText("Data:");
    }//GEN-LAST:event_rbDataActionPerformed

    /**
     * Inicializar uma nova janela.
     */
    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        FilterByUser frame = new FilterByUser(tree);
        frame.setVisible(true);
    }//GEN-LAST:event_btnNextMouseClicked

    /**
     * Realizar a busca por um infiltrado em um papel específico. E inicializar
     * uma nova janela para apresentar os dados do resultado.
     */
    private void btnInsidersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsidersMouseClicked
        try {
            Vector<Distance> lista = tree.analyzerByCategory(txtRoleUser.getText(), true);
            Insiders insiders = new Insiders(lista);
            insiders.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Nome de papel inválido. Verifique o papel.", "Inválido!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInsidersMouseClicked

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
    private javax.swing.JButton btnInsiders;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOKUsers;
    private javax.swing.JButton btnSelectFiles;
    private javax.swing.JButton btnUtilizacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
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
    private javax.swing.JTextField txtRoleUser;
    // End of variables declaration//GEN-END:variables

    /**
     * Modificar o icone da janela.
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/logokkk.png")));
    }

    private boolean validardatas() {
        try{
            
            if(rbTudo.isSelected())
                return true;
            
            
            String finalDate;
            String[] dataFi;
            String[] dataIn = txtDataInicio.getText().split("/");
            if(txtDataFinal.getText().equals("")){
                finalDate = "11/30/2020";
                dataFi = finalDate.split("/");
            }else{
                dataFi = txtDataFinal.getText().split("/");
            }
            
            if(Integer.parseInt(dataIn[2]) <= Integer.parseInt(dataFi[2]) ){
                if(Integer.parseInt(dataIn[1]) > 0 && Integer.parseInt(dataFi[1]) > 0 &&
                        Integer.parseInt(dataIn[1]) < 32  && Integer.parseInt(dataFi[1]) < 32 &&
                        Integer.parseInt(dataIn[0]) <= 12  && Integer.parseInt(dataFi[0]) <= 12 &&
                        Integer.parseInt(dataIn[0]) > 0  && Integer.parseInt(dataFi[0]) > 0){
                    if(Integer.parseInt(dataIn[0]) == Integer.parseInt(dataFi[0])){
                        if(Integer.parseInt(dataIn[1]) <= Integer.parseInt(dataFi[1])){
                            return true;
                        } else{
                            throw new InvalidDate();
                        }
                    }
                    
                    return true;
                    
                } else{
                    throw new InvalidDate();
                }
            } else{
                throw new InvalidDate();
            }
        } catch( InvalidDate ex ){
            JOptionPane.showMessageDialog(this, "Data(s) inválidas.");
        }
        
        return false;
    }
}
