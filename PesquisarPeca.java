/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: PesquisarPeca.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class PesquisarPeca extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    
    public PesquisarPeca()
    {
        super("Pesquisas das Pecas");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {
        private JTextField quantidadeJTF;
        private JComboBox horarioJCB;
        private JRadioButton pesquisarPorQuantidade, pesquisarPorHorario;
        private ButtonGroup grupo;
    
        public PainelCentro()
        {
            setLayout(new GridLayout(3 , 2));
            
            grupo = new ButtonGroup();

            add(pesquisarPorQuantidade= new JRadioButton("Pesquisa Por Quantidade"));
            add(pesquisarPorHorario = new JRadioButton("Pesquisa Por Horario"));

            grupo.add(pesquisarPorQuantidade);
            grupo.add(pesquisarPorHorario);
            
           add(new JLabel("Digite a Quantidade Procurada"));
           add(quantidadeJTF = new JTextField());
           quantidadeJTF.setEnabled(false);
            
            add(new JLabel("Escolha o Horario Procurado"));
            add(horarioJCB = UInterfaceBox.createJComboBoxsTabela2("Horario.tab"));
            horarioJCB.setEnabled(false);
            
            pesquisarPorQuantidade.addActionListener(this);
            pesquisarPorHorario.addActionListener(this);
        }

        public int getQuantidadeProcurada() 
        {
            return Integer.parseInt(quantidadeJTF.getText().trim());
        }

        public String getHorarioProcurado()
        {
            return String.valueOf(horarioJCB.getSelectedItem());
        }

        public int getTipoPesquisa()
        {
            if(pesquisarPorQuantidade.isSelected())
                return 1;
            else 
                return 2;
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarPorQuantidade)
            {
                quantidadeJTF.setEnabled(true);
                horarioJCB.setEnabled(false); 
            }
            else if(event.getSource() == pesquisarPorHorario)
            {
                quantidadeJTF.setEnabled(false);
                horarioJCB.setEnabled(true);
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener
    {
        private JButton pesquisarJB, cancelarJB;

        public PainelSul()
        {
            add(pesquisarJB = new JButton("Pesquisar", new ImageIcon("image/search32.PNG")));
            add(cancelarJB = new JButton("Cancelar", new ImageIcon("image/cancel24.PNG")));

            pesquisarJB.addActionListener(this);
            cancelarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarJB)
            {    
                if(centro.getTipoPesquisa() == 1)
                    PecaFile.pesquisarPorQuantidade(centro.getQuantidadeProcurada());
                else if(centro.getTipoPesquisa() == 2)
                    PecaFile.pesquisarPorHorario(centro.getHorarioProcurado());
            }
            else 
                dispose();
        }
    }
}
