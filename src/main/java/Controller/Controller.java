package Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import Dao.CourseDao;
import Dao.ThreadsDao;
import Dao.UserDao;
import Model.Course;
import Model.Threads;

@org.springframework.stereotype.Controller
public class Controller { 
	
	 ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	    Course course = context.getBean("course", Course.class);
	    CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
	    
	@RequestMapping("/")
	public String home() {
		System.out.println("Opening index page.."); 
		return "index"; 
		}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
	    System.out.println("Opening dashboard..");
	    List<Course> courses = courseDao.getAllCourses();
	    System.out.println(courses);
	    System.out.println("Courses retrieved: " + courses.size());
	    model.addAttribute("courses", courses);
	    return "Dashboard"; 
	}
	@RequestMapping("/signUp")
	public String SignUp() {
		System.out.println("Opening Sign up page.."); 
		return "SignUp"; 
		}
	@RequestMapping("/adminLogin")
	public String AdminLogin() {
		System.out.println("Opening Sign up page.."); 
		return "AdminLogin"; 
		}
	@RequestMapping("/error")
	public String Error() {
		System.out.println("Error"); 
		return "Error"; 
		}
	@RequestMapping(path="/afterLogin",method=RequestMethod.POST)
	public String AfterLogin(HttpServletRequest request,Model model,HttpSession session){
		String uname=request.getParameter("name");
	    String password=request.getParameter("password");
	    if(uname.equals("Sayali")&& password.equals("Sayali123"))
	    {
	    	session.setAttribute("userRole", "Admin");
	    	session.setAttribute("adminName", "uname");
	    	System.out.println("Opening dashboard..");
		    List<Course> courses = courseDao.getAllCourses();
		    System.out.println(courses);
		    System.out.println("Courses retrieved: " + courses.size());
		    model.addAttribute("courses", courses); 
		    return "Dashboard"; 
	    }
	    else{
	    	System.out.println("Login Failed!!! wrong credentials");
	    	return "Error";
	    }
	}
	@RequestMapping(path = "/afterCourseFormSubmit", method = RequestMethod.POST)
    public String SubmitUser(@ModelAttribute Course course) {
        try {
            Long id = courseDao.insert(course);
            System.out.println("Course Added with ID: " + id);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
	@RequestMapping(path="/deleteGroup/{id}", method=RequestMethod.GET)
    public RedirectView deleteCourse(@PathVariable("id") long id, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        if (courseDao.deleteCourseById(id)) {
            redirectView.setUrl(request.getContextPath() + "/dashboard");
        } else {
            redirectView.setUrl(request.getContextPath() + "/error");
        }
        return redirectView;
    }
	
	    @RequestMapping(path = "/logout", method = RequestMethod.GET)
	    public String logout(HttpServletRequest request) {
	        HttpSession session = request.getSession(false); // Get the current session
	        if (session != null) {
	            session.invalidate(); // Invalidate the session
	        }
	        // Redirect to the login page or any other page
	        return "redirect:/"; // Adjust the path as needed
	    }
  
}