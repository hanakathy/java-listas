package Adicao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaAdicao extends JFrame {
    
    //declarar componentes da tela
    JPanel painel = new JPanel();
    JLabel lblNum1 = new JLabel("Número 1: ");
    JLabel lblNum2 = new JLabel("Número 2: ");
    JLabel lblResultado = new JLabel("Resultado");
    JTextField txtNum1 = new JTextField();
    JTextField txtNum2 = new JTextField();
    JButton btnSomar = new JButton("Somar");
    
    //modificar o construtor
    //organizar componentes na janela
    public TelaAdicao(){
        
        iniciarComponentes();
        
    }
    
    public static void main(String[] args){
        
        //carregar janela
        new TelaAdicao();
    }
    
    private void iniciarComponentes(){
        
        GridLayout grid = new GridLayout(3, 2, 5, 5);
        painel.setLayout(grid);
        
        painel.add(lblNum1);
        painel.add(txtNum1);
        painel.add(lblNum2);
        painel.add(txtNum2);
        painel.add(btnSomar);
        painel.add(lblResultado);
        
        //adicionar o painel à janela
        add(painel);
        
        btnSomar.addActionListener(new SomarListener());
        
        //configuraçoes da janela
        setTitle("Tela de adição de valores");
        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    
        //criar classe aninhada
        //definit ação do botão somar
        class SomarListener implements ActionListener{
            
            public void actionPerformed(ActionEvent e){
                
                //verificar os campos vazios
                
                if ( txtNum1.getText().trim().equals("") ) {
                    if ( txtNum2.getText().trim().equals("") ){
                        JOptionPane.showMessageDialog(null, "Preencha os campos Número 1 e Número 2");
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Preencha o campo Número 1");
                    }
                }else{
                    if ( txtNum2.getText().trim().equals("") ){
                        JOptionPane.showMessageDialog(null, "Preencha o campo Número 2");
                    }
                }
                
                //recuperar valores da tela
                double num1 = Double.parseDouble(txtNum1.getText());
                double num2 = Double.parseDouble(txtNum2.getText());
                
                //instanciar classe modelo
                Adicao ad = new Adicao(num1, num2);
                //executar método
                double resultado = ad.somar();
                
                lblResultado.setText(Double.toString(resultado));
                
            }
               
            }
            
        
        
    }
