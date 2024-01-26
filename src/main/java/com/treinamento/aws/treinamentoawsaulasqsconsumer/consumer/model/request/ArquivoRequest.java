package com.treinamento.aws.treinamentoawsaulasqsconsumer.consumer.model.request;

public class ArquivoRequest {
	private String nomeArquivo;
	private String dataCriacao;
	private String descricao;
	private String nomeArquivoSalvoBucket;

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeArquivoSalvoBucket() {
		return nomeArquivoSalvoBucket;
	}

	public void setNomeArquivoSalvoBucket(String nomeArquivoSalvoBucket) {
		this.nomeArquivoSalvoBucket = nomeArquivoSalvoBucket;
	}
}
