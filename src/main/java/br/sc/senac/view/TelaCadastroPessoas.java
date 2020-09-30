package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sc.senac.controller.PessoaController;
import br.sc.senac.model.entity.PessoaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import com.toedter.calendar.JDateChooser;

public class TelaCadastroPessoas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JComboBox cBSexo;
	private JComboBox cBTipo;
	private final Action action = new SwingAction();
	private JDateChooser testeData;
	private boolean Voluntario = true;
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
		lblInstituicao.setBounds(39, 213, 73, 14);
		contentPane.add(lblInstituicao);
		
		JComboBox cBInstituicao = new JComboBox();
		cBInstituicao.setBounds(122, 210, 253, 20);
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
		cBSexo = new JComboBox(sexos.toArray());
		cBSexo.setBounds(175, 115, 103, 20);
		contentPane.add(cBSexo);
			
				
		JButton btnCadastrar = new JButton("SALVAR");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			PessoaVO pessoa = new PessoaVO();
			
			
				if(txtNome.getText().equals("") || txtNome.getText().equals("   ")) {
					JOptionPane.showMessageDialog(null, "Campo nome obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
				return;
				}
				if(txtCPF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo CPF obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);
				return;
				}
				
				else {
					pessoa.setNome(txtNome.getText());
					pessoa.setCpf(txtCPF.getText());
					pessoa.setSexo((String) cBSexo.getSelectedItem());
					pessoa.setVoluntario(Voluntario);
					pessoa.setDataNascimento((String) testeData.toString());
					
					PessoaController controller = new PessoaController();
					
					String mensagem = controller.salvar(pessoa);
					JOptionPane.showMessageDialog(contentPane, mensagem);
				}
				
				
				
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(204, 257, 91, 46);
		contentPane.add(btnCadastrar);
		
		JButton btnCadastrarInstituicao = new JButton("Cadastrar Institui\u00E7\u00E3o");
		btnCadastrarInstituicao.setBounds(409, 238, 133, 23);
		contentPane.add(btnCadastrarInstituicao);
		
		JLabel lblCadastrarInstituicao = new JLabel("N\u00E3o achou a Institui\u00E7\u00E3o?\n Clique abaixo:\r\n");
		lblCadastrarInstituicao.setBounds(385, 213, 204, 14);
		contentPane.add(lblCadastrarInstituicao);
		
		JDateChooser dCNascimento = new JDateChooser();
		dCNascimento.setBounds(385, 159, 126, 20);
		contentPane.add(dCNascimento);
		testeData = dCNascimento;
		
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(385, 134, 126, 14);
		contentPane.add(lblDataNascimento);
		
	}
	public ArrayList<String> obterTipo() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add(" ");
		tipos.add("Voluntário(a)");
		tipos.add("Pesquisador(a)");		
		return tipos;
	}
	
	
	private boolean isVoluntario (String tipos) {
		boolean Voluntario = true;
		if(tipos.contentEquals("Pesquisador(a)")){
			Voluntario = false;
		}
		
		return Voluntario;
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
