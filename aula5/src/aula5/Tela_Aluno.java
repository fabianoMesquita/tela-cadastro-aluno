package aula5;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class Tela_Aluno implements ActionListener {

    Aluno alu;
    ArrayList<Aluno> lista = new ArrayList<Aluno>();

    JFrame tela = new JFrame("Cadastro de aluno");
    JPanel painel = new JPanel();

    JLabel lbnome = new JLabel("Nome:");
    JLabel lbn1 = new JLabel("N1:");
    JLabel lbn2 = new JLabel("N2");
    JLabel lbmedia = new JLabel("Media:");
    JLabel lbstatus = new JLabel("Status:");
    JLabel lbcurso = new JLabel("Curso:");
    JLabel lbturno = new JLabel("Turno:");
    JLabel lbidade= new JLabel("Idade:");
    JLabel lbimagem = new JLabel(); // Label para a imagem


    JTextField txtnome = new JTextField();
    JTextField txtn1 = new JTextField();
    JTextField txtn2 = new JTextField();
    JTextField txtmedia = new JTextField();
    JTextField txtstatus = new JTextField();

    String[] cursos = {"Engenharia", "Medicina", "Direito", "Computação"};
    JComboBox<String> comboCurso = new JComboBox<>(cursos);

    JRadioButton rbManha = new JRadioButton("Manhã");
    JRadioButton rbTarde = new JRadioButton("Tarde");
    JRadioButton rbNoite = new JRadioButton("Noite");
    ButtonGroup grupoTurno = new ButtonGroup();


    SpinnerNumberModel idadeModelo = new SpinnerNumberModel(18, 0, 100, 1);
    JSpinner spinnerIdade = new JSpinner(idadeModelo);


    JButton btsalvar = new JButton("Salvar");
    JButton btlista = new JButton("Listar");

    void criaTela() {
        tela.setSize(400, 600);
        tela.setLocation(600, 200);
        painel.setLayout(null);

        // Carregar imagem
        lbimagem.setBounds(120, 10, 150, 150); // Ajuste o tamanho e posição da imagem
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
            Image image = icon.getImage().getScaledInstance(150, 125, Image.SCALE_SMOOTH);
            lbimagem.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
        }

        lbnome.setBounds(20, 170, 90, 30); // x, y, w, h
        txtnome.setBounds(120, 170, 130, 30);
        lbn1.setBounds(20, 210, 90, 30);
        txtn1.setBounds(120, 210, 130, 30);
        lbn2.setBounds(20, 250, 90, 30);
        txtn2.setBounds(120, 250, 130, 30);
        lbmedia.setBounds(20, 290, 90, 30);
        txtmedia.setBounds(120, 290, 130, 30);
        txtmedia.setEnabled(false);
        lbstatus.setBounds(20, 290, 90, 30);
        txtstatus.setBounds(120, 290, 130, 30);
        txtstatus.setEnabled(false);

        lbcurso.setBounds(20, 330, 90, 30);
        comboCurso.setBounds(120, 330, 130, 30);

        lbturno.setBounds(20, 370, 90, 30);
        rbManha.setBounds(120, 370, 70, 30);
        rbTarde.setBounds(200, 370, 70, 30);
        rbNoite.setBounds(280, 370, 70, 30);

        lbidade.setBounds(20, 410, 90, 30);
        spinnerIdade.setBounds(120, 410, 130, 30);

        btsalvar.setBounds(40, 480, 130, 30);
        btsalvar.addActionListener(this);
        btlista.setBounds(200, 480, 130, 30);
        btlista.addActionListener(this);

        painel.add(lbnome);
        painel.add(txtnome);
        painel.add(lbn1);
        painel.add(txtn1);
        painel.add(lbn2);
        painel.add(txtn2);
        //painel.add(lbmedia);
        //painel.add(txtmedia);
        painel.add(lbstatus);
        painel.add(txtstatus);
        painel.add(lbcurso);
        painel.add(comboCurso);
        painel.add(lbturno);
        painel.add(rbManha);
        painel.add(rbTarde);
        painel.add(rbNoite);
        painel.add(lbidade);
        painel.add(spinnerIdade);
        painel.add(btsalvar);
        painel.add(btlista);
        painel.add(lbimagem); // Adicionando a imagem ao painel

        grupoTurno.add(rbManha);
        grupoTurno.add(rbTarde);
        grupoTurno.add(rbNoite);

        tela.getContentPane().add(painel);
        tela.setVisible(true);
    }


    public static void main(String[]args) {
        Tela_Aluno tl = new Tela_Aluno();
        tl.criaTela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btsalvar) {
            String n = txtnome.getText();
            Double n1 = Double.valueOf(txtn1.getText());
            Double n2 = Double.valueOf(txtn2.getText());
            String curso = comboCurso.getSelectedItem().toString();
            String turno = "";
            int idade = (int) spinnerIdade.getValue();

            if (rbManha.isSelected()) {
                turno = "Manhã";
            } else if (rbTarde.isSelected()) {
                turno = "Tarde";
            } else if (rbNoite.isSelected()) {
                turno = "Noite";
            }

            alu = new Aluno(n, n1, n2, turno, curso,idade);
            alu.calcMedia();
            lista.add(alu);
            txtmedia.setText(String.valueOf(alu.getMedia()));
            txtmedia.requestFocus();
            txtstatus.setText(alu.getStatus());
            txtstatus.requestFocus();
            JOptionPane.showMessageDialog(null, "Objeto cadastro !!");
            txtnome.setText("");
            txtn1.setText("");
            txtn2.setText("");
            txtmedia.setText("");
            grupoTurno.clearSelection();
            grupoTurno.clearSelection();
            spinnerIdade.setValue(18);
        }

        if (e.getSource() == btlista) {
            for (Aluno a: lista) {
                JOptionPane.showMessageDialog(null, "Aluno: " + a.getNome() +"\nMedia: " + a.getMedia() + "\nStatus: " + a.getStatus() + "\nCurso: " + a.getCurso() + "\nTurno: " + a.getTurno() +"\nIdade: " + a.getIdade())
                ;
            }
        }

    }

}