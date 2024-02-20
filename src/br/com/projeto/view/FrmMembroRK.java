package br.com.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.AcademiaDAO;
import br.com.projeto.dao.FederacaoDAO;
import br.com.projeto.dao.FederadosDAO;
import br.com.projeto.dao.GraduacaoDAO;
import br.com.projeto.dao.MembrosDAO;
import br.com.projeto.model.Academia;
import br.com.projeto.model.Federacao;
import br.com.projeto.model.Federado;
import br.com.projeto.model.Graduacao;
import br.com.projeto.model.Membros;
import br.com.projeto.model.Utilitarios;

public class FrmMembroRK extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeMembro;
	private JPanel pnlDadosPessoais;
	private JTable tblAssociado;
	private JTable tblResponsavel;
	private JTextField txtAssociadoFederado;
	private JTable tblFederado;
	private JTextField txtAssociadoGraduacao;
	private JTable tblGraduacaoIndividual;
	private JTable tblGraduacaoColetiva;
	private JFormattedTextField txtCelular;
	private JTextField txtPesquisaMatricula;
	private JTextField txtPesquisaAluno;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JFormattedTextField txtCep;
	private JTextField txtEmailResponsavel;
	private JTextField txtEmail;
	private JFormattedTextField txtCelularResponsavel;
	private JTextField txtIdFederacao;
	private JTextField txtEndereco;
	private JTextArea txtObservacao;
	private JComboBox<String> cmbTpMembro;
	private JButton btnFecharpnlResponsavel;
	private JTextField txtDtValidade;
	private JComboBox<String> cmbStatus;
	private JTextField txtNumero;
	private JTextField txtMatricula;
	private JFormattedTextField txtCpf;
	private JTextField txtDtMatricula;
	private JTextField txtDtNascimento;
	private JComboBox<String> cmbGraduacao;
	private JComboBox<Academia> cmbAcademia;
	private JTextField txtAnoFederacao;
	private JTextField txtAnuidadeFederacao;
	private JTextField txtNumeroRegistro;
	private JTextField txtIdFederado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMembroRK frame = new FrmMembroRK();
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
	public FrmMembroRK() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\robrf\\OneDrive\\Imagens\\Ryu Kumite\\logo ryukumite.jpg"));
		setTitle("Associação Ryu Kumite - Membros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0, 0, 984, 48);
		pnlTitulo.setLayout(null);
		pnlTitulo.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlTitulo);

		JLabel lblMembroDaAssociao = new JLabel("ASSOCIAÇÃO RYU KUMITÊ - MEMBRO");
		lblMembroDaAssociao.setBackground(new Color(0, 0, 0));
		lblMembroDaAssociao.setForeground(new Color(0, 0, 0));
		lblMembroDaAssociao.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
		lblMembroDaAssociao.setBounds(278, 11, 452, 31);
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
		tabbedPane.setBackground(new Color(240, 240, 240));
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBounds(0, 92, 984, 484);
		contentPane.add(tabbedPane);

		pnlDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, pnlDadosPessoais, null);
		pnlDadosPessoais.setBackground(new Color(240, 240, 240));
		pnlDadosPessoais.setLayout(null);

		JPanel pnlAssociado = new JPanel();
		pnlAssociado.setBackground(new Color(240, 240, 240));
		pnlAssociado.setBounds(0, 11, 973, 277);
		pnlAssociado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDadosPessoais.add(pnlAssociado);
		pnlAssociado.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Situação:");
		lblNewLabel_1_1.setBounds(10, 11, 105, 17);
		pnlAssociado.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_1_2.setBounds(10, 39, 39, 17);
		pnlAssociado.add(lblNewLabel_1_1_1_2);
		lblNewLabel_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));

		txtNomeMembro = new JTextField();
		txtNomeMembro.setBounds(125, 36, 243, 20);
		pnlAssociado.add(txtNomeMembro);
		txtNomeMembro.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNomeMembro.setColumns(10);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_1_1_1.setBounds(378, 39, 48, 17);
		pnlAssociado.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Academia:");
		lblNewLabel_1_1_1_1_2.setBounds(378, 11, 58, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_1_2);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Dt  Matrícula:");
		lblNewLabel_1_1_1_4.setBounds(378, 67, 70, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_4);
		lblNewLabel_1_1_1_4.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Dt Validade:");
		lblNewLabel_1_1_1_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5.setBounds(378, 95, 66, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_5);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			txtCpf.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {

					if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
						Utilitarios utilitarios = new Utilitarios();
						if (!utilitarios.validaCpf(txtCpf.getText())) {
							JOptionPane.showMessageDialog(null, "CPF inválido");
						}

					}
				}
			});
			txtCpf.setFont(new Font("Dialog", Font.PLAIN, 12));
			txtCpf.setBounds(125, 92, 105, 20);
			pnlAssociado.add(txtCpf);
		} catch (Exception e) {

		}

		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4.setBounds(10, 95, 48, 17);
		pnlAssociado.add(lblNewLabel_1_1_1_1_4);

		try {
			txtDtNascimento = new JTextField();
			txtDtNascimento.setFont(new Font("Dialog", Font.PLAIN, 12));
			txtDtNascimento.setBounds(125, 66, 84, 20);
			pnlAssociado.add(txtDtNascimento);
		} catch (Exception e) {
		}

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Nascimento:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_3.setBounds(10, 67, 76, 17);
		pnlAssociado.add(lblNewLabel_1_1_1_1_3);

		cmbStatus = new JComboBox<>();
		cmbStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbStatus.setModel(new DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo", "Desfiliado" }));
		cmbStatus.setBounds(125, 8, 91, 22);
		pnlAssociado.add(cmbStatus);

		cmbAcademia = new JComboBox<>();
		// Carregue a lista de academias uma vez, talvez na inicialização do formulário
		AcademiaDAO dao = new AcademiaDAO();
		List<Academia> listaAcademia = dao.listarAcademia();
		for (Academia f : listaAcademia) {
			cmbAcademia.addItem(f);
		}
		cmbAcademia.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbAcademia.setBounds(458, 8, 277, 22);
		pnlAssociado.add(cmbAcademia);

		try {
			txtDtMatricula = new JTextField();
			txtDtMatricula.setFont(new Font("Dialog", Font.PLAIN, 12));
			txtDtMatricula.setBounds(458, 66, 84, 20);
			pnlAssociado.add(txtDtMatricula);
		} catch (Exception e) {
		}

		try {
			txtDtValidade = new JTextField();
		} catch (Exception e) {
		}
		txtDtValidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtDtValidade.setBounds(458, 92, 84, 20);
		pnlAssociado.add(txtDtValidade);

		cmbTpMembro = new JComboBox<>();
		cmbTpMembro.setModel(new DefaultComboBoxModel<>(new String[] { "Aluno", "Professor", "Diretoria" }));
		cmbTpMembro.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbTpMembro.setBounds(458, 37, 201, 22);
		pnlAssociado.add(cmbTpMembro);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membros membros = new Membros();

				// pegar apenas o numero da academia na combobox
				Academia selectedItem = (Academia) cmbAcademia.getSelectedItem();
				String numero = null;
				if (selectedItem != null) {
					numero = String.valueOf(selectedItem.getId());
				}
				ValidaCpfNulo(membros);
				membros.setNome(txtNomeMembro.getText());
				membros.setDtNascimento(txtDtNascimento.getText());
				membros.setDtValidade(txtDtValidade.getText());
				membros.setDtMatricula(txtDtMatricula.getText());
				membros.setObservacao(txtObservacao.getText());
				membros.setTpMembro(cmbTpMembro.getSelectedItem().toString());
				membros.setStatus(cmbStatus.getSelectedItem().toString());
				membros.setIdAcademia(Integer.parseInt(numero));
				membros.setCep(txtCep.getText());
				membros.setEndereco(txtEndereco.getText());
				membros.setBairro(txtBairro.getText());
				membros.setCidade(txtCidade.getText());
				membros.setNumero(Integer.parseInt(txtNumero.getText()));
				membros.setEmail(txtEmail.getText());
				membros.setCelular(txtCelular.getText());
				membros.setComplemento(txtComplemento.getText());

				MembrosDAO dao = new MembrosDAO();
				dao.cadastrarMembros(membros);
				txtMatricula.setText(String.valueOf(membros.getMatricula()));

				listarTabelaAssociado();

			}
		});
		btnIncluir.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/103863_disk_floppy_guardar_save_icon.png")));
		btnIncluir.setHorizontalAlignment(SwingConstants.LEADING);
		btnIncluir.setBounds(221, 237, 100, 29);
		pnlAssociado.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membros membros = new Membros();

				// Obtém a seleção da JComboBox como String
				String Item = cmbAcademia.getSelectedItem().toString();
				// Divide a String usando um espaço como delimitador
				String[] parts = Item.split(" ");
				// Obtém o ID (primeira parte após a separação)
				int idAcademia = Integer.parseInt(parts[0]);

				// Define o ID na instância membros
				membros.setMatricula(Integer.parseInt(txtMatricula.getText()));
				membros.setNome(txtNomeMembro.getText());
				membros.setDtMatricula(txtDtMatricula.getText());
				membros.setDtValidade(txtDtValidade.getText());
				membros.setDtNascimento(txtDtNascimento.getText());
				membros.setObservacao(txtObservacao.getText());
				membros.setTpMembro(cmbTpMembro.getSelectedItem().toString());
				membros.setStatus(cmbStatus.getSelectedItem().toString());
				membros.setIdAcademia(idAcademia);
				membros.setCep(txtCep.getText());
				membros.setEndereco(txtEndereco.getText());
				membros.setBairro(txtBairro.getText());
				membros.setCidade(txtCidade.getText());
				membros.setNumero(Integer.parseInt(txtNumero.getText()));
				membros.setEmail(txtEmail.getText());
				membros.setCelular(txtCelular.getText());
				membros.setComplemento(txtComplemento.getText());
				ValidaCpfNulo(membros);

				MembrosDAO dao = new MembrosDAO();
				dao.alterarMembros(membros);
				listarTabelaAssociado();
			}
		});
		btnAlterar.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/285638_pencil_icon.png")));
		btnAlterar.setHorizontalAlignment(SwingConstants.LEADING);
		btnAlterar.setBounds(335, 237, 100, 29);
		pnlAssociado.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membros membros = new Membros();

				membros.setMatricula(Integer.parseInt(txtMatricula.getText()));

				MembrosDAO dao = new MembrosDAO();
				dao.excluirMembros(membros);

				new Utilitarios().LimparTela(pnlAssociado);
				listarTabelaAssociado();
			}
		});
		btnExcluir.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/8726424_trash_alt_icon.png")));
		btnExcluir.setHorizontalAlignment(SwingConstants.LEADING);
		btnExcluir.setBounds(449, 237, 100, 29);
		pnlAssociado.add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnlAssociado);
			}
		});
		btnLimpar.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/118917_edit_clear_icon.png")));
		btnLimpar.setHorizontalAlignment(SwingConstants.LEADING);
		btnLimpar.setBounds(563, 237, 100, 29);
		pnlAssociado.add(btnLimpar);

		txtObservacao = new JTextArea();
		txtObservacao.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtObservacao.setBounds(248, -1, 206, 103);
		pnlAssociado.add(txtObservacao);

		JLabel lblNewLabel_1_1_1_1_4_2 = new JLabel("CEP");
		lblNewLabel_1_1_1_1_4_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_2.setBounds(10, 138, 25, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_1_4_2);

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			txtCep.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
						MembrosDAO dao = new MembrosDAO();
						Membros membros = new Membros();
						membros = dao.buscacep(txtCep.getText());

						txtEndereco.setText(membros.getEndereco());
						txtBairro.setText(membros.getBairro());
						txtCidade.setText(membros.getCidade());
					}
				}
			});
		} catch (Exception e) {
		}
		txtCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCep.setBounds(104, 136, 84, 20);
		pnlAssociado.add(txtCep);

		JLabel lblNewLabel_1_1_1_1_3_2 = new JLabel("Endereço:");
		lblNewLabel_1_1_1_1_3_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_3_2.setBounds(338, 140, 56, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_1_3_2);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEndereco.setBounds(418, 138, 176, 20);
		pnlAssociado.add(txtEndereco);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 122, 953, 3);
		pnlAssociado.add(separator);

		JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Número:");
		lblNewLabel_1_1_1_1_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_6.setBounds(667, 138, 48, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_1_6);

		txtNumero = new JTextField();
		txtNumero.setText("0");
		txtNumero.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNumero.setBounds(720, 136, 84, 20);
		pnlAssociado.add(txtNumero);

		JLabel lblNewLabel_1_1_1_4_2 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_4_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_4_2.setBounds(338, 170, 36, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_4_2);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(418, 167, 176, 20);
		pnlAssociado.add(txtBairro);

		JLabel lblNewLabel_1_1_1_5_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_5_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5_1.setBounds(667, 169, 43, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_5_1);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(720, 167, 176, 20);
		pnlAssociado.add(txtCidade);

		JLabel lblNewLabel_1_1_1_5_1_2 = new JLabel("Celular:");
		lblNewLabel_1_1_1_5_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5_1_2.setBounds(10, 200, 51, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_5_1_2);

		try {
			txtCelular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (Exception e) {
		}
		txtCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBounds(104, 198, 105, 20);
		pnlAssociado.add(txtCelular);

		JLabel lblNewLabel_1_1_1_5_1_1 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_5_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5_1_1.setBounds(10, 167, 82, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_5_1_1);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(104, 165, 206, 20);
		pnlAssociado.add(txtComplemento);

		JLabel lblNewLabel_1_1_1_5_1_3 = new JLabel("Email:");
		lblNewLabel_1_1_1_5_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5_1_3.setBounds(338, 200, 43, 16);
		pnlAssociado.add(lblNewLabel_1_1_1_5_1_3);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(418, 198, 243, 20);
		pnlAssociado.add(txtEmail);

		JScrollPane scrTxtObservacao = new JScrollPane(txtObservacao);
		scrTxtObservacao.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrTxtObservacao.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTxtObservacao.setBounds(757, 11, 206, 103);
		pnlAssociado.add(scrTxtObservacao);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/icons8-porta-20.png")));
		btnFechar.setHorizontalAlignment(SwingConstants.LEADING);
		btnFechar.setBounds(673, 237, 100, 29);
		pnlAssociado.add(btnFechar);

		JPanel pnlTblAluno = new JPanel();
		pnlTblAluno.setBackground(new Color(240, 240, 240));
		pnlTblAluno.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTblAluno.setBounds(0, 277, 973, 173);
		pnlDadosPessoais.add(pnlTblAluno);
		pnlTblAluno.setLayout(null);

		tblAssociado = new JTable();
		tblAssociado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMatricula.setText(tblAssociado.getValueAt(tblAssociado.getSelectedRow(), 0).toString());
				cmbAcademia.setSelectedItem(tblAssociado.getValueAt(tblAssociado.getSelectedRow(), 0).toString());
				PreencherConsultaMembros(Integer.parseInt(txtMatricula.getText()));

				if (txtMatricula.getText() != null) {
					int matricula = Integer.parseInt(txtMatricula.getText());
					listarGraduacaoIndividual(matricula);
				}
				// Ajuste automático da largura das colunas
				for (int column = 0; column < tblGraduacaoIndividual.getColumnCount(); column++) {
					TableColumn tableColumn = tblGraduacaoIndividual.getColumnModel().getColumn(column);
					int preferredWidth = tableColumn.getMinWidth();
					int maxWidth = tableColumn.getMaxWidth();

					for (int row = 0; row < tblGraduacaoIndividual.getRowCount(); row++) {
						TableCellRenderer cellRenderer = tblGraduacaoIndividual.getCellRenderer(row, column);
						Component c = tblGraduacaoIndividual.prepareRenderer(cellRenderer, row, column);
						int width = c.getPreferredSize().width + tblGraduacaoIndividual.getIntercellSpacing().width
								+ 50;
						preferredWidth = Math.max(preferredWidth, width);
					}
					tableColumn.setPreferredWidth(preferredWidth);
				}
				ordenarTabelaPorColuna(0);

			}
		});
		tblAssociado.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matricula", "Nome", "Fun\u00E7\u00E3o", "Situa\u00E7\u00E3o", "Academia", "Nascimento",
						"CPF", "Dt Matr\u00EDcula", "Dt Validade", "Celular", "Endere\u00E7o", "N\u00FAmero" }));
		tblAssociado.setBounds(10, 11, 662, 140);
		listarTabelaAssociado();
		tblAssociado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		pnlTblAluno.add(tblAssociado);

		JScrollPane scrTblAssociado = new JScrollPane(tblAssociado);
		scrTblAssociado.setBounds(10, 11, 953, 162);
		pnlTblAluno.add(scrTblAssociado);
		// Ajuste automático da largura das colunas
		for (int column = 0; column < tblAssociado.getColumnCount(); column++) {
			TableColumn tableColumn = tblAssociado.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < tblAssociado.getRowCount(); row++) {
				TableCellRenderer cellRenderer = tblAssociado.getCellRenderer(row, column);
				Component c = tblAssociado.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + tblAssociado.getIntercellSpacing().width + 35;
				preferredWidth = Math.max(preferredWidth, width);
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
		ordenarTabelaPorColuna(0);

		try {
		} catch (Exception e) {
		}

		JPanel pnlResponsavel = new JPanel();
		tabbedPane.addTab("Responsável", null, pnlResponsavel, null);
		pnlResponsavel.setLayout(null);
		try {
		} catch (Exception e) {
		}
		try {
		} catch (Exception e) {

		}

		JPanel pnlTabelaResponsavel = new JPanel();
		pnlTabelaResponsavel.setLayout(null);
		pnlTabelaResponsavel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTabelaResponsavel.setBounds(0, 171, 973, 284);
		pnlResponsavel.add(pnlTabelaResponsavel);

		tblResponsavel = new JTable();
		tblResponsavel.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matr\u00EDcula", "Aluno", "Respons\u00E1vel", "Parentesco", "Telefone", "Email" }));
		tblResponsavel.setBounds(0, 0, 745, 0);
		pnlTabelaResponsavel.add(tblResponsavel);

		JScrollPane scrResponsavel = new JScrollPane(tblResponsavel);
		scrResponsavel.setBounds(10, 11, 953, 252);
		pnlTabelaResponsavel.add(scrResponsavel);

		JPanel pnlDadosResponsavel = new JPanel();
		pnlDadosResponsavel.setBounds(0, 0, 973, 171);
		pnlResponsavel.add(pnlDadosResponsavel);
		pnlDadosResponsavel.setLayout(null);

		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("Responsável:");
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_3_1.setBounds(10, 55, 76, 17);
		pnlDadosResponsavel.add(lblNewLabel_1_1_1_1_3_1);

		JLabel lblNewLabel_1_1_1_1_4_1 = new JLabel("Parentesco:");
		lblNewLabel_1_1_1_1_4_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_1.setBounds(10, 86, 66, 16);
		pnlDadosResponsavel.add(lblNewLabel_1_1_1_1_4_1);

		JComboBox<String> cmbParentesco = new JComboBox<>();
		cmbParentesco.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbParentesco.setEnabled(false);
		cmbParentesco.setBounds(125, 83, 99, 22);
		pnlDadosResponsavel.add(cmbParentesco);

		JTextField txtResponsavel = new JTextField();
		txtResponsavel.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtResponsavel.setEditable(false);
		txtResponsavel.setBounds(125, 53, 243, 20);
		pnlDadosResponsavel.add(txtResponsavel);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_2_1.setBounds(404, 55, 58, 16);
		pnlDadosResponsavel.add(lblNewLabel_1_1_1_1_2_1);

		try {
			txtCelularResponsavel = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (Exception e) {
		}
		txtCelularResponsavel.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCelularResponsavel.setEditable(false);
		txtCelularResponsavel.setBounds(472, 53, 105, 20);
		pnlDadosResponsavel.add(txtCelularResponsavel);

		txtEmailResponsavel = new JTextField();
		txtEmailResponsavel.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEmailResponsavel.setEditable(false);
		txtEmailResponsavel.setBounds(472, 84, 243, 20);
		pnlDadosResponsavel.add(txtEmailResponsavel);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(404, 86, 48, 17);
		pnlDadosResponsavel.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel = new JLabel("Dados Disponíveis se o associado for menor de idade");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(252, 11, 429, 20);
		pnlDadosResponsavel.add(lblNewLabel);

		JTextArea txtObservacaoResponsavel = new JTextArea();
		txtObservacaoResponsavel.setBorder(
				new TitledBorder(null, "Observa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtObservacaoResponsavel.setBounds(743, 52, 206, 103);
		pnlDadosResponsavel.add(txtObservacaoResponsavel);

		JButton btnIncluirResponsavel = new JButton("Incluir");
		btnIncluirResponsavel.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/103863_disk_floppy_guardar_save_icon.png")));
		btnIncluirResponsavel.setHorizontalAlignment(SwingConstants.LEADING);
		btnIncluirResponsavel.setBounds(135, 126, 100, 29);
		pnlDadosResponsavel.add(btnIncluirResponsavel);

		JButton btnAlterarResponsavel = new JButton("Alterar");
		btnAlterarResponsavel.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/285638_pencil_icon.png")));
		btnAlterarResponsavel.setHorizontalAlignment(SwingConstants.LEADING);
		btnAlterarResponsavel.setBounds(249, 126, 100, 29);
		pnlDadosResponsavel.add(btnAlterarResponsavel);

		JButton btnExcluirResponsavel = new JButton("Excluir");
		btnExcluirResponsavel
				.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/8726424_trash_alt_icon.png")));
		btnExcluirResponsavel.setHorizontalAlignment(SwingConstants.LEADING);
		btnExcluirResponsavel.setBounds(363, 126, 100, 29);
		pnlDadosResponsavel.add(btnExcluirResponsavel);

		JButton btnLimparTelaResponsavel = new JButton("Limpar");
		btnLimparTelaResponsavel
				.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/118917_edit_clear_icon.png")));
		btnLimparTelaResponsavel.setHorizontalAlignment(SwingConstants.LEADING);
		btnLimparTelaResponsavel.setBounds(477, 126, 100, 29);
		pnlDadosResponsavel.add(btnLimparTelaResponsavel);

		JButton btnFecharpnlResponsavel = new JButton("Fechar");
		btnFecharpnlResponsavel.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/icons8-porta-20.png")));
		btnFecharpnlResponsavel.setHorizontalAlignment(SwingConstants.LEADING);
		btnFecharpnlResponsavel.setBounds(587, 126, 100, 29);
		pnlDadosResponsavel.add(btnFecharpnlResponsavel);

		JPanel pnlGraduacao = new JPanel();
		pnlGraduacao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Graduação", null, pnlGraduacao, null);
		pnlGraduacao.setLayout(null);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1.setBounds(0, 0, 341, 168);
		pnlGraduacao.add(panel_4_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Faixa:");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(12, 23, 32, 16);
		panel_4_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Associado:");
		lblNewLabel_1_1_1_2_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_3.setBounds(12, 51, 61, 16);
		panel_4_1.add(lblNewLabel_1_1_1_2_3);

		txtAssociadoGraduacao = new JTextField();
		txtAssociadoGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAssociadoGraduacao.setColumns(10);
		txtAssociadoGraduacao.setBounds(83, 49, 243, 20);
		panel_4_1.add(txtAssociadoGraduacao);

		JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Ano:");
		lblNewLabel_1_1_1_1_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_5.setBounds(12, 76, 24, 16);
		panel_4_1.add(lblNewLabel_1_1_1_1_5);

		JFormattedTextField txtAnoGraduacao = new JFormattedTextField((Object) null);
		txtAnoGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAnoGraduacao.setBounds(55, 74, 114, 20);
		panel_4_1.add(txtAnoGraduacao);

		JLabel lblNewLabel_1_1_1_4_1 = new JLabel("Semestre:");
		lblNewLabel_1_1_1_4_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_4_1.setBounds(12, 104, 57, 16);
		panel_4_1.add(lblNewLabel_1_1_1_4_1);

		JComboBox<String> cmbFaixa = new JComboBox<>();
		cmbFaixa.setModel(new DefaultComboBoxModel<>(new String[] { "Branca", "Cinza", "Azul", "Amarela", "Vermelha",
				"Laranja", "Verde", "Roxa", "Marrom", "Preta" }));
		cmbFaixa.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbFaixa.setBounds(55, 20, 97, 22);
		panel_4_1.add(cmbFaixa);

		JComboBox<String> cmbSemestreGraduacao = new JComboBox<>();
		cmbSemestreGraduacao.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2" }));
		cmbSemestreGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbSemestreGraduacao.setBounds(79, 101, 46, 22);
		panel_4_1.add(cmbSemestreGraduacao);

		JButton btnIncluirGraduacao = new JButton("Incluir");
		btnIncluirGraduacao.setHorizontalAlignment(SwingConstants.LEADING);
		btnIncluirGraduacao.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/103863_disk_floppy_guardar_save_icon.png")));
		btnIncluirGraduacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graduacao graduacao = new Graduacao();

				graduacao.setMatricula(Integer.parseInt(txtMatricula.getText()));
				graduacao.setFaixa(cmbFaixa.getSelectedItem().toString());
				graduacao.setGraduacao(cmbGraduacao.getSelectedItem().toString());
				graduacao.setAno(Integer.parseInt(txtAnoGraduacao.getText()));
				graduacao.setSemestre(Integer.parseInt(cmbSemestreGraduacao.getSelectedItem().toString()));

				GraduacaoDAO dao = new GraduacaoDAO();
				dao.incluirGraduacao(graduacao);
				listarGraduacaoIndividual(Integer.parseInt(txtMatricula.getText()));
			}
		});
		btnIncluirGraduacao.setBounds(15, 134, 100, 29);
		panel_4_1.add(btnIncluirGraduacao);

		JButton btnAlterarGraduacao = new JButton("Alterar");
		btnAlterarGraduacao.setHorizontalAlignment(SwingConstants.LEADING);
		btnAlterarGraduacao.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/285638_pencil_icon.png")));
		btnAlterarGraduacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graduacao graduacao = new Graduacao();

				graduacao.setMatricula(Integer.parseInt(txtMatricula.getText()));
				graduacao.setFaixa(cmbFaixa.getSelectedItem().toString());
				graduacao.setGraduacao(cmbGraduacao.getSelectedItem().toString());
				graduacao.setAno(Integer.parseInt(txtAnoGraduacao.getText()));
				graduacao.setSemestre(Integer.parseInt(cmbSemestreGraduacao.getSelectedItem().toString()));

				GraduacaoDAO dao = new GraduacaoDAO();
				dao.alterarGraduacao(graduacao);
				listarGraduacaoIndividual(Integer.parseInt(txtMatricula.getText()));
			}
		});
		btnAlterarGraduacao.setBounds(127, 134, 100, 29);
		panel_4_1.add(btnAlterarGraduacao);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Graduação:");
		lblNewLabel_1_1_1_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_3.setBounds(180, 20, 64, 16);
		panel_4_1.add(lblNewLabel_1_1_1_3);

		cmbGraduacao = new JComboBox<>();
		cmbGraduacao.setModel(new DefaultComboBoxModel<>(
				new String[] { "7° Kyu", "6° Kyu", "5° Kyu", "4° Kyu", "3° Kyu", "2° Kyu", "1° Kyu", "1° Dan", "2° Dan",
						"3° Dan", "4° Dan", "5° Dan", "6° Dan", "7° Dan", "8° Dan", "9° Dan", "10° Dan" }));
		cmbGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbGraduacao.setBounds(256, 17, 75, 22);
		panel_4_1.add(cmbGraduacao);

		JButton btnFecharGraduacao = new JButton("Fechar");
		btnFecharGraduacao.setHorizontalAlignment(SwingConstants.LEADING);
		btnFecharGraduacao.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/icons8-porta-20.png")));
		btnFecharGraduacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFecharGraduacao.setBounds(237, 134, 100, 29);
		panel_4_1.add(btnFecharGraduacao);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1_1.setBounds(340, 0, 633, 168);
		pnlGraduacao.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);

		tblGraduacaoIndividual = new JTable();
		tblGraduacaoIndividual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAssociadoGraduacao.setText(
						tblGraduacaoIndividual.getValueAt(tblGraduacaoIndividual.getSelectedRow(), 1).toString());
				cmbFaixa.setSelectedItem(
						tblGraduacaoIndividual.getValueAt(tblGraduacaoIndividual.getSelectedRow(), 2).toString());
				cmbGraduacao.setSelectedItem(
						tblGraduacaoIndividual.getValueAt(tblGraduacaoIndividual.getSelectedRow(), 3).toString());
				txtAnoGraduacao.setText(
						tblGraduacaoIndividual.getValueAt(tblGraduacaoIndividual.getSelectedRow(), 4).toString());
				cmbSemestreGraduacao.setSelectedItem(
						tblGraduacaoIndividual.getValueAt(tblGraduacaoIndividual.getSelectedRow(), 5).toString());
			}
		});
		tblGraduacaoIndividual.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matricula", "Aluno", "Faixa", "Gradua\u00E7\u00E3o", "Ano", "Semestre" }));
		tblGraduacaoIndividual.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblGraduacaoIndividual.setBounds(10, 11, 407, 146);
		ordenarTabelaPorColunaGraduacaoIndividual(0);
		panel_4_1_1.add(tblGraduacaoIndividual);

		JScrollPane scrGraduacaoIndividual = new JScrollPane(tblGraduacaoIndividual);
		scrGraduacaoIndividual.setBounds(10, 11, 613, 146);
		panel_4_1_1.add(scrGraduacaoIndividual);

		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setLayout(null);
		panel_4_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1_1_1.setBounds(0, 167, 973, 283);
		pnlGraduacao.add(panel_4_1_1_1);

		JLabel lblNewLabel_1_1_1_6 = new JLabel("Faixa:");
		lblNewLabel_1_1_1_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_6.setBounds(10, 11, 32, 16);
		panel_4_1_1_1.add(lblNewLabel_1_1_1_6);

		JComboBox<String> cmbFaixaPesquisa = new JComboBox<>();
		cmbFaixaPesquisa.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbFaixaPesquisa.setBounds(52, 8, 97, 22);
		panel_4_1_1_1.add(cmbFaixaPesquisa);

		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Graduação:");
		lblNewLabel_1_1_1_3_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_3_1.setBounds(196, 11, 64, 16);
		panel_4_1_1_1.add(lblNewLabel_1_1_1_3_1);

		JComboBox <String>cmbGraduacaoPesquisa = new JComboBox<>();
		cmbGraduacaoPesquisa.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbGraduacaoPesquisa.setBounds(274, 11, 75, 22);
		panel_4_1_1_1.add(cmbGraduacaoPesquisa);

		JButton btnPesquisaFaixa = new JButton("");
		btnPesquisaFaixa.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaFaixa.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaFaixa.setBounds(158, 9, 28, 23);
		panel_4_1_1_1.add(btnPesquisaFaixa);

		JButton btnPesquisaGraduacao = new JButton("");
		btnPesquisaGraduacao.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaGraduacao.setBounds(359, 9, 28, 23);
		panel_4_1_1_1.add(btnPesquisaGraduacao);

		tblGraduacaoColetiva = new JTable();
		tblGraduacaoColetiva.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Matricula", "Nome", "Faixa",
				"Gradua\u00E7\u00E3o Atual", "Ano", "Semestre", "Academia" }));
		tblGraduacaoColetiva.setBounds(10, 38, 747, 171);
		listarGraduacaoColetiva();
		panel_4_1_1_1.add(tblGraduacaoColetiva);

		JScrollPane scrGraduacao = new JScrollPane(tblGraduacaoColetiva);
		scrGraduacao.setBounds(10, 38, 953, 234);
		panel_4_1_1_1.add(scrGraduacao);

		JPanel pnlFederado = new JPanel();
		tabbedPane.addTab("Federação", null, pnlFederado, null);
		pnlFederado.setLayout(null);

		JPanel pnlDadoFederado = new JPanel();
		pnlDadoFederado.setBounds(0, 0, 973, 148);
		pnlDadoFederado.setLayout(null);
		pnlDadoFederado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlFederado.add(pnlDadoFederado);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Federação");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(364, 46, 59, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2_2_1 = new JLabel("Associado:");
		lblNewLabel_1_1_1_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_2_1.setBounds(10, 50, 62, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_2_2_1);

		txtAssociadoFederado = new JTextField();
		txtAssociadoFederado.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAssociadoFederado.setColumns(10);
		txtAssociadoFederado.setBounds(79, 48, 262, 20);
		pnlDadoFederado.add(txtAssociadoFederado);

		txtIdFederacao = new JTextField();
		txtIdFederacao.setText("00");
		txtIdFederacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdFederacao.setForeground(Color.RED);
		txtIdFederacao.setFont(new Font("Dialog", Font.BOLD, 18));
		txtIdFederacao.setEditable(false);
		txtIdFederacao.setColumns(10);
		txtIdFederacao.setBorder(null);
		txtIdFederacao.setBounds(134, 13, 96, 20);
		pnlDadoFederado.add(txtIdFederacao);

		JComboBox<Federacao> cmbFederacao = new JComboBox<>();
		cmbFederacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Federacao federacaoSelecionada = (Federacao) cmbFederacao.getSelectedItem();
				if (federacaoSelecionada != null) {
					txtIdFederacao.setText(String.valueOf(federacaoSelecionada.getIdFederacao()));
				}
			}
		});
		cmbFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbFederacao.setBounds(433, 44, 290, 22);
		FederacaoDAO federacaodao = new FederacaoDAO();
		List<Federacao> listaFederacao = federacaodao.listarFederacao();
		for (Federacao f : listaFederacao) {
			cmbFederacao.addItem(f);
		}
		pnlDadoFederado.add(cmbFederacao);

		JLabel lblFederacao = new JLabel("Id Federação:");
		lblFederacao.setForeground(Color.BLACK);
		lblFederacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFederacao.setBounds(10, 11, 120, 24);
		pnlDadoFederado.add(lblFederacao);

		JLabel lblNewLabel_1_1_1_1_4_1_1_1_1 = new JLabel("Registro da graduação:");
		lblNewLabel_1_1_1_1_4_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_1_1_1_1.setBounds(10, 80, 129, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_4_1_1_1_1);

		JComboBox<String> cmbRegistroGraduacao = new JComboBox<>();
		cmbRegistroGraduacao.setModel(new DefaultComboBoxModel<>(new String[] {"", "7° Kyu", "6° Kyu", "5° Kyu", "4° Kyu", "3° Kyu", "2° Kyu", "1° Kyu", "1° Dan", "2° Dan", "3° Dan", "4° Dan", "5° Dan", "6° Dan", "7° Dan", "8° Dan", "9° Dan", "10° Dan"}));
		cmbRegistroGraduacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbRegistroGraduacao.setBounds(149, 77, 113, 22);
		pnlDadoFederado.add(cmbRegistroGraduacao);

		txtAnoFederacao = new JTextField();
		txtAnoFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAnoFederacao.setColumns(10);
		txtAnoFederacao.setBounds(420, 76, 94, 20);
		pnlDadoFederado.add(txtAnoFederacao);

		JLabel lblNewLabel_1_1_1_1_2_1_1_1_1 = new JLabel("Ano que federou:");
		lblNewLabel_1_1_1_1_2_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_2_1_1_1_1.setBounds(315, 78, 93, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_2_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_4_1_1_1 = new JLabel("Anuidade:");
		lblNewLabel_1_1_1_1_4_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_1_1_1.setBounds(564, 78, 55, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_4_1_1_1);

		txtAnuidadeFederacao = new JTextField();
		txtAnuidadeFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtAnuidadeFederacao.setColumns(10);
		txtAnuidadeFederacao.setBounds(629, 76, 94, 20);
		pnlDadoFederado.add(txtAnuidadeFederacao);

		JLabel lblNewLabel_1_1_1_1_2_1_1_1 = new JLabel("Status:");
		lblNewLabel_1_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_2_1_1_1.setBounds(780, 77, 38, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_2_1_1_1);

		JComboBox<String> cmbStatusFederacao = new JComboBox<>();
		cmbStatusFederacao.setModel(new DefaultComboBoxModel<>(new String[] { "", "Pendente", "Pago", "Isento" }));
		cmbStatusFederacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbStatusFederacao.setBounds(830, 74, 99, 22);
		pnlDadoFederado.add(cmbStatusFederacao);

		JButton btnIncluirAnuidade = new JButton("Incluir");
		btnIncluirAnuidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Federado federado = new Federado();

				federado.setMatricula(Integer.parseInt(txtMatricula.getText()));
				federado.setIdFederecao(Integer.parseInt(txtIdFederacao.getText().trim()));
				federado.setRegistro(cmbRegistroGraduacao.getSelectedItem().toString());
				federado.setAnoRegistro(Integer.parseInt(txtAnoFederacao.getText()));
				federado.setAnuidade(Integer.parseInt(txtAnuidadeFederacao.getText()));
				federado.setStatus(cmbStatusFederacao.getSelectedItem().toString());
				federado.setNumeroRegistro(txtNumeroRegistro.getText());

				// incluir federado
				FederadosDAO dao = new FederadosDAO();
				dao.incluirFederado(federado);
				listarFederado();
			}
		});
		btnIncluirAnuidade.setHorizontalAlignment(SwingConstants.LEADING);
		btnIncluirAnuidade.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/103863_disk_floppy_guardar_save_icon.png")));
		btnIncluirAnuidade.setBounds(182, 110, 100, 29);
		pnlDadoFederado.add(btnIncluirAnuidade);

		JButton btnAlterarAnuidade = new JButton("Alterar");
		btnAlterarAnuidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Federado federado = new Federado();

				federado.setNome(txtAssociadoFederado.getText());
				federado.setMatricula(Integer.parseInt(txtMatricula.getText().trim()));
				federado.setIdFederecao(Integer.parseInt(txtIdFederacao.getText().trim()));
				federado.setNomeFederacao(cmbFederacao.getSelectedItem().toString());
				federado.setRegistro(cmbRegistroGraduacao.getSelectedItem().toString());
				federado.setAnoRegistro(Integer.parseInt(txtAnoFederacao.getText()));
				federado.setAnuidade(Integer.parseInt(txtAnuidadeFederacao.getText()));
				federado.setStatus(cmbStatusFederacao.getSelectedItem().toString());
				federado.setNumeroRegistro(txtNumeroRegistro.getText());
				federado.setIdFederado(Integer.parseInt(txtIdFederado.getText().trim()));

				// incluir federado
				FederadosDAO dao = new FederadosDAO();
				dao.alterarFederado(federado);
				listarFederado();
			}
		});
		btnAlterarAnuidade.setHorizontalAlignment(SwingConstants.LEADING);
		btnAlterarAnuidade.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/285638_pencil_icon.png")));
		btnAlterarAnuidade.setBounds(295, 110, 100, 29);
		pnlDadoFederado.add(btnAlterarAnuidade);

		JButton btnExcluirAnuidade = new JButton("Excluir");
		btnExcluirAnuidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Federado federado = new Federado();
				federado.setIdFederado(Integer.parseInt(txtIdFederado.getText().trim()));
				federado.setMatricula(Integer.parseInt(txtMatricula.getText().trim()));
				federado.setIdFederecao(Integer.parseInt(txtIdFederacao.getText().trim()));

				FederadosDAO dao = new FederadosDAO();
				dao.excluirFederado(federado);
				listarFederado();
			}
		});
		btnExcluirAnuidade.setHorizontalAlignment(SwingConstants.LEADING);
		btnExcluirAnuidade.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/8726424_trash_alt_icon.png")));
		btnExcluirAnuidade.setBounds(410, 110, 100, 29);
		pnlDadoFederado.add(btnExcluirAnuidade);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnlDadoFederado);
			}
		});
		btnLimpar_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnLimpar_1.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/118917_edit_clear_icon.png")));
		btnLimpar_1.setBounds(523, 110, 100, 29);
		pnlDadoFederado.add(btnLimpar_1);

		JButton btnFechar_1 = new JButton("Fechar");
		btnFechar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnFechar_1.setIcon(new ImageIcon(FrmMembroRK.class.getResource("/image/icons8-porta-20.png")));
		btnFechar_1.setBounds(637, 110, 100, 29);
		pnlDadoFederado.add(btnFechar_1);

		JLabel lblNewLabel_1_1_1_1_4_1_1_1_2 = new JLabel("Número do Registro:");
		lblNewLabel_1_1_1_1_4_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_4_1_1_1_2.setBounds(745, 48, 115, 16);
		pnlDadoFederado.add(lblNewLabel_1_1_1_1_4_1_1_1_2);

		txtNumeroRegistro = new JTextField();
		txtNumeroRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNumeroRegistro.setColumns(10);
		txtNumeroRegistro.setBounds(869, 46, 94, 20);
		pnlDadoFederado.add(txtNumeroRegistro);

		txtIdFederado = new JTextField();
		txtIdFederado.setVisible(false);
		txtIdFederado.setEnabled(false);
		txtIdFederado.setEditable(false);
		txtIdFederado.setBorder(null);
		txtIdFederado.setBounds(283, 16, 86, 20);
		pnlDadoFederado.add(txtIdFederado);
		txtIdFederado.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 146, 963, 293);
		pnlFederado.add(panel_1);
		panel_1.setLayout(null);

		tblFederado = new JTable();
		tblFederado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtMatricula.setText(tblFederado.getValueAt(tblFederado.getSelectedRow(), 0).toString());
				// Obtenha a informação da coluna 2 (id_federacao, nome_federacao)
				String obterIdFederacao = tblFederado.getValueAt(tblFederado.getSelectedRow(), 1).toString();

				// Divida a informação em id_federacao e nome_federacao
				String[] partes = obterIdFederacao.split("- ");
				String idFederacao = partes[0];
				txtIdFederacao.setText(String.valueOf(idFederacao));
				txtAssociadoFederado.setText(tblFederado.getValueAt(tblFederado.getSelectedRow(), 2).toString());

				// Obtenha a instância de Federacao correspondente ao id_federacao
				Federacao federacaoSelecionada = obterFederacaoPorId(Integer.parseInt(idFederacao.trim()));

				// Preencha a JComboBox com a instância de Federacao
				cmbFederacao.setSelectedItem(federacaoSelecionada);

				txtAnuidadeFederacao.setText(tblFederado.getValueAt(tblFederado.getSelectedRow(), 3).toString());
				cmbStatusFederacao.setSelectedItem(tblFederado.getValueAt(tblFederado.getSelectedRow(), 4).toString());
				txtNumeroRegistro.setText(tblFederado.getValueAt(tblFederado.getSelectedRow(), 5).toString());
				cmbRegistroGraduacao
						.setSelectedItem(tblFederado.getValueAt(tblFederado.getSelectedRow(), 6).toString());
				txtAnoFederacao.setText(tblFederado.getValueAt(tblFederado.getSelectedRow(), 7).toString());

				// Abaixo sao os codigos para inserir o valor IdFederado no txtIdFederado, esse
				// campo nao e visível ao usuário
				int matricula;
				int id_Federacao;
				int anuidade;

				matricula = Integer.parseInt(txtMatricula.getText().trim());
				id_Federacao = Integer.parseInt(idFederacao.trim());
				anuidade = Integer.parseInt(txtAnuidadeFederacao.getText().trim());

				FederadosDAO dao = new FederadosDAO();
				txtIdFederado.setText(
						String.valueOf(dao.consultarIdFederado(matricula, id_Federacao, anuidade).getIdFederado()));
			}
		});
		tblFederado.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matr\u00EDcula", "Federa\u00E7\u00E3o", "Associado", "Anuidade", "Situa\u00E7\u00E3o",
						"Num. Registro", "Gradua\u00E7\u00E3o", "Ano de Ingresso" }));
		tblFederado.setBounds(193, 210, -136, -201);
		listarFederado();
		tblFederado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ordenarTabelaPorColunaFederado(0);
		panel_1.add(tblFederado);

		JScrollPane scrTblFederacao = new JScrollPane(tblFederado);
		scrTblFederacao.setBounds(10, 8, 943, 261);
		panel_1.add(scrTblFederacao);
		// Ajuste automático da largura das colunas
		for (int column = 0; column < tblFederado.getColumnCount(); column++) {
			TableColumn tableColumn = tblFederado.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < tblFederado.getRowCount(); row++) {
				TableCellRenderer cellRenderer = tblFederado.getCellRenderer(row, column);
				Component c = tblFederado.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + tblFederado.getIntercellSpacing().width + 35;
				preferredWidth = Math.max(preferredWidth, width);
			}
			tableColumn.setPreferredWidth(preferredWidth);
		}
		ordenarTabelaPorColuna(0);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 240, 240));
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(0, 47, 984, 48);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("Matrícula:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(193, 14, 58, 17);
		panel_3.add(lblNewLabel_1_2);

		txtPesquisaMatricula = new JTextField();
		txtPesquisaMatricula.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPesquisaMatricula.setColumns(10);
		txtPesquisaMatricula.setBounds(261, 12, 94, 20);
		panel_3.add(txtPesquisaMatricula);

		JButton btnPesquisaMatricula = new JButton("");
		btnPesquisaMatricula.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaMatricula.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaMatricula.setBounds(365, 11, 28, 23);
		panel_3.add(btnPesquisaMatricula);

		txtPesquisaAluno = new JTextField();
		txtPesquisaAluno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String nome = "%" + txtPesquisaAluno.getText() + "%";
				FederadosDAO dao = new FederadosDAO();
				List<Federado> lista = dao.pesquisarNomeFederado(nome);

				if (lista != null) {
					DefaultTableModel dados = (DefaultTableModel) tblFederado.getModel();
					dados.setNumRows(0);

					for (Federado r : lista) {
						dados.addRow(new Object[] { r.getMatricula(), r.toString(), r.getNome(), r.getAnuidade(),
								r.getStatus(), r.getNumeroRegistro(), r.getRegistro(), r.getAnoRegistro(),
								r.getIdFederado() });
					}
				} else {
					// Lógica para lidar com a lista nula, se necessário
					JOptionPane.showMessageDialog(null, "A lista retornada é nula.");
				}
				MembrosDAO mdao = new MembrosDAO();
				List<Membros> mlista = mdao.pesquisarNomeMembros(nome);
				if (mlista != null) {
					DefaultTableModel membrosDados = (DefaultTableModel) tblAssociado.getModel();
					membrosDados.setNumRows(0);

					for (Membros r : mlista) {

						membrosDados.addRow(new Object[] { r.getMatricula(), r.getNome(), r.getTpMembro(),
								r.getStatus(), r.getIdAcademia(), r.getDtNascimento(), r.getCpf(), r.getDtMatricula(),
								r.getDtValidade(), r.getCelular(), r.getEndereco(), r.getNumero() });
					}

				}
				GraduacaoDAO gdao = new GraduacaoDAO();
				List<Graduacao> glista = gdao.pesquisarNomeFederado(nome);
				if(glista!=null) {
					DefaultTableModel graduadosDados = (DefaultTableModel) tblGraduacaoIndividual.getModel();
					graduadosDados.setNumRows(0);
					
					for (Graduacao r : glista) {
						graduadosDados.addRow(new Object[] { r.getMatricula(), r.getNome(), r.getFaixa(), r.getGraduacao(),
								r.getAno(), r.getSemestre() });
					}
				}
				
			}
		});
		txtPesquisaAluno.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtPesquisaAluno.setColumns(10);
		txtPesquisaAluno.setBounds(452, 12, 208, 20);
		panel_3.add(txtPesquisaAluno);

		JButton btnPesquisaNome = new JButton("");
		btnPesquisaNome.setIcon(
				new ImageIcon(FrmMembroRK.class.getResource("/image/2608311_magnify_search_searching_icon.png")));
		btnPesquisaNome.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnPesquisaNome.setBounds(670, 11, 28, 23);
		panel_3.add(btnPesquisaNome);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nome:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2_1.setBounds(403, 14, 39, 17);
		panel_3.add(lblNewLabel_1_1_1_2_1);

		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setForeground(Color.BLACK);
		lblMatricula.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMatricula.setBounds(10, 0, 96, 19);
		panel_3.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setText("00");
		txtMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatricula.setForeground(Color.RED);
		txtMatricula.setFont(new Font("Dialog", Font.BOLD, 18));
		txtMatricula.setEditable(false);
		txtMatricula.setColumns(10);
		txtMatricula.setBorder(null);
		txtMatricula.setBounds(10, 21, 96, 20);
		panel_3.add(txtMatricula);

		// Fim do Constructor
	}

	public void listarTabelaAssociado() {
		MembrosDAO dao = new MembrosDAO();
		List<Membros> lista = dao.listarMembros();
		DefaultTableModel dadosTabelaMembros = (DefaultTableModel) tblAssociado.getModel();
		dadosTabelaMembros.setNumRows(0);

		for (Membros r : lista) {

			try {

				dadosTabelaMembros.addRow(new Object[] { r.getMatricula(), r.getNome(), r.getTpMembro(), r.getStatus(),
						r.getIdAcademia(), r.getDtNascimento(), r.getCpf(), r.getMatricula(), r.getDtValidade(),
						r.getCelular(), r.getEndereco(), r.getNumero() });
			} catch (DateTimeParseException e) {
				e.printStackTrace();
			}
		}
	}

	// listar tabela graduacao de um unico membro
	public void listarGraduacaoIndividual(int matricula) {
		GraduacaoDAO dao = new GraduacaoDAO();
		List<Graduacao> lista = dao.listarGraduacaoIndividual(matricula);
		DefaultTableModel dadosTabelaMembros = (DefaultTableModel) tblGraduacaoIndividual.getModel();
		dadosTabelaMembros.setNumRows(0);

		for (Graduacao r : lista) {
			dadosTabelaMembros.addRow(new Object[] { r.getMatricula(), r.getNome(), r.getFaixa(), r.getGraduacao(),
					r.getAno(), r.getSemestre() });
		}
	}
	
	// listar tabela graduacao de todos os membros
	public void listarGraduacaoColetiva() {
		GraduacaoDAO dao = new GraduacaoDAO();
		List<Graduacao> lista = dao.listarGraducaoMembros();
		DefaultTableModel dadosTabelaMembros = (DefaultTableModel) tblGraduacaoColetiva.getModel();
		dadosTabelaMembros.setNumRows(0);

		for (Graduacao r : lista) {
			dadosTabelaMembros.addRow(new Object[] { r.getMatricula(), r.getNome(), r.getFaixa(), r.getGraduacao(),
					r.getAno(), r.getSemestre(), r.getNomeAcademia() });
		}
	}

	public void listarFederado() {
		FederadosDAO dao = new FederadosDAO();
		List<Federado> lista = dao.listarFederado();
		DefaultTableModel dadosTabelaMembros = (DefaultTableModel) tblFederado.getModel();
		dadosTabelaMembros.setNumRows(0);

		for (Federado r : lista) {

			dadosTabelaMembros.addRow(new Object[] { r.getMatricula(), r.toString(), r.getNome(), r.getAnuidade(),
					r.getStatus(), r.getNumeroRegistro(), r.getRegistro(), r.getAnoRegistro(), r.getIdFederado() });
		}
	}

	public void PreencherConsultaMembros(int valor) {
		MembrosDAO dao = new MembrosDAO();
		Membros membros = dao.consultaMembros(valor);

		// tratar o formato da data ele esta no banco de dados como yyyy-MM-dd
		// vai ser exibido no formato dd/MM/yyyy

		// tratar o resultado da busca para a cbmAcademia
		// Obtém a seleção da JComboBox como String
		String Item = cmbAcademia.getSelectedItem().toString();
		// Divide a String usando um espaço como delimitador
		String[] parts = Item.split(" ");
		// Obtém o ID (primeira parte após a separação)
		int idAcademia = Integer.parseInt(parts[0]);

		txtMatricula.setText(String.valueOf(membros.getMatricula()));
		txtNomeMembro.setText(membros.getNome());
		txtAssociadoFederado.setText(membros.getNome());
		txtAssociadoGraduacao.setText(membros.getNome());
		txtDtNascimento.setText(membros.getDtNascimento());
		txtDtValidade.setText(membros.getDtValidade());
		txtDtMatricula.setText(membros.getDtMatricula());
		txtCpf.setText(membros.getCpf());
		// cmbAcademia.setSelectedItem(idAcademia);
		cmbTpMembro.setSelectedItem(membros.getTpMembro());
		txtObservacao.setText(membros.getObservacao());
		cmbStatus.setSelectedItem(membros.getStatus());

		txtCep.setText(membros.getCep());
		txtEndereco.setText(membros.getEndereco());
		txtNumero.setText(String.valueOf(membros.getNumero()));
		txtBairro.setText(membros.getBairro());
		txtCidade.setText(membros.getCidade());
		txtComplemento.setText(membros.getComplemento());
		txtCelular.setText(membros.getCelular());
		txtEmail.setText(membros.getEmail());

	}

	// ordenar tabela
	private void ordenarTabelaPorColuna(int coluna) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblAssociado.getModel());
		tblAssociado.setRowSorter(sorter);
		sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(coluna, SortOrder.ASCENDING)));
	}

	private void ordenarTabelaPorColunaFederado(int coluna) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblFederado.getModel());
		tblFederado.setRowSorter(sorter);
		sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(coluna, SortOrder.ASCENDING)));
	}

	private void ordenarTabelaPorColunaGraduacaoIndividual(int coluna) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(
				(DefaultTableModel) tblGraduacaoIndividual.getModel());
		tblGraduacaoIndividual.setRowSorter(sorter);
		sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(coluna, SortOrder.ASCENDING)));
	}

	private Federacao obterFederacaoPorId(int idFederacao) {
		FederacaoDAO federacaoDao = new FederacaoDAO();
		List<Federacao> listaFederacao = federacaoDao.listarFederacao();

		for (Federacao federacao : listaFederacao) {
			// Assumindo que idFederacao é uma string
			if (federacao.getIdFederacao() == idFederacao) {
				return federacao;
			}
		}

		// Se não encontrar, pode retornar null ou lançar uma exceção, dependendo do seu
		// requisito.
		return null;
	}
	
	private Membros ValidaCpfNulo(Membros membros) {
		String cpfText = txtCpf.getText().replaceAll("[^0-9]",""); // Remove caracteres não numéricos
		if (cpfText.isEmpty()) {
			membros.setCpf(null); // Atribui valor nulo se o CPF estiver vazio
		}else  {
			membros.setCpf(txtCpf.getText()); // Atribui o valor original do campo se houver pelo menos um dígito numérico
		}
		return membros;
	}
}
