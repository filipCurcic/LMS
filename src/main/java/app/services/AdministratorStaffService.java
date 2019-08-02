package app.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.entities.AdministratorStaff;
import app.entities.Course;
import app.entities.CourseAttending;
import app.entities.CourseRealization;
import app.entities.ElectiveCourseAttendance;
import app.entities.Student;
import app.entities.StudentOnYear;
import app.entities.StudyYear;
import app.repositories.AdministratorStaffRepository;

@Service
public class AdministratorStaffService {

	@Autowired
	AdministratorStaffRepository administratorStaffRepository;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudyYearService studyYearService;
	
	@Autowired
	StudentOnYearService studentOnYearService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseRealizationService courseRealizationService;
	
	@Autowired
	CourseAttendingService courseAttendingService;
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
    
	
	public Iterable<AdministratorStaff> getAdministratorStaff() {
		return administratorStaffRepository.findAll();
	}
	
	public Optional<AdministratorStaff> getOne(Long id) {
		return administratorStaffRepository.findById(id);
	}
	
	public Optional<AdministratorStaff> getOneByUsername(String username) {
		return administratorStaffRepository.getByUsername(username);
	}
	
	public void addAdministratorStaff(AdministratorStaff adminStaff) {
		loginService.addPermssion(adminStaff.getRegisteredUser(), "ROLE_ADMINISTRATOR_STAFF");
		adminStaff.getRegisteredUser().setPassword(passwordEncoder.encode(adminStaff.getRegisteredUser().getPassword()));
		administratorStaffRepository.save(adminStaff);
	}
	
	public void removeAdministratorStaff(Long id) {
		Optional<AdministratorStaff> adminStaff = administratorStaffRepository.findById(id);
		AdministratorStaff admin = adminStaff.get();
		admin.setDeleted(true);
		administratorStaffRepository.save(admin);
	}
	
	public void updateAdministrationStaff(String username, AdministratorStaff adminStaff) {
		 Optional<AdministratorStaff> admin = administratorStaffRepository.getByUsername(username);
	        if(admin.isPresent()) {
	            adminStaff.setId(admin.get().getId());
	            adminStaff.getRegisteredUser().setPassword(passwordEncoder.encode(adminStaff.getRegisteredUser().getPassword()));
	            registeredUserService.updateUser(adminStaff.getRegisteredUser().getId(), adminStaff.getRegisteredUser());
	            addressService.updateAddress(adminStaff.getAddress().getId(), adminStaff.getAddress());
	            administratorStaffRepository.save(adminStaff);
	        }
	}
	
	public Iterable<Student> getStudentsForEnrollmentToTheNextYear(Long studyYearId) {
    	ArrayList<Student> studentsForEnrollmentToTheNextYear = new ArrayList<Student>();
        Optional<StudyYear> nextStudyYear = studyYearService.getNextYearOfStudyByStudyProgram(studyYearId);
        if(!nextStudyYear.isPresent()) { 
        	return studentsForEnrollmentToTheNextYear;
        }
        ArrayList<Course> preconditions = (ArrayList<Course>) courseService.getPrerequisitesForMandatorySubjectsByStudyYear(nextStudyYear.get().getId());
        ArrayList<Student> tempStudents = (ArrayList<Student>) administratorStaffRepository.findStudentsForEnrollmentToTheNextYear(studyYearId);
    	
    	int preconditionsSize = preconditions.size();
    	if(preconditionsSize == 0) {
    		studentsForEnrollmentToTheNextYear = (ArrayList<Student>) tempStudents;
    		return studentsForEnrollmentToTheNextYear;
    	}
    	for(int i = 0; i < tempStudents.size(); i++) {
			int passedPrecondition = 0;
			for(CourseAttending ca : tempStudents.get(i).getCourseAttending()) {
				for(Course precondition: preconditions) {
    				if(ca.getGrade() != null && precondition.getId() == ca.getCourseRealization().getCourse().getId()) {
    					passedPrecondition = passedPrecondition + 1;
    				}
				}
			}
			if(passedPrecondition == preconditionsSize) {
				studentsForEnrollmentToTheNextYear.add(tempStudents.get(i));
			}	
			
		}
    	
    	return studentsForEnrollmentToTheNextYear;
    }
    
	public Boolean enrollmentStudentToTheNextYear(Long studentId, StudyYear studyYear) { 
    	Optional<Student> student = studentService.getOne(studentId);
        if(student.isPresent()) {
        	Optional<StudyYear> oldStudyYear = studyYearService.getYearOfStudyById(studyYear.getId());
        	Optional<StudyYear> newYearOfStudy = studyYearService.getNextYearOfStudyByStudyProgram(studyYear.getId());
        	Optional<StudentOnYear> studentOnYear = studentOnYearService.getStudentYearByStudyYearIdAndStudentId(oldStudyYear.get().getId(), student.get().getId());
        	studentOnYear.get().setStudyYear(newYearOfStudy.get());
        	studentOnYearService.updateStudentOnYear(studentOnYear.get().getId(), studentOnYear.get());
        	
        	Iterable<CourseRealization> courseRealizations = courseRealizationService.getCourseRealizationByStudyYearId(newYearOfStudy.get().getId());
        	for(CourseRealization cr: courseRealizations) {
        		if(cr.getCourse().getMandatory()) {
        			courseAttendingService.AddCourseAttending(new CourseAttending(null, student.get(), cr));
        		}
        		else if(!cr.getCourse().getMandatory()) {
        			for(ElectiveCourseAttendance eca: student.get().getElectiveCourseAttendances()) {
        				if(eca.getCourseRealization().getId() == cr.getId()) {
        					courseAttendingService.AddCourseAttending(new CourseAttending(null, student.get(), cr));
        				}
        			}
        		}
        	}
        	return true;
        }
        return false;
    }

}
