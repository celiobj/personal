/**
 *
 * @author Amila
 */
public class ClockWindow extends javax.swing.JFrame {

    /** Creates new form ClockWindow */
    public ClockWindow() {
        initComponents();

		ClockComponent clock = new ClockComponent();
		clock.setSize(500, 500);
		clockPanel.add(clock);
		clock.fireUpdate.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        transparentFace = new javax.swing.JLabel();
        clockPanel = new javax.swing.JPanel();
        clockLabel1 = new javax.swing.JLabel();
        clockLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Analog Clock");
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(218, 218, 255));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setRequestFocusEnabled(false);

        transparentFace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clock.png"))); // NOI18N
        transparentFace.setBounds(0, 0, 400, 400);
        jLayeredPane1.add(transparentFace, javax.swing.JLayeredPane.PALETTE_LAYER);

        clockPanel.setOpaque(false);

        javax.swing.GroupLayout clockPanelLayout = new javax.swing.GroupLayout(clockPanel);
        clockPanel.setLayout(clockPanelLayout);
        clockPanelLayout.setHorizontalGroup(
            clockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        clockPanelLayout.setVerticalGroup(
            clockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        clockPanel.setBounds(0, 0, 400, 400);
        jLayeredPane1.add(clockPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        clockLabel1.setFont(new java.awt.Font("Script MT Bold", 1, 11)); // NOI18N
        clockLabel1.setText("QUARTZ");
        clockLabel1.setBounds(180, 80, 50, 14);
        jLayeredPane1.add(clockLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        clockLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 11)); // NOI18N
        clockLabel2.setText("Made In Sri Lanka");
        clockLabel2.setBounds(150, 330, 120, 14);
        jLayeredPane1.add(clockLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClockWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel1;
    private javax.swing.JLabel clockLabel2;
    private javax.swing.JPanel clockPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel transparentFace;
    // End of variables declaration//GEN-END:variables

}
