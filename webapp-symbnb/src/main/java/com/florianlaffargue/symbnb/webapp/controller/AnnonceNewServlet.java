/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.webapp.controller;

import com.florianlaffargue.symbnb.coreBNB.dto.AnnonceDto;
import com.florianlaffargue.symbnb.coreBNB.dto.ImageDto;
import com.florianlaffargue.symbnb.coreBNB.dto.UserDto;
import com.florianlaffargue.symbnb.coreBNB.service.AnnonceService;
import com.florianlaffargue.symbnb.webapp.provider.AnnonceServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Flo
 */
@WebServlet(name = "AnnonceNew", urlPatterns = {"/new"})
public class AnnonceNewServlet extends HttpServlet {

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
            
            if(request.getParameter("title") == null) {
                RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/annonce_new.jsp");
                disp.forward(request, response);
            } else {
                
                HttpSession session = request.getSession();
                
                AnnonceService annonceService = AnnonceServiceProvider.getAnnonceService();
                
                AnnonceDto dto = new AnnonceDto();

                dto.setTitle(request.getParameter("title"));
                dto.setSlug(request.getParameter("slug"));
                dto.setPrice(Double.parseDouble(request.getParameter("price")));
                dto.setIntroduction(request.getParameter("introduction"));
                dto.setContent(request.getParameter("content"));
                dto.setCoverImage(request.getParameter("coverImage"));
                dto.setRooms(Integer.parseInt(request.getParameter("rooms")));
                
                UserDto userDto = new UserDto();
                userDto.setId((Integer)session.getAttribute("userId"));
                dto.setAuthor(userDto);
                
                List<ImageDto> images = new ArrayList();
                ImageDto image = new ImageDto();
                image.setUrl(request.getParameter("url"));
                image.setCaption(request.getParameter("caption"));
                images.add(image);
                dto.setImages(images); 
                
                annonceService.createAnnonce(dto);
                
                request.setAttribute("success", "L'enregistremenet a bien été effectué");
                RequestDispatcher dispatch = request.getRequestDispatcher("/list");
                dispatch.forward(request, response);
                
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
