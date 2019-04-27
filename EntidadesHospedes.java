package br.com.estacio.entidade;

public class Hospedes {
	
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String tel;
	private Object numQuarto;
	private String ckeckIn;
	private String ckeckOut;
	private int codigo;
	private Boolean tipo;
	private Object imagem;
	private String formaPagamento;
	private String dataRegistro;
	
	
	
	public Object getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Object numQuarto) {
		this.numQuarto = numQuarto;
	}
	public String getCkeckOut() {
		return ckeckOut;
	}
	public void setCkeckOut(String ckeckOut) {
		this.ckeckOut = ckeckOut;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getCkeckIn() {
		return ckeckIn;
	}
	public void setCkeckIn(String ckeckIn) {
		this.ckeckIn = ckeckIn;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Boolean getTipo() {
		return tipo;
	}
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	public Object getImagem() {
		return imagem;
	}
	public void setImagem(Object imagem) {
		this.imagem = imagem;
	}
	
	
}
