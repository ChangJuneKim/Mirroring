///////////////////////// select box 설정 (지역, 매매기간) /////////////////////////
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

window.onload = function () {
  let yearEl = document.querySelector('#year');
  let yearOpt = `<option value="">매매년도선택</option>`;
  let year = date.getFullYear();
  for (let i = year; i > year - 20; i--) {
    yearOpt += `<option value="${i}">${i}년</option>`;
  }
  yearEl.innerHTML = yearOpt;

  // 브라우저가 열리면 시도정보 얻기.
  sendRequest('sido', '*00000000');
};

document.querySelector('#year').addEventListener('change', function () {
  let month = date.getMonth() + 1;
  let monthEl = document.querySelector('#month');
  let monthOpt = `<option value="">매매월선택</option>`;
  let yearSel = document.querySelector('#year');
  let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
  for (let i = 1; i < m; i++) {
    monthOpt += `<option value="${i < 10 ? '0' + i : i}">${i}월</option>`;
  }
  monthEl.innerHTML = monthOpt;
});

// https://juso.dev/docs/reg-code-api/
// let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
// let regcode = "*00000000";
// 전국 특별/광역시, 도
// https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

// 시도가 바뀌면 구군정보 얻기.
document.querySelector('#sido').addEventListener('change', function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 2) + '*00000';
    sendRequest('gugun', regcode);
  } else {
    initOption('gugun');
    initOption('dong');
  }
});

// 구군이 바뀌면 동정보 얻기.
document.querySelector('#gugun').addEventListener('change', function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 5) + '*';
    sendRequest('dong', regcode);
  } else {
    initOption('dong');
  }
});

function sendRequest(selid, regcode) {
  const url = 'https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes';
  let params = 'regcode_pattern=' + regcode + '&is_ignore_zero=true';
  fetch(`${url}?${params}`)
    .then(response => response.json())
    .then(data => addOption(selid, data));
}

// 시도 선택, 구군 선택 ,,,,
function addOption(selid, data) {
  let opt = ``;
  initOption(selid);
  switch (selid) {
    case 'sido':
      opt += `<option value="">시도선택</option>`;
      data.regcodes.forEach(function (regcode) {
        opt += `
          <option value="${regcode.code}">${regcode.name}</option>
          `;
      });
      break;
    case 'gugun':
      opt += `<option value="">구군선택</option>`;
      for (let i = 0; i < data.regcodes.length; i++) {
        if (i != data.regcodes.length - 1) {
          if (
            data.regcodes[i].name.split(' ')[1] == data.regcodes[i + 1].name.split(' ')[1] &&
            data.regcodes[i].name.split(' ').length != data.regcodes[i + 1].name.split(' ').length
          ) {
            data.regcodes.splice(i, 1);
            i--;
          }
        }
      }
      let name = '';
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(' ').length == 2) name = regcode.name.split(' ')[1];
        else name = regcode.name.split(' ')[1] + ' ' + regcode.name.split(' ')[2];
        opt += `
          <option value="${regcode.code}">${name}</option>
          `;
      });
      break;
    case 'dong':
      opt += `<option value="">동선택</option>`;
      let idx = 2;
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(' ').length != 3) idx = 3;
        opt += `
          <option value="${regcode.code}">${regcode.name.split(' ')[idx]}</option>
          `;
      });
  }
  document.querySelector(`#${selid}`).innerHTML = opt;
}

function initOption(selid) {
  let options = document.querySelector(`#${selid}`);
  options.length = 0;
  // let len = options.length;
  // for (let i = len - 1; i >= 0; i--) {
  //   options.remove(i);
  // }
}

///////////////////////// 연립다세대 매매 정보 /////////////////////////
document.querySelector('#list-btn').addEventListener('click', function () {
  let url =
    'http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade';
  let gugunSel = document.querySelector('#gugun');
  let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
  let yearSel = document.querySelector('#year');
  let year = yearSel[yearSel.selectedIndex].value;
  let monthSel = document.querySelector('#month');
  let month = monthSel[monthSel.selectedIndex].value;
  let dealYM = year + month;
  let queryParams =
    encodeURIComponent('serviceKey') +
    '=' +
    'QFgPOQhYrh%2BCCboi0j9FB4L9%2FiE2JfBgy%2BVTak4PxHUAgGwcy96K5l3%2BO85ijOCVbOj76VU3mQX%2FmFA0wguWJA%3D%3D'; /*Service Key*/
  queryParams +=
    '&' + encodeURIComponent('LAWD_CD') + '=' + encodeURIComponent(regCode); /*아파트소재 구군*/
  queryParams +=
    '&' + encodeURIComponent('DEAL_YMD') + '=' + encodeURIComponent(dealYM); /*조회년월*/

  fetch(`${url}?${queryParams}`)
    .then(response => response.text())
    .then(data => {
      console.log(data);
      makeList(data);
    });
});

const filterTransactionHistory = name => {
  let url =
    'http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHTrade';
  let gugunSel = document.querySelector('#gugun');
  let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
  let yearSel = document.querySelector('#year');
  let year = yearSel[yearSel.selectedIndex].value;
  let monthSel = document.querySelector('#month');
  let month = monthSel[monthSel.selectedIndex].value;
  let dealYM = year + month;
  let queryParams =
    encodeURIComponent('serviceKey') +
    '=' +
    'QFgPOQhYrh%2BCCboi0j9FB4L9%2FiE2JfBgy%2BVTak4PxHUAgGwcy96K5l3%2BO85ijOCVbOj76VU3mQX%2FmFA0wguWJA%3D%3D'; /*Service Key*/
  queryParams +=
    '&' + encodeURIComponent('LAWD_CD') + '=' + encodeURIComponent(regCode); /*아파트소재 구군*/
  queryParams +=
    '&' + encodeURIComponent('DEAL_YMD') + '=' + encodeURIComponent(dealYM); /*조회년월*/

  fetch(`${url}?${queryParams}`)
    .then(response => response.text())
    .then(data => filterList(data, name));
};

async function filterList(data, name) {
  console.log(name);
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, 'application/xml');
  // console.log(xml);

  let apts = xml.querySelectorAll('item');
  const apartData = [];
  let filteredApart;

  apts.forEach(apt => {
    const transactionInfo = {
      apart: apt.querySelector('연립다세대').textContent,
      amount: apt.querySelector('거래금액').textContent.trim(),
      dedicatedArea: apt.querySelector('전용면적').textContent,
      date: `${apt.querySelector('년').textContent}. ${apt.querySelector('월').textContent}. ${
        apt.querySelector('일').textContent
      }.`,
      category: `${apt.querySelector('거래유형').textContent}`,
    };

    apartData.push(transactionInfo);
    filteredApart = apartData.filter(apart => apart.apart === name);
  });

  initList();

  const $apartName = document.createElement('h1');
  $apartName.innerText = `${name}`;
  document.querySelector('#apart-info').appendChild($apartName);

  for (const apartElement of filteredApart) {
    console.log(apartElement);
    const $apartInfo = document.createElement('li');
    const $amount = document.createElement('p');
    const $dedicatedArea = document.createElement('p');
    const $date = document.createElement('p');
    const $category = document.createElement('p');
    const { amount, dedicatedArea, category, date } = apartElement;

    $amount.innerText = `거래금액 : ${amount}`;
    $dedicatedArea.innerText = `전용면적 : ${dedicatedArea}`;
    $date.innerText = `거래일자 : ${date}`;
    $category.innerText = `거래유형 : ${category}`;

    $apartInfo.appendChild($amount);
    $apartInfo.appendChild($dedicatedArea);
    $apartInfo.appendChild($date);
    $apartInfo.appendChild($category);
    document.querySelector('#apart-info').appendChild($apartInfo);
  }
}

function makeList(data) {
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, 'application/xml');
  // console.log(xml);
  initList();
  let apts = xml.querySelectorAll('item');

  let positions = [];
  const apartData = [];

  apts.forEach(apt => {
    const apartInfo = document.createElement('li');
    const apartName = document.createElement('p');
    const amount = document.createElement('p');
    const dedicatedArea = document.createElement('p');
    const date = document.createElement('p');

    let apt_addr =
      apt.querySelector('법정동').textContent + ' ' + apt.querySelector('지번').textContent;

    let position = {
      addr: apt_addr,
      content: apt.querySelector('연립다세대').textContent,
    };

    const transactionInfo = {
      apart: apt.querySelector('연립다세대').textContent,
      amount: apt.querySelector('거래금액').textContent.trim(),
      dedicatedArea: apt.querySelector('전용면적').textContent,
      date: `${apt.querySelector('년').textContent}. ${apt.querySelector('월').textContent}. ${
        apt.querySelector('일').textContent
      }.`,
    };

    apartName.innerText = `연립다세대 : ${apt.querySelector('연립다세대').textContent}`;
    amount.innerText = `거래금액 : ${apt.querySelector('거래금액').textContent.trim()}`;
    dedicatedArea.innerText = `전용면적 : ${apt.querySelector('전용면적').textContent}`;
    date.innerText = `거래일자 : ${apt.querySelector('년').textContent}. ${
      apt.querySelector('월').textContent
    }. ${apt.querySelector('일').textContent}.`;

    apartInfo.appendChild(apartName);
    apartInfo.appendChild(amount);
    apartInfo.appendChild(dedicatedArea);
    apartInfo.appendChild(date);

    document.querySelector('#apart-info').appendChild(apartInfo);

    apartData.push(transactionInfo);
    positions.push(position);
    // tbody.appendChild(tr);
  });

  console.log(apartData);

  var mapContainer = document.getElementById('apt2_map'), // 지도를 표시할 div
    mapOption = {
      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      level: 5, // 지도의 확대 레벨
    };
  var map = new kakao.maps.Map(mapContainer, mapOption);

  for (let i = 0; i < positions.length; i++) {
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();
    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(positions[i].addr, function (result, status) {
      // 정상적으로 검색이 완료됐으면
      if (status === kakao.maps.services.Status.OK) {
        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
          map: map,
          position: coords,
        });

        // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
        var iwContent = positions[i].content; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: '<div style="width:100%; padding:5px;">' + iwContent + '</div>',
          removable: iwRemoveable,
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(
          marker,
          'mouseover',
          makeOverListener(map, marker, infowindow)
        );

        kakao.maps.event.addListener(marker, 'click', () =>
          filterTransactionHistory(infowindow.a.innerText)
        );

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

        // var infowindow = new kakao.maps.InfoWindow({
        //   content: positions[i].content, // 인포윈도우에 표시할 내용
        // });
        // kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        // kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
        // // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
      }
    });
  }
}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다
function makeOverListener(map, marker, infowindow) {
  return function () {
    infowindow.open(map, marker);
  };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다
function makeOutListener(infowindow) {
  return function () {
    infowindow.close();
  };
}

function initList() {
  document.querySelector('#apart-info').innerHTML = null;
}
