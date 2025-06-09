<script>
document.addEventListener("DOMContentLoaded", function () {
    const toggleButton = document.getElementById("menu-toggle");
    const leftSection = document.querySelector(".left-section");
    const rightSection = document.querySelector(".right-section");
    const icon = document.getElementById("toggle-icon");

    toggleButton.addEventListener("click", () => {
        leftSection.classList.toggle("active");
        rightSection.classList.toggle("active");

        // Zmiana ikony (hamburger <-> X)
        if (icon.classList.contains("fa-bars")) {
            icon.classList.remove("fa-bars");
            icon.classList.add("fa-times");
        } else {
            icon.classList.remove("fa-times");
            icon.classList.add("fa-bars");
        }
    });
});
</script>
