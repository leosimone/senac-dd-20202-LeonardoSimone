package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class TelaCadastroPessoas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JComboBox cbSexo;
	private JComboBox cBTipo;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPessoas frame = new TelaCadastroPessoas();
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
	public TelaCadastroPessoas() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setForeground(Color.BLACK);
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 44, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(39, 86, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(39, 121, 46, 14);
		contentPane.add(lblSexo);
		
		ArrayList<String> tipos = obterTipo();
		cBTipo = new JComboBox(tipos.toArray());
		cBTipo.setBounds(175, 159, 103, 20);
		contentPane.add(cBTipo);
		
		JLabel lblTipo = new JLabel("Sou:");
		lblTipo.setBounds(39, 165, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblInstituicao = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituicao.setBounds(39, 244, 73, 14);
		contentPane.add(lblInstituicao);
		
		JComboBox cBInstituicao = new JComboBox();
		cBInstituicao.setBounds(175, 238, 253, 20);
		contentPane.add(cBInstituicao);
		
		txtNome = new JTextField();
		txtNome.setBounds(175, 38, 336, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(175, 80, 336, 20);
		contentPane.add(txtCPF);
		
		ArrayList<String> sexos = obterSexo();
		cbSexo = new JComboBox(sexos.toArray());
		cbSexo.setBounds(175, 115, 103, 20);
		contentPane.add(cbSexo);
			
				
		JButton btnCadastrar = new JButton("SALVAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(232, 274, 91, 46);
		contentPane.add(btnCadastrar);
		
		JComboBox cBVoluntario = new JComboBox();
		cBVoluntario.setBounds(175, 198, 103, 20);
		contentPane.add(cBVoluntario);
		
		JLabel lblVoluntario = new JLabel("Volunt\u00E1rio(a):");
		lblVoluntario.setBounds(39, 201, 103, 14);
		contentPane.add(lblVoluntario);
		
		JButton btnCadastrarInstituicao = new JButton("Cadastrar Institui\u00E7\u00E3o");
		btnCadastrarInstituicao.setBounds(438, 237, 133, 23);
		contentPane.add(btnCadastrarInstituicao);
	}
	private ArrayList<String> obterTipo() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add(" ");
		tipos.add("Voluntário(a)");
		tipos.add("Pesquisador(a)");
		return tipos;
	}

	private ArrayList<String> obterSexo() {
		ArrayList<String> sexos = new ArrayList<String>();
		sexos.add(" ");
		sexos.add("Masculino");
		sexos.add("Feminino");
		sexos.add("Outro");
		return sexos;
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
