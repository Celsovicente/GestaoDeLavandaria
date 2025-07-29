/*------------------------------------
Tema: Gestão de uma Lavandaria
Nome: António Manuel
Número: 34370
Ficheiro: MenuPrincipal.java
Data: 28/07/2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class MenuPrincipal extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu clienteMenu, vendaMenu, pecaMenu, listagemMenu, tabelaMenu, ajudaMenu, defesaMenu;
	private JMenuItem novoClienteItem, editarClienteItem, eliminarClienteItem, sairClienteItem;
	private JMenuItem novaVendaItem, editarVendaItem, eliminarVendaItem, sairVendaItem;
	private JMenuItem novaPecaItem, editarPecaItem, eliminarPecaItem, sairPecaItem;
	private JMenuItem listarClientesItem, pesquisarClienteItem, listarVendaItem, pesquisarVendaItem, 
	listarPecaItem, pesquisarPecaItem;
	private JMenuItem nacionalidade, provincia, municipio, comuna, tipoPeca, horario, metodoPagamento, 
	funcionario;
	private JMenuItem novaDefesaItem, pesquisarDefesaItem, listarDefesaItem, conferenciaItem, 
	dioceseItem, paroquiaItem;

	public MenuPrincipal(String user)
	{
        super("Menu Principal | Operador " + user);

        instanciarObjetos();

        setJMenuBar(menuBar);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public void instanciarObjetos()
	{
		// instanciando o menuBar
        menuBar = new JMenuBar();

		// instanciando os elementos do menuBar
		menuBar.add(clienteMenu = new JMenu("Cliente"));
        clienteMenu.setIcon(new ImageIcon("image/funcionario32.png"));
		clienteMenu.setMnemonic('C');
		menuBar.add(vendaMenu = new JMenu("Venda"));
		vendaMenu.setMnemonic('V');
		menuBar.add(pecaMenu = new JMenu("Peca"));
		pecaMenu.setMnemonic('P');
		menuBar.add(listagemMenu = new JMenu("Listagens/Pesquisas"));
		listagemMenu.setIcon(new ImageIcon("image/search32.png"));
		listagemMenu.setMnemonic('L');
		menuBar.add(tabelaMenu = new JMenu("Tabela"));
		tabelaMenu.setIcon(new ImageIcon("image/tabela.png"));
		tabelaMenu.setMnemonic('T');
		menuBar.add(ajudaMenu = new JMenu("Ajuda"));
		ajudaMenu.setIcon(new ImageIcon("image/help.png"));
		ajudaMenu.setMnemonic('A');
		menuBar.add(defesaMenu = new JMenu("Defesa"));
		defesaMenu.setMnemonic('D');

		// instanciando os elementos do menuCliente
		clienteMenu.add(novoClienteItem = new JMenuItem("Novo Cliente", new ImageIcon("image/novo24.png")));
		novoClienteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		clienteMenu.add(editarClienteItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
		clienteMenu.add(eliminarClienteItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
		clienteMenu.addSeparator();
		clienteMenu.add(sairClienteItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

		// instanciando os elementos do menuVenda
		vendaMenu.add(novaVendaItem = new JMenuItem("Nova Venda", new ImageIcon("image/novo24.png")));
		novaVendaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		vendaMenu.add(editarVendaItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
		vendaMenu.add(eliminarVendaItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
		vendaMenu.addSeparator();
		vendaMenu.add(sairVendaItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

		// instanciando os elementos do menuPeca
		pecaMenu.add(novaPecaItem = new JMenuItem("Nova Peca", new ImageIcon("image/novo24.png")));
		novaPecaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		pecaMenu.add(editarPecaItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
		pecaMenu.add(eliminarPecaItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
		pecaMenu.addSeparator();
		pecaMenu.add(sairPecaItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

		// instanciando os elementos da listagemMenu
		listagemMenu.add(listarClientesItem = new JMenuItem("Listar Clientes"));
		listagemMenu.add(pesquisarClienteItem = new JMenuItem("Pesquisar Clientes"));
		listagemMenu.addSeparator();
		listagemMenu.add(listarVendaItem = new JMenuItem("Listar Vendas"));
		listagemMenu.add(pesquisarVendaItem = new JMenuItem("Pesquisar Vendas"));
		listagemMenu.addSeparator();
		listagemMenu.add(listarPecaItem = new JMenuItem("Listar Pecas"));
		listagemMenu.add(pesquisarPecaItem = new JMenuItem("Pesquisar Pecas"));
		listagemMenu.addSeparator();
		listagemMenu.add(listarDefesaItem = new JMenuItem("Listar Defesa"));

		// instanciando os elementos do tabelaMenu
		tabelaMenu.add(nacionalidade = new JMenuItem("Nacionalidade"));
		tabelaMenu.add(provincia = new JMenuItem("Provincia"));
		tabelaMenu.add(municipio = new JMenuItem("Municipio"));
		tabelaMenu.add(comuna = new JMenuItem("Comuna"));
		tabelaMenu.add(tipoPeca = new JMenuItem("Tipo de Peca"));
		tabelaMenu.add(metodoPagamento = new JMenuItem("Metodo de Pagamento"));
		tabelaMenu.add(funcionario = new JMenuItem("Nome do Funcionario"));
		tabelaMenu.add(horario = new JMenuItem("Horario"));
		tabelaMenu.add(conferenciaItem = new JMenuItem("Conferencia"));
		tabelaMenu.add(dioceseItem = new JMenuItem("Diocese"));
		tabelaMenu.add(paroquiaItem = new JMenuItem("Paroquia"));

		defesaMenu.add(novaDefesaItem = new JMenuItem("Cadastrar Defesa"));
		defesaMenu.add(pesquisarDefesaItem = new JMenuItem("Pesquisar Defesa"));

		// adicionando evento nos elementos do clienteMenu
		novoClienteItem.addActionListener(this);
		editarClienteItem.addActionListener(this);
		eliminarClienteItem.addActionListener(this);
		sairClienteItem.addActionListener(this);
		listarClientesItem.addActionListener(this);
		pesquisarClienteItem.addActionListener(this);

		// adicionando evento nos elementos do menuVenda
		novaVendaItem.addActionListener(this);
		editarVendaItem.addActionListener(this);
		eliminarVendaItem.addActionListener(this);
		sairVendaItem.addActionListener(this);
		listarVendaItem.addActionListener(this);
		pesquisarVendaItem.addActionListener(this);

		// adicionando evento nos elementos do menuPeca
		novaPecaItem.addActionListener(this);
		editarPecaItem.addActionListener(this);
		eliminarPecaItem.addActionListener(this);
		sairPecaItem.addActionListener(this);
		listarPecaItem.addActionListener(this);
		pesquisarPecaItem.addActionListener(this);

		// adicionando evento nos elementos das tabelas
		nacionalidade.addActionListener(this);
		provincia.addActionListener(this);
		municipio.addActionListener(this);
		comuna.addActionListener(this);
		horario.addActionListener(this);
		funcionario.addActionListener(this);
		tipoPeca.addActionListener(this);
		metodoPagamento.addActionListener(this);
		conferenciaItem.addActionListener(this);
		dioceseItem.addActionListener(this);
		paroquiaItem.addActionListener(this);
		novaDefesaItem.addActionListener(this);
		listarDefesaItem.addActionListener(this);
		pesquisarDefesaItem.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event)	
	{
		if(event.getSource() == novoClienteItem)
			new ClienteVisao(false, new ClienteModelo());
		else if(event.getSource() == editarClienteItem)
			new EditarCliente();
		else if(event.getSource() == eliminarClienteItem)
			new EliminarCliente();
		else if(event.getSource() == pesquisarClienteItem)
			new PesquisarCliente();
		else if(event.getSource() == listarClientesItem)
			ClienteFile.listarClientes();
		else if(event.getSource() == novaPecaItem)
			new PecaVisao(false, new PecaModelo());
		else if(event.getSource() == editarPecaItem)
			new EditarPeca();
		else if(event.getSource() == eliminarPecaItem)
			new EliminarPeca();
		else if(event.getSource() == pesquisarPecaItem)
			new PesquisarPeca();
		else if(event.getSource() == listarPecaItem)
			PecaFile.listarPecas();
		else if(event.getSource() == novaVendaItem)
			new VendaVisao(false, new VendaModelo());
		else if(event.getSource() == editarVendaItem)
			new EditarVenda();
		else if(event.getSource() == eliminarVendaItem)
			new EliminarVenda();
		else if(event.getSource() == pesquisarVendaItem)
			new PesquisarVenda();
		else if(event.getSource() == listarVendaItem)
			VendaFile.listarVendas();
		else if(event.getSource() == novaDefesaItem)
			new DefesaVisao();
		else if(event.getSource() == pesquisarDefesaItem)
			new PesquisarDefesa();
		else if(event.getSource() == listarDefesaItem)
			DefesaFile.listarDefesas();
		else if(event.getSource() == nacionalidade)
		    Tabela2.editarNovosItems("Nacionalidades.tab", "Nova Nacionalidade");
		else if(event.getSource() == provincia)
			Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
		else if(event.getSource() == municipio)
            Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", "Provincia", "Municipio", 
            "Novo Municipio");
		else if(event.getSource() == comuna)
            Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab","Comunas.tab", 
            "Provincia", "Municipio", "Comuna", "Nova Comuna");
		else if(event.getSource() == horario)
			Tabela2.editarNovosItems("Horario.tab", "Novo Horario");
		else if(event.getSource() == funcionario)
			Tabela2.editarNovosItems("Funcionario.tab", "Novo Funcionario");
		else if(event.getSource() == tipoPeca)
			Tabela2.editarNovosItems("TipoPeca.tab", "Novo Tipo de Peca");
		else if(event.getSource() == metodoPagamento)
			Tabela2.editarNovosItems("MetodoPagamento.tab", "Novo Metodo dee Pagamento");
		else if(event.getSource() == conferenciaItem)
			Tabela2.editarNovosItems("Conferencia.tab", "Nova Conferencia");
		else if(event.getSource() == dioceseItem)
			Tabela3_2.editarNovosItems("Conferencia.tab", "Diocese.tab", "Conferencia", "Diocese", "Nova Diocese");
		else if(event.getSource() == paroquiaItem)
			Tabela3_3.editarNovosItems("Conferencia.tab", "Diocese.tab", "Paroquia.tab", 
			"Conferencia", "Diocese", "Paroquia", "Nova Paroquia");
		else if(event.getSource() == sairClienteItem)
			dispose();
		else if(event.getSource() == sairVendaItem)
			dispose();
		else if(event.getSource() == sairPecaItem)
			dispose();
	}

	public static void main(String[] args)
	{
		Vector_Tabelas.inic();
		new MenuPrincipal("");
	}
}