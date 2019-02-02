package br.com.workmade.springbootsecurityouth2acl.entity.enuns;

public enum PerfilEnum {
	
	ADMIN(1, "ROLE_ADMIN"),CLIENTE(2, "ROLE_CLIENTE");
	
	private int cod;
	private String descricao;
	
	private PerfilEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static PerfilEnum paraEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(PerfilEnum x : PerfilEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido"+cod);
	}

}
