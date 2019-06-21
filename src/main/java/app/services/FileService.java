package app.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.entities.AdministratorStaff;
import app.entities.Student;
import app.entities.StudyCourse;
import app.entities.Teacher;

@Service
public class FileService {

	public void addProfileImageAdministratorStaff(MultipartFile file, String fileName, AdministratorStaff adminStaff) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType.equals("image/png")|| mimeType.equals("image/jpeg"))) {
			File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			adminStaff.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			
		}
	}
	
	public void addStudyCourseImage(MultipartFile file, String fileName, StudyCourse studyCourse) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType.equals("image/png")|| mimeType.equals("image/jpeg"))) {
			File convertFile = new File("src/main/resources/images/course_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			studyCourse.setImgPath("images/course_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
		}
	}
	
	public void addProfileImageTeacher(MultipartFile file, String fileName, Teacher teacher) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
	    if(file != null && (mimeType.equals("image/png")|| mimeType.equals("image/jpeg"))) {
	    	File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			teacher.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			
		}
	}
	
	public void addProfileImageStudent(MultipartFile file, String fileName, Student student) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
	    if(file != null && (mimeType.equals("image/png")|| mimeType.equals("image/jpeg"))) {
			File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			student.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			
		}
	}
	
}
