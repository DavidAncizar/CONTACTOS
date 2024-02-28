/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.directorio.Contacto;
import com.mycompany.directorio.controladorContacto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danie
 */
@WebServlet(name = "SvBuscarContacto", urlPatterns = {"/SvBuscarContacto"})

public class SvBuscarContacto extends HttpServlet {
    private controladorContacto controlador = new controladorContacto();
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
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
        String nombre = request.getParameter("nombre");
    
        Contacto contacto = controlador.buscarContactoPorNombre(nombre);
        
        if (contacto != null) {
            // Devuelve los detalles del contacto como respuesta del servlet
            System.out.println("estoy en el servlet buscar");
            String detallesContacto = "<h5>" + contacto.getNombre() + " " + contacto.getApellido() + "</h5>";
            detallesContacto += "<p><strong>Dirección:</strong> " + contacto.getDireccion() + "</p>";
            detallesContacto += "<p><strong>Teléfono:</strong> " + contacto.getCelular() + "</p>";
            detallesContacto += "<p><strong>Correo:</strong> " + contacto.getCorreo() + "</p>";

            response.setContentType("text/html");
            response.getWriter().write(detallesContacto);
        } else {
            // Si no se encuentra el contacto, puedes enviar un mensaje de error
            response.setContentType("text/plain");
            response.getWriter().write("No se encontró ningún contacto con ese nombre.");
        }

         
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
