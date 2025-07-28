/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: VendaModelo.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class VendaModelo implements RegistGeneric
{
    private int id;
    private StringBufferModelo nomeFuncionario, metodoPagamento;
    private DataModelo dataVenda;
    private float valor;
    private boolean status;

    public VendaModelo()
    {
        id = 0;
        dataVenda = new DataModelo();
        nomeFuncionario = new StringBufferModelo("", 20);
        valor = 0;
        metodoPagamento = new StringBufferModelo("", 20);
        status = false;
    }

    public VendaModelo(int id, String dataVenda, String nomeFuncionario, float valor, 
    String metodoPagamento, boolean status)
    {
        this.id = id;
        this.dataVenda = new DataModelo(dataVenda);
        this.nomeFuncionario = new StringBufferModelo(nomeFuncionario, 20);
        this.valor = valor;
        this.metodoPagamento = new StringBufferModelo(metodoPagamento, 20);
        this.status = status;
    }

    // metodos getters
    public int getId()
    {
        return id;
    }

    public String getDataVenda()
    {
        return dataVenda.toString();
    }

    public String getNome()
    {
        return nomeFuncionario.toStringEliminatingSpaces();
    }

    public float getValor()
    {
        return valor;
    }

    public String getMetodoPagamento()
    {
        return metodoPagamento.toStringEliminatingSpaces();
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

    public void setDataVenda(String dataVenda)
    {
        this.dataVenda = new DataModelo(dataVenda);
    }

    public void setNome(String nomeFuncionario)
    {
        this.nomeFuncionario = new StringBufferModelo(nomeFuncionario,20);
    }

    public void setValor(float valor)
    {
        this.valor = valor;
    }

    public void setMetodoPagamento(String metodoPagamento)
    {
        this.metodoPagamento = new StringBufferModelo(metodoPagamento, 20);
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    // metodo toString
    public String toString()
    {
        String dados = "Dados da Venda\n\n";
        
        dados += "Id: " + getId() + "\n";
        dados += "Data de Venda: " + getDataVenda() + "\n";
        dados += "Nome do Funcionario: " + getNome() + "\n";
        dados += "Valor: " + getValor() + "\n";
        dados += "Metodo de Pagamento: " + getMetodoPagamento() + "\n";
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
            dataVenda.write(stream);
            nomeFuncionario.write(stream);
            stream.writeFloat(valor);
            metodoPagamento.write(stream);
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
            dataVenda.read(stream);
            nomeFuncionario.read(stream);
            valor = stream.readFloat();
            metodoPagamento.read(stream);
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
        VendaFile file = new VendaFile();
        file.salvarDados(this);
    }

    public void salvarDados()
    {
        VendaFile file = new VendaFile();
        file.alterarDados(this);
    }
}