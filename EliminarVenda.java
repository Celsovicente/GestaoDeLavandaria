/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: EliminarVenda.java
Data: 29/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EliminarVenda extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    
    public EliminarVenda()
    {
        super("Pesquisas das Vendas para Eliminacao");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {
        private JTextField idJTF;
        private JComboBox nomeJCB;
        private JRadioButton pesquisarPorId, pesquisarPorNome;
        private ButtonGroup grupo;
    
        public PainelCentro()
        {
            setLayout(new GridLayout(3 , 2));
            
            grupo = new ButtonGroup();

            add(pesquisarPorId= new JRadioButton("Pesquisa Por Id"));
            add(pesquisarPorNome = new JRadioButton("Pesquisa Por Nome"));

            grupo.add(pesquisarPorId);
            grupo.add(pesquisarPorNome);
            
           add(new JLabel("Digite Id Procurado"));
           add(idJTF = new JTextField());
           idJTF.setEnabled(false);
            
            add(new JLabel("Escolha o Nome Procurado"));
            add(nomeJCB = UInterfaceBox.createJComboBoxsTabela2("Funcionario.tab"));
            nomeJCB.setEnabled(false);
            
            pesquisarPorId.addActionListener(this);
            pesquisarPorNome.addActionListener(this);
        }

        public int getIdProcurado() 
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getNomeProcurado()
        {
            return String.valueOf(nomeJCB.getSelectedItem());
        }

        public int getTipoPesquisa()
        {
            if(pesquisarPorId.isSelected())
                return 1;
            else 
                return 2;
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarPorId)
            {
                idJTF.setEnabled(true);
                nomeJCB.setEnabled(false); 
            }
            else if(event.getSource() == pesquisarPorNome)
            {
                idJTF.setEnabled(false);
                nomeJCB.setEnabled(true);
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
                VendaModelo modelo;
                if(centro.getTipoPesquisa() == 1)
                {    
                    modelo = VendaFile.getPesquisaPorId(centro.getIdProcurado());

                    JOptionPane.showMessageDialog(null, modelo.toString());

                    int opcao = JOptionPane.showConfirmDialog(null, "Tem a certeza que deseja eliminar esse dado?");

                    if(opcao == JOptionPane.YES_OPTION)
                    {
                        // eliminar dados
                        modelo.setStatus(false);

                        new VendaFile().eliminarDados(modelo);
                        dispose();
                    }
                    else    
                        JOptionPane.showMessageDialog(null, "Operacao Interrompida por ordem do operador");    
                }
                else if(centro.getTipoPesquisa() == 2)
                {
                    modelo = VendaFile.getPesquisaPorNome(centro.getNomeProcurado());
                    
                    JOptionPane.showMessageDialog(null, modelo.toString());

                    int opcao = JOptionPane.showConfirmDialog(null, "Tem a certeza que deseja eliminar esse dado?");

                    if(opcao == JOptionPane.YES_OPTION)
                    {
                        // eliminar dados
                        modelo.setStatus(false);

                        new VendaFile().eliminarDados(modelo);
                        dispose();
                    }
                    else    
                        JOptionPane.showMessageDialog(null, "Operacao Interrompida por ordem do operador");    
                }
            }
            else 
                dispose();
        }
    }
}
