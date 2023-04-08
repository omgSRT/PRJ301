/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangND.controller;

import ThangND.DAO.RegistrationDTO;
import ThangND.DAO.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omg
 */
public class SearchController extends HttpServlet {

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
            String searchValue = request.getParameter("txtSearchValue");
//            String urlRewriting; int count = 0;
            ArrayList<RegistrationDTO> list = RegistrationDAO.searchByLastName(searchValue);
            request.setAttribute("regList", list);
            request.getRequestDispatcher("showSearchResult.jsp").forward(request, response);
//            out.println("<html><body><table border='1'>");
//            out.println("<h1>Search result</h1>");
//            out.println("<tr>");
//            out.println("<th>No.</th>");
//            out.println("<th>username</th>");
//            out.println("<th>lastname</th>");
//            out.println("<th>password</th>");
//            out.println("<th>isAdmin</th>");
//            out.println("<th>Delete</th>");
//            out.println("<th>Update</th>");
//            out.println("</tr>");
//            for (int i = 0; i < list.size(); i++) {
//                count++;
//                urlRewriting = "MainController?action=delete&txtusername=" + list.get(i).getUsername() + "&lastSearchResult=" + searchValue;
//
//                out.println("<tr>");
//                out.println("<form action='MainController' method='post'>");
//
//                out.println("<td>" + count + "</td>");
//                out.println("<td>" + list.get(i).getUsername() + "<input type='hidden' name='txtUsername' value='" + list.get(i).getUsername() + "'></td>");
//                out.println("<td><input type='text' name='txtLastname' value='" + list.get(i).getLastname() + "'></td>");
//                out.println("<td><input type='text' name='txtPassword' value='" + list.get(i).getPassword() + "'></td>");
//                if (list.get(i).isIsAdmin()) {
//                    out.println("<td><input type='checkbox' name='ADMIN' value='ON' checked='checked'></td>");
//                } else {
//                    out.println("<td><input type='checkbox' name='ADMIN' value='ON'></td>");
//                }
//                out.println("<td><a href='" + urlRewriting + "'>Delete</a></td>");
//                out.println("<td><input type='hidden' name='lastSearchValue' value='" + searchValue + "'>"
//                        + "<input type='submit' value='update' name='action'></td>");
//
//                out.println("</form>");
//                out.println("</tr>");
//            }
//            out.println("</table></body></html>");
//            out.println("<a href='search.html'>Go back</a>");
        } catch (Exception e) {
            e.printStackTrace();
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
