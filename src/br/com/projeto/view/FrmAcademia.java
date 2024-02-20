package br.com.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.AcademiaDAO;
import br.com.projeto.model.Academia;
import br.com.projeto.model.Utilitarios;

public class FrmAcademia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAcademia;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JFormattedTextField txtTelefone;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTable tblAcademia;
	private JTextField txtIdAcademia;
	private JFormattedTextField txtCep;
	private JTable tblAcademiaAlunos;
	private JTextField txtPesquisaAluno;
	private JFormattedTextField txtCelular;
	
	private int valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAcademia frame = new FrmAcademia();
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
	public FrmAcademia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAcademia.class.getResource("/image/logo ryukumite.jpg")));
		setTitle("Associação Ryu Kumite - Academias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Definir o tamanho e a posição inicial
		int largura = 1000;
		int altura = 615;

		// Obter a resolução da tela
		Dimension dimensaoTela = Toolkit.getDefaultToolkit().getScreenSize();

		// Calcular a posição central
		int x = (dimensaoTela.width - largura) / 2;
		int y = (dimensaoTela.height - altura) / 2;

		// Definir as dimensões e a posição
		setBounds(x, y, largura, altura);

		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTitulo.setBounds(0, 0, 984, 48);
		pnlTitulo.setLayout(null);
		pnlTitulo.setBackground(Color.WHITE);
		contentPane.add(pnlTitulo);

		JLabel lblMembroDaAssociao = new JLabel("ASSOCIAÇÃO RYU KUMITÊ - ACADEMIA");
		lblMembroDaAssociao.setForeground(Color.BLACK);
		lblMembroDaAssociao.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		lblMembroDaAssociao.setBackground(Color.BLACK);
		lblMembroDaAssociao.setBounds(278, 11, 489, 31);
		pnlTitulo.add(lblMembroDaAssociao);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(264, 11, 48, 48);
		pnlTitulo.add(lblNewLabel_2);

		ImageIcon icon = new ImageIcon(getClass().getResource("/image/logo ryukumite.jpg"));
		Image image = icon.getImage();

		JDesktopPane dskpaneLogo = new JDesktopPane() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		dskpaneLogo.setBounds(10, 0, 142, 48);
		pnlTitulo.add(dskpaneLogo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 46, 984, 530);
		contentPane.add(tabbedPane);

		JPanel pnlDadosAcademia = new JPanel();
		tabbedPane.addTab("Dados Academia", null, pnlDadosAcademia, null);
		pnlDadosAcademia.setLayout(null);

		JPanel pnlAcademia = new JPanel();
		pnlAcademia.setLayout(null);
		pnlAcademia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlAcademia.setBounds(0, 0, 513, 231);
		pnlDadosAcademia.add(pnlAcademia);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Academia:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 58, 62, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(187, 85, 35, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(336, 58, 59, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_1 = new JLabel("Endereço:");
		lblNewLabel_1_1_1_1_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_1.setBounds(187, 114, 59, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_2 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_1_1_1_2_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_2.setBounds(187, 143, 36, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_3 = new JLabel("Número:");
		lblNewLabel_1_1_1_1_1_1_2_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_3.setBounds(10, 143, 48, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2_1_3);

		txtAcademia = new JTextField();
		txtAcademia.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAcademia.setColumns(10);
		txtAcademia.setBounds(79, 56, 243, 20);
		pnlAcademia.add(txtAcademia);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(256, 83, 243, 20);
		pnlAcademia.add(txtEmail);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(256, 112, 243, 20);
		pnlAcademia.add(txtEndereco);

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		} catch (Exception e) {
		}
		txtTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(405, 56, 94, 20);
		pnlAcademia.add(txtTelefone);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNumero.setColumns(10);
		txtNumero.setBounds(79, 141, 94, 20);
		pnlAcademia.add(txtNumero);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(256, 141, 162, 20);
		pnlAcademia.add(txtBairro);

		JLabel lblNewLabel = new JLabel("Cidade:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 173, 46, 14);
		pnlAcademia.add(lblNewLabel);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(79, 170, 180, 20);
		pnlAcademia.add(txtCidade);

		JLabel lblIdDaFederao = new JLabel("Id Academia:");
		lblIdDaFederao.setForeground(Color.RED);
		lblIdDaFederao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIdDaFederao.setBounds(10, 12, 115, 24);
		pnlAcademia.add(lblIdDaFederao);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 489, 4);
		pnlAcademia.add(separator);

		txtIdAcademia = new JTextField();
		txtIdAcademia.setText("00");
		txtIdAcademia.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdAcademia.setForeground(Color.RED);
		txtIdAcademia.setFont(new Font("Dialog", Font.BOLD, 18));
		txtIdAcademia.setEditable(false);
		txtIdAcademia.setColumns(10);
		txtIdAcademia.setBorder(null);
		txtIdAcademia.setBounds(135, 15, 96, 20);
		pnlAcademia.add(txtIdAcademia);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1 = new JLabel("CEP:");
		lblNewLabel_1_1_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1.setBounds(10, 114, 28, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2_1);

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			txtCep.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
						Academia academia = new Academia();
						AcademiaDAO dao = new AcademiaDAO();
						academia = dao.buscaCep(txtCep.getText());

						txtEndereco.setText(academia.getEndereco());
						txtBairro.setText(academia.getBairro());
						txtCidade.setText(academia.getCidade());
					}

				}
			});
		} catch (Exception e) {
		}
		txtCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCep.setColumns(10);
		txtCep.setBounds(79, 112, 94, 20);
		pnlAcademia.add(txtCep);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execucao do comando incluir acaddemia
				Academia academia = new Academia();

				academia.setNomeAcademia(txtAcademia.getText());
				academia.setEmail(txtEmail.getText());
				academia.setTelefone(txtTelefone.getText());
				academia.setCelular(txtCelular.getText());
				academia.setCep(txtCep.getText());
				academia.setEndereco(txtEndereco.getText());
				academia.setNumero(Integer.parseInt(txtNumero.getText()));
				academia.setBairro(txtBairro.getText());
				academia.setCidade(txtCidade.getText());

				// incluir academia
				AcademiaDAO dao = new AcademiaDAO();
				dao.incluirAcademia(academia);
				txtIdAcademia.setText(String.valueOf(academia.getId()));
				listarTabela();
			}
		});
		btnIncluir.setBounds(89, 195, 100, 29);
		pnlAcademia.add(btnIncluir);
		btnIncluir.setIcon(
				new ImageIcon(FrmAcademia.class.getResource("/image/103863_disk_floppy_guardar_save_icon.png")));
		btnIncluir.setHorizontalAlignment(SwingConstants.LEADING);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execução do comando alterar academia
				Academia academia = new Academia();

				academia.setId(Integer.parseInt(txtIdAcademia.getText()));
				academia.setNomeAcademia(txtAcademia.getText());
				academia.setEmail(txtEmail.getText());
				academia.setTelefone(txtTelefone.getText());
				academia.setCelular(txtCelular.getText());
				academia.setCep(txtCep.getText());
				academia.setEndereco(txtEndereco.getText());
				academia.setNumero(Integer.parseInt(txtNumero.getText()));
				academia.setBairro(txtBairro.getText());
				academia.setCidade(txtCidade.getText());

				//setAcademia();
				// alterar academia
				AcademiaDAO dao = new AcademiaDAO();
				dao.alterarAcademia(academia);

				// Consultar a academia recém-alterada
				Academia academiaInserida = dao.consultarAcademia(Integer.parseInt(txtIdAcademia.getText()));
				if (academiaInserida != null) {
					txtIdAcademia.setText(String.valueOf(academiaInserida.getId()));
				}
				listarTabela();

			}
		});
		btnAlterar.setBounds(199, 195, 100, 29);
		pnlAcademia.add(btnAlterar);
		btnAlterar.setIcon(new ImageIcon(FrmAcademia.class.getResource("/image/285638_pencil_icon.png")));
		btnAlterar.setHorizontalAlignment(SwingConstants.LEADING);

		JButton btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnlAcademia);
			}
		});
		btnLimparTela.setForeground(new Color(0, 0, 255));
		btnLimparTela.setBounds(309, 195, 128, 29);
		pnlAcademia.add(btnLimparTela);
		btnLimparTela.setIcon(new ImageIcon(FrmAcademia.class.getResource("/image/118917_edit_clear_icon.png")));
		btnLimparTela.setHorizontalAlignment(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2_2 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1_1_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_2.setBounds(10, 87, 59, 16);
		pnlAcademia.add(lblNewLabel_1_1_1_1_1_1_2_2);
		
		try{
			txtCelular = new JFormattedTextField ((new MaskFormatter("(##)#####-####")));
			} catch (Exception e) {
				
			};
		txtCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBounds(79, 85, 100, 20);
		pnlAcademia.add(txtCelular);

		JPanel pnlTabelaAcademia = new JPanel();
		pnlTabelaAcademia.setLayout(null);
		pnlTabelaAcademia.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlTabelaAcademia.setBounds(0, 230, 979, 272);
		pnlDadosAcademia.add(pnlTabelaAcademia);

		tblAcademia = new JTable();
		tblAcademia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblAcademia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdAcademia.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 0).toString());
				txtAcademia.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 1).toString());
				txtTelefone.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 2).toString());
				txtCelular.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 3).toString());
				txtEmail.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 4).toString());
				txtCep.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 5).toString());
				txtEndereco.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 6).toString());
				txtNumero.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 7).toString());
				txtBairro.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 8).toString());
				txtCidade.setText(tblAcademia.getValueAt(tblAcademia.getSelectedRow(), 9).toString());
			}
		});
		tblAcademia.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Academia", "Telefone", "Celular", 
				"Email", "Cep", "Endere\u00E7o", "N\u00FAmero", "Bairro", "Cidade" }));
		tblAcademia.setBounds(0, 0, 745, 0);
		listarTabela();
		pnlTabelaAcademia.add(tblAcademia);

		JScrollPane scrollPane_1 = new JScrollPane(tblAcademia);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 40, 959, 188);
		pnlTabelaAcademia.add(scrollPane_1);
		// Ajuste automático da largura das colunas
		for (int column = 0; column < tblAcademia.getColumnCount(); column++) {
			TableColumn tableColumn = tblAcademia.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < tblAcademia.getRowCount(); row++) {
				TableCellRenderer cellRenderer = tblAcademia.getCellRenderer(row, column);
				Component c = tblAcademia.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + tblAcademia.getIntercellSpacing().width + 50;
				preferredWidth = Math.max(preferredWidth, width);
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
		ordenarTabelaPorColuna(0);
		listarTabela();

		JLabel lblNewLabel_1_1_1_1_1_1_3_2 = new JLabel("Academia:");
		lblNewLabel_1_1_1_1_1_1_3_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3_2.setBounds(10, 13, 58, 16);
		pnlTabelaAcademia.add(lblNewLabel_1_1_1_1_1_1_3_2);

		JComboBox<Academia> cmbAcademia = new JComboBox<>();
		cmbAcademia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						// Obtem o item selecionado na combo box
						Academia selectedAcademia = (Academia) cmbAcademia.getSelectedItem();

						// Atualiza o valor da label txtIdAcademia com o valor da ID da Academia
						// selecionada
						txtAcademia.setText(String.valueOf(selectedAcademia.getId()));

						// O valor da txtIdFederacao deve ser transferido para a variável valor que vai
						// alimentar o método PreencherConsultaFederacao
						String valorIdAcademia = txtIdAcademia.getText();
						valor = Integer.parseInt(valorIdAcademia);

						PreencherConsultaAcademia(valor);
						new Utilitarios().LimparTela(pnlAcademia);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		//Carrega a lista de academia
		AcademiaDAO dao = new AcademiaDAO();
		List<Academia> listaAcademia = dao.listarAcademia();
		for (Academia a : listaAcademia) {
			cmbAcademia.addItem(a);
		}

		cmbAcademia.setBounds(78, 11, 315, 22);
		pnlTabelaAcademia.add(cmbAcademia);

		JButton btnFecharMdulo = new JButton("Fechar módulo");
		btnFecharMdulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharMdulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnFecharMdulo.setForeground(Color.BLACK);
		btnFecharMdulo.setBounds(839, 242, 130, 27);
		pnlTabelaAcademia.add(btnFecharMdulo);

		JPanel pnlTabelaAcademiaAlunos = new JPanel();
		pnlTabelaAcademiaAlunos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTabelaAcademiaAlunos.setBounds(513, 0, 466, 231);
		pnlDadosAcademia.add(pnlTabelaAcademiaAlunos);
		pnlTabelaAcademiaAlunos.setLayout(null);

		tblAcademiaAlunos = new JTable();
		tblAcademiaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblAcademiaAlunos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id Academia", "Academia", "Aluno" }));
		tblAcademiaAlunos.setBounds(10, 11, 446, 202);
		pnlTabelaAcademiaAlunos.add(tblAcademiaAlunos);

		JScrollPane scrollPane = new JScrollPane(tblAcademiaAlunos);
		scrollPane.setBounds(10, 64, 446, 149);
		pnlTabelaAcademiaAlunos.add(scrollPane);

		JLabel lblNewLabel_1_1_1_1_1_1_3_2_1 = new JLabel("Academia:");
		lblNewLabel_1_1_1_1_1_1_3_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3_2_1.setBounds(36, 12, 58, 16);
		pnlTabelaAcademiaAlunos.add(lblNewLabel_1_1_1_1_1_1_3_2_1);

		JComboBox<Academia> cmbProcuraAcademia = new JComboBox<>();
		cmbProcuraAcademia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						// Obtem o item selecionado na combo box
						Academia selectedAcademia = (Academia) cmbAcademia.getSelectedItem();

						// Atualiza o valor da label txtIdAcademia com o valor da ID da Academia
						// selecionada
						txtAcademia.setText(String.valueOf(selectedAcademia.getId()));

						// O valor da txtIdFederacao deve ser transferido para a variável valor que vai
						// alimentar o método PreencherConsultaFederacao
						String valorIdAcademia = txtIdAcademia.getText();
						valor = Integer.parseInt(valorIdAcademia);

						PreencherConsultaAcademia(valor);
						new Utilitarios().LimparTela(pnlAcademia);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}

		});
		//Carrega a lista de academia
		AcademiaDAO academiadao = new AcademiaDAO();
		List<Academia> listaProcurarAcademia = academiadao.listarAcademia();
		for (Academia a : listaAcademia) {
			cmbProcuraAcademia.addItem(a);
		}
		cmbProcuraAcademia.setBounds(104, 10, 315, 22);
		pnlTabelaAcademiaAlunos.add(cmbProcuraAcademia);

		JLabel lblNewLabel_1_1_1_1_1_1_3_2_1_1 = new JLabel("Aluno:");
		lblNewLabel_1_1_1_1_1_1_3_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3_2_1_1.setBounds(36, 39, 58, 16);
		pnlTabelaAcademiaAlunos.add(lblNewLabel_1_1_1_1_1_1_3_2_1_1);

		txtPesquisaAluno = new JTextField();
		txtPesquisaAluno.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPesquisaAluno.setColumns(10);
		txtPesquisaAluno.setBounds(104, 38, 275, 20);
		pnlTabelaAcademiaAlunos.add(txtPesquisaAluno);

		JButton btnPesquisaAluno = new JButton("");
		btnPesquisaAluno.setIcon(
				new ImageIcon(FrmAcademia.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaAluno.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaAluno.setBounds(391, 38, 28, 23);
		pnlTabelaAcademiaAlunos.add(btnPesquisaAluno);

		// fim do metodo construtor
	}

	public void setAcademia() {

		Academia academia = new Academia();
		academia.setId(Integer.parseInt(txtIdAcademia.getText()));
		academia.setNomeAcademia(txtAcademia.getText());
		academia.setEmail(txtEmail.getText());
		academia.setTelefone(txtTelefone.getText());
		academia.setCep(txtCep.getText());
		academia.setEndereco(txtEndereco.getText());
		academia.setNumero(Integer.parseInt(txtNumero.getText()));
		academia.setBairro(txtBairro.getText());
		academia.setCidade(txtCidade.getText());
		academia.setCelular(txtCelular.getText());
	}

	// metodo listartabela
	public void listarTabela() {
		AcademiaDAO dao = new AcademiaDAO();
		List<Academia> lista = dao.listarAcademia();
		DefaultTableModel dados = (DefaultTableModel) tblAcademia.getModel();
		dados.setNumRows(0);

		for (Academia r : lista) {
			dados.addRow(new Object[] { r.getId(), r.getNomeAcademia(), r.getTelefone(), r.getCelular(), r.getEmail(), r.getCep(),
					r.getEndereco(), r.getNumero(), r.getBairro(), r.getCidade()

			});
		}
	}

	// esse metodo vai passar o valor do id para o metodo de consulta e vai carregar
	// as informacoes
	// nos campos
	public void PreencherConsultaAcademia(int valor) {
		System.out.println(valor);
		AcademiaDAO dao = new AcademiaDAO();
		Academia academia = dao.consultarAcademia(valor);
		txtAcademia.setText(academia.getNomeAcademia());
		txtBairro.setText(academia.getBairro());
		txtTelefone.setText(academia.getTelefone());
		txtEmail.setText(academia.getEmail());
		txtCep.setText(academia.getCep());
		txtEndereco.setText(academia.getEndereco());
		txtCidade.setText(academia.getCidade());
		txtNumero.setText(String.valueOf(academia.getNumero()));

	}

	private void ordenarTabelaPorColuna(int coluna) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblAcademia.getModel());
		tblAcademia.setRowSorter(sorter);
		sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(coluna, SortOrder.ASCENDING)));
	}
}
