var url="http://localhost:8080/api/shoestore/producto/";

function listarProductos(){
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