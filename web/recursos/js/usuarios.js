/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
APLICACION = "proyecto";

function ListarUsuarios() {
    try {
//      console.log("Consultando...");
        usuariosGrid.clearAll();
        $.ajax({
            type: "GET",
            url: "/" + APLICACION + "/api/usuarios",
            dataType: 'json',
            success: function (response) {

                response.forEach(function (r) {
                    //var btnLinkLlamar = "recursos/icons/call.png^Llamar^javaScript:llamarUsuario(" + r.id + ")";
                    var data = [r.id, r.nombreApellido, r.telefono, r.correo];
                    usuariosGrid.addRow(r.id, data);
                    //console.log(r.nombreApellido);
                });
            },
            error: function (jqxhr, status, errorMsg) {
                //dhtmlx.message({type:"error", text: errorMsg});
                console.log(jqxhr.responseText);
            }
        });

    } catch (e) {
        console.log("ListarUsuarios() [ " + e.name + " - " + e.message + " ]");
    }
}

function llamarUsuario() {
    
    var mensaje = "Notificando desde la aplicaccion web prueba II";
    $.ajax({
        type: "GET",
        url: "/" + APLICACION + "/api/usuarios/llamar?mensaje="+mensaje,
        dataType: 'json',
        success: function (response) {

        },
        error: function (jqxhr, status, errorMsg) {
            //dhtmlx.message({type:"error", text: errorMsg});
            console.log(jqxhr.responseText);
        }
    });
    
}
