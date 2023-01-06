package com.escuela.sms.views;

import java.util.List;

import com.escuela.sms.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.escuela.sms.model.SchoolYear;
import com.escuela.sms.repository.ClassRepository;
import com.escuela.sms.repository.RegistrationRepository;
import com.escuela.sms.repository.SchoolRepository;
import com.escuela.sms.repository.SchoolYearRepository;
import com.escuela.sms.repository.StudentRepository;
import com.escuela.sms.repository.SubjectRepository;
import com.escuela.sms.repository.TeacherRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewsController.
 */
@Controller
@RequestMapping
public class 	ViewsController {
	
	/** The student repository. */
	@Autowired
    StudentRepository studentRepository;
	
	/** The teacher repository. */
	@Autowired
	private TeacherRepository teacherRepository;
	
	/** The school repository. */
	@Autowired
	private SchoolRepository schoolRepository;
	
	/** The school year repository. */
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/** The class repository. */
	@Autowired
	private ClassRepository classRepository;

	/** The subject repository. */
	@Autowired
	private SubjectRepository subjectRepository;

	/** The registration repository. */
	@Autowired
	private RegistrationRepository registrationRepository;
	
	/**
	 * Index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/")
	public String index(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        model.addAttribute("registrations", registrationRepository.findFirst5ByOrderByTimestampDesc());
        model.addAttribute("schoolYears", schoolYearRepository.findFirst5ByOrderByIdDesc());
        Iterable<SchoolYear> years = schoolYearRepository.findFirst5ByOrderByIdDesc();
        List<SchoolYear> list = (List<SchoolYear>) years;
        for(int i = 0; i < list.size(); ++i) {
        	String attributeName = "class" + i;
        	Iterable<Class> attributeValue = classRepository
        			.findBySchoolYearId(list.get(i).getId());
        	model.addAttribute(attributeName, attributeValue);
        }
		return "index";
	}
	
	/**
	 * Error 404.
	 *
	 * @return the string
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String error404() {
		return "error/404";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
