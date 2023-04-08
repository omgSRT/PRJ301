/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangND.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omg
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final String LOGINPAGE = "login.jsp";
    private final String LOGINCONTROLLER = "LoginController";
    private final String SEARCHCONTROLLER = "SearchController";
    private final String DELETECONTROLLER = "DeleteController";
    private final String UPDATECONTROLLER = "UpdateController";
    private final String ADDITEMCONTROLLER = "AddItemController";
    private final String VIEWCART = "viewCart.jsp";
    private final String REMOVECARTITEM = "RemoveItemController";
    private final String REGISTERCONTROLLER = "RegisterController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("txtname");
            String password = request.getParameter("txtpassword");
            String action = request.getParameter("action");
            String url = "error.html";
            if(action.equals("login")){
                url = LOGINCONTROLLER;
            }
            else if(action.equals("search")){
                url = SEARCHCONTROLLER;
            }
            else if(action.equals("delete")){
                url = DELETECONTROLLER;
            }
            else if(action.equals("update")){
                url = UPDATECONTROLLER;
            }else if(action.equals("addBook")){
                url = ADDITEMCONTROLLER;
            }
            else if(action.equals("viewCart")){
                url = VIEWCART;
            }else if(action.equals("removeItem")){
                url = REMOVECARTITEM;
            }else if(action.equals("register")){
                url = REGISTERCONTROLLER;
            }
            
            request.getRequestDispatcher(url).forward(request, response);
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
