$(document).ready(function () {

});

async function cargarUsuarios() {
    const usuario = localStorage.getItem("NombreUsuario");
    const rawResponse = await fetch(`/usuario/${usuario}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const usuarios = await rawResponse.json();
    console.log(usuarios);
    let titulo = document.getElementById("titulo");
    titulo.textContent = `Hola, ${usuarios[0].nombre}`;

}

const lista = document.querySelector('#lista')
const elemento = document.querySelector('#elemento')
const input = document.querySelector('#input')
const botonEnter = document.querySelector('#boton-enter')
const check = 'fa-check-circle'
const uncheck = 'fa-circle'
const lineThrough = 'line-through'
let LIST

let id // para que inicie en 0 cada tarea tendra un id diferente



// funcion de agregar tarea

function cerrarSesion(){
    localStorage.removeItem("NombreUsuario");
    window.location.href = "/IniciarSesion";
}

function agregarTarea( tarea,id,realizado,eliminado) {
    cargarUsuarios()
    if(eliminado) {return} // si existe eliminado es true si no es false

    const REALIZADO = realizado ? check : uncheck // si realizado es verdadero check si no uncheck

    const LINE = realizado ? lineThrough : ''

    const elemento = `
                        <li id="elemento">
                        <i class="far ${REALIZADO}" data="realizado" id="${id}"></i>
                        <p class="text ${LINE}">${tarea}</p>
                        <i class="fas fa-trash de" data="eliminado" id="${id}"></i> 
                        </li>
                    `
    lista.insertAdjacentHTML("beforeend",elemento)

}


// funcion de Tarea Realizada

function tareaRealizada(element) {
    element.classList.toggle(check)
    element.classList.toggle(uncheck)
    element.parentNode.querySelector('.text').classList.toggle(lineThrough)
    LIST[element.id].realizado = LIST[element.id].realizado ?false :true //Si
    // console.log(LIST)
    // console.log(LIST[element.id])
    // console.log(LIST[element.id].realizado)
}

function tareaEliminada(element){
    // console.log(element.parentNode)
    // console.log(element.parentNode.parentNode)
    element.parentNode.parentNode.removeChild(element.parentNode)
    LIST[element.id].eliminado = true
    console.log(LIST)
}





// crear un evento para escuchar el enter y para habilitar el boton

botonEnter.addEventListener('click', ()=> {
    const tarea = input.value
    if(tarea){
        agregarTarea(tarea,id,false,false)
        LIST.push({
            nombre : tarea,
            id : id,
            realizado : false,
            eliminado : false
        })
        localStorage.setItem('TODO',JSON.stringify(LIST))
        id++
        input.value = ''
    }

})

document.addEventListener('keyup', function (event) {
    if (event.key=='Enter'){
        const tarea = input.value
        if(tarea) {
            agregarTarea(tarea,id,false,false)
            LIST.push({
                nombre : tarea,
                id : id,
                realizado : false,
                eliminado : false
            })
            localStorage.setItem('TODO',JSON.stringify(LIST))

            input.value = ''
            id++
            console.log(LIST)
        }
    }

})


lista.addEventListener('click',function(event){
    const element = event.target
    const elementData = element.attributes.data.value
    console.log(elementData)

    if(elementData == 'realizado') {
        tareaRealizada(element)
    }
    else if(elementData == 'eliminado') {
        tareaEliminada(element)
        console.log("elimnado")
    }
    localStorage.setItem('TODO',JSON.stringify(LIST))
})




let data = localStorage.getItem('TODO')
if(data){
    LIST = JSON.parse(data)
    console.log(LIST)
    id = LIST.length
    cargarLista(LIST)
}else {
    LIST = []
    id = 0
}


function cargarLista(array) {
    array.forEach(function(item){
        agregarTarea(item.nombre,item.id,item.realizado,item.eliminado)
    })
}





