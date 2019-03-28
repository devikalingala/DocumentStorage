package com.storage.document.documentstorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.storage.document.documentstorage.controller.DocumentStorageService;
import com.storage.document.documentstorage.response.ServiceResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentStorageApplicationTests {

	
	@InjectMocks
	DocumentStorageService service;
	
	@Mock
	MultipartFile file;
	
	@Test
	public void shouldSaveDocumengtSuccess() throws IOException {
		when(file.getBytes()).thenReturn("Sample".getBytes());
		when(file.getContentType()).thenReturn("plain/text");
		when(file.getSize()).thenReturn((long)"Sample".length());
		
		ServiceResponse response = service.saveDocument(file);
		assertEquals("201 Created", response.getResponseCode());
		assertEquals(6, response.getContentLegth());
		assertEquals("plain/text", response.getContentType());
		assertTrue(response.getDocumentId().length()==20);
	}

}
