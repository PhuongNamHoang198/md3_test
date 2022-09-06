package finaltest;


import model.Student;
import service.IStudentDAO;
import service.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    IStudentDAO studentDAO = new StudentDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException{
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                showAllStudent(request,response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student temp = studentDAO.findByID(id);
        request.setAttribute("", temp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher("student/create.jsp").forward(request,response);
    }

    private void showAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Student> studentList = studentDAO.findAll();
        request.setAttribute("list",studentList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req, resp);
                break;
            case "edit":

                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
                showAllStudent(req, resp);
                break;
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.delete(id);
        showAllStudent(request, response);
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date birth = Date.valueOf(req.getParameter("date_of_birth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone_number");
        String email = req.getParameter("email");
        int class_id = Integer.parseInt(req.getParameter("class_id")) ;
        Student student = new Student(name,birth,address,phone,email,class_id);
        studentDAO.save(student);
        req.setAttribute("mess","Thanh Cong");
        req.getRequestDispatcher("student/create.jsp").forward(req,resp);
    }
}