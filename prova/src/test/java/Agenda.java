package prova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Agenda extends Win {
    private ArrayList<Contato> contatos;
    private int pos = -1;
    private boolean incluindo, alterando;
    //
    private JLabel posicao;
    private JButton btnPrimeiro, btnAnterior, btnProximo, btnUltimo;
    private JButton btnIncluir, btnAlterar, btnExcluir, btnConfirmar, btnCancelar;
    private JLabel id, nome, sexo, telefone;
    private JTextField txtId, txtNome, txtTelefone;
    private JRadioButton pessoa, empresa;
    private ButtonGroup grpTipo;
    private JComboBox comboSexo;
    private JCheckBox amigo, cliente;
    public Agenda() {
        super("Agenda", 500, 500, JFrame.EXIT_ON_CLOSE);
        contatos = new ArrayList<>();
        atualizaUI();
    }
    @Override
    protected void setupComponents() {
        initToolbar();
        initForm();
        initLayout();
        initEvents();
    }
    private void initToolbar() {
        posicao = new JLabel("0 / 0");
        btnPrimeiro = new JButton("<<");
        btnAnterior = new JButton("<");
        btnProximo = new JButton(">");
        btnUltimo = new JButton(">>");
        btnIncluir = new JButton("+");
        btnAlterar = new JButton("Δ");
        btnExcluir = new JButton("-");
        btnConfirmar = new JButton("✓");
        btnCancelar = new JButton("✗");
    }
    private void initForm() {
        id = new JLabel("Id");
        nome = new JLabel("Nome");
        sexo = new JLabel("Sexo");
        telefone = new JLabel("Telefone");
        txtId = new JTextField(5);
        txtNome = new JTextField(30);
        txtTelefone = new JTextField(15);
        pessoa = new JRadioButton("Pessoa", true);
        empresa = new JRadioButton("Empresa");
        grpTipo = new ButtonGroup();
        grpTipo.add(pessoa);
        grpTipo.add(empresa);
        comboSexo = new JComboBox(new String[] { "Masculino", "Feminino" });
        amigo = new JCheckBox("Amigo");                                   
        cliente = new JCheckBox("Cliente");
    }
    private void initLayout() {
        setLayout(new BorderLayout(2, 2));
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        toolbar.add(btnPrimeiro);
        toolbar.add(btnAnterior);
        toolbar.add(posicao);
        toolbar.add(btnProximo);
        toolbar.add(btnUltimo);
        toolbar.add(btnIncluir);
        toolbar.add(btnAlterar);
        toolbar.add(btnExcluir);
        toolbar.add(btnConfirmar);
        toolbar.add(btnCancelar);
        add(toolbar, BorderLayout.NORTH);
        RowPanel form = new RowPanel(5);
        form.addRow(id, txtId, pessoa, empresa);
        form.addRow(nome, txtNome);
        form.addRow(sexo, comboSexo, telefone, txtTelefone);
        form.addRow(amigo);
        form.addRow(cliente);
        add(form, BorderLayout.CENTER);
    }
    private void atualizaUI() {
        atualizaUI_toolbar();
        atualizaUI_form();
        atualizaUI_data();
    }
    private void atualizaUI_toolbar() {
        btnPrimeiro.setEnabled(pos > 0 && !incluindo && !alterando);
        btnAnterior.setEnabled(pos > 0 && !incluindo && !alterando);
        if (pos == -1) {
            posicao.setText("0 / 0");
        } else {
            posicao.setText(pos + 1 + " / " + contatos.size());
        }
        btnProximo.setEnabled(pos < contatos.size() - 1 && !incluindo && !alterando);
        btnUltimo.setEnabled(pos < contatos.size() - 1 && !incluindo && !alterando);
        btnIncluir.setEnabled(!incluindo && !alterando);
        btnAlterar.setEnabled(!incluindo && !alterando && pos != -1);
        btnExcluir.setEnabled(!incluindo && !alterando && pos != -1);
        btnConfirmar.setEnabled(incluindo || alterando);
        btnCancelar.setEnabled(incluindo || alterando);
    }
    private void atualizaUI_form() {
        txtId.setEnabled(incluindo || alterando);
        pessoa.setEnabled(incluindo || alterando);
        empresa.setEnabled(incluindo || alterando);
        txtNome.setEnabled(incluindo || alterando);
        comboSexo.setEnabled(incluindo || alterando);
        txtTelefone.setEnabled(incluindo || alterando);
        amigo.setEnabled(incluindo || alterando);
        cliente.setEnabled(incluindo || alterando);
    }
    private void atualizaUI_data() {
        if (pos == -1) {
            txtId.setText("");
            pessoa.setSelected(true);
            txtNome.setText("");
            comboSexo.setSelectedIndex(0);
            txtTelefone.setText("");
            amigo.setSelected(false);
            cliente.setSelected(false);
        } else {
            Contato contato = contatos.get(pos);
            txtId.setText(String.valueOf(contato.getId()));
            if (contato.getTipo() == 'P')
                pessoa.setSelected(true);
            else
                empresa.setSelected(true);
            txtNome.setText(contato.getNome());
            if (contato.getSexo() == 'M')
                comboSexo.setSelectedIndex(0);
            else
                comboSexo.setSelectedIndex(1);
            txtTelefone.setText(contato.getTelefone());
            amigo.setSelected(contato.isAmigo());
            cliente.setSelected(contato.isCliente());
        }
    }
    private void initEvents() {
        btnPrimeiro.addActionListener(this::btnPrimeiro_click); //  método como referência. atribuído ao objeto atualmente instanciado
        btnAnterior.addActionListener(this::btnAnterior_click);
        btnProximo.addActionListener(this::btnProximo_click);
        btnUltimo.addActionListener(this::btnUltimo_click);
        btnIncluir.addActionListener(this::btnIncluir_click);
        btnConfirmar.addActionListener(this::btnConfirmar_click);
        btnCancelar.addActionListener(this::btnCancelar_click);
    }
    private void btnPrimeiro_click(ActionEvent e) {
        pos = 0;
        atualizaUI();
    }
    private void btnAnterior_click(ActionEvent e) {
        pos--;
        atualizaUI();
    }
    private void btnProximo_click(ActionEvent e) {
        pos++;
        atualizaUI();
    }
    private void btnUltimo_click(ActionEvent e) {
        pos = contatos.size() - 1;
        atualizaUI();
    }
    private void btnIncluir_click(ActionEvent e) {
        Contato contato = new Contato();
        pos = contatos.size();
        contatos.add(contato);
        incluindo = true;
        atualizaUI();
    }
    private void btnConfirmar_click(ActionEvent e) {
        Contato contato = contatos.get(pos);
        contato.setTipo(pessoa.isSelected() ? 'P' : 'E');
//        if (pessoa.isSelected())
//            contato.setTipo('P');
//        else
//            contato.setTipo('E');
        contato.setNome(txtNome.getText().trim());
        contato.setSexo(comboSexo.getSelectedIndex() == 0 ? 'M' : 'F');
//        if (comboSexo.getSelectedIndex() == 0)
//            contato.setSexo('M');
//        else
//            contato.setSexo('F');
        contato.setTelefone(txtTelefone.getText().trim());
        contato.setAmigo(amigo.isSelected());
        contato.setCliente(cliente.isSelected());
        incluindo = alterando = false;
        atualizaUI();
    }
    private void btnCancelar_click(ActionEvent e) {
        if (incluindo) {
            incluindo = false;
            contatos.remove(contatos.size() - 1);
            pos--;
        } else {
            alterando = false;
        }
        atualizaUI();
    }
}
