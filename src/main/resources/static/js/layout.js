const sidebar = document.querySelector(".sidebar");
const sidebarToggler = document.querySelector(".sidebar-toggler");
const menuToggler = document.querySelector(".menu-toggler");

const collapsedSidebarHeight = "56px";
const fullSidebarHeight = "calc(100vh - 32px)";

//Deslizamiento del Sidebar
sidebarToggler.addEventListener("click", () => {
    sidebar.classList.toggle("collapsed");
});

//Actualizacion de la altura del sidebar y texto del toggle menu
const toggleMenu = (isMenuActive) => {
    sidebar.style.height = isMenuActive ? `${sidebar.scrollHeight}px` : collapsedSidebarHeight;
}

//Clase toggle menu-active y ajuste de la altura
menuToggler.addEventListener("click", () =>{
    toggleMenu(sidebar.classList.toggle("menu-active"));
});

//ajustar el tamaño del sidebar en la ventana
window.addEventListener("resize", () => {
    if (window.innerWidth >= 1024) {
        sidebar.style.height = fullSidebarHeight;
    } else {
        sidebar.classList.remove("collapsed");
        sidebar.style.height = "auto";
        toggleMenu(sidebar.classList.contains("menu-active"));
    }
});

//Opcion desplegable del Menu
let listElements = document.querySelectorAll('.nav-list-button--click');
listElements.forEach(listElement =>{
    listElement.addEventListener('click', () =>{
        listElement.classList.toggle('arrow');
        let height= 0;
        let menu = listElement.nextElementSibling;
        if(menu.clientHeight == "0"){
            height= menu.scrollHeight;
        }
        menu.style.height = `${height}px`;
    })
})