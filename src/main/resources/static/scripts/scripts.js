console.log("JavaScript działa!");
document.addEventListener("DOMContentLoaded", function () {
    const toggleButton = document.getElementById("toggle-icon");
    const hiddenMenuContainer = document.querySelector(".hidden-menu-container");
    const closeButton = document.getElementById("close-menu");
    const stickyNav = document.getElementById("sticky-nav");

    // Otwieranie menu
    toggleButton?.addEventListener("click", function (e) {
        e.preventDefault(); // zapobiega przeładowaniu strony
        hiddenMenuContainer?.classList.add("active");
    });

    // Zamykanie menu
    closeButton?.addEventListener("click", function (e) {
        e.preventDefault();
        hiddenMenuContainer?.classList.remove("active");
    });

    // Sticky nawigacja przy scrollu
    window.addEventListener("scroll", function () {
        if (window.scrollY > 200) {
            stickyNav?.classList.add("visible");
        } else {
            stickyNav?.classList.remove("visible");
        }
    });
});
