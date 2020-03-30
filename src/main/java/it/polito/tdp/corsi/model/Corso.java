package it.polito.tdp.corsi.model;

public class Corso {
	
	private String nome;
	private int periodo;
	private String codIns;
	private int crediti;
	
	public Corso(String nome, int periodo, String codIns, int crediti) {
		this.nome = nome;
		this.periodo = periodo;
		this.codIns = codIns;
		this.crediti = crediti;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public String getCodIns() {
		return codIns;
	}
	public void setCodIns(String codIns) {
		this.codIns = codIns;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + nome + ", periodo=" + periodo + ", codIns=" + codIns + ", crediti=" + crediti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codIns == null) ? 0 : codIns.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codIns == null) {
			if (other.codIns != null)
				return false;
		} else if (!codIns.equals(other.codIns))
			return false;
		return true;
	}

}
