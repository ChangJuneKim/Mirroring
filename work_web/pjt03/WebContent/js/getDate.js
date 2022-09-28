const date = new Date();

const setYears = () => {
  const yearEl = document.querySelector('#year');
  let yearOpt = `<option value="">매매년도선택</option>`;
  const year = date.getFullYear();
  for (let i = year; i > year - 20; i--) {
    yearOpt += `<option value="${i}">${i}년</option>`;
  }
  yearEl.innerHTML = yearOpt;
};

const setMonths = () => {
	let month = date.getMonth() + 1;
	let monthEl = document.querySelector('#month');
	let monthOpt = `<option value="">매매월선택</option>`;
	let yearSel = document.querySelector('#year');
	let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
	for (let i = 1; i < m; i++) {
	  monthOpt += `<option value="${i < 10 ? '0' + i : i}">${i}월</option>`;
    }
	monthEl.innerHTML = monthOpt;
}

window.addEventListener("load", setYears)
const $year = document.querySelector('#year'); 
$year.addEventListener('change', setMonths);