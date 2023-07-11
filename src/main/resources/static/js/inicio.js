

async function iniciarSesion() {

    let datos={};
    datos.usuario = document.getElementById("usuario").value;
    datos.contrasenna = document.getElementById("pass").value;


    const rawResponse = await fetch("/login", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

    });

    const respusta = await rawResponse.text();
    if(respusta==='OK'){
        localStorage.setItem('NombreUsuario', datos.usuario);
        window.location.href = "/home";

    }else{
        alert("Credenciales incorrectas");
    }


}

function crearCuenta(){
    window.location.href = "/Registro";
}