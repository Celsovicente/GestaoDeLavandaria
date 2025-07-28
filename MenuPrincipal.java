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

	public MenuPrincipal(String user)
	{
        super("Menu Principal | Operador " + user);

        instanciarObjetos();

        setJMenuBar(menuBar);

        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public void instanciarObjetos()
	{
		// instanciando o menuBar
        menuBar = new JMenuBar();
	}

	public void actionPerformed(ActionEvent event)	
	{

	}

	public static void main(String[] args)
	{
		new MenuPrincipal("");
	}
}