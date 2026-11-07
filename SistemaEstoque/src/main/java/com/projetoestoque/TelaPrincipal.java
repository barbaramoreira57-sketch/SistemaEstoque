/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.projetoestoque;
public class TelaPrincipal extends javax.swing.JPanel {
    public TelaPrincipal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnMovimentacao = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();

        jLabel1.setText("SISTEMA DE CONTROLE DE ESTOQUE ");

        jButton1.setText("Cadastrar Produto ");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Consultar Produtos");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        btnMovimentacao.setText("Movimentar Estoque");
        btnMovimentacao.addActionListener(this::btnMovimentacaoActionPerformed);

        jButton4.setText("Sair");

        btnHistorico.setText("Historico de Movimentação");
        btnHistorico.addActionListener(this::btnHistoricoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(btnMovimentacao)
                            .addComponent(btnHistorico)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton4)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMovimentacao)
                .addGap(18, 18, 18)
                .addComponent(btnHistorico)
                .addGap(33, 33, 33)
                .addComponent(jButton4)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

TelaCadastro tela = new TelaCadastro();
tela.setLocationRelativeTo(null);
tela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
TelaConsulta tela = new TelaConsulta();
tela.setLocationRelativeTo(null);
tela.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentacaoActionPerformed
TelaMovimentacao tela = new TelaMovimentacao();
tela.setLocationRelativeTo(null);
tela.setVisible(true);
    }//GEN-LAST:event_btnMovimentacaoActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed

TelaHistorico tela = new TelaHistorico();
tela.setLocationRelativeTo(null);
tela.setVisible(true);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnMovimentacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
