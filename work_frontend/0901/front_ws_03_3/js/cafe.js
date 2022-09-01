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
let $backdrop;
let $modal

const toggleAuthState = () => {
    for (const navLink of $navLinks) {
        if (navLink.classList.contains('auth')) {
            navLink.classList.remove('auth');
        } else {
            navLink.classList.add('auth');
        }
    }
}

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
}

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
}

const login = () => {
    $profileImages[0].classList.toggle('hide'); //기본 프로필 안보이게
    $profileImages[1].classList.toggle('hide'); // 라이언 보이게

    foldList();
    toggleAuthState();
}

const logout = () => {
    $profileImages[0].classList.toggle('hide'); //기본 프로필 보이게
    $profileImages[1].classList.toggle('hide'); // 라이언 안 보이게

    foldList();
    toggleAuthState();
}

const closeModal = () => {
    if ($backdrop) {
        $backdrop.remove();
    }
    if ($modal) {
        $modal.remove();
    }
}

$login.addEventListener('click', () => {
    const id = prompt('아이디입력');
    const password = prompt('비밀번호 입력');

    if (id === 'ssafy' && +password === 1234) {
        alert('로그인 성공!!!');
        login();
    } else {
        alert('로그인 실패.. 아이디와 비밀번호를 확인하세요.');
    }
})

$logout.addEventListener('click', () => {
    alert('로그아웃 되었습니다.');
    logout();
})

$spreadBtn.addEventListener('click', spreadList);

$foldBtn.addEventListener('click', foldList)

$storeItem.addEventListener('click', (e) => {
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
})

$admin.addEventListener('click', () => {
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
          <div class="poll-question">
            <label>질문 내용</label>
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
    `
    $modal.classList.add('modal');
    $modal.classList.add('poll');
    document.body.insertBefore($modal, $backdrop);

    document.querySelector('#btn-add').addEventListener('click', function () {
        let listDiv = document.querySelector('#poll-answer-list');

        let divEl = document.createElement('div');
        divEl.setAttribute('class', 'poll-answer-item');

        let inputEl = document.createElement('input');
        inputEl.setAttribute('type', 'text');
        inputEl.setAttribute('name', 'answer');

        let buttonEl = document.createElement('button');
        buttonEl.setAttribute('type', 'button');
        buttonEl.setAttribute('class', 'button');
        buttonEl.appendChild(document.createTextNode('삭제'));

        buttonEl.addEventListener('click', function () {
            let parentEl = this.parentElement;
            listDiv.removeChild(parentEl);
        });

        divEl.appendChild(inputEl);
        divEl.appendChild(buttonEl);

        listDiv.appendChild(divEl);
    });

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
            answerArr.push(answer.value);  // ["서울", ... "부물경"]
        }

        localStorage.setItem('question', question);
        localStorage.setItem('answers', JSON.stringify(answerArr));

        if (confirm('투표 생성 하시겠습니까??')) {
            $modal.remove();
            $backdrop.remove();
        }
    });
})

