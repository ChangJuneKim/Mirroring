let cnt = 0; // 펼쳐진 메뉴의 개수

// HTML 문서가 완전히 로딩 된 후 실행
window.onload = function () {
  // 모든 매장 접기
  let subs = document.getElementsByClassName('store_item_sub');
  for (let i = 0; i < subs.length; i++) {
    subs[i].style.display = 'none';
  }

  // localStorage에서 poll 이름의 데이터 얻기
  let poll = localStorage.getItem('poll');

  // 투표가 보여질 div
  let pollDiv = document.querySelector('.vote');

  if (poll) {
    // localStorage에서 얻은 문자열을 JSON 객체로 변환
    let vote = JSON.parse(poll);
    let sdate = vote.start_date; // 시작일
    let edate = vote.end_date; // 종료일
    let question = vote.question; // 질문
    let answers = vote.answers; // 답변항목

    let imgArr = [];
    imgArr.push('./img/poll/python.png');
    imgArr.push('./img/poll/html5.png');
    imgArr.push('./img/poll/java.png');
    imgArr.push('./img/poll/vuejs.png');

    // 투표 화면 구성
    let pollContent = `
        <div class="vote_title">[ 당신의 선택 ]</div>
        <div class="vote_question">${question}</div>
        <div class="vote_answer">
          <ul>`;

    for (let i = 0; i < answers.length; i++) {
      pollContent += `
            <li>
              <input type="radio" name="vote_answer" id="" value="${answers[i]}"/>
              <img src="${imgArr[i % 4]}" alt="" /> ${answers[i]}
            </li>
            `;
    }

    pollContent += `
          </ul>
        </div>
        <div class="vote_button">
          <button class="button btn_primary" onclick="poll()">투표하기</button>
          <button class="button">결과보기</button>
        </div>
        <div class="vote_date">투표기간 : ${dateFormat(sdate)} ~ ${dateFormat(edate)}</div>
        `;

    pollDiv.innerHTML = pollContent;
  } else {
    // 진행중인 투표가 없을 경우 화면 추가
    pollDiv.innerHTML = "<div class='vote_title'>진행중인 투표가 없습니다.</div>";
  }
};

// 투표 시작일과 종료일 날짜 형식을 변경 (yy.mm.dd)
function dateFormat(date) {
  let yymmdd = date.split('-');
  return yymmdd[0].substr(2, 2) + '.' + yymmdd[1] + '.' + yymmdd[2];
}

// 로그인
function login() {
  // 사용자 정보를 입력받는다.
  let userid = window.prompt('아이디 입력', 'ssafy');
  if (userid.length == 0) {
    window.alert('아이디 입력!!!');
    return;
  }

  let userpass = window.prompt('비밀번호 입력', '1234');
  if (userpass.length == 0) {
    window.alert('비밀번호 입력!!!');
    return;
  }

  if (userid == 'ssafy' && userpass == '1234') {
    window.alert('로그인 성공!!!');
    document.querySelector('#header_nav_confirm_off').style.display = 'none';
    document.querySelector('#header_nav_confirm_on').style.display = 'block';
    document.querySelector('.profile_img').src = './img/profile.png';
  } else {
    window.alert('아이디 또는 비밀번호 확인!!!');
  }
}

// 전국매장펼치기
function allSlide(onoff) {
  if (onoff == 'on') {
    // 모든 매장 펼치기
    let subs = document.getElementsByClassName('store_item_sub');
    for (let i = 0; i < subs.length; i++) {
      subs[i].style.display = 'block';
    }

    document.querySelector('#store_display_off').style.display = 'block';
    document.querySelector('#store_display_on').style.display = 'none';

    cnt = 5;
  } else {
    // 모든 매장 접기
    let subs = document.getElementsByClassName('store_item_sub');
    for (let i = 0; i < subs.length; i++) {
      subs[i].style.display = 'none';
    }

    document.querySelector('#store_display_off').style.display = 'none';
    document.querySelector('#store_display_on').style.display = 'block';

    cnt = 0;
  }
}

function slideDown(id) {
  // 지역별 메뉴를 클릭 시 펼치기/접기
  let areaId = document.querySelector('#' + id);
  if (areaId.style.display == 'none') {
    areaId.style.display = 'block';
    cnt++;
  } else {
    areaId.style.display = 'none';
    cnt--;
  }

  if (cnt == 5) {
    // 모든 메뉴가 펼쳐졌다면 전국매장접기 버튼 활성화
    document.querySelector('#store_display_off').style.display = 'block';
    document.querySelector('#store_display_on').style.display = 'none';
  } else {
    // 하나 이상의 메뉴가 접혔다면 전국매장펼치기 버튼 활성화
    document.querySelector('#store_display_off').style.display = 'none';
    document.querySelector('#store_display_on').style.display = 'block';
  }
}

// 투표만들기 페이지 띄우기
function pollMake() {
  // pollmake.html의 창 아이디를 poll로 설정하고 가로 420, 세로 300인 창을 열기
  window.open('pollmake.html', 'poll', 'width=420,height=300');
}

// 답변 항목 추가
function addAnswer() {
  let listDiv = document.getElementById('poll_answer_list');
  let divEl = document.createElement('div');
  divEl.setAttribute('class', 'poll_answer_item');

  let inputEl = document.createElement('input');
  inputEl.setAttribute('type', 'text');
  inputEl.setAttribute('name', 'answer');

  let buttonEl = document.createElement('button');
  buttonEl.setAttribute('type', 'button');
  buttonEl.setAttribute('class', 'button');

  // 버튼에 클릭 이벤트 리스너 등록
  buttonEl.addEventListener('click', function (e) {
    let parent = this.parentNode;
    listDiv.removeChild(parent);
  });
  buttonEl.appendChild(document.createTextNode('삭제'));

  divEl.appendChild(inputEl);
  divEl.appendChild(buttonEl);
  listDiv.appendChild(divEl);
}

// 투표 생성
function makePoll() {
  let sdate = document.querySelector('#start_date').value; // 시작일
  let edate = document.querySelector('#end_date').value; // 종료일
  if (!sdate || !edate) {
    // 시작, 종료일 유효성 검사
    alert('설문 기간 입력!!!');
    return;
  }

  let quest = document.querySelector('#question').value; // 질문
  if (!quest) {
    // 질문 유효성 검사
    alert('질문 내용 입력');
    return;
  }

  let answerInput = document.querySelectorAll("input[name='answer']"); // 답변 항목
  for (let i = 0; i < answerInput.length; i++) {
    // 답변항목 유효성 검사
    if (!answerInput[i].value) {
      alert('답변 항목 입력!!!');
      return;
    }
  }

  let answers = [];
  for (let i = 0; i < answerInput.length; i++) {
    answers.push(answerInput[i].value); // 답변 배열에 입력 data 넣기
  }

  // 입력 데이터를 이용하여 JSON 객체 생성
  let poll = {
    start_date: sdate,
    end_date: edate,
    question: quest,
    answers: answers,
  };

  let poll_json = JSON.stringify(poll); // JSON 객체를 직렬화
  localStorage.setItem('poll', poll_json); // localStorage에 저장

  alert('투표를 생성합니다.');
  opener.document.location.reload(); // 부모 창 새로고침
  self.close(); // 관리자 창 닫기
}

// 투표하기 버튼
function poll() {
  let votes = document.querySelectorAll("input[name='vote_answer']");
  let sel_menu = '';

  for (let i = 0; i < votes.length; i++) {
    if (votes[i].checked == true) {
      sel_menu = votes[i].value;
      break;
    }
  }

  alert(sel_menu + '를 선택했습니다.');
}
