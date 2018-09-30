package br.com.servlet;

import br.com.control.ControllerDAOUser;
import br.com.object.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       User userSession = new User();
       ControllerDAOUser control = new ControllerDAOUser();
        
        String email = request.getParameter("email");
        String password = request.getParameter("senha");
        userSession = control.requestDAOByLogin(email,password);
        
        if(userSession!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", userSession);
            
            if(userSession.getlevel().equals("user")){
                response.sendRedirect("clienteIndex.jsp");
            }else if(userSession.getlevel().equals("expert")){
                response.sendRedirect("tecnicoIndex.html");
            }else{
                response.sendRedirect("adminIndex.html");
            }
        }else{
            response.sendRedirect("pages/login.jsp");
        }
       
    }
   
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
