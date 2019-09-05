package app.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.entities.AdministratorStaff;
import app.entities.News;
import app.entities.Student;
import app.entities.StudyCourse;
import app.entities.Teacher;

@Service
public class FileService {
	
	private String defaultProfileImagePath = "src/main/resources/images/profile_images/default.png";
	private String defaultCourseImagePath = "src/main/resources/images/course_images/default.png";
	

	public void addProfileImageAdministratorStaff(MultipartFile file, String fileName, AdministratorStaff adminStaff) throws IOException {
		 Tika tika = new Tika();
		    String mimeType = tika.detect(file.getBytes());
			if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/mp4"))) {
				File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				adminStaff.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			}
			else {
				InputStream initialStream = new FileInputStream(new File(defaultProfileImagePath));
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			    File targetFile = new File("src/main/resources/images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			    targetFile.createNewFile();
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			    initialStream.close();
			    outStream.close();
			    adminStaff.setProfilePicturePath("images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			}
		}
	
	public void addStudyCourseImage(MultipartFile file, String fileName, StudyCourse studyCourse) throws IOException {
		 Tika tika = new Tika();
		    String mimeType = tika.detect(file.getBytes());
			if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/mp4"))) {
				File convertFile = new File("src/main/resources/images/course_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				studyCourse.setImgPath("images/course_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			}
			else {
				InputStream initialStream = new FileInputStream(new File(defaultCourseImagePath));
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			    File targetFile = new File("src/main/resources/images/course_images/" + fileName + defaultCourseImagePath.substring(defaultCourseImagePath.lastIndexOf(".")));
			    targetFile.createNewFile();
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			    initialStream.close();
			    outStream.close();
			    studyCourse.setImgPath("images/course_images/" + fileName + defaultCourseImagePath.substring(defaultCourseImagePath.lastIndexOf(".")));
			}
		}
	
	public void addProfileImageTeacher(MultipartFile file, String fileName, Teacher teacher) throws IOException {
		 Tika tika = new Tika();
		    String mimeType = tika.detect(file.getBytes());
			if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/mp4"))) {
				File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				teacher.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			}
			else {
				InputStream initialStream = new FileInputStream(new File(defaultProfileImagePath));
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			    File targetFile = new File("src/main/resources/images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			    targetFile.createNewFile();
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			    initialStream.close();
			    outStream.close();
			    teacher.setProfilePicturePath("images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			}
		}
	
	public void addProfileImageStudent(MultipartFile file, String fileName, Student student) throws IOException {
		 Tika tika = new Tika();
		    String mimeType = tika.detect(file.getBytes());
			if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/mp4"))) {
				File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				student.setProfilePicturePath("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			}
			else {
				InputStream initialStream = new FileInputStream(new File(defaultProfileImagePath));
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			    File targetFile = new File("src/main/resources/images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			    targetFile.createNewFile();
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			    initialStream.close();
			    outStream.close();
			    student.setProfilePicturePath("images/profile_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			}
		}
	public void addImageNews(MultipartFile file, String fileName, News news) throws IOException {
		 Tika tika = new Tika();
		    String mimeType = tika.detect(file.getBytes());
			if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/mp4"))) {
				File convertFile = new File("src/main/resources/images/news_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				news.setProfilePicturePath("images/news_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			}
			else {
				InputStream initialStream = new FileInputStream(new File(defaultProfileImagePath));
			    byte[] buffer = new byte[initialStream.available()];
			    initialStream.read(buffer);
			    File targetFile = new File("src/main/resources/images/news_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			    targetFile.createNewFile();
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			    initialStream.close();
			    outStream.close();
			    news.setProfilePicturePath("images/news_images/" + fileName + defaultProfileImagePath.substring(defaultProfileImagePath.lastIndexOf(".")));
			}
		}
	
	
}
