package prova;

public class Contato {
    private static int seq; // sequenciador de IDs
    private int id;
    private char tipo; // P = Pessoa, E = Empresa
    private String nome;
    private char sexo; // M = Masculino, F = Feminino
    private String telefone;
    private boolean amigo;
    private boolean cliente;
    // invocado ao carregar os dados do arquivo
    public Contato(int id, char tipo, String nome, char sexo, String telefone,
        boolean amigo, boolean cliente) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.amigo = amigo;
        this.cliente = cliente;
    }
    // invocado sempre que um novo contato for criado
    public Contato() {
        this(++seq, 'P', null, 'M', null, false, false);
    }
    public int getId() {
        return id;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public boolean isAmigo() {
        return amigo;
    }
    public void setAmigo(boolean amigo) {
        this.amigo = amigo;
    }
    public boolean isCliente() {
        return cliente;
    }
    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }
}
