/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.webapp.controller;

import com.florianlaffargue.symbnb.coreBNB.HibernateUtil;
import com.florianlaffargue.symbnb.coreBNB.dto.AnnonceDto;
import com.florianlaffargue.symbnb.coreBNB.entity.Annonce;
import com.florianlaffargue.symbnb.coreBNB.service.AnnonceService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Flo
 */
@WebServlet(name = "AnnonceUpdateServlet", urlPatterns = {"/edit"})
public class AnnonceUpdateServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnnonceUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnnonceUpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String id = request.getParameter("id");
        AnnonceService annonceService = new AnnonceService();
        Annonce annonce = annonceService.getAnnonce(Integer.parseInt(id));
        request.setAttribute("annonce", annonce);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/annonce_edit.jsp");
        dispatch.forward(request, response);

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
        
        AnnonceDto dto = new AnnonceDto();
        
        dto.setTitle(request.getParameter("title"));
        dto.setSlug(request.getParameter("slug"));
        dto.setPrice(Double.parseDouble(request.getParameter("price")));
        dto.setIntroduction(request.getParameter("introduction"));
        dto.setContent(request.getParameter("content"));
        dto.setCoverImage(request.getParameter("coverImage"));
        dto.setRooms(Integer.parseInt(request.getParameter("rooms")));
        
        String id = request.getParameter("id");
        AnnonceService annonceAnnonceService = new AnnonceService();
        Annonce annonce = annonceAnnonceService.updateAnnonce(Integer.parseInt(id), dto);
       
        request.setAttribute("success", "La modification de l'annonce " + annonce.getTitle() + "a bien été effectuée");
        RequestDispatcher dispatch = request.getRequestDispatcher("/home");
        dispatch.forward(request, response);

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
