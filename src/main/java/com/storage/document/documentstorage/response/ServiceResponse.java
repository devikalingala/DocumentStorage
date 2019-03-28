package com.storage.document.documentstorage.response;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse {

	@JsonProperty("Response")
	String responseCode;
	@JsonProperty("Content-Length")
	long contentLegth;
	@JsonProperty("Content-Type")
	String contentType;
	@JsonProperty("document-id")
	String documentId;
	@JsonProperty("content")
	String content;
	

	
	public String getResponseCode() {
		return responseCode;
	}

	public long getContentLegth() {
		return contentLegth;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setContentLegth(long contentLegth) {
		this.contentLegth = contentLegth;
	}

	public String getContentType() {
		return contentType;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
