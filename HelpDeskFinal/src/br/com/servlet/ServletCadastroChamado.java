/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.control.ControlDAOOrder;
import br.com.object.Order;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leandro
 */
public class ServletCadastroChamado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ControlDAOOrder ct = new ControlDAOOrder();
        Order chamado = new Order();
        
        chamado.setIdUser(request.getParameter("idUser"));
        chamado.setDetails(request.getParameter("detalhesChamado"));
        chamado.setPriority(request.getParameter("prioridadeSelect"));
        chamado.setProblem(request.getParameter("problemaSelect"));
        chamado.setStatus("WAITING");
        LocalDate dt = LocalDate.now();
        chamado.setDateIni(dt.toString());
        chamado.setIdExpert(null);
        chamado.setDateFin(null);
        ct.create(chamado);
        
        String tipoUser = request.getParameter("userLevel");
//        PrintWriter out = response.getWriter();
//        out.println(chamado.getDateIni());
        if(tipoUser.equals("user")){
          response.sendRedirect("clienteIndex.jsp");
            
        }else if(tipoUser.equals("expert")){
        }else if(tipoUser.equals("admin")){
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
