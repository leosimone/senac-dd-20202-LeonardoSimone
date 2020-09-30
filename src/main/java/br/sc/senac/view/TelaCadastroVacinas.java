package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroVacinas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeVacina;
	private JTextField txtOrigem;
	private JComboBox cBEstagio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVacinas frame = new TelaCadastroVacinas();
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
	public TelaCadastroVacinas() {
		setForeground(Color.BLACK);
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setTitle("Cadastro de Vacinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeVacina = new JLabel("Nome da Vacina:");
		lblNomeVacina.setBounds(10, 31, 150, 14);
		contentPane.add(lblNomeVacina);
		
		JLabel lblEstagioPesquisa = new JLabel("Est\u00E1gio da Pesquisa");
		lblEstagioPesquisa.setBounds(10, 72, 150, 14);
		contentPane.add(lblEstagioPesquisa);
		
		JLabel lblOrigem = new JLabel("Origem da Vacina");
		lblOrigem.setBounds(10, 107, 150, 14);
		contentPane.add(lblOrigem);
		
		JLabel lblNomePesquisador = new JLabel("Nome do Pesquisador");
		lblNomePesquisador.setBounds(10, 149, 150, 14);
		contentPane.add(lblNomePesquisador);
		
		JLabel lblNomeVoluntario = new JLabel("Nome do Volunt\u00E1rio");
		lblNomeVoluntario.setBounds(10, 188, 150, 14);
		contentPane.add(lblNomeVoluntario);
		
		JLabel lblDataInicio = new JLabel("Data de In\u00EDcio da Pesquisa\r\n");
		lblDataInicio.setBounds(10, 232, 150, 14);
		contentPane.add(lblDataInicio);
		
		txtNomeVacina = new JTextField();
		txtNomeVacina.setBounds(176, 32, 223, 20);
		contentPane.add(txtNomeVacina);
		txtNomeVacina.setColumns(10);
		
		txtOrigem = new JTextField();
		txtOrigem.setColumns(10);
		txtOrigem.setBounds(176, 108, 223, 20);
		contentPane.add(txtOrigem);
		
		JComboBox cBPesquisador = new JComboBox();
		cBPesquisador.setBounds(182, 150, 217, 20);
		contentPane.add(cBPesquisador);
		
		JComboBox cBVoluntario = new JComboBox();
		cBVoluntario.setBounds(182, 189, 217, 20);
		contentPane.add(cBVoluntario);
		
		JLabel lblNovaPessoa = new JLabel("N\u00E3o encontrou o pesquisador \r\n");
		lblNovaPessoa.setBounds(409, 150, 149, 20);
		contentPane.add(lblNovaPessoa);
		
		JLabel lblNovaPessoa2 = new JLabel("ou o volunt\u00E1rio? Clique abaixo:\r\n");
		lblNovaPessoa2.setBounds(409, 167, 156, 14);
		contentPane.add(lblNovaPessoa2);
		
		JButton btnCadastrarPessoasVacina = new JButton("Cadastrar Pessoa");
		btnCadastrarPessoasVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarPessoasVacina.setBounds(419, 188, 124, 23);
		contentPane.add(btnCadastrarPessoasVacina);
		
		
		ArrayList<String> estagio = obterEstagio();
		cBEstagio = new JComboBox(estagio.toArray());
		cBEstagio.setBounds(178, 73, 221, 20);
		contentPane.add(cBEstagio);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(181, 232, 150, 20);
		contentPane.add(dateChooser);
		
		JButton btnSalvarVacina = new JButton("SALVAR");
		btnSalvarVacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			}
		});
		btnSalvarVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarVacina.setBounds(230, 263, 89, 23);
		contentPane.add(btnSalvarVacina);
	}
	
	private ArrayList<String> obterEstagio() {
		ArrayList<String> estagio = new ArrayList<String>();
		estagio.add(" ");
		estagio.add("Inicial");
		estagio.add("Testes");
		estagio.add("Aplicação em massa");
		return estagio;
	}
}
