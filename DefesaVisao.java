/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: DefesaVisao.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class DefesaVisao extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;

    public DefesaVisao()
    {

        super("Registrar Clientes");


        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(450, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel
    {
        private JTextField idJTF, nomeJTF, telefoneJTF, emailJTF;
        private JComboBox generoJCB, nacionalidadeJCB, provinciaJCB, municipioJCB, comunaJCB;
        private JComboBox conferenciaJCB, dioceseJCB, paroquiaJCB;
        private String[] generoArray = {"Masculino", "Feminino"}; 
        private JTextFieldData txtData;
        private JComboBoxTabela3_Tabela3 provinciaComMunicipio, confDioceParoquia;
        private DefesaFile file;

        public PainelCentro()
        {
            setLayout(new GridLayout(13, 2));
            provinciaComMunicipio = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
            confDioceParoquia = new JComboBoxTabela3_Tabela3("Conferencia.tab", "Diocese.tab", "Paroquia.tab"); 
            file = new DefesaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Nome"));
            add(nomeJTF = new JTextField());

            // 3º linha
            add(new JLabel("Telefone"));
            add(telefoneJTF = new JTextField());

            // 4º linha
            add(new JLabel("Email"));
            add(emailJTF = new JTextField());

            // 5º linha
            add(new JLabel("Genero"));
            add(generoJCB = new JComboBox(generoArray));

            // 6º linha
            add(new JLabel("Nacionalidade"));
            add(nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab"));

             // 7º linha
            add(new JLabel("Provincia"));
            add(provinciaJCB = provinciaComMunicipio.getComboBoxFather());

            // 8º linha
            add(new JLabel("Municipio"));
            add(municipioJCB = provinciaComMunicipio.getComboBoxSun());

            // 9º liha
            add(new JLabel("Comuna"));
            add(comunaJCB = provinciaComMunicipio.getComboBoxNeto());

            // 10º linha
            add(new JLabel("Conferencia"));
            add(conferenciaJCB = confDioceParoquia.getComboBoxFather());

            // 11º linha
            add(new JLabel("Diocese"));
            add(dioceseJCB = confDioceParoquia.getComboBoxSun());

            // 12º linha
            add(new JLabel("Paroquia"));
            add(paroquiaJCB = confDioceParoquia.getComboBoxNeto());

            // 13º linha
            add(new JLabel("Data de Fundacao"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);
        } 
        // getters
        public int getId()
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getNome()
        {
            return nomeJTF.getText();
        }

        public String getTelefone()
        {
            return telefoneJTF.getText().trim();
        }

        public String getEmail()
        {
            return emailJTF.getText().trim();
        }

        public String getGenero()
        {
            return String.valueOf(generoJCB.getSelectedItem());
        }

        public String getNacionalidade()
        {
            return String.valueOf(nacionalidadeJCB.getSelectedItem());
        }

        public String getProvincia()
        {
            return String.valueOf(provinciaJCB.getSelectedItem());
        }

        public String getMunicipio()
        {
            return String.valueOf(municipioJCB.getSelectedItem());
        }

        public String getComuna()
        {
            return String.valueOf(comunaJCB.getSelectedItem());
        }

        public String getConferencia()
        {
            return String.valueOf(conferenciaJCB.getSelectedItem());
        }

        public String getDiocese()
        {
            return String.valueOf(dioceseJCB.getSelectedItem());
        }

        public String getParoquia()
        {
            return String.valueOf(paroquiaJCB.getSelectedItem());
        }

        public String getDataFundacao()
        {
            return txtData.getDTestField().getText();
        }

        // metodos setters
        public void setId(int id)
        {
            idJTF.setText("" +id);
        }

        public void setNome(String nome)
        {
            nomeJTF.setText(nome);
        }

        public void setTelefone(String telefone)
        {
            telefoneJTF.setText(telefone);
        }

        public void setEmail(String email)
        {
            emailJTF.setText(email);
        }

        public void setGenero(String genero)
        {
            generoJCB.setSelectedItem(genero);
        }

        public void setNacionalidade(String nacionalidade)
        {
            nacionalidadeJCB.setSelectedItem(nacionalidade);
        }

        public void setProvincia(String provincia)
        {
            provinciaJCB.setSelectedItem(provincia);
        }

        public void setMunicipio(String municipio)
        {
            municipioJCB.setSelectedItem(municipio);
        }

        public void setComuna(String comuna)
        {
            comunaJCB.setSelectedItem(comuna);
        }

        public void setConferencia(String conferencia)
        {
            conferenciaJCB.setSelectedItem(conferencia);
        }

        public void setDiocese(String diocese)
        {
            dioceseJCB.setSelectedItem(diocese);
        }

        public void setParoquia(String paroquia)
        {
            paroquiaJCB.setSelectedItem(paroquia);
        }

        public void setDataFundacao(String data)
        {
            txtData.getDTestField().setText(data);
        }

        // metodo salvar
        public void salvar()
        {
            DefesaModelo modelo = new DefesaModelo(
            getId(),
            getNome(),
            getTelefone(),
            getEmail(),
            getGenero(),
            getNacionalidade(),
            getProvincia(),
            getMunicipio(), 
            getComuna(),
            getConferencia(),
            getDiocese(),
            getParoquia(),
            getDataFundacao(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvar();
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
        new DefesaVisao();
    }
}