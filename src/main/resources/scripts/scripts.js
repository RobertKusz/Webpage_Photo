document.addEventListener("DOMContentLoaded", function () {
    const toggleButton = document.getElementById("toggle-icon");
    const hiddenMenuContainer = document.querySelector(".hidden-menu-container");
    const closeButton = document.querySelector(".hidden-menu li:last-child a");

    // Otwieranie menu
    toggleButton.addEventListener("click", function (e) {
        e.preventDefault(); // zapobiega ewentualnemu przeładowaniu strony
        hiddenMenuContainer.classList.add("active");
    });

    // Zamykanie menu
    closeButton.addEventListener("click", function (e) {
        e.preventDefault();
        hiddenMenuContainer.classList.remove("active");
    });
});



document.addEventListener("DOMContentLoaded", function () {
    const stickyNav = document.getElementById("sticky-nav");

    window.addEventListener("scroll", function () {
        if (window.scrollY > 200) {
            stickyNav.classList.add("visible");
        } else {
            stickyNav.classList.remove("visible");
        }
    });
});