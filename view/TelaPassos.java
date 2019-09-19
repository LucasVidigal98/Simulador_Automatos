package view;

import control.ControlAutomato;
import java.util.ArrayList;
import model.Automato;

public class TelaPassos extends javax.swing.JFrame {
    
    private Automato auto;
    private ArrayList <Object> passos;
    private int posicao;
    private final String palavraPesquisa;
    private String caminhoFinal = "";
    private final boolean palavraAceita;
    private boolean inicio;
    
    public TelaPassos(Automato auto, ArrayList <Object> passos, String palavraPesquisa, boolean palavraAceita) {
        initComponents();
        this.setResizable(false);
        this.auto = auto;
        this.passos = passos;
        this.posicao = 1;
        this.palavraPesquisa = palavraPesquisa;
        this.palavraAceita = palavraAceita;
        this.inicio = false;
        if(!this.ehPalavraVazia()){
            this.jTextAreaPassos.setText("Aperte Próximo para ver a sequência de passos!\n");
            this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + "--------------------------------------------------------------\n");
            this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + "Palavra a ser processada = " 
                    + this.palavraPesquisa + "\n");
        }
    }
    
    private boolean ehPalavraVazia(){
        
        if (this.palavraAceita && this.palavraPesquisa.equals("E")) {
            this.jTextAreaPassos.setText("O automato aceia a palavra vazia!\n"
                    + "Feche a janela para pesquisar uma nova palavra!\n");
            this.jButtonProximo.setEnabled(false);
            return true;
        } else if (!this.palavraAceita && this.palavraPesquisa.equals("E")) {
            this.jTextAreaPassos.setText("O automato não aceita a palavra vazia!\n"
                    + "Feche a janela para pesquisar uma nova palavra!\n");
            this.jButtonProximo.setEnabled(false);
            return true;
        }
        
        return false;
    }

    public ArrayList<Object> getPassos() {
        return passos;
    }

    public void setPassos(ArrayList<Object> passos) {
        this.passos = passos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaPassos = new javax.swing.JTextArea();
        jButtonProximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaPassos.setEditable(false);
        jTextAreaPassos.setColumns(20);
        jTextAreaPassos.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jTextAreaPassos.setRows(100);
        jTextAreaPassos.setTabSize(18);
        jTextAreaPassos.setFocusCycleRoot(true);
        jScrollPane2.setViewportView(jTextAreaPassos);

        jButtonProximo.setText("Próximo");
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonProximo))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(635, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        ControlAutomato control = new ControlAutomato();
        
        if(this.posicao == 1) this.inicio = true;
        
        if(this.posicao < this.passos.size()){
        
            String passo;
            String caminho = "";
            String estadoAtual = "";
            String simboloAtual = "";
            boolean processou = false;

            int i = this.posicao;
            while(!this.passos.get(i).toString().substring(0, 1).equals("I")){
                
                switch (this.passos.get(i).toString().substring(0, 1)) {
                    case "S":
                        processou = true;
                        if(this.inicio) this.jTextAreaPassos.setText("INICIO\n");
                        passo = "Simbolo a ser processado = " + this.passos.get(i).toString().substring(1, 2) + "\n";
                        this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + passo);
                        simboloAtual = this.passos.get(i).toString().substring(1, 2);
                        break;
                    case "E":
                        processou = true;
                        if(this.inicio){
                            passo = "Estado Inicial = Q" + this.passos.get(i).toString().substring(1, 2) + "\n";
                            estadoAtual = this.passos.get(i).toString().substring(1, 2);
                            caminho = "->Q"+ estadoAtual;
                            this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + passo);
                            this.inicio = false;
                        }else{
                            passo = "Estado a ser expandido = Q" + this.passos.get(i).toString().substring(1, 2) + "\n";
                            estadoAtual = this.passos.get(i).toString().substring(1, 2);
                            this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + passo);
                        }   break;
                    case "V":
                        processou = true;
                        passo = "Vizinho de Q" + estadoAtual + " Com transição " + simboloAtual + " = Q" + this.passos.get(i).toString().substring(1, 2) + "\n";
                        if(control.ehEstadoFinal(auto, Integer.parseInt(this.passos.get(i).toString().substring(1, 2))))
                            caminho = caminho + " - *Q" + this.passos.get(i).toString().substring(1, 2);
                        else
                            caminho = caminho + " - Q" + this.passos.get(i).toString().substring(1, 2);
                        this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + passo);
                        break;
                    default:
                        break;
                }
                
                i++;
            }
            
            if(processou){
                this.caminhoFinal = this.caminhoFinal + caminho;
                String aux = "\n";
                this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + this.caminhoFinal + aux);
            }
            
            this.jTextAreaPassos.setText(this.jTextAreaPassos.getText() + "--------------------------------------------------------------\n");
            this.posicao = i + 1;
            
        }else{
            
            this.jButtonProximo.setEnabled(false);
            if(this.palavraAceita)
                this.jTextAreaPassos.setText((this.jTextAreaPassos.getText() + "A PALAVRA É ACEITA!"));
            else
                this.jTextAreaPassos.setText((this.jTextAreaPassos.getText() + "A PALAVRA NÃO É ACEITA!"));
        }
    }                                              

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaPassos;
    // End of variables declaration                   
}
