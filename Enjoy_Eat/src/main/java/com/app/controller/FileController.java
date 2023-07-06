package com.app.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.FileResponse;
import com.app.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {  
	
	@Autowired
	private FileService fileService; 
	@Value("${project.image}")
	private String path;

	@RequestMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
		String fileName =this.fileService.uploadImage(path, image);
		
		return new ResponseEntity<>(new FileResponse(fileName,"Image is sucessfully uploaded"),HttpStatus.OK);
	}
	
	//method to serve files
	
	@GetMapping("/images/{imageName}")
	public void downloadImage(@PathVariable("imageName") String imageName,HttpServletResponse response) throws IOException {
		
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType("image/jpg");
		
		StreamUtils.copy(resource,response.getOutputStream());
		}
}
