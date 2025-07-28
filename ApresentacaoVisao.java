/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: ApresentacaoVisao.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class ApresentacaoVisao extends JFrame 
{
    
    private PainelCentro centro;
    private PainelSul sul;

    public ApresentacaoVisao()
    {
        super("Tela de Boas Vindas");

        JPanel painelNorte = new JPanel();

        ImageIcon iconOriginal = new ImageIcon("image/apresentacao.png");
        Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);

        JLabel lbImagem = new JLabel(iconRedimensionado);

        painelNorte.add(lbImagem);
        getContentPane().add(painelNorte, BorderLayout.NORTH);

        getContentPane().add(painelNorte , BorderLayout.NORTH);
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {
            JTextArea areaPrincipal;
            JCheckBox concordarJCB;
            public PainelCentro()
            {
                setLayout(new GridLayout(2, 1));
                
                add(new JScrollPane(areaPrincipal = new JTextArea(80 , 60)));
                areaPrincipal.setFocusable(false);
                areaPrincipal.setText("Bem-vindo ao Sistema de Gestao de Lavandaria.\n\n" +
                "\tTema: Gestao de Lavandaria\n\n" +
                "Este projeto tem como objetivo gerir de forma eficiente uma lavandaria,\n" +
                "permitindo o cadastro de clientes, registo de pecas de roupa entregues para lavagem,\n" +
                "controle das vendas realizadas e acompanhamento dos metodos de pagamento utilizados.\n\n" +
                "Este sistema foi desenvolvido no ambito da cadeira de Fundamentos de Programacao 2,\n" +
                "no Curso de Engenharia Informatica da UCAN. E de uso exclusivo aos Recursos Humanos.\n\n" +
                "O projeto visa facilitar o controle e a gestao da informacao sobre os clientes da lavandaria,\n" +
                "permitindo localizar os dados de forma concisa, organizada e segura.\n\n" +
                "Desenvolvido por Antonio Manuel, estudante do 1º ano, ID: 34370.\n\n" +
                "Se concorda com os termos e condicoes, clique em 'Concordar' para continuar.");


                add(concordarJCB = new JCheckBox("Concordo com os termos a seguir"));

                concordarJCB.addActionListener(this);
            }

            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == concordarJCB)
                    if(concordarJCB.isSelected())
                        sul.ativarBotao(true);
                    else
                        sul.ativarBotao(false);
            }
    }

    
    class PainelSul extends JPanel implements ActionListener
    {
        JButton entrarJB, sairJB;
        public PainelSul()
        {
            add(entrarJB = new JButton("Entrar", new ImageIcon("image/next24.png")));
            add(sairJB = new JButton("Sair", new ImageIcon("image/logout24.png")));

            ativarBotao( false );

            entrarJB.addActionListener(this);
            sairJB.addActionListener(this);
        }

        public void ativarBotao(boolean status)
        {
            entrarJB.setEnabled(status);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == entrarJB)
            {
                dispose();
                new LoginVisao();
            }
            else
                dispose();
        }
    }

    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new ApresentacaoVisao();       
    }
}