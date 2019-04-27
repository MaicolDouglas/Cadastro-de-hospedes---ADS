package br.com.estacio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.estacio.entidade.Hospedes;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import java.awt.Font;

public class Trabalho {

	private JFrame frmCadastro;
	private JTextField textField_nome;
	private JTextField textField_email;
	private JTable table_registros;
	final ArrayList<Hospedes> addlistafuncionario = new ArrayList<Hospedes>(); 
	//adiciona um array da classe Funcionario para ser usado mais abaixo.
	int ID = 1;
		
	public int proximoCodigo() {
	
	return ID++ ;
}
	
	private int geradorCodigo = proximoCodigo();
	

	/**
	 * Launch the application.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {			
			String OSName = System.getProperty("os.name");
			if (OSName.contains("Linux"))				 
			 UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");	
			else
			 //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");	
		} catch (UnsupportedLookAndFeelException e) {

		}


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trabalho window = new Trabalho();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 */
	public Trabalho() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */

	private void initialize() throws ParseException {
		frmCadastro = new JFrame();
		frmCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(Trabalho.class.getResource("/sun/print/resources/oneside.png")));
		
		frmCadastro.setTitle("Cadastro de Hospedes");
		frmCadastro.getContentPane().setBackground(SystemColor.menu);
		frmCadastro.setResizable(false);
		frmCadastro.setBounds(100, 100, 683, 502);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmCadastro.setLocation((int) screenSize.getWidth() / 2 - (570 / 2),
				(int) screenSize.getHeight() / 2 - (380 / 2));
		
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);		
	
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 667, 426);
		tabbedPane.setBorder(null);
		frmCadastro.getContentPane().add(tabbedPane);
		final JButton btn_novo = new JButton("Novo Hospede");
		final JButton btn_record = new JButton("Gravar Hospede");
		
		JLayeredPane PainelCadastro = new JLayeredPane();
		PainelCadastro.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, PainelCadastro, null);
				
		final JLabel label_img = new JLabel("");
		label_img.setHorizontalAlignment(SwingConstants.CENTER);
		label_img.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		label_img.setBackground(Color.GRAY);
		label_img.setBounds(550, 35, 100, 100);
		PainelCadastro.add(label_img);
						
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(12, 86, 46, 14);
		PainelCadastro.add(lblNewLabel);
								
		JLabel lblNewLabel_1 = new JLabel("Check-in:");
		lblNewLabel_1.setBounds(12, 338, 70, 14);
		PainelCadastro.add(lblNewLabel_1);								
										
		JLabel lblNewLabel_2 = new JLabel("RG:");
		lblNewLabel_2.setBounds(235, 152, 86, 14);
		PainelCadastro.add(lblNewLabel_2);										
												
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(12, 152, 86, 14);
		PainelCadastro.add(lblNewLabel_3);
														
		JLabel lblNewLabel_4 = new JLabel("Forma de Pagemento:");
		lblNewLabel_4.setBounds(324, 275, 134, 14);
		PainelCadastro.add(lblNewLabel_4);														
																
		JLabel lblNewLabel_5 = new JLabel("Telefone:");
		lblNewLabel_5.setBounds(12, 212, 86, 14);
		PainelCadastro.add(lblNewLabel_5);																
																		
		final JFormattedTextField formattedTextField_ckeckin = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextField_ckeckin.setEnabled(false);
		formattedTextField_ckeckin.setBounds(12, 363, 100, 24);
		PainelCadastro.add(formattedTextField_ckeckin);																		
																				
		JFormattedTextField formattedTextField_ckeckout = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextField_ckeckout.setText("  /  /    ");
		formattedTextField_ckeckout.setEnabled(false);
		formattedTextField_ckeckout.setBounds(235, 363, 100, 24);
		PainelCadastro.add(formattedTextField_ckeckout);																		
																				
		JFormattedTextField formattedTextField_dateNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextField_dateNascimento.setText("  /  /    ");
		formattedTextField_dateNascimento.setEnabled(false);
		formattedTextField_dateNascimento.setBounds(310, 113, 100, 24);
		PainelCadastro.add(formattedTextField_dateNascimento);																		
																				
		JLabel lblDataNas = new JLabel("Data Nas.:");
		lblDataNas.setBounds(310, 86, 70, 14);
		PainelCadastro.add(lblDataNas);																		
																				
		JFormattedTextField formattedTextField_dateRegistro = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextField_dateRegistro.setText("  /  /    ");
		formattedTextField_dateRegistro.setEnabled(false);
		formattedTextField_dateRegistro.setBounds(258, 33, 100, 24);
		PainelCadastro.add(formattedTextField_dateRegistro);																		
																				
		JLabel lblRegistro = new JLabel("Data Registro:");
		lblRegistro.setBounds(164, 38, 84, 14);
		PainelCadastro.add(lblRegistro);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(123, 340, 46, 14);
		PainelCadastro.add(lblHorrio);
		
		JFormattedTextField formattedTextField_horaEntrada = new JFormattedTextField(new MaskFormatter("##:##"));
		formattedTextField_horaEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_horaEntrada.setText(":");
		formattedTextField_horaEntrada.setEnabled(false);
		formattedTextField_horaEntrada.setBounds(122, 363, 56, 24);
		PainelCadastro.add(formattedTextField_horaEntrada);
		
		JLabel label = new JLabel("Hor\u00E1rio:");
		label.setBounds(346, 340, 46, 14);
		PainelCadastro.add(label);
		
		JFormattedTextField formattedTextField_horaSaida = new JFormattedTextField(new MaskFormatter("##:##"));
		formattedTextField_horaSaida.setText(":");
		formattedTextField_horaSaida.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_horaSaida.setEnabled(false);
		formattedTextField_horaSaida.setBounds(345, 363, 56, 24);
		PainelCadastro.add(formattedTextField_horaSaida);																		
																				
		textField_nome = new JTextField();
		textField_nome.setEnabled(false);
		textField_nome.setBounds(12, 111, 276, 24);
		PainelCadastro.add(textField_nome);
		textField_nome.setColumns(10);																				
																						
		final JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(235, 212, 86, 14);
		PainelCadastro.add(lblNewLabel_7);																						
																								
		final JFormattedTextField formattedTextField_cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextField_cpf.setEnabled(false);
		formattedTextField_cpf.setBounds(12, 177, 175, 24);
		PainelCadastro.add(formattedTextField_cpf);																								
																										
		final JFormattedTextField formattedTextField_tel = new JFormattedTextField(new MaskFormatter("(##)####-####"));
		formattedTextField_tel.setEnabled(false);
		formattedTextField_tel.setBounds(12, 237, 175, 24);
		PainelCadastro.add(formattedTextField_tel);																										
																												
		final JFormattedTextField formattedTextField_rg = new JFormattedTextField(new MaskFormatter("#####.###-#"));
		formattedTextField_rg.setEnabled(false);
		formattedTextField_rg.setBounds(235, 177, 175, 24);
		PainelCadastro.add(formattedTextField_rg);						
																														
		textField_email = new JTextField();
		textField_email.setEnabled(false);
		textField_email.setBounds(235, 237, 211, 24);
		PainelCadastro.add(textField_email);
		textField_email.setColumns(10);																														
																																
		final JComboBox comboBox_pagamento = new JComboBox();
		comboBox_pagamento.setEnabled(false);
		comboBox_pagamento.setModel(new DefaultComboBoxModel(new String[] {"A vista", "Debito", "Credito"}));
		comboBox_pagamento.setBounds(324, 300, 110, 24);
		PainelCadastro.add(comboBox_pagamento);
																																		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText("Clique aqui para carregar uma imagem");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				final JFileChooser fc = new JFileChooser();

				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					label_img.setIcon(new ImageIcon(
							new ImageIcon(file.getPath()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

				} else {
					label_img.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
					JOptionPane.showMessageDialog(null, "Cancelado pelo usuário.");
				}

			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		btnNewButton_3.setBounds(625, 146, 25, 26);
		PainelCadastro.add(btnNewButton_3);																																		
																																				
		JLabel lblNewLabel_6 = new JLabel("N\u00BA Quarto:");
		lblNewLabel_6.setBounds(235, 275, 79, 14);
		PainelCadastro.add(lblNewLabel_6);
		
		final JComboBox comboBox_numQuarto = new JComboBox();
		comboBox_numQuarto.setEnabled(false);
		comboBox_numQuarto.setModel(new DefaultComboBoxModel(new String[] {"Q101", "Q102", "Q103", "Q104", "Q201", "Q202", "Q203", "Q204"}));
		comboBox_numQuarto.setBounds(235, 300, 79, 24);
		PainelCadastro.add(comboBox_numQuarto);		
				
		final JFormattedTextField formattedTextField_codigo = new JFormattedTextField(new MaskFormatter("####"));
		formattedTextField_codigo.setEnabled(false);
		formattedTextField_codigo.setBounds(56, 33, 56, 24);
		PainelCadastro.add(formattedTextField_codigo);				
						
		JLabel lblNewLabel_cnh = new JLabel("C\u00F3digo:");
		lblNewLabel_cnh.setBounds(12, 38, 46, 15);
		PainelCadastro.add(lblNewLabel_cnh);
														
		JLabel lblNewLabel_8 = new JLabel("Foto Hospede:");
		lblNewLabel_8.setBounds(445, 65, 100, 15);
		PainelCadastro.add(lblNewLabel_8);
		
		JLabel lblCheckout = new JLabel("Check-out:");
		lblCheckout.setBounds(235, 338, 70, 14);
		PainelCadastro.add(lblCheckout);
		
		
		JLabel lblQtdaultos = new JLabel("Qtd.Aultos:");
		lblQtdaultos.setBounds(12, 272, 70, 14);
		PainelCadastro.add(lblQtdaultos);
		
		JSpinner spinner_qtdAdultos = new JSpinner();
		spinner_qtdAdultos.setBounds(12, 297, 70, 30);
		spinner_qtdAdultos.setEnabled(false);
		PainelCadastro.add(spinner_qtdAdultos);
		
		JLabel lblQtdcrianas = new JLabel("Qtd.Crian\u00E7as:");
		lblQtdcrianas.setBounds(117, 272, 82, 14);
		PainelCadastro.add(lblQtdcrianas);
		
		JSpinner spinner_qtdCriancas = new JSpinner();
		spinner_qtdCriancas.setBounds(129, 297, 70, 30);
		spinner_qtdCriancas.setEnabled(false);
		PainelCadastro.add(spinner_qtdCriancas);
										
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(550, 36, 100, 2);
		PainelCadastro.add(separator_2);										
												
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(550, 36, 2, 100);
		PainelCadastro.add(separator_3);												
														
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(550, 135, 100, 2);
		PainelCadastro.add(separator_4);														
																
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(650, 36, 2, 100);
		PainelCadastro.add(separator_5);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 662, 28);
		PainelCadastro.add(toolBar);																
																		
		final JButton btn_del = new JButton("Excluir Registro");
		btn_del.setEnabled(false);
		btn_del.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addlistafuncionario.remove(table_registros.getSelectedRow());
						
						table_registros.getColumnModel().getColumn(0).setResizable(false);
						table_registros.getColumnModel().getColumn(0).setPreferredWidth(40);
						table_registros.setRowHeight(90);
						btn_del.setEnabled(false);
						//chama o metodo para montar o modelo da tabela, com o parametro de 1 para mostrar a msg de remoÃ§Ã£o de cadastro.
						montatabela(1);
							
					}
		});																
																		
		toolBar.add(btn_novo);																
																		
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_novo.setEnabled(false);
				btn_record.setEnabled(true);
				textField_nome.setEnabled(true);
				formattedTextField_ckeckin.setEnabled(true);
				formattedTextField_ckeckout.setEnabled(true);
				formattedTextField_cpf.setEnabled(true);
				formattedTextField_rg.setEnabled(true);
				formattedTextField_tel.setEnabled(true);
				textField_email.setEnabled(true);
				formattedTextField_codigo.setEnabled(true);
				spinner_qtdCriancas.setEnabled(true);
				spinner_qtdAdultos.setEnabled(true);
				comboBox_numQuarto.setEnabled(true);
				comboBox_pagamento.setEnabled(true);
				formattedTextField_dateNascimento.setEnabled(true);
				formattedTextField_dateRegistro.setEnabled(true);
				formattedTextField_horaEntrada.setEnabled(true);
				formattedTextField_horaSaida.setEnabled(true);
				formattedTextField_codigo.setText(Integer.toString(geradorCodigo));
				btn_del.setEnabled(false);

			}
		});
		btn_novo.setIcon(new ImageIcon(Trabalho.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		btn_novo.setName("btnovo");
		
		btn_record.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(btn_record);
		
				
				btn_record.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {				
						
						btn_novo.setEnabled(true);
						btn_record.setEnabled(false);				
						textField_nome.setEnabled(false);
						formattedTextField_ckeckin.setEnabled(false);
						formattedTextField_cpf.setEnabled(false);
						formattedTextField_rg.setEnabled(false);
						formattedTextField_tel.setEnabled(false);
						textField_email.setEnabled(false);
						formattedTextField_codigo.setEnabled(false);
						formattedTextField_ckeckout.setEnabled(false);
						formattedTextField_dateRegistro.setEnabled(false);
						formattedTextField_dateNascimento.setEnabled(false);
						formattedTextField_horaEntrada.setEnabled(false);
						formattedTextField_horaSaida.setEnabled(false);
						comboBox_numQuarto.setEnabled(false);
						comboBox_pagamento.setEnabled(false);
						spinner_qtdAdultos.setEnabled(false);
						spinner_qtdCriancas.setEnabled(false);
						
						Hospedes hospederegistro = new Hospedes();
						 hospederegistro.setNome(textField_nome.getText());
						 hospederegistro.setCpf(formattedTextField_cpf.getText());
						 hospederegistro.setRg(formattedTextField_rg.getText());
						 hospederegistro.setEmail(textField_email.getText());
						 hospederegistro.setTel(formattedTextField_tel.getText());				
						hospederegistro.setImagem(label_img.getIcon());
						hospederegistro.setCkeckIn(formattedTextField_ckeckin.getText());
						hospederegistro.setNumQuarto(comboBox_numQuarto.getSelectedItem());
						
						//adiciona um funcionario da Classe Funcionario no array addlistafuncionario.
						addlistafuncionario.add(hospederegistro); 
						//chama o metodo para montar o modelo da tabela, com o parametro de 0 para mostrar a msg de cadastro.
						montatabela(0);
						tabbedPane.setSelectedIndex(1);
					}
				});
				btn_record.setEnabled(false);
				
				
				JTextPane txtpnPreenchaTodosOs = new JTextPane();
				txtpnPreenchaTodosOs.setFont(new Font("Tahoma", Font.ITALIC, 12));
				txtpnPreenchaTodosOs.setText("\"Preencha todos os campos corretamente e clique na op\u00E7\u00E3o 'gravar hospede' para efetivar o cadastro do novo hospede.\"");
				txtpnPreenchaTodosOs.setBounds(492, 212, 158, 110);
				PainelCadastro.add(txtpnPreenchaTodosOs);																																																				
				
				JButton btnLimpar = new JButton("Limpar");
				btnLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						textField_nome.setText(null);
						formattedTextField_ckeckin.setText(null);
						formattedTextField_ckeckout.setText(null);
						formattedTextField_cpf.setText(null);
						formattedTextField_rg.setText(null);
						formattedTextField_tel.setText(null);
						textField_email.setText(null);
						formattedTextField_codigo.setText(null);
						formattedTextField_dateNascimento.setText(null);
						formattedTextField_dateRegistro.setText(null);
						formattedTextField_horaEntrada.setText(null);
						formattedTextField_horaSaida.setText(null);
						
					}
				});
				btnLimpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				btnLimpar.setBounds(427, 364, 89, 23);
				PainelCadastro.add(btnLimpar);
																																																								
																																																																																																														
		JLayeredPane PainelRegistros = new JLayeredPane();
		
				tabbedPane.addTab("Hospedes Cadastrados", null, PainelRegistros, null);
				PainelRegistros.setLayout(new BorderLayout(0, 0));
				
				JScrollPane scrollPane = new JScrollPane();
				PainelRegistros.add(scrollPane);
				
				table_registros = new JTable();
				table_registros.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int itemtabela = table_registros.getSelectedRow();
						if (itemtabela >= 0)
							btn_del.setEnabled(true);
						else
							btn_del.setEnabled(false);
					}
				});
				table_registros.setModel(new DefaultTableModel(
					new Object[][] {}, new String[] {"Código", "Nome", "Email", "Telefone","Nº Quarto","Ceck-in", "Imagem"}) {
					Class[] columnTypes = new Class[] {
						int.class, String.class, String.class, String.class, Object.class, String.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_registros.getColumnModel().getColumn(0).setResizable(false);
				table_registros.getColumnModel().getColumn(0).setPreferredWidth(40);
				table_registros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_registros.setBackground(new Color(211, 211, 211));
				scrollPane.setViewportView(table_registros);
				
				JToolBar toolBar_lista = new JToolBar();
				toolBar_lista.setFloatable(false);
				toolBar_lista.setPreferredSize(new Dimension(26, 26));
				PainelRegistros.add(toolBar_lista, BorderLayout.NORTH);
				btn_del.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
				toolBar_lista.add(btn_del);

		JButton btnCancel = new JButton("Sair");
		btnCancel.setIcon(new ImageIcon(Trabalho.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(Color.RED);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(578, 437, 89, 25);
		frmCadastro.getContentPane().add(btnCancel);
		
	}
	public void montatabela(int tipomsg) {
		
		Object matrizdados[][] = new Object[addlistafuncionario.size()][7];
		for (int i = 0; i < addlistafuncionario.size(); i++)
		{
			matrizdados[i][0] = addlistafuncionario.get(i).getCodigo();
			matrizdados[i][1] = addlistafuncionario.get(i).getNome();;
			matrizdados[i][2] = addlistafuncionario.get(i).getEmail();
			matrizdados[i][3] = addlistafuncionario.get(i).getTel();
			matrizdados[i][4] = addlistafuncionario.get(i).getNumQuarto();
			matrizdados[i][5] = addlistafuncionario.get(i).getCkeckIn();
			matrizdados[i][6] = addlistafuncionario.get(i).getImagem();
		}
		//cria o modelo para preencher a tabela com a matriz de dados criada acima.				
		table_registros.setModel(new DefaultTableModel(
				matrizdados, new String[] { "Código", "Nome", "Email", "Telefone","Nº Quarto","Ceck-in", "Imagem" }) {
			Class[] columnTypes = new Class[] {
					int.class, String.class, String.class, String.class, Object.class, String.class, ImageIcon.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}						
			});
		table_registros.getColumnModel().getColumn(0).setResizable(false);
		table_registros.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_registros.setRowHeight(90);
		if (tipomsg == 0)
			JOptionPane.showMessageDialog(null, "Novo Hospede Inserido com Sucesso!");
		else
			JOptionPane.showMessageDialog(null, "Registro Hospede Removido!");
	}
}