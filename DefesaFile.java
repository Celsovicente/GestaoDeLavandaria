/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: DefesaFile.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class DefesaFile extends ObjectsFile
{
    public DefesaFile()
    {
        super("DefesaFile.dat", new DefesaModelo());
    }  

    public void salvarDados(DefesaModelo modelo)
    {
        try
        {
            // colocar o file pointer no final do ficheiro
            stream.seek(stream.length());

            // escrever no modelo
            modelo.write(stream);

            incrementarProximoCodigo();
            JOptionPane.showMessageDialog(null,  "Dados Salvos com Sucessso");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao Salvar os Dados");
        }
    }

    public static void listarDefesas()
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        String dados = "Listagem dos Dados do Cliente:\n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);
                if(modelo.getStatus() == true)
                {    
                    dados += "==============================\n";
                    dados += modelo.toString() + "\n\n";
                }
            }

            JTextArea area = new JTextArea(40 , 60);
            area.setText(dados);
            area.setFocusable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(area),
            "Gestao de Lavandaria", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }  
    }

    // pesquisa por filtro
    public static void pesquisa(String paroquia, String dataFundacao)
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        boolean status = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                // conversao da data
                String dataConvertida = new DataModelo(dataFundacao).toString();
                
                if(modelo.getStatus() && modelo.getParoquia().equalsIgnoreCase(paroquia) &&  
                modelo.getDataFundacao().equals(dataConvertida))
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    status = true;
                    break;
                }
            }
            if(!status)
            {
                JOptionPane.showMessageDialog(null, "Erro, paroquia e a data de fundacao nao encontradas", 
                    "File Not Found", JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

}   