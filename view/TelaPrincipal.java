package view;

import entrada.Arquivo;
import model.Automato;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    private Automato auto;
    private TelaPesquisa telaAuto;
    
    public TelaPrincipal() {
        initComponents();
        this.setResizable(false);
    }

    public Automato getAuto() {
        return auto;
    }

    public void setAuto(Automato auto) {
        this.auto = auto;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonCarregarAFD = new javax.swing.JButton();
        jButtonCarregarAFN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Simulador de Automatos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 40));

        jButtonCarregarAFD.setText("Carregar AFD");
        jButtonCarregarAFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarAFDActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarregarAFD, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 220, 60));

        jButtonCarregarAFN.setText("Carregar AFN");
        jButtonCarregarAFN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarAFNActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCarregarAFN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 220, 60));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lucas de Freitas Vidigal©");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 380, -1));

        jLabelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/plano-de-fundo-discador-.png"))); // NOI18N
        getContentPane().add(jLabelBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 430));

        setSize(new java.awt.Dimension(686, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCarregarAFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarAFDActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(jButtonCarregarAFD) == JFileChooser.APPROVE_OPTION){
            File afd = jfc.getSelectedFile();
            Arquivo arq = new Arquivo(afd.toString(), "AFD");
            this.auto = arq.leituraArquivo();
            if(this.auto != null){
                if(this.telaAuto == null){
                    this.telaAuto = new TelaPesquisa(afd.toString());
                    this.telaAuto.setAuto(this.auto);
                    this.telaAuto.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Novo Automato gerado!");
                    this.telaAuto = new TelaPesquisa(afd.toString());
                    this.telaAuto.setAuto(this.auto);
                    this.telaAuto.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jButtonCarregarAFDActionPerformed

    private void jButtonCarregarAFNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarAFNActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(jButtonCarregarAFN) == JFileChooser.APPROVE_OPTION){
            File afn = jfc.getSelectedFile();
            Arquivo arq = new Arquivo(afn.toString(), "AFN");
            this.auto = arq.leituraArquivo();
            if(this.auto != null){
                if(this.telaAuto == null){
                    this.telaAuto = new TelaPesquisa(afn.toString());
                    this.telaAuto.setAuto(this.auto);
                    this.telaAuto.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Novo Automato gerado!");
                    this.telaAuto = new TelaPesquisa(afn.toString());
                    this.telaAuto.setAuto(this.auto);
                    this.telaAuto.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jButtonCarregarAFNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarregarAFD;
    private javax.swing.JButton jButtonCarregarAFN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBackGround;
    // End of variables declaration//GEN-END:variables
}