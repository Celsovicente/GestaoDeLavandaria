/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: PecaVisao.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class PecaVisao extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    private boolean editar;

    public PecaVisao(boolean alterar, PecaModelo modelo)
    {

        super("Registrar Pecas");

        editar = alterar;

        definirTema();
        if(!alterar)
        {
            	getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        }
        else
            getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
         getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel
    {
        private JTextField idJTF, quantidadeJTF, dataEntregaJTF;
        private JComboBox tipoDePecaJCB, horarioJCB;
        private JTextFieldData txtData;
        private PecaFile file;

        public PainelCentro()
        {
            setLayout(new GridLayout(5, 2));
            file = new PecaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Tipo de Peca"));
            add(tipoDePecaJCB = UInterfaceBox.createJComboBoxsTabela2("TipoPeca.tab"));

            // 3º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());

            // 4º linha
            add(new JLabel("Data de Entrega"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);

            // 5º linha
            add(new JLabel("Horario"));
            add(horarioJCB = UInterfaceBox.createJComboBoxsTabela2("Horario.tab"));
        }

        // construtor com parametros
        public PainelCentro(PecaModelo modelo)
        {
            setLayout(new GridLayout(5, 2));
            file = new PecaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setText("" +modelo.getId());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Tipo de Peca"));
            add(tipoDePecaJCB = UInterfaceBox.createJComboBoxsTabela2("TipoPeca.tab"));
            tipoDePecaJCB.setSelectedItem(modelo.getTipoPeca());

            // 3º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());
            quantidadeJTF.setText("" +modelo.getQuantidade());

            // 4º linha
            add(new JLabel("Data de Entrega"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);
            txtData.getDTestField().setText(modelo.getDataEntrega());

            // 5º linha
            add(new JLabel("Horario"));
            add(horarioJCB = UInterfaceBox.createJComboBoxsTabela2("Horario.tab"));
            horarioJCB.setSelectedItem(modelo.getHorario());
        }

        // getters
        public int getId()
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getTipoPeca()
        {
            return String.valueOf(tipoDePecaJCB.getSelectedItem());
        }

        public int getQuantidade()
        {
            return Integer.parseInt(quantidadeJTF.getText().trim());
        }

        public String getDataEntrega()
        {
            return txtData.getDTestField().getText();
        }

        public String getHorario()
        {
            return String.valueOf(horarioJCB.getSelectedItem());
        }

        // metodos setters
        public void setId(int id)
        {
            idJTF.setText("" +id);
        }

        public void setTipoPeca(String tipoDePeca)
        {
            tipoDePecaJCB.setSelectedItem(tipoDePeca);
        }

        public void setQuantidade(int quantidade)
        {
            quantidadeJTF.setText("" + quantidade);
        }

        public void setDataEntrega(String dataEntrega)
        {
            txtData.getDTestField().setText(dataEntrega);
        }

        public void setHorario(String horario)
        {   
            horarioJCB.setSelectedItem(horario);
        } 
        // metodo salvar
        public void salvar()
        {
            PecaModelo modelo = new PecaModelo(
            getId(),
            getTipoPeca(),
            getQuantidade(),
            getDataEntrega(),
            getHorario(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvar();
            dispose();
        }

        // alterar
        public void alterar()
        {            
            PecaModelo modelo = new PecaModelo(
            getId(),
            getTipoPeca(),
            getQuantidade(),
            getDataEntrega(),
            getHorario(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvarDados();
            dispose();
        }
    }

    class PainelSul extends JPanel implements ActionListener
    {
        private JButton salvarJBT, cancelarJBT;
        
        public PainelSul()
        {
           setLayout(new FlowLayout());

            add(salvarJBT = new JButton("Salvar", new ImageIcon("image/save24.png")));
            add(cancelarJBT = new JButton("Cancelar", new ImageIcon("image/cancel24.png")));

            salvarJBT.setBackground(Color.GREEN);
            cancelarJBT.setBackground(Color.RED);

            salvarJBT.setForeground(Color.WHITE);
            cancelarJBT.setForeground(Color.WHITE);
            
            salvarJBT.addActionListener(this);
            cancelarJBT.addActionListener(this);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == salvarJBT)
            {
                if(editar)
                    centro.alterar();
                else    
                    centro.salvar();
            }
            else
                dispose();
        }
    }

    public void definirTema() 
    {
        try 
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
                {
                    if ("Nimbus".equals(info.getName())) 
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) 
        {
        }
    }

    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new PecaVisao(false, new PecaModelo());
    }
}