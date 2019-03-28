package com.storage.document.documentstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storage.document.documentstorage.response.ServiceResponse;

@Controller
@RestController
public class DocumentStorageController {
	
	@Autowired
	DocumentStorageService service;
	
    @PostMapping("/storage/documents")
	public ServiceResponse saveDocument(@RequestParam("content") MultipartFile file){      	
    	return service.saveDocument(file);
	}
    
    @RequestMapping("/storage/documents/{documentId}")
	public ServiceResponse saveDocument(@PathVariable String documentId){      	
    	return service.getDocument(documentId);
	}
    
    @PutMapping("/storage/documents/{documentId}")
	public ServiceResponse updateDocument(@RequestParam("content") MultipartFile file, @PathVariable String documentId){      	
    	return service.updateDocument(file, documentId);
	}
    
    @DeleteMapping("/storage/documents/{documentId}")
	public ServiceResponse deleteDocument(@PathVariable String documentId){      	
    	return service.deleteDocument(documentId);
	}

}
