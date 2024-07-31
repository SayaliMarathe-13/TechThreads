package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Dao.CourseDao;
import Dao.ThreadsDao;
import Dao.UserDao;
import Model.Course;
import Model.Threads;
import Model.User;

@Controller
public class UserController {

    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    User user = context.getBean("user", User.class);
    UserDao userDao = context.getBean("userDao", UserDao.class);
    Course course = context.getBean("course", Course.class);
    CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
  

    @RequestMapping(path = "/afterUserSignUp", method = RequestMethod.POST)
    public String SubmitUser(@ModelAttribute User user) {
        try {
            String id = userDao.insert(user);
            System.out.println("User Account Added with ID: " + id);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping(path = "/afterUserLogin", method = RequestMethod.POST)
    public String checkUser(HttpServletRequest request, Model model, HttpSession session) {
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");
        System.out.println(contact + " " + password);
        try {
            User user = userDao.getAccount(contact);
            System.out.println(user);
            if (user == null || !password.equals(user.getPassword())) {
                throw new RuntimeException("Invalid credentials or user not found");
            }
            session.setAttribute("name", user.getName());
            System.out.println("User verified");
            session.setAttribute("loggedInContact", contact); 
            List<Course> courses = courseDao.getAllCourses();
		    System.out.println(courses);
		    System.out.println("Courses retrieved: " + courses.size());
		    model.addAttribute("courses", courses);
            return "UserDashboard";
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
    @RequestMapping("/userDashboard")
   	public String UserDashboard(Model model) {
   		System.out.println("Opening index page.."); 
   		 List<Course> courses = courseDao.getAllCourses();
   		    System.out.println(courses);
   		    System.out.println("Courses retrieved: " + courses.size());
   		    model.addAttribute("courses", courses);
   		return "UserDashboard"; 
   		}

}
