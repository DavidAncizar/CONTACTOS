/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.directorio.Contacto;
import com.mycompany.directorio.controladorContacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvMostrarContacto", urlPatterns = {"/SvMostrarContacto"})
public class SvMostrarContacto extends HttpServlet {
    ArrayList<Contacto> miContacto = new ArrayList<>();
    private controladorContacto controlador = new controladorContacto();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        String nombre = request.getParameter("nombre");
    
        Contacto contacto = controlador.buscarContactoPorNombre(nombre);
         if (contacto != null) {
            
 
            // Devuelve los detalles del contacto en formato HTML
            System.out.println("Contaco encontrado: " + contacto.getNombre());
            String html = "<h3>" + contacto.getNombre() + " " + contacto.getApellido() + "</h3>";
            html += "<p><strong>Dirección:</strong> " + contacto.getDireccion() + "</p>";
            html += "<p><strong>Teléfono:</strong> " + contacto.getCelular() + "</p>";
            html += "<p><strong>Correo:</strong> " + contacto.getCorreo() + "</p>";

            response.setContentType("text/html");
            response.getWriter().write(html);
        } else {
            System.out.println("No existe ningun contacto con ese nombre");
            //response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
         
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
