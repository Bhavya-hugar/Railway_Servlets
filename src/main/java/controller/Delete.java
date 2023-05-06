package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/deletetrain")
public class Delete extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   int num=Integer.parseInt(req.getParameter("number"));
    	   TrainDao dao=new TrainDao();
    	   dao.delete(num);
    	   List<Train>list=dao.fetchAll();
   		if(list.isEmpty())
   		{
   			resp.getWriter().print("<h1 style='color:red'>no railway information found</h1>");
   			req.getRequestDispatcher("ManagementHome.html").include(req, resp);
   		}
   		else{
   			resp.getWriter().print("<h1style='color:red'>railway information deleted successfully</h1>");
   			req.setAttribute("list", list);
   			req.getRequestDispatcher("Fetch.jsp").include(req, resp);
   			
   		}
    }
}
