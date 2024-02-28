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
@WebServlet(name = "SvAgregarContacto", urlPatterns = {"/SvAgregarContacto"})
public class SvAgregarContacto extends HttpServlet {

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
        try {
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String celular = request.getParameter("celular");
            ServletContext context = getServletContext();
            Contacto c = new Contacto(id, nombre, apellido, correo, direccion, celular);
            Contacto contacto = controlador.buscarContactoPorNombre(nombre);
            
            
            
            
            
            controladorContacto.guardarContactosArchivo(c, context);
            controlador.agregarContacto(id, nombre, apellido, correo, direccion, celular);
            ArrayList<Contacto> misContactos = controlador.obtenerContactos(context);
            
            
            System.out.println("Lista de contactos:");
            for (Contacto contactos : misContactos) {
                System.out.println(contactos.getNombre() + " --- " + contactos.getApellido() + " - " + contactos.getCorreo());
            }
            
            
            request.setAttribute("contactos", misContactos);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvAgregarContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
