$(document).ready(function (){
    cargarUsuarios()
    $('#ListaUsuariosTabla').DataTable()

});

async function cargarUsuarios() {

    const rawResponse = await fetch('/usuariosGet', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const usuarios = await rawResponse.json();
    let c =0;
    console.log(usuarios[0].edad);
    let listadoHTML ='';
    for(let usuario of usuarios){
        let usuario ='<tr><td>'+usuarios[c].id+'</td><td>'+usuarios[c].usuario+'</td><td>'+usuarios[c].nombre+'</td><td>'+usuarios[c].apellido+'</td><td>'+usuarios[c].edad+'</td><td>'+usuarios[c].peso+'</td></tr>';
        listadoHTML +=usuario;
        c = c+1;
    }


    document.querySelector('#ListaUsuariosTabla tbody').outerHTML = listadoHTML;
}