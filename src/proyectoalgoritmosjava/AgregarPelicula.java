/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalgoritmosjava;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gollo
 */
public class AgregarPelicula extends JInternalFrame implements ActionListener{
    
    private JLabel jlblCode;
    private JLabel jlblTitle;
    private JLabel jlblGender;
    private JLabel jlblTotal;
    private JLabel jlblSubtitled;
    private JLabel jlblPremier;
    
    private JTextField jtxtCode;
    private JTextField jtxtTitle;
    private JTextField jtxtTotal;
    
    private JCheckBox jcbPremier;
    private JCheckBox jcbSubtitled;
    
    private JComboBox<String> genero;
    private JButton jbtnAgregar;
    
    public AgregarPelicula(){
        super("Agregar Pelicula");
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(new Dimension(280,280));
        
        this.jlblCode=new JLabel("Code:");
        this.jlblCode.setBounds(10, 10, 100, 30);
        this.jlblTitle=new JLabel("Title:");
        this.jlblTitle.setBounds(10, 40, 100, 30);
        this.jlblGender=new JLabel("Gender:");
        this.jlblGender.setBounds(10, 100, 100, 30);
        this.jlblTotal=new JLabel("Total:");
        this.jlblTotal.setBounds(10, 70, 100, 30);
        this.jlblSubtitled=new JLabel("Subtitled:");
        this.jlblSubtitled.setBounds(10, 130, 100, 30);
        this.jlblPremier=new JLabel("Premier:");
        this.jlblPremier.setBounds(10, 160, 100, 30);
        
        this.jtxtCode=new JTextField();
        this.jtxtCode.setBounds(100, 10, 100, 30);
        this.jtxtTitle=new JTextField();
        this.jtxtTitle.setBounds(100, 40, 100, 30);
        this.jtxtTotal=new JTextField();
        this.jtxtTotal.setBounds(100, 70, 100, 30);

        this.jcbPremier=new JCheckBox();
        this.jcbPremier.setBounds(100, 160, 30, 30);
        this.jcbSubtitled=new JCheckBox();
        this.jcbSubtitled.setBounds(100, 130, 30, 30);

        this.genero=new JComboBox<String>(new String[]{"Drama","Comedy","Action","Romance","Childish","Fiction"});
        this.genero.setBounds(100, 100, 100, 30);
        this.add(genero);
        
        this.add(jlblCode);
        this.add(jlblTitle);
        this.add(jlblGender);
        this.add(jlblTotal);
        this.add(jlblSubtitled);
        this.add(jlblPremier);
        
        this.add(jcbSubtitled);
        this.add(jcbPremier);
        
        this.add(jtxtCode);
        this.add(jtxtTitle);
        this.add(jtxtTotal);

        this.jbtnAgregar=new JButton("Agregar");
        this.jbtnAgregar.setBounds(10, 200, 100, 40);
        this.jbtnAgregar.addActionListener(this);
        this.add(this.jbtnAgregar);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtnAgregar){
            try {
                String gender="";
                if(this.genero.getSelectedItem().equals("Drama"))
                    gender="1000";
                else if(this.genero.getSelectedItem().equals("Action"))
                    gender="4000";
                else if(this.genero.getSelectedItem().equals("Comedy"))
                    gender="2000";
                else if(this.genero.getSelectedItem().equals("Fiction"))
                    gender="6000";
                else if(this.genero.getSelectedItem().equals("Romance"))
                    gender="5000";
                else if(this.genero.getSelectedItem().equals("Childish"))
                    gender="3000";
                String premier="";
                if(jcbPremier.isSelected()){
                    premier="1";
                }else premier="0";
                String subtitled="";
                if(jcbSubtitled.isSelected())
                    subtitled="1";
                else subtitled="0";
                Pelicula p=new Pelicula(jtxtCode.getText(), jtxtTitle.getText(), gender, jtxtTotal.getText(), subtitled, premier);
                Archivo a=new Archivo();
                GeneroList gL=a.cargarArchivo("all");
                gL.agregarPelicula(p);
                a.guardarArchivo(gL);
                JOptionPane.showMessageDialog(rootPane, "Pelicula Agregada");
                System.out.println(gL.printList());
            } catch (IOException ex) {
                Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}// AgregarPelicula
