const toggleButton = document.querySelector(".header__menu-btn");
const navbarLinks = document.querySelector(".header__nav");

toggleButton.addEventListener("click", (e) => {
  e.preventDefault();
  navbarLinks.classList.toggle("active");
});
