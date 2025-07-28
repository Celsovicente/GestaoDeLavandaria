/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: PecaModelo.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class PecaModelo implements RegistGeneric
{
    private int id, quantidade;
    private StringBufferModelo tipoPeca, horario;
    private DataModelo dataEntrega;
    private boolean status;

    public PecaModelo()
    {
        id = 0;
        tipoPeca = new StringBufferModelo("", 20);
        quantidade = 0;
        dataEntrega = new DataModelo();
        horario = new StringBufferModelo("", 20);
        status = false;
    }

    public PecaModelo(int id, String tipoPeca, int quantidade, String dataEntrega, String horario, boolean status)
    {
        this.id = id;
        this.tipoPeca = new StringBufferModelo(tipoPeca, 20);
        this.quantidade = quantidade;
        this.dataEntrega = new DataModelo(dataEntrega);
        this.horario = new StringBufferModelo(horario, 20);
        this.status = status;
    }

    // metodos getters
    public int getId()
    {
        return id;
    }

    public String getTipoPeca()
    {
        return tipoPeca.toStringEliminatingSpaces();
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public String getDataEntrega()
    {
        return dataEntrega.toString();
    }

    public String getHorario()
    {
        return horario.toStringEliminatingSpaces();
    }

    public boolean getStatus()
    {
        return status;
    }
 
    // metodos setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setTipoPeca(String tipoPeca)
    {
        this.tipoPeca = new StringBufferModelo(tipoPeca, 20);
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void setDataEntrega(String dataEntrega)
    {
        this.dataEntrega = new DataModelo(dataEntrega);
    }

    public void setHorario(String horario)
    {
        this.horario = new StringBufferModelo(horario, 20);
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    // metodo toString
    public String toString()
    {
        String dados = "Dados da Peca\n\n";
        
        dados += "Id: " + getId() + "\n";
        dados += "Tipo de Peca: " + getTipoPeca() + "\n";
        dados += "Quantidade: " + getQuantidade() + "\n";
        dados += "Data de Entrega: " + getDataEntrega() + "\n";
        dados += "Horario: " + getHorario() + "\n";
        dados += "Status: " + getStatus() + "\n";

        return dados;
    }

    // calcular o tamanho dos bytes
    public long sizeof()
    {
        try
        {
            return 40 * 2 + 4 * 2 + 12 + 1;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }

    // metodo write
    public void write(RandomAccessFile stream)
    {
        try
        {
            stream.writeInt(id);            
            tipoPeca.write(stream);
            stream.writeInt(quantidade);
            dataEntrega.write(stream);
            horario.write(stream);
            stream.writeBoolean(status);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao escrever no Ficheiro");
        }
    }

    // metodo read
    public void read(RandomAccessFile stream)
    {
        try
        {
            id = stream.readInt();
            tipoPeca.read(stream);
            quantidade = stream.readInt();
            dataEntrega.read(stream);
            horario.read(stream);
            status = stream.readBoolean();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao ler no ficheiro");
        }
    }

    public void salvar()
    {
        PecaFile file = new PecaFile();
        file.salvarDados(this);
    }

    public void salvarDados()
    {
        PecaFile file = new PecaFile();
        file.alterarDados(this);
    }
}