package br.com.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/image/logo ryukumite.jpg")));
		setTitle("Sistema Associação Ryu Kumitê");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuMembros = new JMenu("Membros");
		menuMembros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMembroRK membro = new FrmMembroRK();
				membro.setVisible(true);
				
			}
		});
		menuBar.add(menuMembros);
		
		JMenu menuFederacao = new JMenu("Federação");
		menuFederacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmFederacao federacao = new FrmFederacao();
				federacao.setVisible(true);
			}
		});
		menuBar.add(menuFederacao);
		
		JMenu menuAcademia = new JMenu("Academia");
		menuAcademia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmAcademia academia = new FrmAcademia();
				academia.setVisible(true);
			}
		});
		menuBar.add(menuAcademia);
		
		JMenu menuSair = new JMenu("Sair");
		menuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int op;
				op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?");
				if (op == 0) {
					System.exit(0);
				}
			}
		});		menuBar.add(menuSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/image/ryu street fighter.jpg"));
		Image image = icon.getImage();
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JDesktopPane painelDesktop = new JDesktopPane() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.add(painelDesktop, BorderLayout.CENTER);
		
		ImageIcon iconlogo = new ImageIcon(getClass().getResource("/image/logo ryukumite.jpg"));
		Image imagelogo = iconlogo.getImage();

		
		JPanel pnlLogo = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imagelogo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		pnlLogo.setBounds(0, 0, 353, 152);
		painelDesktop.add(pnlLogo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2);
	}
}
