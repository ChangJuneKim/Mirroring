const $navItems1 = document.querySelectorAll('.header__nav ul:last-child .header__nav-item');

let toggleNavList1 = () => {
  const user = JSON.parse(localStorage.getItem('user'));
  if (user) {
    for (const navItem of $navItems1) {
      if (navItem.classList.contains('hide')) {
        navItem.classList.remove('hide');
      } else {
        navItem.classList.add('hide');
      }
    }
  }
};

(function () {
  const user = localStorage.getItem('user');
  if (user) {
    toggleNavList1();
  }
})();
