package view;

import control.ControlAutomato;
import java.util.ArrayList;
import model.Automato;
import javax.swing.JOptionPane;

public class TelaPesquisa extends javax.swing.JFrame {
    
    private String caminho;
    private Automato auto;
    private ControlAutomato controlAuto;
    private final ArrayList <Object> passos;
    private TelaPassos tela;
    
    public TelaPesquisa(String caminho) {
        initComponents();
        this.setResizable(false);
        this.caminho = caminho;
        this.passos = new ArrayList<>();
        this.jLabelCaminhoArquivo.setText(this.caminho);
        this.jTextFieldPalavra.setText("");
        this.tela = null;
    }
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
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

        jTextFieldPalavra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonPesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelCaminhoArquivo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jButtonPassos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Palavra de pesquisa:");

        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Arquivo:");

        jLabelCaminhoArquivo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCaminhoArquivo.setText("Caminho Aqui!");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Pesquisa no Automato");

        jButtonInfo.setText("Informações");
        jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfoActionPerformed(evt);
            }
        });

        jButtonPassos.setText("Passo a Passo");
        jButtonPassos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCaminhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPassos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelCaminhoArquivo))
                .addGap(18, 18, 18)
                .addComponent(jButtonInfo)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisa)
                    .addComponent(jButtonPassos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(454, 220));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        
        this.controlAuto = new ControlAutomato();
        
        //Salva a palavra do campo pesquisa para o automato
        if(this.jTextFieldPalavra.getText().equals(""))
            this.auto.setPalavra("E");
        else
            this.auto.setPalavra(this.jTextFieldPalavra.getText().toUpperCase()); 
        
        boolean palavraAceita = this.controlAuto.inicializaPesquisa(this.auto, this.passos);
               if(palavraAceita){
            int opcao = JOptionPane.showConfirmDialog(null, "Esta palavra pertence ao automato!\n" + "Deseja Pesquisar uma nova palavra?");
            if(opcao == JOptionPane.NO_OPTION){
                this.dispose();
            }else{
                this.jTextFieldPalavra.setText("");
            }
        }else{
            int opcao = JOptionPane.showConfirmDialog(null, "Esta palavra não pertence ao automato!\n" + "Deseja Pesquisar uma nova palavra?");
            if (opcao == JOptionPane.NO_OPTION) {
                this.dispose();
            }else{
                this.jTextFieldPalavra.setText("");
            }
        }
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed
        
        String alfabeto = this.auto.alfabeto[0];
        for(int i=1; i<this.auto.getAlfabeto().length; i++)
            alfabeto = alfabeto + ", " + this.auto.alfabeto[i];
        
        if(this.auto.getDescricao().equals("")){
            JOptionPane.showMessageDialog(null, "Informações sobre o automato!\n" + "\nTipo: " + this.auto.getTipo() + "\nNº de Estados: " 
            + this.auto.getnEstados() + "\n" + "Nº de Transições: " + this.auto.getnTransicoes() + "\nAlfabeto: " +"{" + alfabeto + "}" + "\nDescrição: Não possui");
        }else{
            JOptionPane.showMessageDialog(null, "Informações sobre o automato!\n" + "\nTipo: " + this.auto.getTipo() + "\nNº de Estados: " 
            + this.auto.getnEstados() + "\nNº de Transições: " + this.auto.getnTransicoes() + "\nAlfabeto: " +"{" + alfabeto + "}" + "\nDescrição: " + this.auto.getDescricao());
        }
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonPassosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassosActionPerformed
        
        this.controlAuto = new ControlAutomato();
        this.passos.clear();
        
        //Salva a palavra do campo pesquisa para o automato
        if(this.jTextFieldPalavra.getText().equals(""))
            this.auto.setPalavra("E");
        else
            this.auto.setPalavra(this.jTextFieldPalavra.getText().toUpperCase());
        
        boolean palavraAceita = this.controlAuto.inicializaPesquisa(this.auto, this.passos);
        
        if(this.tela == null){
            this.tela = new TelaPassos(this.auto, this.passos, this.auto.getPalavra(), palavraAceita);
            this.tela.setVisible(true);
        }else{
            this.tela = new TelaPassos(this.auto, this.passos, this.auto.getPalavra(), palavraAceita);
            this.tela.setVisible(true);
        }
    }//GEN-LAST:event_jButtonPassosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonPassos;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCaminhoArquivo;
    private javax.swing.JTextField jTextFieldPalavra;
    // End of variables declaration//GEN-END:variables
}
