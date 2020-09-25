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
import java.awt.event.ActionEvent;

public class TelaCadastroVacinas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeVacina;
	private JTextField txtEstagioPesquisa;
	private JTextField txtOrigem;

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
		lblNomeVacina.setBounds(39, 32, 92, 14);
		contentPane.add(lblNomeVacina);
		
		JLabel lblEstagioPesquisa = new JLabel("Est\u00E1gio da Pesquisa");
		lblEstagioPesquisa.setBounds(39, 73, 128, 14);
		contentPane.add(lblEstagioPesquisa);
		
		JLabel lblOrigem = new JLabel("Origem da Vacina");
		lblOrigem.setBounds(39, 108, 92, 14);
		contentPane.add(lblOrigem);
		
		JLabel lblNomePesquisador = new JLabel("Nome do Pesquisador");
		lblNomePesquisador.setBounds(39, 150, 110, 14);
		contentPane.add(lblNomePesquisador);
		
		JLabel lblNomeVoluntario = new JLabel("Nome do Volunt\u00E1rio");
		lblNomeVoluntario.setBounds(39, 189, 110, 14);
		contentPane.add(lblNomeVoluntario);
		
		JLabel lblDataInicio = new JLabel("Data de In\u00EDcio da Pesquisa\r\n");
		lblDataInicio.setBounds(39, 233, 144, 14);
		contentPane.add(lblDataInicio);
		
		txtNomeVacina = new JTextField();
		txtNomeVacina.setBounds(153, 29, 223, 20);
		contentPane.add(txtNomeVacina);
		txtNomeVacina.setColumns(10);
		
		txtEstagioPesquisa = new JTextField();
		txtEstagioPesquisa.setColumns(10);
		txtEstagioPesquisa.setBounds(153, 70, 223, 20);
		contentPane.add(txtEstagioPesquisa);
		
		txtOrigem = new JTextField();
		txtOrigem.setColumns(10);
		txtOrigem.setBounds(153, 105, 223, 20);
		contentPane.add(txtOrigem);
		
		JComboBox cBPesquisador = new JComboBox();
		cBPesquisador.setBounds(159, 147, 217, 20);
		contentPane.add(cBPesquisador);
		
		JComboBox cBVoluntario = new JComboBox();
		cBVoluntario.setBounds(159, 186, 217, 20);
		contentPane.add(cBVoluntario);
		
		JLabel lblNovaPessoa = new JLabel("N\u00E3o encontrou o pesquisador \r\n");
		lblNovaPessoa.setBounds(386, 147, 149, 20);
		contentPane.add(lblNovaPessoa);
		
		JLabel lblNovaPessoa2 = new JLabel("ou o volunt\u00E1rio? Clique abaixo:\r\n");
		lblNovaPessoa2.setBounds(386, 164, 156, 14);
		contentPane.add(lblNovaPessoa2);
		
		JButton btnCadastrarPessoasVacina = new JButton("Cadastrar Pessoa");
		btnCadastrarPessoasVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarPessoasVacina.setBounds(396, 185, 124, 23);
		contentPane.add(btnCadastrarPessoasVacina);
	}
}
