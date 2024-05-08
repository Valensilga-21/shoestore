<<<<<<< HEAD
var url="http://localhost:8080/api/shoestore/cliente/";

function listarClientes(){
$.ajax({
    url:url,
    type:"GET",
    success: function(result){
        console.log(result);

        var cuerpoTablaCliente=document.getElementById("cuerpoTablaCliente");
        cuerpoTablaCliente.innerHTML="";

        for(var i=0; i<result.length;i++){
            var trResgistro=document.createElement("tr");
            var celdaId=document.createElement("td");

            let celdaNombre = document.createElement("td","a")
            let celdaApellido = document.createElement("td")
            let celdaTipoIdentificacion = document.createElement("td")
            let celdaIdentificacion = document.createElement("td")
            let celdaTelefono = document.createElement("td")
            let celdaDireccion = document.createElement("td")
            let celdaCiudad = document.createElement("td")
            let celdaCorreoElectronico = document.createElement("td")
            let celdaEstado = document.createElement("td")

            let celdaOpcion = document.createElement("td");
            let botonActualizar = document.createElement("button");
            botonActualizar.value=result[i]["id_cliente"];
            botonActualizar.innerHTML = "Actualizar";
            
            botonActualizar.onclick=function(e){
                $('#exampleModal').modal('show');
                consultarClienteId(this.value);
            }
            botonActualizar.className = "btn btn-warning actualizar-cliente";

            let celdaOpcion2 = document.createElement("td");
            let botonEliminar = document.createElement("button");
            botonEliminar.innerHTML = "Eliminar";
            botonEliminar.className = "btn btn-danger eliminar-cliente";

            let clienteIdEliminar = result[i]["id_cliente"];
            botonEliminar.onclick = function() {
            eliminarCliente(clienteIdEliminar);
            };

            celdaId.innerText=result[i]["id_cliente"];
            celdaNombre.innerText=result[i]["tipo_identificacion"];
            celdaApellido.innerText=result[i]["identificacion"];
            celdaTipoIdentificacion.innerText=result[i]["nombre_cliente"];
            celdaIdentificacion.innerText=result[i]["apellido_cliente"];
            celdaTelefono.innerText=result[i]["telefono"];
            celdaDireccion.innerText=result[i]["direccion"];
            celdaCiudad.innerText=result[i]["ciudad"];
            celdaCorreoElectronico.innerText=result[i]["correo_electronico"];
            celdaEstado.innerText=result[i]["estado"];
            

            trResgistro.appendChild(celdaId);
            trResgistro.appendChild(celdaNombre);
            trResgistro.appendChild(celdaApellido);
            trResgistro.appendChild(celdaTipoIdentificacion);
            trResgistro.appendChild(celdaIdentificacion);
            trResgistro.appendChild(celdaTelefono);
            trResgistro.appendChild(celdaDireccion);
            trResgistro.appendChild(celdaCiudad);
            trResgistro.appendChild(celdaCorreoElectronico);
            trResgistro.appendChild(celdaEstado);

            celdaOpcion.appendChild(botonActualizar);
            trResgistro.appendChild(celdaOpcion)

            celdaOpcion2.appendChild(botonEliminar);
            trResgistro.appendChild(celdaOpcion2)


            cuerpoTablaCliente.appendChild(trResgistro);
            
        }
    },
    error: function(error){
       alert("Error en la petición ".error);
    }
});
}

function consultarClienteId(id){
    $.ajax({
        url:url+id,
        type:"GET",
        success: function(result){
            document.getElementById("id_cliente").value=result["id_cliente"];
            document.getElementById("tipo_identificacion").value=result["tipo_identificacion"];
            document.getElementById("identificacion").value=result["identificacion"];
            document.getElementById("nombre_cliente").value=result["nombre_cliente"];
            document.getElementById("apellido_cliente").value=result["apellido_cliente"];
            document.getElementById("telefono").value=result["telefono"];
            document.getElementById("direccion").value=result["direccion"];
            document.getElementById("ciudad").value=result["ciudad"];
            document.getElementById("correo_electronico").value=result["correo_electronico"];
            document.getElementById("estado").value=result["estado"];
        }
    });
}

function actualizarCliente() { 
    var id_cliente=document.getElementById("id_cliente").value;
    let formData={
        "tipo_identificacion": document.getElementById("tipo_identificacion").value,
        "identificacion": document.getElementById("identificacion").value,
        "nombre_cliente": document.getElementById("nombre_cliente").value,
        "apellido_cliente": document.getElementById("apellido_cliente").value,
        "telefono": document.getElementById("telefono").value,
        "direccion": document.getElementById("direccion").value,
        "ciudad": document.getElementById("ciudad").value,
        "correo_electronico": document.getElementById("correo_electronico").value,
        "estado": document.getElementById("estado").value
    };

    if (validarCampos()) {
        $.ajax({
            url:url+id_cliente,
            type: "PUT", // Use PUT method for updating
            data: formData,
            success: function(result) {
                // Manejar la respuesta exitosa según necesites
                Swal.fire({
                    title: "¡Excelente!",
                    text: "Se guardó correctamente",
                    icon: "success"
                  });
                // Puedes hacer algo adicional como recargar la lista de médicos
                listarClientes();
            },
            error: function(error) {
                // Manejar el error de la petición
                Swal.fire({
                    title: "¡Error!",
                    text: "No se guardó",
                    icon: "error"
                  });
            }
        });
    } else {
    Swal.fire({
        title: "¡Error!",
        text: "Llene todos los campos correctamente",
        icon: "error"
      });
    }
}


function eliminarCliente(id) {
    Swal.fire({
        title: '¿Está seguro?',
        text: "Esta acción no se puede deshacer",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: url + id,
                type: "DELETE",
                success: function (result) {
                    Swal.fire(
                        'Eliminado!',
                        'El registro ha sido eliminado.',
                        'success'
                    );
                    listarMedico(); // Recarga la lista de médicos
                },
                error: function (error) {
                    Swal.fire(
                        'Error!',
                        'No se pudo eliminar el registro.',
                        'error'
                    );
                }
            });
        }
    });
}

function registrarCliente() {
  
    let formData={
        "tipo_identificacion":  document.getElementById("tipo_identificacion").value,
        "identificacion": document.getElementById("identificacion").value,
        "nombre_cliente": document.getElementById("nombre_cliente").value,
        "apellido_cliente":  document.getElementById("apellido_cliente").value,
        "telefono":  document.getElementById("telefono").value,
        "direccion":  document.getElementById("direccion").value,
        "ciudad":  document.getElementById("ciudad").value,
        "correo_electronico":  document.getElementById("correo_electronico").value,
        "estado":  document.getElementById("estado").value,
    };

    if (validarCampos()) {
        $.ajax({
            url:url,
            type:"POST",
            data:formData,
            success: function (result){
                //
                Swal.fire({
                    title: "¡Excelente!",
                    text: "Se guardó correctamente",
                    icon: "success"
                  });
            },
        })}else{
            Swal.fire({
                title: "¡Error!",
                text: "Llene todos los campos correctamente",
                icon: "error"
              });
    }
}

function validarCampos() {
    var identificacion = document.getElementById("identificacion");
    var nombre_cliente = document.getElementById("nombre_cliente");
    var apellido_cliente = document.getElementById("apellido_cliente");
    var telefono = document.getElementById("telefono");
    var direccion = document.getElementById("direccion");
    var ciudad = document.getElementById("ciudad");
    var correo_electronico = document.getElementById("correo_electronico");

    return validarIdentificacion(identificacion),
    validarNombre(nombre_cliente), 
    validarApellido(apellido_cliente),
    validarTelefono(telefono), validarDireccion(direccion), 
    validarCiudad(ciudad), 
    validarCorreo(correo_electronico);
}

//validar identificacion
function validarIdentificacion(Identificacion){
    var valor=Identificacion.value;
    var valido=true;
    if (valor.length <7 || valor.length> 11){
     valido=false
    }
 
    if(valido){
        Identificacion.className="form-control is-valid";
    }else{
        Identificacion.className="form-control is-invalid";
    }
    return valido;
 }

 //validar nombre
function validarNombre(Nombre){
    var valor=Nombre.value;
    var valido=true;
    if (valor.length <2 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        Nombre.className="form-control is-valid";
    }else{
        Nombre.className="form-control is-invalid";
    }
    return valido;
 }

 //validar apellidos
function validarApellido(Apellidos){
    var valor=Apellidos.value;
    var valido=true;
    if (valor.length <3 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        Apellidos.className="form-control is-valid";
    }else{
        Apellidos.className="form-control is-invalid";
    }
    return valido;
 }

 //validar telefono
function validarTelefono(Telefono){
    var valor=Telefono.value;
    var valido=true;
    if (valor.length <9 || valor.length> 14){
     valido=false
    }
 
    if(valido){
        Telefono.className="form-control is-valid";
    }else{
        Telefono.className="form-control is-invalid";
    }
    return valido;
 }

 //validar direccion
function validarDireccion(Direccion){
    var valor=Direccion.value;
    var valido=true;
    if (valor.length <8 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        Direccion.className="form-control is-valid";
    }else{
        Direccion.className="form-control is-invalid";
    }
    return valido;
 }

 //validar ciudad
function validarCiudad(Ciudad){
    var valor=Ciudad.value;
    var valido=true;
    if (valor.length <3 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        Ciudad.className="form-control is-valid";
    }else{
        Ciudad.className="form-control is-invalid";
    }
    return valido;
 }

 //validar correo
function validarCorreo(Correo){
    var valor=Correo.value;
    var valido=true;
    if (valor.length <3 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        Correo.className="form-control is-valid";
    }else{
        Correo.className="form-control is-invalid";
    }
    return valido;
 }
=======
var url="http://localhost:8080/api/shoestore/cliente";

function listarClientes(){
$.ajax({
    url:url,
    type:"GET",
    success: function(result){
        console.log(result);

        var cuerpoTablaCliente=document.getElementById("cuerpoTablaCliente");
        cuerpoTablaCliente.innerHTML="";

        for(var i=0; i<result.length;i++){
            var trResgistro=document.createElement("tr");
            var celdaId=document.createElement("td");

            let celdaNombre = document.createElement("td","a")
            let celdaApellido = document.createElement("td")
            let celdaTipoIdentificacion = document.createElement("td")
            let celdaIdentificacion = document.createElement("td")
            let celdaTelefono = document.createElement("td")
            let celdaDireccion = document.createElement("td")
            let celdaCiudad = document.createElement("td")
            let celdaEstado = document.createElement("td")

            let celdaOpcion = document.createElement("td");
            let botonActualizar = document.createElement("button")
            botonActualizar.innerHTML="Actualizar"
            botonActualizar.className = "btn btn-warning"

            let celdaOpcion2 = document.createElement("td");
            let botonEliminar = document.createElement("button")
            botonEliminar.innerHTML="Eliminar"
            botonEliminar.className = "btn btn-danger"

            celdaId.innerText=result[i]["id_cliente"];
            celdaNombre.innerText=result[i]["tipo_identificacion"];
            celdaApellido.innerText=result[i]["identificacion"];
            celdaTipoIdentificacion.innerText=result[i]["nombre_cliente"];
            celdaIdentificacion.innerText=result[i]["apellido_cliente"];
            celdaTelefono.innerText=result[i]["telefono"];
            celdaDireccion.innerText=result[i]["direccion"];
            celdaCiudad.innerText=result[i]["ciudad"];
            celdaEstado.innerText=result[i]["estado"];
            

            trResgistro.appendChild(celdaId);
            trResgistro.appendChild(celdaNombre);
            trResgistro.appendChild(celdaApellido);
            trResgistro.appendChild(celdaTipoIdentificacion);
            trResgistro.appendChild(celdaIdentificacion);
            trResgistro.appendChild(celdaTelefono);
            trResgistro.appendChild(celdaDireccion);
            trResgistro.appendChild(celdaCiudad);
            trResgistro.appendChild(celdaEstado);
            celdaOpcion.appendChild(botonEditar);
            trResgistro.appendChild(celdaOpcion)

            celdaOpcion2.appendChild(botonEliminar);
            trResgistro.appendChild(celdaOpcion2)

            cuerpoTabla.appendChild(trResgistro);
            
        }
    },
    error: function(error){
       alert("Error en la petición ".error);
    }
});
}
>>>>>>> a8788167102ed202bea9d6fd6c60e9091c3ce0ac
