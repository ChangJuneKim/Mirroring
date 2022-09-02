const $login = document.querySelector('.login');
const $logout = document.querySelector('.logout');
const $admin = document.querySelector('.admin');
const $profileImages = document.querySelectorAll('.profile_img');
const $storeItemSubs = document.querySelectorAll('.store_item_sub');
const $navLinks = document.querySelectorAll('.header_nav_menuitem');
const $storeDisplayBtns = document.querySelectorAll('.store_display');
const $storeItem = document.querySelector('.store_item');
const $spreadBtn = $storeDisplayBtns[0];
const $foldBtn = $storeDisplayBtns[1];
const $vote = document.querySelector('.vote');
let $backdrop;
let $modal;

const refreshVoteList = () => {
  $vote.innerHTML = '';
  if (localStorage.length > 0) {
    if (document.querySelector('.no-vote')) {
      document.querySelector('.no-vote').classList.add('hide');
    }

    const { start_date, end_date, question, answers, expire } = JSON.parse(
      localStorage.getItem('poll')
    );

    // console.log(start_date, end_date, question, answers, expire)
    if (Date.now() > expire) {
      localStorage.clear();
    }
    const $voteTitle = document.createElement('div');
    $voteTitle.classList.add('vote_title');
    $voteTitle.innerText = '[ 당신의 선택 ]';

    const $voteQuestion = document.createElement('div');
    $voteQuestion.classList.add('vote_question');
    $voteQuestion.innerText = question;

    const $voteAnswer = document.createElement('div');
    $voteAnswer.classList.add('vote_answer');
    const $voteList = document.createElement('ul');
    $voteList.classList.add('vote-list');

    $vote.appendChild($voteTitle);
    $vote.appendChild($voteQuestion);
    $vote.appendChild($voteAnswer);

    for (const answer of answers) {
      const $li = document.createElement('li');
      const $input = document.createElement('input');
      $input.setAttribute('type', 'radio');
      $input.setAttribute('name', 'vote-answer');
      $input.setAttribute('id', answer);
      const $label = document.createElement('label');
      $label.innerText = answer;
      $label.setAttribute('for', answer);

      $li.appendChild($input);
      $li.appendChild($label);
      $voteList.appendChild($li);
    }

    $vote.appendChild($voteList);

    const $voteButton = document.createElement('div');
    $voteButton.classList.add('vote_button');

    const $voteBtn = document.createElement('button');
    $voteBtn.classList.add('button');
    $voteBtn.classList.add('btn_primary');
    $voteBtn.innerText = '투표하기';
    $voteBtn.addEventListener('click', vote);

    const $resultBtn = document.createElement('button');
    $resultBtn.classList.add('button');
    $resultBtn.innerText = '결과보기';

    $voteButton.appendChild($voteBtn);
    $voteButton.appendChild($resultBtn);

    $vote.appendChild($voteButton);

    const $voteDate = document.createElement('div');
    $voteDate.classList.add('vote_date');
    $voteDate.innerText = `투표기간 : ${start_date} ~ ${end_date}`;

    $vote.appendChild($voteDate);
  } else {
    const $noVote = document.createElement('div');
    $noVote.innerHTML = `
    <div class="no-vote">진행중인 투표가 없습니다.</div>
    `;
    $vote.appendChild($noVote);
  }
};

const vote = () => {
  const votedItem = document.querySelector('input[type=radio]:checked');

  console.log(votedItem);
};

const toggleAuthState = () => {
  for (const navLink of $navLinks) {
    if (navLink.classList.contains('auth')) {
      navLink.classList.remove('auth');
    } else {
      navLink.classList.add('auth');
    }
  }
};

const spreadList = () => {
  for (const storeItemSub of $storeItemSubs) {
    if (storeItemSub.classList.contains('hide')) {
      storeItemSub.classList.add('show');
      storeItemSub.classList.remove('hide');
    }
  }

  $spreadBtn.classList.add('hide');
  $spreadBtn.classList.remove('show');
  $foldBtn.classList.add('show');
  $foldBtn.classList.remove('hide');
};

const foldList = () => {
  for (const storeItemSub of $storeItemSubs) {
    if (storeItemSub.classList.contains('show')) {
      storeItemSub.classList.add('hide');
      storeItemSub.classList.remove('show');
    }
  }

  $spreadBtn.classList.add('show');
  $spreadBtn.classList.remove('hide');
  $foldBtn.classList.add('hide');
  $foldBtn.classList.remove('show');
};

const login = () => {
  $profileImages[0].classList.toggle('hide'); //기본 프로필 안보이게
  $profileImages[1].classList.toggle('hide'); // 라이언 보이게

  foldList();
  toggleAuthState();
  refreshVoteList();
};

const logout = () => {
  $profileImages[0].classList.toggle('hide'); //기본 프로필 보이게
  $profileImages[1].classList.toggle('hide'); // 라이언 안 보이게

  foldList();
  toggleAuthState();
  refreshVoteList();
};

const closeModal = () => {
  if ($backdrop) {
    $backdrop.remove();
  }
  if ($modal) {
    $modal.remove();
  }
  refreshVoteList();
};

// 모달 열기(만들어서 열기)
const showModal = () => {
  $backdrop = document.createElement('div');
  $backdrop.classList.add('backdrop');
  $backdrop.addEventListener('click', closeModal);
  document.body.insertBefore($backdrop, document.querySelector('header'));
  // backdrop.addEventListener('click', closeModal);

  $modal = document.createElement('div');

  $modal.innerHTML = `
    <h3 class="poll-title">투표 만들기</h3>
      <div class="poll-content">
        <form action="">
          <div class="poll-date">
            <label for="start-date">시작일</label>
            <input type="date" id="start-date" name="start-date">
            <label for="end-date">종료일</label>
            <input type="date" id="end-date" name="end-date" />
          </div>
          <div class="poll-question">
            <label for="question">질문 내용</label>
            <input type="text" id="question" name="question" placeholder="질문내용..." />
          </div>
          <div class="poll-answer">
            <label>답변 항목</label>
            <button type="button" id="btn-add" class="button">추가</button>
          </div>
          <div id="poll-answer-list">
            <div class="poll-answer-item">
              <input type="text" name="answer" />
            </div>
          </div>
          <div class="poll-make">
            <button type="button" id="btn-make" class="button btn-primary">투표 생성</button>
          </div>
        </form>
      </div>
    `;

  $modal.classList.add('modal');
  $modal.classList.add('poll');
  document.body.insertBefore($modal, $backdrop);
  const now = new Date();
  const offset = now.getTimezoneOffset() * 60000;
  const today = new Date(now.getTime() - offset).toISOString().substring(0, 10);
  const lastDay = new Date(now.getFullYear(), now.getMonth() + 1, 0);
  const endDay = new Date(lastDay.getTime() - offset).toISOString().substring(0, 10);

  const $startDate = document.querySelector('#start-date');
  $startDate.setAttribute('value', today);
  const $endDate = document.querySelector('#end-date');
  $endDate.setAttribute('value', endDay);
};

// 투표 후보군 추가하기
const addList = () => {
  document.querySelector('#btn-add').addEventListener('click', function () {
    const listDiv = document.querySelector('#poll-answer-list');

    const divEl = document.createElement('div');
    divEl.setAttribute('class', 'poll-answer-item');

    const inputEl = document.createElement('input');
    inputEl.setAttribute('type', 'text');
    inputEl.setAttribute('name', 'answer');

    const buttonEl = document.createElement('button');
    buttonEl.setAttribute('type', 'button');
    buttonEl.setAttribute('class', 'button');
    buttonEl.appendChild(document.createTextNode('삭제'));

    buttonEl.addEventListener('click', function () {
      const parentEl = this.parentElement;

      listDiv.removeChild(parentEl);
    });
    divEl.appendChild(inputEl);
    divEl.appendChild(buttonEl);
    listDiv.appendChild(divEl);
  });
};

// 만들어진 투표 화면에 추가하기
const makeVote = () => {
  document.querySelector('#btn-make').addEventListener('click', function () {
    let question = document.querySelector('#question').value;
    //console.log(question);
    if (!question) {
      alert('질문은 반드시 입력!!!!');
      return;
    }

    let answers = document.querySelectorAll('[name=answer]');
    //console.log(answers);
    for (let answer of answers) {
      if (!answer.value) {
        alert('답변을 입력!!!');
        return;
      }
    }

    let answerArr = [];
    for (let answer of answers) {
      answerArr.push(answer.value); // ["서울", ... "부물경"]
    }

    const $startDate = document.querySelector('#start-date');
    const $endDate = document.querySelector('#end-date');
    const now = new Date();
    const offset = now.getTimezoneOffset() * 60000;

    if (!$startDate.value || !$endDate.value) {
      alert('설문 기간 입력!!!!');
      return;
    }

    if ($startDate.value > $endDate.value) {
      alert('잘못된 날짜 선택');
      return;
    }

    const poll = {
      start_date: $startDate.value,
      end_date: $endDate.value,
      question: question,
      answers: answerArr,
      expire: new Date($endDate.value).getTime() - offset,
    };

    localStorage.setItem('poll', JSON.stringify(poll));

    if (confirm('투표 생성 하시겠습니까??')) {
      $modal.remove();
      $backdrop.remove();
      refreshVoteList();
    }
  });
};

const init = () => {
  refreshVoteList();
};

$login.addEventListener('click', () => {
  const id = prompt('아이디입력');
  const password = prompt('비밀번호 입력');

  if (id === 'ssafy' && +password === 1234) {
    alert('로그인 성공!!!');
    login();
  } else {
    alert('로그인 실패.. 아이디와 비밀번호를 확인하세요.');
  }
});

$logout.addEventListener('click', () => {
  alert('로그아웃 되었습니다.');
  logout();
});

$storeItem.addEventListener('click', e => {
  // console.log(e.target) // 이벤트를 발생시키는 요소
  // console.log(e.currentTarget) // 이벤트 핸들러가 등록된 요소
  let target = e.target;
  if (target.tagName === 'A') {
    target = target.parentElement;
  }

  for (const child of target.children) {
    if (child.classList.contains('store_item_sub')) {
      if (child.classList.contains('hide')) {
        child.classList.remove('hide');
        child.classList.add('show');
      } else {
        child.classList.remove('show');
        child.classList.add('hide');
      }
    }
  }

  const lists = document.querySelector('.store_item').children;
  let showCount = 0;
  for (const list of lists) {
    if (list.children[1].classList.contains('show')) {
      showCount++;
    }
  }
  if (showCount === document.querySelector('.store_item').childElementCount) {
    $spreadBtn.classList.add('hide');
    $spreadBtn.classList.remove('show');
    $foldBtn.classList.add('show');
    $foldBtn.classList.remove('hide');
  }

  if (showCount === 0) {
    $spreadBtn.classList.add('show');
    $spreadBtn.classList.remove('hide');
    $foldBtn.classList.add('hide');
    $foldBtn.classList.remove('show');
  }
});

$admin.addEventListener('click', () => {
  showModal();
  addList();
  makeVote();
});

$spreadBtn.addEventListener('click', spreadList);

$foldBtn.addEventListener('click', foldList);

init();
