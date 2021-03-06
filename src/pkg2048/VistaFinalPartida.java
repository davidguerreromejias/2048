/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048;

/**
 *
 * @author Octavi
 */
public class VistaFinalPartida extends javax.swing.JFrame {

    private CPJugarPartida CPJugar;

    /**
     * Creates new form VistaFinalPartida
     */
    public VistaFinalPartida() {
        initComponents();
        CPJugar = null;
    }
    
    public VistaFinalPartida(boolean guanyat, CPJugarPartida cp, String punt) {
        initComponents();
        CPJugar = cp;
        txtPuntuacio.setText(punt);
        if(guanyat) lblInfo.setText("Has guanyat la partida!");
        else lblInfo.setText("<html><body><center>Has perdut.<br> No és possible fer més moviments.</body></html>");//"Has perdut.<br>No és possible fer més moviments."
    }
    
    void setCPJugar(CPJugarPartida cp){
        CPJugar = cp;
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        lblPuntuacio = new javax.swing.JLabel();
        txtPuntuacio = new javax.swing.JTextField();
        lblInfo = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final");

        btnJugar.setText("Jugar");
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnJugarMousePressed(evt);
            }
        });

        btnRanking.setText("Ranking");
        btnRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRankingMousePressed(evt);
            }
        });

        lblPuntuacio.setText("Puntuació:");

        txtPuntuacio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPuntuacio.setFocusable(false);

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("buu");
        lblInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblInfo.setFocusable(false);
        lblInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPuntuacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPuntuacio))
                    .addComponent(btnJugar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRanking, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJugar)
                .addGap(1, 1, 1)
                .addComponent(btnRanking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntuacio)
                    .addComponent(txtPuntuacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMousePressed
        CPJugar.inicializarPartida();
    }//GEN-LAST:event_btnJugarMousePressed

    private void btnRankingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRankingMousePressed
        CPJugar.inicializarRanking();
    }//GEN-LAST:event_btnRankingMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPuntuacio;
    private javax.swing.JTextField txtPuntuacio;
    // End of variables declaration//GEN-END:variables
}
