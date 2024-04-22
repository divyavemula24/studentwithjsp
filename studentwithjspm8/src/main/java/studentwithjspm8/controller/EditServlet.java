package studentwithjspm8.controller;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjspm8.dao.StudentDao;
import studentwithjspm8.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 Student student=new Student();
 student.setAddress(req.getParameter("address"));
 student.setEmail(req.getParameter("email"));
 student.setFees(Double.parseDouble(getServletContext().getInitParameter("fees")));
 student.setId(Integer.parseInt(req.getParameter("id")));
 student.setName(req.getParameter("name"));
 student.setPassword(req.getParameter("password"));
 student.setPhone(Long.parseLong(req.getParameter("phone")));
 
 
 StudentDao dao=new StudentDao();
 dao.updateStudent(student);
 
 req.setAttribute("students", dao.getAllStudents());
 RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
 dispatcher.forward(req, resp);
 
 
 
 
 
 
}
}
