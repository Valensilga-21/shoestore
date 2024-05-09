var url="http://localhost:8080/api/shoestore/producto/";

function listarProductos(){
    
    var urlLocal=url;
    var filtro=document.getElementById("texto").value
    if(filtro!="")
        urlLocal += "busqueda/" + filtro;

$.ajax({
    url:url,
    type:"GET",
    success: function(result){
        console.log(result);

        var cuerpoTablaProductos=document.getElementById("cuerpoTablaProductos");
        cuerpoTablaProductos.innerHTML="";

        for(var i=0; i<result.length;i++){
            var trResgistro=document.createElement("tr");
            var celdaId=document.createElement("td");

            let celdaNombreProduc = document.createElement("td","a")
            let celdaDescripción = document.createElement("td")
            let celdaCantidad = document.createElement("td")
            let celdaPrecio = document.createElement("td")
            let celdaIVA = document.createElement("td")
            let celdaDescuento = document.createElement("td")
            let celdaEstado = document.createElement("td")

            let celdaOpcion = document.createElement("td");
            let botonActualizar = document.createElement("button");
            botonActualizar.value=result[i]["id_producto"];
            botonActualizar.innerHTML = "Actualizar";
            
            botonActualizar.onclick=function(e){
                $('#exampleModal').modal('show');
                consultarProductosId(this.value);
            }
            botonActualizar.className = "btn btn-warning actualizar-producto";

            let celdaOpcion2 = document.createElement("td");
            let botonEliminar = document.createElement("button");
            botonEliminar.innerHTML = "Eliminar";
            botonEliminar.className = "btn btn-danger eliminar-producto";

            let clienteIdEliminar = result[i]["id_producto"];
            botonEliminar.onclick = function() {
            eliminarProducto(clienteIdEliminar);
            };

            celdaId.innerText=result[i]["id_producto"];
            celdaNombreProduc.innerText=result[i]["nombre_producto"];
            celdaDescripción.innerText=result[i]["descripcion"];
            celdaCantidad.innerText=result[i]["cantidad"];
            celdaPrecio.innerText=result[i]["precio"];
            celdaIVA.innerText=result[i]["porcentaje_iva"];
            celdaDescuento.innerText=result[i]["porcentaje_descuento"];
            celdaEstado.innerText=result[i]["estado"];
            

            trResgistro.appendChild(celdaId);
            trResgistro.appendChild(celdaNombreProduc);
            trResgistro.appendChild(celdaDescripción);
            trResgistro.appendChild(celdaCantidad);
            trResgistro.appendChild(celdaPrecio);
            trResgistro.appendChild(celdaIVA);
            trResgistro.appendChild(celdaDescuento);
            trResgistro.appendChild(celdaEstado);

            celdaOpcion.appendChild(botonActualizar);
            trResgistro.appendChild(celdaOpcion)

            celdaOpcion2.appendChild(botonEliminar);
            trResgistro.appendChild(celdaOpcion2)


            cuerpoTablaProductos.appendChild(trResgistro);
            
        }
    },
    error: function(error){
       alert("Error en la petición ".error);
    }
});
}

function consultarProductosId(id){
    $.ajax({
        url:url+id,
        type:"GET",
        success: function(result){
            document.getElementById("id_producto").value=result["id_producto"];
            document.getElementById("nombre_producto").value=result["tiponombre_producto_identificacion"];
            document.getElementById("descripcion").value=result["descripcion"];
            document.getElementById("cantidad").value=result["cantidad"];
            document.getElementById("precio").value=result["precio"];
            document.getElementById("porcentaje_iva").value=result["porcentaje_iva"];
            document.getElementById("porcentaje_descuento").value=result["porcentaje_descuento"];
            document.getElementById("estado").value=result["estado"];
        }
    });
}

function actualizarProducto() { 
    var id_producto=document.getElementById("id_producto").value;
    let formData={
        "nombre_producto": document.getElementById("nombre_producto").value,
        "descripcion": document.getElementById("descripcion").value,
        "cantidad": document.getElementById("cantidad").value,
        "precio": document.getElementById("precio").value,
        "porcentaje_iva": document.getElementById("porcentaje_iva").value,
        "porcentaje_descuento": document.getElementById("porcentaje_descuento").value,
        "estado": document.getElementById("estado").value
    };

    if (validarCampos()) {
        $.ajax({
            url:url+id_producto,
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
                listarProductos();
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


function eliminarProducto(id) {
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

function registrarProducto() {
  
    let formData={
        "nombre_producto":  document.getElementById("nombre_producto").value,
        "descripcion": document.getElementById("descripcion").value,
        "cantidad": document.getElementById("cantidad").value,
        "precio":  document.getElementById("precio").value,
        "porcentaje_iva":  document.getElementById("porcentaje_iva").value,
        "porcentaje_descuento":  document.getElementById("porcentaje_descuento").value,
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
    var nombre_producto = document.getElementById("nombre_producto");
    var descripcion = document.getElementById("descripcion");
    var cantidad = document.getElementById("cantidad");
    var precio = document.getElementById("precio");
    var porcentaje_iva = document.getElementById("porcentaje_iva");
    var porcentaje_descuento = document.getElementById("porcentaje_descuento");

    return validarNombreProduc(nombre_producto),
    validarDescripcion(descripcion), 
    validarCantidad(cantidad),
    validarPrecio(precio), 
    validarIva(porcentaje_iva), 
    validarDescuento(porcentaje_descuento);
}

//validar nombre producto
function validarNombreProduc(nombre_producto){
    var valor=nombre_producto.value;
    var valido=true;
    if (valor.length <3 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        nombre_producto.className="form-control is-valid";
    }else{
        nombre_producto.className="form-control is-invalid";
    }
    return valido;
 }

 //validar descripcion
function validarDescripcion(descripcion){
    var valor=descripcion.value;
    var valido=true;
    if (valor.length <5 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        descripcion.className="form-control is-valid";
    }else{
        descripcion.className="form-control is-invalid";
    }
    return valido;
 }

 //validar cantidad
function validarCantidad(cantidad){
    var valor=cantidad.value;
    var valido=true;
    if (valor.length <0 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        cantidad.className="form-control is-valid";
    }else{
        cantidad.className="form-control is-invalid";
    }
    return valido;
 }

 //validar precio
function validarPrecio(precio){
    var valor=precio.value;
    var valido=true;
    if (valor.length <2 || valor.length> 9){
     valido=false
    }
 
    if(valido){
        precio.className="form-control is-valid";
    }else{
        precio.className="form-control is-invalid";
    }
    return valido;
 }

 //validar % iva
function validarIva(porcentaje_iva){
    var valor=porcentaje_iva.value;
    var valido=true;
    if (valor.length <1 || valor.length> 4){
     valido=false
    }
 
    if(valido){
        porcentaje_iva.className="form-control is-valid";
    }else{
        porcentaje_iva.className="form-control is-invalid";
    }
    return valido;
 }

 //validar % descuento
function validarDescuento(porcentaje_descuento){
    var valor=porcentaje_descuento.value;
    var valido=true;
    if (valor.length <1 || valor.length> 46){
     valido=false
    }
 
    if(valido){
        porcentaje_descuento.className="form-control is-valid";
    }else{
        porcentaje_descuento.className="form-control is-invalid";
    }
    return valido;
 }