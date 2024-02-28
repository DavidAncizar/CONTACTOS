
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.directorio.Contacto"%>
<%@page import="com.mycompany.directorio.controladorContacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/e153d37948.js" crossorigin="anonymous"></script>
    <title>Directorio</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-success sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-phone"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Directorio</div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            <!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Nav Item - Tables -->
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Directorio Telefonico</span>
                </a>
                 <a class="nav-link" id="mostrarContacto">
                    <i class="fa fa-address-book" aria-hidden="true"></i>
                    <span>Agregar Contacto</span>
                </a>
            </li>
            
          
            <!-- Divider -->
     
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>
                    <%                 controladorContacto controlador = new controladorContacto();
                                   
                                      
                                         String id = request.getParameter("id");
                                         String nombre = request.getParameter("nombre");
                                         String apellido = request.getParameter("apellido");
                                         String correo = request.getParameter("correo");
                                         String direccion = request.getParameter("direccion");
                                         String celular = request.getParameter("celular");
                                         ServletContext context = getServletContext();
                                         Contacto contacto2 = new Contacto(id, nombre, apellido, correo, direccion, celular);

                    %>
                    <!-- Topbar Search -->
                    <form id="searchForm" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Buscar por nombre..." aria-label="Search" aria-describedby="basic-addon2" name="nombre">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-success" data-nombre="<%= nombre%>">
                                    <i class="fa-solid fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                           
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-success" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">DIRECTORIO TELEFONICO</h1>
                    

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-success">Directorio telefonico</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <%
          
                                   
                                    ArrayList<Contacto> misContactos = controlador.obtenerContactos(context);
                                     if (misContactos == null) {
                                    // Mostrar un mensaje de error al usuario
                                    request.setAttribute("error", "La lista de contactos está vacía.");

                            }
                                %>
                                
                                <table class="table table-dark" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombres</th>
                                            <th>Apellidos</th>
                                            <th>Dirección</th>
                                            <th>Telefono</th>
                                            <th>Correo</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        
                                        <%
                                            if(misContactos!=null){
                                                for(Contacto contacto : misContactos){
                                        %>
                                        <tr>
                                            <td><%= contacto.getId()%></td>
                                            <td><%= contacto.getNombre()%></td>
                                            <td><%= contacto.getApellido()%></td>
                                            <td><%= contacto.getDireccion()%></td>
                                            <td><%= contacto.getCelular()%></td>
                                            <td><%= contacto.getCorreo()%></td>
                                            <td>
                                                <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" data-nombre="<%= contacto.getNombre()%>"><i class="fa-solid fa-eye"></i></a>
                                 
                                                <a href="#" class="btn btn-success eliminar" data-borrar="<%= contacto.getNombre()%>"><i class="fa-solid fa-trash"></i></a>

                                                
                                            </td>
                                        </tr>
                                        
                                     <%
                                            }
                                        } 
                                     %>   
                                    </tbody>
                                </table>
                                          
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                
                

            </div>
                                    
                                         
                                    
                                               <!-- Modal Ver -->
                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Detalles del Contacto</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div id="contacto-details">
                                                                <!-- Contenido del modal de detalles -->
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                               
                                               <!-- Modal Buscar -->
                                               <div class="modal fade" id="modalBuscar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                   <div class="modal-dialog">
                                                       <div class="modal-content">
                                                           <div class="modal-header">
                                                               <h5 class="modal-title" id="exampleModalLabel">Detalles del contacto</h5>
                                                               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                           </div>
                                                           <div class="modal-body">
                                                               <!-- Aquí se mostrarán los detalles del contacto -->
                                                               <div id="contacto-details2"></div>
                                                               <!-- Agrega más campos según sea necesario -->
                                                           </div>
                                                           <div class="modal-footer">
                                                               <button type="button" class="btn btn-success" data-bs-dismiss="modal">Cerrar</button>
                                                           </div>
                                                       </div>
                                                   </div>
                                               </div>
                                               
            <!-- End of Main Content -->
             <!-- Seccion de formulario para agregar nuevo -->
             
             
        
             <div class="col-lg-12 d-flex justify-content-center align-items-center" style='margin-top: 5%;'> <!-- Agrega las clases d-flex, justify-content-center y align-items-center -->



                 <form id="formularioContacto" action="SvAgregarContacto" method="post" style="display: none;">
                     <div class="custom-card" style="background-color: #f2f4f8; color: black;" >
                         <div class="row">
                             <div class="col-md-6">
                                 <h4 class="form-title">Agrega un nuevo contacto</h4>

                                 <div class="form-group">
                                     <label for="id">Id</label>
                                     <input type="text" name="id" class="form-control" required>
                                 </div>

                                 <div class="form-group">
                                     <label for="nombre">Nombres</label>
                                     <input type="text" name="nombre" class="form-control" required>
                                 </div>

                                 <div class="form-group">
                                     <label for="apellido">Apellidos</label>
                                     <input type="text" name="apellido" class="form-control" required>
                                 </div>
                          
                             </div>
                             <div class="col-md-6" style="margin-top:10%">
                                 <div class="form-group">
                                     <label for="correo">Correo Electronico</label>
                                     <input type="text" name="correo" class="form-control" required>
                                 </div>

                                 <div class="form-group">
                                     <label for="direccion">Direccion</label>
                                     <input type="text" name="direccion" class="form-control" required>
                                 </div>
                                     
                                 <div class="form-group">
                                     <label for="celular">Telefono</label>
                                     <input type="text" name="celular" class="form-control" required>
                                 </div>

                           
                          </div>
                       </div>
                         <button type="submit" class="btn btn-success">Agregar Contacto</button>
                     </div>
                 </form>




             </div>
             
             
             
             
             
        
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Directorio Telefonico 2024</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>


    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
    <script>   
        document.getElementById("mostrarContacto").addEventListener("click", function () {
                    var formulario = document.getElementById("formularioContacto");
                    var tabla = document.getElementById("tablaTarea");
                    var contenidoInicio = document.getElementById("contenidoInicio");
                    var tusLibros = document.getElementById("tusLibros");
                    var todosLibros = document.getElementById("todosLibros");
                    
                    if (formulario.style.display === "none" || formulario.style.display === "") {
                        formulario.style.display = "block";
                        tabla.style.display = "none";
                        contenidoInicio.style.display = "none";
                        tusLibros.style.display = "none";
                        todosLibros.style.display = "none";
                        document.getElementById("formularioActual").value = "tarea"; // Agregar esta línea
                    }
                });
    </script>
               <!-- Js para conectar el modal buscar con el servlet --> 
  <script>
    $(document).ready(function() {
        // Captura el evento submit del formulario de búsqueda
        $('#searchForm').submit(function(event) {
            // Detener el envío del formulario
            event.preventDefault();
            
            // Obtener el nombre del contacto del campo de entrada
            var nombre = $(this).find('input[name="nombre"]').val();
            
            // Realizar la solicitud AJAX al servlet
            $.ajax({
                url: 'SvBuscarContacto',
                method: 'POST',
                data: {nombre: nombre},
                success: function(response) {
                    console.log('Detalles del contacto recibidos:', response);
                    // Actualizar el contenido del modal con los detalles del contacto
                    $('#contacto-details2').html(response);
                    
                    // Abrir el modal automáticamente
                    $('#modalBuscar').modal('show');
                },
                error: function() {
                    // Manejar errores si es necesario
                    console.error('Error al cargar los detalles del contacto.');
                }
            });
        });
    });
</script>  
                
               <script>
                                    // funcion para mostrar los datos en la ventana modal
                                    $('#exampleModal').on('show.bs.modal', function (event) {
                                        var button = $(event.relatedTarget); // Botón que desencadenó el evento
                                        var nombre = button.data('nombre'); // Obtén el nombre del contacto

                                        // Realiza una solicitud AJAX al servlet para obtener los detalles del perro por su nombre
                                        $.ajax({
                                            url: 'SvMostrarContacto?nombre=' + nombre, // Cambia 'id' por el nombre del parámetro que esperas en tu servlet
                                            method: 'POST',
                                            success: function (data) {
                                                // Actualiza el contenido del modal con los detalles del perro
                                                $('#contacto-details').html(data);
                                            },
                                            error: function () {
                                                // Maneja errores aquí si es necesario
                                                console.log('Error al cargar los detalles del contacto.');
                                            }
                                        });
                                    });      
                </script> 
                
            
                
                                <script>
    // Script para borrar una fila al hacer clic en un botón
    $('.eliminar').click(function(){
        var filaAEliminar = $(this).closest('tr'); // Encuentra la fila más cercana al botón eliminar
        var borrar = $(this).data('borrar');
        var resultado = window.confirm("¿Estás seguro de que deseas eliminar el contacto: " + borrar + "?");

        // Comprueba si se hizo clic en "Aceptar" o "Cancelar"
        if (resultado) {
            alert("Se ha eliminado: " + borrar);
            $.ajax({
                url: 'SvEliminarContacto?nombre='+ borrar,
                method: 'POST',
                success: function(){
                    console.log("Eliminado exitosamente");
                    filaAEliminar.remove(); // Elimina la fila de la tabla
                },
                error: function(){
                    console.log("Error al eliminar");
                }
            });
        } else {
            alert("¡Has hecho clic en Cancelar!");
        }
    });
</script>
