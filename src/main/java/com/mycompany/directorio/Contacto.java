/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.directorio;

/**
 *
 * @author danie
 */
public class Contacto implements Comparable{
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private String celular;
    private Contacto izq;
    private Contacto der;

    public Contacto() {
    }

    public Contacto(String id, String nombre, String apellido, String correo, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.celular = celular;
        
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Contacto getIzq() {
        return izq;
    }

    public void setIzq(Contacto izq) {
        this.izq = izq;
    }

    public Contacto getDer() {
        return der;
    }

    public void setDer(Contacto der) {
        this.der = der;
    }


     
    
    
    
    
    
    @Override
    //metodo para el comparable
     public int compareTo( Object o ){
        Contacto otro = ( Contacto )o;
        return nombre.compareToIgnoreCase( otro.nombre );
    }

   
    
 
    
    
    
}
