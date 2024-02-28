/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.directorio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.lang.String;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author danie
 */
public class controladorContacto implements Comparable {
    private static ArrayList<Contacto> misContactos = new ArrayList<>();
    private Contacto contactoRaiz = null;
    private int numContactos = 0;

    public void agregarContacto(String id, String nombre, String apellido, String correo, String direccion, String celular) {
        Contacto c = new Contacto(id, nombre, apellido, correo, direccion, celular);

        if (contactoRaiz == null) {
            contactoRaiz = c;
            agregarContacto(c);
        } else {
            insertar(contactoRaiz, c);
        }
        numContactos++;

    }

    public void insertar(Contacto actual, Contacto nuevo) {

        if (nuevo.compareTo(actual) <= 0) {

            if (actual.getIzq() == null) {
                actual.setIzq(nuevo);
                misContactos.add(misContactos.indexOf(actual), nuevo);
            } else {

                insertar(actual.getIzq(), nuevo);
            }
        } else {


            if (actual.getDer() == null) {

                actual.setDer(nuevo);
                misContactos.add(misContactos.indexOf(actual) + 1, nuevo);
            } else {
                insertar(actual.getDer(), nuevo);
            }
        }
    }

    public void eliminarContactoPorNombre(String nombre) {
        contactoRaiz = eliminarPorNombre(contactoRaiz, nombre);
        actualizarMisContactos(contactoRaiz); // Llamar a un método para actualizar misContactos
    }

    private void actualizarMisContactos(Contacto actual) {
        misContactos.clear(); // Limpiar la lista actual
        recorrerEnOrden(actual); // Volver a recorrer el árbol y agregar los contactos a misContactos
    }

    private void recorrerEnOrden(Contacto actual) {
        if (actual != null) {
            recorrerEnOrden(actual.getIzq());
            misContactos.add(actual);
            recorrerEnOrden(actual.getDer());
        }
    }

    public static void guardarContactosArchivo(Contacto c, ServletContext context) throws IOException {
        String relativePath = "/data/usuariosGuardados.txt";
        String absPath = context.getRealPath(relativePath);
        File archivoUsuarios = new File(absPath);

        BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoUsuarios, true));

        if (archivoUsuarios.exists() && archivoUsuarios.length() <= 0) {
            escribir.write("======Contactos guardados======");
        } else {
            escribir.write("ID: " + c.getId());
            escribir.newLine();
            escribir.write("Nombre: " + c.getNombre());
            escribir.newLine();
            escribir.write("Apellido: " + c.getApellido());
            escribir.newLine();
            escribir.write("Correo: " + c.getCorreo());
            escribir.newLine();
            escribir.write("Direccion: " + c.getDireccion());
            escribir.newLine();
            escribir.write("Celular: " + c.getCelular());
            escribir.newLine();
            escribir.write("---------------------------");
            escribir.newLine();
        }
        escribir.close();

    }

    public ArrayList<Contacto> obtenerContactos(ServletContext context) throws IOException, ClassNotFoundException {
        String date = "/data/usuariosGuardados.txt";
        String dateAbstract = context.getRealPath(date);
        File rutaDate = new File(dateAbstract);

        try {
            FileInputStream leerA = new FileInputStream(rutaDate);
            ObjectInputStream archivo = new ObjectInputStream(leerA);
            misContactos = (ArrayList<Contacto>) archivo.readObject();
            archivo.close();
            System.out.println("Datos guardados: " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error en el archivo" + e.getMessage());
        }

        return misContactos;
    }

    private void agregarContacto(Contacto c) {
        misContactos.add(c);
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : misContactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private Contacto eliminarPorNombre(Contacto actual, String nombre) {
        if (actual == null) {
            return actual;
        }

        int comparacion = actual.getNombre().compareTo(nombre);

        if (comparacion > 0) {
            actual.setIzq(eliminarPorNombre(actual.getIzq(), nombre));
        } else if (comparacion < 0) {
            actual.setDer(eliminarPorNombre(actual.getDer(), nombre));
        } else {
            if (actual.getIzq() == null) {
                return actual.getDer();
            } else if (actual.getDer() == null) {
                return actual.getIzq();
            }

            Contacto temp = buscarMinimo(actual.getDer());
            actual.setNombre(temp.getNombre());
            actual.setApellido(temp.getApellido());
            actual.setCorreo(temp.getCorreo());
            actual.setDireccion(temp.getDireccion());
            actual.setCelular(temp.getCelular());
            actual.setDer(eliminarPorNombre(actual.getDer(), temp.getNombre()));
        }

        return actual;
    }

    private Contacto buscarMinimo(Contacto actual) {
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }

        return actual;
    }

    private Contacto buscarMinimoPorNombre(Contacto actual) {
        Contacto minimo = buscarMinimo(actual.getDer());
        while (minimo.getIzq() != null) {
            minimo = minimo.getIzq();
        }

        return minimo;
    }
}