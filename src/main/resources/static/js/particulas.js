document.addEventListener("DOMContentLoaded", function() {
    const container = document.body; 
    const numParticulas = 25; 
    const width = window.innerWidth; 
    const height = window.innerHeight; 

    
    for (let i = 0; i < numParticulas; i++) {
        let snow = document.createElement('div');
        snow.classList.add('snow');
        container.appendChild(snow);

     
        const xPosition = Math.random() * width; 
        const yPosition = Math.random() * height; 
        snow.style.left = `${xPosition}px`;
        snow.style.top = `${yPosition}px`;

        const duration = Math.random() * 15 + 10; 
        const delay = Math.random() * 5; 
        snow.style.animation = `fall ${duration}s linear ${delay}s infinite`;
    }
});