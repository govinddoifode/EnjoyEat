package com.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) {

		//file Name
		String name = file.getOriginalFilename();
		
		//random name generate
//		String randomID = UUID.randomUUID().toString();
//
//		String fileName1 =randomID.concat(name.substring(name.lastIndexOf(".")));

		//Full path
		String  filePath = path + File.separator + name;

		//create folder if not created

		File f = new File(path);

		if(!f.exists()) {
			f.mkdir();
		}
			//file copy
			try {
				Files.copy(file.getInputStream(),Paths.get(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath =path+File.separator+fileName;
		InputStream is = new FileInputStream(fullPath);
		//DB logic to return inputStream
		return is;
	}

}
