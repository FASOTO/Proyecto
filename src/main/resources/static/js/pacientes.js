//4) Link y mostrar en Modal (funciona)
// document.addEventListener("DOMContentLoaded", function () {
//     // Selecciona todos los elementos con la clase paciente-link (apellido y nombre)
//     const pacienteLinks = document.querySelectorAll('.paciente-link');
    
//     // Añadir un event listener de dblclick a cada celda de nombre y apellido
//     pacienteLinks.forEach(function (element) {
//         element.addEventListener("dblclick", function () {
//             // Obtiene el DNI del paciente desde el id de la celda (ejemplo: apellido-123456)
//             const dni = element.id.split('-')[1];

//             // Realiza la petición AJAX al servidor para obtener la información del paciente
//             fetch(`/paciente/informacionPaciente/${dni}`)
//                 .then(response => {
//                     if (!response.ok) {
//                         throw new Error('Paciente no encontrado');
//                     }
//                     return response.json();
//                 })
//                 .then(data => {
//                     // Llena el modal con la información del paciente
//                     document.getElementById('apellido').textContent = data.paciente.apellido;
//                     document.getElementById('nombre').textContent = data.paciente.nombre;
//                     document.getElementById('edad').textContent = data.edadCalculada;
//                     document.getElementById('telefono').textContent = data.paciente.telefono;
//                     document.getElementById('fechaNacimiento').textContent = data.paciente.fechaNacimiento;
//                     document.getElementById('nacionalidad').textContent = data.paciente.nacionalidad;
//                     document.getElementById('dni').textContent = data.paciente.dni;

//                     // Muestra el modal
//                     const modal = new bootstrap.Modal(document.getElementById('infopaciente'));
//                     modal.show();
//                 })
//                 .catch(error => {
//                     console.error('Error al cargar el paciente:', error);
//                 });
//         });
//     });
// });

var separar;
// 3) CON LINKS SOBRE LOS NOMBRES, FUNCIONA
// Espera a que el documento esté completamente cargado
document.addEventListener("DOMContentLoaded", function () {
    // Selecciona todos los elementos con la clase paciente-link (apellido y nombre)
    const pacienteLinks = document.querySelectorAll('.paciente-link');
    
    // Añadir un event listener de click a cada celda de nombre y apellido
    pacienteLinks.forEach(function (element) {
        element.addEventListener("dblclick", function () {
            // Obtiene el DNI del paciente desde el id de la celda (ejemplo: apellido-123456)
            const dni = element.id.split('-')[1];

            // Redirige a la URL que abrirá el modal con la información del paciente
            window.location.href = `/paciente/informacionPaciente/${dni}`;
        });
    });
});



// Prueba de eventos
// $(document).ready(function()
// {
// // Evento de prueba
//     var boton = $('#boton');
//     function saludo()
//     {
//         alert('hola');
//     }

//     // boton.click(saludo);
//     boton.dblclick(saludo);
// // Evento de prueba
// });