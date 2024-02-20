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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.FederacaoDAO;
import br.com.projeto.dao.RepresentanteDAO;
import br.com.projeto.model.Federacao;
import br.com.projeto.model.RepresentanteFederacao;
import br.com.projeto.model.Utilitarios;

public class FrmFederacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnl_representante ;
	private JTable tblFederacao;
	private JTextField txtNomeFederacao;
	private JTextField txtEmailFederacao;
	private JTextField txtEnderecoFederacao;
	private JFormattedTextField txtTelefoneFederacao;
	private JFormattedTextField txtCepFederacao;
	private JTextField txtNumeroFederacao;
	private JTextField txtBairroFederacao;
	private JTextField txtCidadeFederacao;
	private JTextField txtRepresentante;
	private JTextField txtTelefoneRepresentante;
	private JTextField txtEmailRepresentante;
	private JTable tblConsultaFederacao;
	private JTextField txtAno;
	private JTextField txtChavePixFederacao;
	private JTextField txtPesquisaRepresentante;
	private JComboBox<String> cmbEstadoFederacao;
	private JComboBox<String> cmbStatus;
	private int valor;
	private JTextField txtIdFederacao;
	private JTextField txtIdRepresentante;
	private JComboBox<String> cmbFuncao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFederacao frame = new FrmFederacao();
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
	public FrmFederacao() {
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmFederacao.class.getResource("/image/logo ryukumite.jpg")));
		setTitle("Associação Ryu Kumite - Federação");
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
		pnlTitulo.setLayout(null);
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(0, 0, 984, 48);
		contentPane.add(pnlTitulo);

		JLabel lblMembroDaAssociao = new JLabel("ASSOCIAÇÃO RYU KUMITÊ - FEDERAÇÃO");
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
		dskpaneLogo.setBounds(10, 0, 196, 48);
		pnlTitulo.add(dskpaneLogo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBounds(0, 47, 984, 529);
		contentPane.add(tabbedPane);

		JPanel pnlDadosFederacao = new JPanel();
		tabbedPane.addTab("Dados da Federação", null, pnlDadosFederacao, null);
		pnlDadosFederacao.setLayout(null);

		JPanel pnl_federacao = new JPanel();
		pnl_federacao.setLayout(null);
		pnl_federacao.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_federacao.setBounds(0, 0, 379, 314);
		pnlDadosFederacao.add(pnl_federacao);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Federação:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 60, 62, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 87, 59, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(10, 114, 59, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1 = new JLabel("CEP:");
		lblNewLabel_1_1_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1.setBounds(191, 114, 28, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_1 = new JLabel("Endereço:");
		lblNewLabel_1_1_1_1_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_1.setBounds(10, 141, 59, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_2_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_2 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_1_1_1_2_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_2.setBounds(183, 168, 36, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_2_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_3 = new JLabel("Número:");
		lblNewLabel_1_1_1_1_1_1_2_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_3.setBounds(10, 168, 48, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_2_1_3);

		txtNomeFederacao = new JTextField();
		txtNomeFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNomeFederacao.setColumns(10);
		txtNomeFederacao.setBounds(79, 59, 267, 20);
		pnl_federacao.add(txtNomeFederacao);

		cmbEstadoFederacao = new JComboBox<>();
		cmbEstadoFederacao.setModel(new DefaultComboBoxModel<>(
				new String[] { "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
						"PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));
		cmbEstadoFederacao.setBounds(79, 220, 69, 22);
		pnl_federacao.add(cmbEstadoFederacao);

		JButton btnIncluirFederacao = new JButton("Incluir");
		btnIncluirFederacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Execução do botao incluir Federacao
				Federacao federacao = new Federacao();

				federacao.setNome(txtNomeFederacao.getText());
				federacao.setCep(txtCepFederacao.getText());
				federacao.setEndereco(txtEnderecoFederacao.getText());
				federacao.setNumero(Integer.parseInt(txtNumeroFederacao.getText()));
				federacao.setBairro(txtBairroFederacao.getText());
				federacao.setCidade(txtCidadeFederacao.getText());
				federacao.setEstado(cmbEstadoFederacao.getSelectedItem().toString());
				federacao.setEmail(txtEmailFederacao.getText());
				federacao.setTelefone(txtTelefoneFederacao.getText());
				federacao.setPix(txtChavePixFederacao.getText());

				// Incluir Federacao
				FederacaoDAO dao = new FederacaoDAO();
				dao.cadastrarFederacao(federacao);
				txtIdFederacao.setText(String.valueOf(federacao.getIdFederacao()));
			}
		});
		btnIncluirFederacao.setBounds(38, 280, 80, 23);
		pnl_federacao.add(btnIncluirFederacao);

		JButton btnAlterarFederacao = new JButton("Alterar");
		btnAlterarFederacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Federacao federacao = new Federacao();
				federacao.setNome(txtNomeFederacao.getText());
				federacao.setCep(txtCepFederacao.getText());
				federacao.setEndereco(txtEnderecoFederacao.getText());
				federacao.setNumero(Integer.parseInt(txtNumeroFederacao.getText()));
				federacao.setBairro(txtBairroFederacao.getText());
				federacao.setCidade(txtCidadeFederacao.getText());
				federacao.setEstado(cmbEstadoFederacao.getSelectedItem().toString());
				federacao.setEmail(txtEmailFederacao.getText());
				federacao.setTelefone(txtTelefoneFederacao.getText());
				federacao.setPix(txtChavePixFederacao.getText());
				federacao.setIdFederacao(Integer.parseInt(txtIdFederacao.getText()));

				// Alterar Federacao
				FederacaoDAO dao = new FederacaoDAO();
				dao.alterarFederacao(federacao);

			}
		});
		btnAlterarFederacao.setBounds(128, 280, 80, 23);
		pnl_federacao.add(btnAlterarFederacao);

		txtEmailFederacao = new JTextField();
		txtEmailFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmailFederacao.setColumns(10);
		txtEmailFederacao.setBounds(79, 86, 267, 20);
		pnl_federacao.add(txtEmailFederacao);

		txtEnderecoFederacao = new JTextField();
		txtEnderecoFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEnderecoFederacao.setColumns(10);
		txtEnderecoFederacao.setBounds(79, 139, 243, 20);
		pnl_federacao.add(txtEnderecoFederacao);

		try {
			txtTelefoneFederacao = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
			txtTelefoneFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
			txtTelefoneFederacao.setColumns(10);
			txtTelefoneFederacao.setBounds(79, 113, 94, 20);
			pnl_federacao.add(txtTelefoneFederacao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			txtCepFederacao = new JFormattedTextField(new MaskFormatter("#####-###"));
			txtCepFederacao.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
						Federacao federacao = new Federacao();
						FederacaoDAO dao = new FederacaoDAO();
						federacao = dao.buscaCep(txtCepFederacao.getText());

						txtEnderecoFederacao.setText(federacao.getEndereco());
						txtBairroFederacao.setText(federacao.getBairro());
						txtCidadeFederacao.setText(federacao.getCidade());
						cmbEstadoFederacao.setSelectedItem(federacao.getEstado());
					}

				}
			});
			txtCepFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
			txtCepFederacao.setColumns(10);
			txtCepFederacao.setBounds(229, 112, 94, 20);
			pnl_federacao.add(txtCepFederacao);
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtNumeroFederacao = new JTextField();
		txtNumeroFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNumeroFederacao.setColumns(10);
		txtNumeroFederacao.setBounds(79, 166, 94, 20);
		pnl_federacao.add(txtNumeroFederacao);

		txtBairroFederacao = new JTextField();
		txtBairroFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtBairroFederacao.setColumns(10);
		txtBairroFederacao.setBounds(228, 166, 94, 20);
		pnl_federacao.add(txtBairroFederacao);

		JLabel lblNewLabel = new JLabel("Cidade:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 195, 46, 14);
		pnl_federacao.add(lblNewLabel);

		txtCidadeFederacao = new JTextField();
		txtCidadeFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCidadeFederacao.setColumns(10);
		txtCidadeFederacao.setBounds(79, 193, 180, 20);
		pnl_federacao.add(txtCidadeFederacao);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEstado.setBounds(10, 223, 46, 14);
		pnl_federacao.add(lblEstado);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 348, 9);
		pnl_federacao.add(separator);

		JLabel lblNewLabel_1_1_1_1_1_1_4 = new JLabel("Chave Pix:");
		lblNewLabel_1_1_1_1_1_1_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_4.setBounds(10, 249, 62, 16);
		pnl_federacao.add(lblNewLabel_1_1_1_1_1_1_4);

		txtChavePixFederacao = new JTextField();
		txtChavePixFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChavePixFederacao.setColumns(10);
		txtChavePixFederacao.setBounds(79, 248, 243, 20);
		pnl_federacao.add(txtChavePixFederacao);

		JLabel lblFederacao = new JLabel("Id Federação:");
		lblFederacao.setForeground(new Color(0, 0, 0));
		lblFederacao.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFederacao.setBounds(10, 7, 96, 19);
		pnl_federacao.add(lblFederacao);

		JLabel lblRepresentante = new JLabel("Id Representante:");
		lblRepresentante.setForeground(new Color(0, 0, 0));
		lblRepresentante.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRepresentante.setBounds(232, 7, 126, 19);
		pnl_federacao.add(lblRepresentante);

		JButton btnLimparTela = new JButton("Limpar tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnl_federacao);
				new Utilitarios().LimparTela(pnl_representante);
				
			}
		});
		btnLimparTela.setHorizontalAlignment(SwingConstants.LEADING);
		btnLimparTela.setIcon(new ImageIcon(FrmFederacao.class.getResource("/image/118917_edit_clear_icon.png")));
		btnLimparTela.setForeground(new Color(0, 0, 255));
		btnLimparTela.setBounds(218, 280, 128, 23);
		pnl_federacao.add(btnLimparTela);

		txtIdFederacao = new JTextField();
		txtIdFederacao.setText("00");
		txtIdFederacao.setBorder(null);
		txtIdFederacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdFederacao.setFont(new Font("Dialog", Font.BOLD, 18));
		txtIdFederacao.setForeground(new Color(255, 0, 0));
		txtIdFederacao.setEditable(false);
		txtIdFederacao.setBounds(10, 28, 96, 20);
		pnl_federacao.add(txtIdFederacao);
		txtIdFederacao.setColumns(10);

		txtIdRepresentante = new JTextField();
		txtIdRepresentante.setText("00");
		txtIdRepresentante.setBorder(null);
		txtIdRepresentante.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdRepresentante.setFont(new Font("Dialog", Font.BOLD, 18));
		txtIdRepresentante.setForeground(new Color(255, 0, 0));
		txtIdRepresentante.setEditable(false);
		txtIdRepresentante.setColumns(10);
		txtIdRepresentante.setBounds(246, 28, 96, 20);
		pnl_federacao.add(txtIdRepresentante);

		pnl_representante = new JPanel();
		pnl_representante.setLayout(null);
		pnl_representante.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl_representante.setBounds(0, 314, 379, 181);
		pnlDadosFederacao.add(pnl_representante);

		JLabel lblNewLabel_1_1_1_1_2_1_1_1 = new JLabel("Função:");
		lblNewLabel_1_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_2_1_1_1.setBounds(10, 43, 58, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_2_1_1_1);

		JLabel lblNewLabel_1_1_1_1_4_1_1_1 = new JLabel("Representante:");
		lblNewLabel_1_1_1_1_4_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_1_1_1.setBounds(10, 13, 85, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_4_1_1_1);

		cmbFuncao = new JComboBox<>();
		cmbFuncao.setModel(
				new DefaultComboBoxModel<>(new String[] { "Presidente", "Diretor", "Financeiro", "Secretaria" }));
		cmbFuncao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbFuncao.setBounds(82, 40, 99, 22);
		pnl_representante.add(cmbFuncao);

		cmbStatus = new JComboBox<>();
		cmbStatus.setModel(new DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
		cmbStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbStatus.setBounds(252, 40, 99, 22);
		pnl_representante.add(cmbStatus);

		JButton btnIncluirRepresentante = new JButton("Incluir");
		btnIncluirRepresentante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepresentanteFederacao representante = new RepresentanteFederacao();

				representante.setRepresentante(txtRepresentante.getText());
				representante.setStatus(cmbStatus.getSelectedItem().toString());
				representante.setFuncao(cmbFuncao.getSelectedItem().toString());
				representante.setAno(Integer.parseInt(txtAno.getText()));
				representante.settelefoneRepresentante(txtTelefoneRepresentante.getText());
				representante.setEmailRepresentante(txtEmailRepresentante.getText());
				representante.setIdFederacao(Integer.parseInt(txtIdFederacao.getText()));

				// incluir o representante
				RepresentanteDAO dao = new RepresentanteDAO();
				dao.cadastrarRepresentante(representante);

				// Consultar o representante recém-inserido
				RepresentanteFederacao representanteInserido = dao
						.consultaRepresentantePorNome(representante.getRepresentante());
				if (representanteInserido != null) {
					txtIdRepresentante.setText(String.valueOf(representanteInserido.getIdRepresentante()));
				}
				listarTabela();
			}
		});
		btnIncluirRepresentante.setBounds(38, 147, 80, 23);
		pnl_representante.add(btnIncluirRepresentante);

		JButton btnAlterarRepresentante = new JButton("Alterar");
		btnAlterarRepresentante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepresentanteFederacao representante = new RepresentanteFederacao();
				representante.setRepresentante(txtRepresentante.getText());
				representante.setStatus(cmbStatus.getSelectedItem().toString());
				representante.setFuncao(cmbFuncao.getSelectedItem().toString());
				representante.setAno(Integer.parseInt(txtAno.getText()));
				representante.settelefoneRepresentante(txtTelefoneRepresentante.getText());
				representante.setEmailRepresentante(txtEmailRepresentante.getText());
				representante.setIdRepresentante(Integer.parseInt(txtIdRepresentante.getText()));
				RepresentanteDAO dao = new RepresentanteDAO();
				dao.alterarRepresentante(representante);

				// Consultar o representante recém-inserido
				RepresentanteFederacao representanteInserido = dao
						.consultaRepresentante(Integer.parseInt(txtIdRepresentante.getText()));
				if (representanteInserido != null) {
					txtIdRepresentante.setText(String.valueOf(representanteInserido.getIdRepresentante()));
				}

				listarTabela();
			}
		});
		btnAlterarRepresentante.setBounds(152, 147, 80, 23);
		pnl_representante.add(btnAlterarRepresentante);

		JButton btnExcluirRepresentante = new JButton("Excluir");
		btnExcluirRepresentante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepresentanteFederacao representante = new RepresentanteFederacao();

				representante.setIdRepresentante(Integer.parseInt(txtIdRepresentante.getText()));

				RepresentanteDAO dao = new RepresentanteDAO();
				dao.excluirRepresentante(representante);
				listarTabela();
				new Utilitarios().LimparTela(pnl_federacao);
				new Utilitarios().LimparTela(pnl_representante);
			}
		});
		btnExcluirRepresentante.setBounds(266, 147, 80, 23);
		pnl_representante.add(btnExcluirRepresentante);

		txtRepresentante = new JTextField();
		txtRepresentante.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtRepresentante.setColumns(10);
		txtRepresentante.setBounds(105, 11, 246, 20);
		pnl_representante.add(txtRepresentante);

		JLabel lblNewLabel_1_1_1_1_1_1_2_2 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_2.setBounds(191, 75, 51, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_1_1_2_2);

		txtTelefoneRepresentante = new JTextField();
		txtTelefoneRepresentante.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTelefoneRepresentante.setColumns(10);
		txtTelefoneRepresentante.setBounds(252, 73, 99, 20);
		pnl_representante.add(txtTelefoneRepresentante);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_1_1.setBounds(10, 104, 59, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_1_1_2_1_1_1);

		txtEmailRepresentante = new JTextField();
		txtEmailRepresentante.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmailRepresentante.setColumns(10);
		txtEmailRepresentante.setBounds(82, 102, 246, 20);
		pnl_representante.add(txtEmailRepresentante);

		JLabel lblNewLabel_1_1_1_1_1_1_2_1_1_1_1 = new JLabel("Ano:");
		lblNewLabel_1_1_1_1_1_1_2_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_1_1_1_1.setBounds(10, 75, 24, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_1_1_2_1_1_1_1);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAno.setColumns(10);
		txtAno.setBounds(82, 73, 99, 20);
		pnl_representante.add(txtAno);

		JLabel lblNewLabel_1_1_1_1_1_1_2_2_1 = new JLabel("Status:");
		lblNewLabel_1_1_1_1_1_1_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_2_2_1.setBounds(204, 43, 38, 16);
		pnl_representante.add(lblNewLabel_1_1_1_1_1_1_2_2_1);

		JPanel pnlPesquisaRepresentante = new JPanel();
		pnlPesquisaRepresentante.setLayout(null);
		pnlPesquisaRepresentante.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlPesquisaRepresentante.setBounds(378, 0, 595, 495);
		pnlDadosFederacao.add(pnlPesquisaRepresentante);

		tblFederacao = new JTable();
		tblFederacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdFederacao.setText(tblFederacao.getValueAt(tblFederacao.getSelectedRow(), 0).toString());
				txtRepresentante.setText(tblFederacao.getValueAt(tblFederacao.getSelectedRow(), 2).toString());
				PreencherConsultaFederacao(Integer.parseInt(txtIdFederacao.getText()));
				PreencherConsultaRepresentantePorNome(txtRepresentante.getText());
			}
		});
		tblFederacao.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Federa\u00E7\u00E3o",
				"Representante", "Fun\u00E7\u00E3o", "Email", "Telefone", "Chave Pix" }));
		tblFederacao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblFederacao.setBounds(0, 0, 367, 0);
		listarTabela();
		pnlPesquisaRepresentante.add(tblFederacao);

		JScrollPane scrollPane_3 = new JScrollPane(tblFederacao);
		scrollPane_3.setBounds(10, 81, 575, 365);
		pnlPesquisaRepresentante.add(scrollPane_3);
		// Ajuste automático da largura das colunas
		for (int column = 0; column < tblFederacao.getColumnCount(); column++) {
		    TableColumn tableColumn = tblFederacao.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();

		    for (int row = 0; row < tblFederacao.getRowCount(); row++) {
		        TableCellRenderer cellRenderer = tblFederacao.getCellRenderer(row, column);
		        Component c = tblFederacao.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + tblFederacao.getIntercellSpacing().width + 50;
		        preferredWidth = Math.max(preferredWidth, width);
		    }
		    tableColumn.setPreferredWidth(preferredWidth);
		}
		ordenarTabelaPorColuna(0);
		listarTabela();


		JLabel lblNewLabel_1_1_1_1_1_1_3 = new JLabel("Federação:");
		lblNewLabel_1_1_1_1_1_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3.setBounds(198, 16, 62, 16);
		pnlPesquisaRepresentante.add(lblNewLabel_1_1_1_1_1_1_3);

		JComboBox<Federacao> cmbFederacao = new JComboBox<>();
		// Carregue a lista de federações uma vez, talvez na inicialização do formulário
		FederacaoDAO dao = new FederacaoDAO();
		List<Federacao> listaFederacao = dao.listarFederacao();
		for (Federacao f : listaFederacao) {
			cmbFederacao.addItem(f);
		}
		cmbFederacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					try {
						// Obtem o item selecionado na combo box
						Federacao selectedFederacao = (Federacao) cmbFederacao.getSelectedItem();

						// Atualiza o valor da label txtIdFederacao com o valor da ID da Federacao
						// selecionada
						txtIdFederacao.setText(String.valueOf(selectedFederacao.getIdFederacao()));

						// O valor da txtIdFederacao deve ser transferido para a variável valor que vai
						// alimentar o método PreencherConsultaFederacao
						String valorIdFederacao = txtIdFederacao.getText();
						valor = Integer.parseInt(valorIdFederacao);

						PreencherConsultaFederacao(valor);
						new Utilitarios().LimparTela(pnl_representante);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		cmbFederacao.setBounds(270, 11, 315, 22);
		pnlPesquisaRepresentante.add(cmbFederacao);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Representante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 155, 59);
		pnlPesquisaRepresentante.add(panel_3);
		panel_3.setLayout(null);

		JCheckBox chckbxAtivo = new JCheckBox("Ativo");
		chckbxAtivo.setSelected(true);
		chckbxAtivo.setBounds(16, 18, 59, 23);
		panel_3.add(chckbxAtivo);

		JCheckBox chckbxInativo = new JCheckBox("Inativo");
		chckbxInativo.setBounds(77, 18, 67, 23);
		panel_3.add(chckbxInativo);

		JLabel lblNewLabel_1_1_1_1_1_1_3_2 = new JLabel("Representante:");
		lblNewLabel_1_1_1_1_1_1_3_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3_2.setBounds(175, 41, 85, 16);
		pnlPesquisaRepresentante.add(lblNewLabel_1_1_1_1_1_1_3_2);

		txtPesquisaRepresentante = new JTextField();
		txtPesquisaRepresentante.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPesquisaRepresentante.setColumns(10);
		txtPesquisaRepresentante.setBounds(270, 39, 275, 20);
		pnlPesquisaRepresentante.add(txtPesquisaRepresentante);

		JButton btnPesquisa_1 = new JButton("");
		btnPesquisa_1.setIcon(
				new ImageIcon(FrmFederacao.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisa_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisa_1.setBounds(557, 39, 28, 23);
		pnlPesquisaRepresentante.add(btnPesquisa_1);
		
		JButton btnFecharMdulo = new JButton("Fechar módulo");
		btnFecharMdulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharMdulo.setSelectedIcon(null);
		btnFecharMdulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnFecharMdulo.setForeground(new Color(0, 0, 0));
		btnFecharMdulo.setBounds(455, 457, 130, 27);
		pnlPesquisaRepresentante.add(btnFecharMdulo);

		JPanel pnlFederado = new JPanel();
		tabbedPane.addTab("Dados Federado", null, pnlFederado, null);
		pnlFederado.setLayout(null);

		JPanel pnlConsultaFederado = new JPanel();
		pnlConsultaFederado.setLayout(null);
		pnlConsultaFederado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlConsultaFederado.setBounds(0, 0, 973, 495);
		pnlFederado.add(pnlConsultaFederado);

		tblConsultaFederacao = new JTable();
		tblConsultaFederacao.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Federacao",
				"Chave Pix", "Federado", "Anuidade", "Status", "Registro", "Faixa" }));
		tblConsultaFederacao.setBounds(0, 0, 367, 0);
		pnlConsultaFederado.add(tblConsultaFederacao);

		JScrollPane scrollPane_3_1 = new JScrollPane(tblConsultaFederacao);
		scrollPane_3_1.setBounds(10, 54, 953, 441);
		pnlConsultaFederado.add(scrollPane_3_1);

		JLabel lblNewLabel_1_1_1_1_1_1_3_1 = new JLabel("Federação:");
		lblNewLabel_1_1_1_1_1_1_3_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1_3_1.setBounds(10, 22, 62, 16);
		pnlConsultaFederado.add(lblNewLabel_1_1_1_1_1_1_3_1);

		JComboBox<Federacao> cmbConsultaFederacao = new JComboBox<>();
		cmbConsultaFederacao.setBounds(82, 20, 246, 22);
		pnlConsultaFederado.add(cmbConsultaFederacao);

		JButton btnPesquisaFederacao = new JButton("");
		btnPesquisaFederacao.setIcon(
				new ImageIcon(FrmFederacao.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaFederacao.setSelectedIcon(null);
		btnPesquisaFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaFederacao.setBounds(339, 20, 28, 23);
		pnlConsultaFederado.add(btnPesquisaFederacao);

		//fim do constructor
	}
	
	

	// metodo listartabela
	public void listarTabela() {
		RepresentanteDAO dao = new RepresentanteDAO();
		List<RepresentanteFederacao> lista = dao.listarRepresentante();
		DefaultTableModel dadosTabelaFederacao = (DefaultTableModel) tblFederacao.getModel();
		dadosTabelaFederacao.setNumRows(0);

		for (RepresentanteFederacao r : lista) {
			dadosTabelaFederacao.addRow(new Object[] { r.getIdFederacao(), r.getNome(), r.getRepresentante(),
					r.getFuncao(), r.getEmailRepresentante(), r.gettelefoneRepresentante(), r.getPix()

			});
		}
	}

	//esse metodo vai passar o valor do id para o metodo de consulta e vai carregar as informacoes 
	//nos campos
	public void PreencherConsultaFederacao(int valor) {
		System.out.println(valor);
		FederacaoDAO dao = new FederacaoDAO();
		Federacao federacao = dao.ConsultaFederacao(valor);
		txtNomeFederacao.setText(federacao.getNome());
		txtBairroFederacao.setText(federacao.getBairro());
		txtTelefoneFederacao.setText(federacao.getTelefone());
		txtEmailFederacao.setText(federacao.getEmail());
		txtCepFederacao.setText(federacao.getCep());
		txtEnderecoFederacao.setText(federacao.getEndereco());
		txtBairroFederacao.setText(federacao.getBairro());
		txtNumeroFederacao.setText(String.valueOf(federacao.getNumero()));
		txtBairroFederacao.setText(federacao.getBairro());
		txtCidadeFederacao.setText(federacao.getCidade());
		txtChavePixFederacao.setText(federacao.getPix());
		cmbEstadoFederacao.setSelectedItem(federacao.getEstado());

	}

	
	//esse metodo vai passar o valor do id para o metodo de consulta e vai carregar as informacoes 
	//nos campos

	public void PreencherConsultaRepresentante(int valor) {
		System.out.println(valor);
		RepresentanteDAO dao = new RepresentanteDAO();
		RepresentanteFederacao representante = dao.consultaRepresentante(valor);
		txtIdRepresentante.setText(String.valueOf(representante.getIdRepresentante()));
		txtRepresentante.setText(representante.getRepresentante());
		txtEmailRepresentante.setText(representante.getEmailRepresentante());
		txtTelefoneRepresentante.setText(representante.gettelefoneRepresentante());
		txtAno.setText(String.valueOf(representante.getAno()));
		cmbFuncao.setSelectedItem(representante.getFuncao());
		cmbStatus.setSelectedItem(representante.getStatus());

	}

	//esse metodo vai passar o valor do nome para o metodo de consulta e vai carregar as informacoes 
	//nos campos

	public void PreencherConsultaRepresentantePorNome(String nome) {
		RepresentanteDAO dao = new RepresentanteDAO();
		RepresentanteFederacao representante = dao.consultaRepresentantePorNome(nome);
		if (representante != null) {
			txtIdRepresentante.setText(String.valueOf(representante.getIdRepresentante()));
			txtRepresentante.setText(representante.getRepresentante());
			txtEmailRepresentante.setText(representante.getEmailRepresentante());
			txtTelefoneRepresentante.setText(representante.gettelefoneRepresentante());
			txtAno.setText(String.valueOf(representante.getAno()));
			cmbFuncao.setSelectedItem(representante.getFuncao());
			cmbStatus.setSelectedItem(representante.getStatus());
		} else {
			// Lógica para lidar com o representante não encontrado, se necessário.
			System.out.println("Representante não encontrado.");

		}
	}
	 private void ordenarTabelaPorColuna(int coluna) {
	        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblFederacao.getModel());
	        tblFederacao.setRowSorter(sorter);
	        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(coluna, SortOrder.ASCENDING)));
	    }
}
