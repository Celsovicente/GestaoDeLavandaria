/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: PecaFile.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class PecaFile extends ObjectsFile
{
    public PecaFile()
    {
        super("PecaFile.dat", new PecaModelo());
    }  

    public void salvarDados(PecaModelo modelo)
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

    public void alterarDados(PecaModelo modelo_novo)
	{
		PecaModelo modelo_antigo = new PecaModelo();
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getId() == modelo_novo.getId())
				{
					stream.seek(4); 
					modelo_novo.write( stream );
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getId() + 1 == modelo_novo.getId())
					{
						modelo_novo.write( stream);
						return;
					}
							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    public void eliminarDados(PecaModelo modelo_novo)
	{
		PecaModelo modelo_antigo = new PecaModelo();
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getId() == modelo_novo.getId())
				{
					stream.seek(4); 
					modelo_novo.write( stream );
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getId() + 1 == modelo_novo.getId())
					{
						modelo_novo.write(stream);
						return;
					}							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    public static void listarPecas()
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        String dados = "Listagem dos Dados da Peca:\n\n";

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

    public static int pesquisarPorQuantidade(int quantidadeProcurada)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean estado = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getQuantidade() == quantidadeProcurada && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    estado = true;
                    return 0;
                }
            }
            if(!estado)
            {
               JOptionPane.showMessageDialog(null, "Erro, quantiade nao encontrada", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return quantidadeProcurada;
    }

    public static String pesquisarPorHorario(String horarioProcurado)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean estado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getHorario().equalsIgnoreCase(horarioProcurado) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    estado = true;
                    return "";
                }
            }
            if(!estado)
            {
               JOptionPane.showMessageDialog(null, "Erro, horario nao encontrado", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    // metodos para a edicao
    public static PecaModelo getPesquisaPorQuantidade(int quantidadeProcurado)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean estado = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getQuantidade() == quantidadeProcurado && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    estado = true;
                    return modelo;
                }
            }
            if(!estado)
            {
               JOptionPane.showMessageDialog(null, "Erro, quantidade nao encontrada", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public static PecaModelo getPesquisaPorHorario(String horarioProcurado)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean estado = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getHorario().equalsIgnoreCase(horarioProcurado) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    estado = true;
                    return modelo;
                }
            }
            if(!estado)
            {
                JOptionPane.showMessageDialog(null, "Erro, horario nao encontrado", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}   