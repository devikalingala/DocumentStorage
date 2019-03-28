package com.storage.document.documentstorage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.storage.document.documentstorage.response.ServiceResponse;

@Service
public class DocumentStorageService {

	Map<String, byte[]> documents = new HashMap<String, byte[]>();

	public ServiceResponse saveDocument(MultipartFile file) {

		ServiceResponse response = new ServiceResponse();
		long size = file.getSize();
		String docID = new RandomStringUtils().randomAlphanumeric(20, 20);
		try {
			documents.put(docID, file.getBytes());
		} catch (IOException e) {
			System.err.println("Error in saving document " + e);
			response.setResponseCode("500 Internal Server Error");
			return response;
		}
		response.setResponseCode("201 Created");
		response.setContentType(file.getContentType());
		response.setContentLegth(size);
		response.setDocumentId(docID);
		return response;

	}

	public ServiceResponse getDocument(String documentId) {
		byte[] document = documents.get(documentId);
		ServiceResponse response = new ServiceResponse();
		if (document == null || document.length == 0) {
			response.setResponseCode("404 Not found");
			return response;
		}
		response.setResponseCode("200 OK");
		response.setContentLegth(document.length);
		response.setDocumentId(documentId);
		response.setContent(new String(document));
		return response;
	}

	public ServiceResponse updateDocument(MultipartFile file, String documentId) {

		byte[] document = documents.get(documentId);

		ServiceResponse response = new ServiceResponse();
		if (document == null || document.length == 0) {
			response.setResponseCode("404 Not found");
			return response;
		}

		try {
			documents.put(documentId, file.getBytes());
		} catch (IOException e) {
			System.err.println("Error in saving document " + e);
			response.setResponseCode("500 Internal Server Error");
			return response;
		}
		response.setResponseCode("200 OK");
		response.setContentLegth(document.length);
		response.setDocumentId(documentId);
		response.setContent(new String(documents.get(documentId)));
		return response;

	}

	public ServiceResponse deleteDocument(String documentId) {
		byte[] document = documents.get(documentId);

		ServiceResponse response = new ServiceResponse();
		if (document == null || document.length == 0) {
			response.setResponseCode("404 Not found");
			return response;
		}		
		documents.remove(documentId);
		response.setResponseCode("204 No Content");
		return response;
		
		
		
	}

}
