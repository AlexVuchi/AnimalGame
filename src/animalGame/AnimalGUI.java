
//Animal Game GUI
//Alex Vucicevich
//Leon Fattakhov
//Eric Li

//Monday

package animalGame;

//Imports
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class AnimalGUI extends javax.swing.JFrame {
   
   //Fields
    
   //Objects
   AnimalGame ag;
   AnimalReader ar; 
   
   //Question string
   String questionAsked = "";

   //Constructor
   public AnimalGUI(){
        initComponents();
        ar = new AnimalReader("animals");
        ag = new AnimalGame(ar.getAnimalList(), ar.numAnimals);

    }
    //Background
    public Image getImage() throws IOException{
        BufferedImage backGround = ImageIO.read(new File("FreeVector-Jungle-Background.png"));
        return backGround;
    }
    
    //Nick Wilde
    public Image getImage2() throws IOException{
        BufferedImage wilde = ImageIO.read(new File("Nick_Wilde.png"));
        return wilde;
    }
    
    //Speech Bubble
    public Image getImage3() throws IOException{
        BufferedImage speech = ImageIO.read(new File("speech.png"));
        return speech;
    }
    
    public void buttonPressMethod(){
        
        if(ag.numAnimals != 1){
            questionAsked = ag.findNextQuestion(ag.animalList);
            textPane.setText(questionAsked);
        }
        else{
            textPane.setText(ag.printAnswer());
        }
        
    }
    
    //Drawing buttons and jPanes in a GUI
    //add(thing) - adds for example "button" to the jLayeredPane
    public void drawJPanes(){
        //Try used for buffered image IOException
        try{
        
        //Text Pane
        //Displays Text
        textPane.setSize(215,100);
        textPane.setLocation(115,250);
        textPane.setText("Welcome To Animal Guesser");
        add(textPane);
        
        //Start Button
        //Starts initial question / program
        startButton.setSize(150,50);
        startButton.setLocation(100,750);
        startButton.setText("Start");
        add(startButton);
        
        //No Button
        //Returns "FALSE" and sets next question
        noButton.setSize(100,50);
        noButton.setLocation(200,700);
        add(noButton);
        
        //Yes Button
        //Returns "True" and sets next question
        yesButton.setSize(100,50);
        yesButton.setLocation(50,700);
        add(yesButton);
        
        //Speech Bubble Image
        Image c = getImage3();
        jLabel3.setIcon(new ImageIcon(c));
        jLabel3.setSize(500,500);
        jLabel3.setLocation(50,50);
        add(jLabel3);
        
        //Nick Wilde xD
        Image b = getImage2();
        nickWilde.setIcon(new ImageIcon(b));
        nickWilde.setSize(200,400);
        nickWilde.setLocation(300,450);
        add(nickWilde);
        
        //Background Image
        Image a = getImage();
        background.setIcon(new ImageIcon(a));
        background.setSize(500,800);
        add(background);

        }
        catch (IOException e){
            System.out.println("BREAKING");}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layeredPane = new javax.swing.JLayeredPane();
        yesButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        noButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        nickWilde = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yesButton.setBackground(new java.awt.Color(0, 240, 0));
        yesButton.setFont(new java.awt.Font("Goudy Stout", 0, 18)); // NOI18N
        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.setBackground(new java.awt.Color(0, 240, 0));
        noButton.setFont(new java.awt.Font("Goudy Stout", 0, 18)); // NOI18N
        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        textPane.setFont(new java.awt.Font("Goudy Stout", 0, 11)); // NOI18N
        textPane.setAutoscrolls(false);
        jScrollPane2.setViewportView(textPane);

        nickWilde.setText("jLabel2");

        startButton.setText("jButton3");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        layeredPane.setLayer(yesButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(background, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(noButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(nickWilde, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(startButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPaneLayout = new javax.swing.GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGap(191, 191, 191))
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yesButton)
                        .addGap(29, 29, 29)
                        .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(nickWilde)
                .addGap(0, 82, Short.MAX_VALUE))
        );
        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(nickWilde)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3))
                    .addGroup(layeredPaneLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(startButton)))
                .addContainerGap(544, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layeredPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Buttons
    
    //Yes Button
    //Answers the question previously displayed in the text pane (TRUE)
    //Sets the next text using using findNextQuestion 
    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        
        ag.animalList = ag.getNewAnimalList(true,questionAsked).clone();
        buttonPressMethod();
    
    }//GEN-LAST:event_yesButtonActionPerformed
    
    //No Button
    //Answers the question previously displayed in the text pane (FALSE)
    //Sets the next text using using findNextQuestions
    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed

        ag.animalList = ag.getNewAnimalList(false,questionAsked).clone();
        buttonPressMethod();

    }//GEN-LAST:event_noButtonActionPerformed

    //Start Button
    //Asks first question when pressed using findNextQuestion (TRUE)
    //Sets text pane to be that question
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        questionAsked = ag.findNextQuestion(ag.animalList);
        textPane.setText(questionAsked);

    }//GEN-LAST:event_startButtonActionPerformed

    //Main
    public static void main(String args[]){

        
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
            java.util.logging.Logger.getLogger(AnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            //Set the panes visible
            //Draws buttons
            
            public void run() {
                AnimalGUI ab = new AnimalGUI();
                ab.setVisible(true);
                ab.drawJPanes();
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JLabel nickWilde;
    private javax.swing.JButton noButton;
    private javax.swing.JButton startButton;
    private javax.swing.JTextPane textPane;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
