package Pessoa;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class TelaPessoa extends JFrame{
    
    //Componentes 
    JPanel painel = new JPanel();
    JLabel lblDtNasc = new JLabel("Data de nascimento (dd/mm/aaaa): ");
    JLabel lblIdade = new JLabel("Idade: ");
    JTextField txtData = new JTextField();
    JTextArea txtIdade = new JTextArea();
    JButton btnCalcIdade = new JButton("Calcular Idade");
    
    public TelaPessoa(){
        iniciarComponentes();
    }
    
    public static void main (String [] args){
        new TelaPessoa();
    }
    
    public void iniciarComponentes(){
        GridLayout grid = new GridLayout(1, 2);
        painel.setLayout(grid);
        
        painel.add(lblDtNasc);
        painel.add(txtData);
        painel.add(btnCalcIdade);
        painel.add(lblIdade);
        painel.add(txtIdade);
        
        //Adicionando painel
        add(painel);
        
        btnCalcIdade.addActionListener(new CalcIdadeListener());
        
        //Configurando a janela
        setTitle("Calculando a Idade");
        setBounds(70, 100, 875, 20);
        setVisible(true);
    }
    
    class CalcIdadeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //Recuperando valores da Tela
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            
            String Data = txtData.getText();
            LocalDate dataNascimento = LocalDate.parse(Data, formatter);
                        
            Pessoa pes = new Pessoa(dataNascimento);
            
            int idade = pes.calcIdade(2017);
            
            txtIdade.setText(Integer.toString(idade));
        }
        
    }
}
