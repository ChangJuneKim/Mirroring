const $toggleButton = document.querySelector(".header__menu-btn");
const $navbarLinks = document.querySelector(".header__nav");
const $body = document.querySelector("body");
const $header = document.querySelector("header");

$toggleButton.addEventListener("click", () => {
  $navbarLinks.classList.toggle("active");
  $header.classList.toggle("open");
  // 햄버거 메뉴를 열면 본문은 스크롤 하지않음
  if ($navbarLinks.classList.contains("active")) {
    $body.classList.add("scroll_disable");
  } else {
    $body.classList.remove("scroll_disable");
  }
});
