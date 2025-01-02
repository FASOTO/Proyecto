// 5) CON Doble Click SOBRE LOS NOMBRES, FUNCIONA
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