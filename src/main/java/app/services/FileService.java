package app.services;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.entities.AdministratorStaff;
import app.entities.File;
import app.entities.Student;
import app.entities.Teacher;

@Service
public class FileService {

	public void uploadPhoto(MultipartFile file, String fileName, Student student) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		}
	
}
