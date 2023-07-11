
async function registrarUsuario() {

    let datos={};
    datos.correo = document.getElementById("email").value;
    datos.usuario = document.getElementById("usuario").value;
    datos.contrasenna = document.getElementById("contrasenna").value;
    datos.nombre = document.getElementById("nombre").value;
    datos.apellido = document.getElementById("apellido").value;
    datos.edad = document.getElementById("edad").value;

    console.log(datos);

    const rawResponse = await fetch('/registroUsuario', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

    });
    window.location.href= "/IniciarSesion";

}
function moverIniciarSesion(){
    window.location.href= "/IniciarSesion"
}