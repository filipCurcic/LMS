package app.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.entities.AdministratorStaff;
import app.entities.Student;
import app.entities.Teacher;

@Service
public class FileService {

	public void addProfileImageAdministratorStaff(MultipartFile file, String fileName, AdministratorStaff adminStaff) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType == "image/png" || mimeType == "image/jpeg")) {
			File convertFile = new File("resources\\images\\profileImages\\" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			//student.setProfilePicturePath(convertFile.getPath());
			//teacher.setProfilePicturePath(convertFile.getPath());
			adminStaff.setProfilePicturePath(convertFile.getPath());
			
		}
	}
	
	public void addProfileImageTeacher(MultipartFile file, String fileName, Teacher teacher) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType == "image/png" || mimeType == "image/jpeg")) {
			File convertFile = new File("resources\\images\\profileImages\\" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			teacher.setProfilePicturePath(convertFile.getPath());
			
		}
	}
	
	public void addProfileImageStudent(MultipartFile file, String fileName, Student student) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType == "image/png" || mimeType == "image/jpeg")) {
			File convertFile = new File("resources\\images\\profileImages\\" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			student.setProfilePicturePath(convertFile.getPath());
			
		}
	}
	
}
