package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import Dao.CourseDao;
import Dao.UserDao;
import Model.Course;
import Model.User;
import Model.Threads;
import Dao.ThreadsDao;
@Controller
public class ThreadController {
	 ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	    User user = context.getBean("user", User.class);
	    UserDao userDao = context.getBean("userDao", UserDao.class);
	    Course course = context.getBean("course", Course.class);
	    CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
	    Threads threads = context.getBean("threads", Threads.class);
	    ThreadsDao threadsDao = context.getBean("threadsDao", ThreadsDao.class);
	   
	    @RequestMapping(path = "/threads/{courseName}", method = RequestMethod.GET)
	    public String getThreadsForCourse(@PathVariable("courseName") String courseName, Model model,HttpSession session) {
	        // Retrieve all threads
	        List<Threads> allThreads = threadsDao.loadAll();
	        session.setAttribute("courseName", courseName);
	        // Filter threads based on the course name
	        List<Threads> filteredThreads = new ArrayList<Threads>();
	        for (Threads thread : allThreads) {
	            if (courseName.equals(thread.getCourseName())) {
	                filteredThreads.add(thread);
	            }
	        }

	        // Add attributes to the model
	        model.addAttribute("threads", filteredThreads);
	        model.addAttribute("courseName",courseName);
	        
	        // Return the view name
	        return "Threads";
	    }
		@RequestMapping(path = "/threads/threadPost", method = RequestMethod.POST)
	    public String SubmitUser(@ModelAttribute Threads thread,RedirectAttributes redirectAttributes,HttpSession session) {
	        try {
	        	String courseName=(String) session.getAttribute("courseName");
	            Long id = threadsDao.insert(thread);
	            System.out.println("Thread Added with ID: " + id);
	            return "redirect:/threads/" + courseName;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	    }
		@RequestMapping(path="/deleteThread/{id}", method=RequestMethod.GET)
	    public RedirectView deleteCourse(@PathVariable("id") long id, HttpServletRequest request,HttpSession session) {
	        RedirectView redirectView = new RedirectView();
	        String courseName = (String) session.getAttribute("courseName");
	        if (threadsDao.deleteThreadById(id)) {
	            redirectView.setUrl(request.getContextPath() + "/threads/" + courseName);
	        } else {
	            redirectView.setUrl(request.getContextPath() + "/error");
	        }
	        return redirectView;
	    }
}
