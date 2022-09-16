package br.com.entra21.backend.spring.entra21.model;

import java.util.ArrayList;

public class ItemNivel3 {
	
	// =================== Atributos
	private String ref;
	private String url;
	private ArrayList<String> headers;
	private String body;

	// =================== Construtores
	ItemNivel3() {
		super();
	}

	public ItemNivel3(String ref, String url, ArrayList<String> headers, String body) {
		super();
		this.ref = ref;
		this.url = url;
		this.headers = headers;
		this.body = body;
	}

	// =================== Getters e Setters
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<String> getHeaders() {
		return headers;
	}

	public void setHeaders(ArrayList<String> headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
