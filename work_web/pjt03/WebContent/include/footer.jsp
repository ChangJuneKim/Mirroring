<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer>
	<h1 class="sr-only">Copyright</h1>
	<ul class="navbar--nav">
		<li><a href="#" class="nav--link">카페소개</a></li>
		<li><a href="#" class="nav--link">개인정보처리방침</a></li>
		<li><a href="#" class="nav--link">이용약관</a></li>
		<li><a href="#" class="nav--link">오시는길</a></li>
		<li><label class="nav--link">&copy; SSAFY Corp.</label></li>
	</ul>
</footer>
<script defer>
      const $info = document.querySelector('#info');
      const $prefer = document.querySelector('#prefer');

      let $backdrop;
      let $modal;

      const deleteUser = () => {
        let form = document.querySelector('#info-form');
        const answer = confirm('정말 탈퇴하시겠습니까?');
        if (answer) {
          const resignMessage = '탈퇴하겠습니다';
          const input = prompt(resignMessage + ' 를 입력해주세요.');

          if (resignMessage === input) {
            form.setAttribute('action', '${root}/user?act=resign');
            form.submit();
            closeModal();
          }
        } else {
          closeModal();
        }
      };

      const confirmModal = () => {
        let form = document.querySelector('#info-form');
        const answer = confirm('회원 정보를 수정하시겠습니까?');
        if (answer) {
          form.setAttribute('action', '${root}/user?act=modifyInfo');
          form.submit();
          closeModal();
        } else {
          closeModal();
        }
      };

      const closeModal = () => {
        if ($backdrop) {
          $backdrop.remove();
        }
        if ($modal) {
          $modal.remove();
        }
      };

      const modifyModal = () => {
        const $inputs = document.querySelectorAll('input[type="text"]:not(#modeId)');
        console.log($inputs);
        for (const input of $inputs) {
          input.disabled = false;
        }
      };

      const setPrefer = () => {
        const form = document.querySelector('#prefer-form');
        form.setAttribute('action', '${root}/main?act=setprefer');
        form.submit();
        closeModal();
      };

      const openPreferModal = () => {
        $backdrop = document.createElement('div');
        $backdrop.classList.add('backdrop');
        $backdrop.addEventListener('click', closeModal);
        document.body.insertBefore($backdrop, document.querySelector('.intro'));

        $modal = document.createElement('div');
        $modal.innerHTML = `
            <header>
              <h1 >선호 지역</h1>
              <div >
      <form id="prefer-form" method="POST" action="">
                <div >
                  <select id="sido-modal">
                    <option value="">시도선택</option>
                  </select>
                  <input type="hidden" name="sido" id="sido-post"/>
                </div>
      
                <div >
                  <select id="gugun-modal">
                    <option value="">구군선택</option>
                  </select>
                  <input type="hidden" name="gugun" id="gugun-post"/>
                </div>
      
                <div>
                  <select  id="dong-modal">
                    <option value="">동선택</option>
                  </select>
                  <input type="hidden" name="dong" id="dong-post"/>
                </div>
      
                <div class="modal__btns">
                      <button class="modal__btn confirm" onclick=setPrefer()>저장</button>
                      <button class="modal__btn close" onclick=closeModal()>닫기</button>
                </div>
      </form>
              </div>
      </header>
              `;
        $modal.classList.add('mymodal');
        $modal.classList.add('poll');
        document.body.insertBefore($modal, $backdrop);
        sendRequest('sido-modal', '*00000000');
        const $sidoModal = document.querySelector('#sido-modal');
        const $gugunModal = document.querySelector('#gugun-modal');
        const $dongModal = document.querySelector('#dong-modal');
        
        // 시도가 바뀌면 구군정보 얻기.
        $sidoModal.addEventListener('change', function () {
          document
            .querySelector('#sido-post')
            .setAttribute('value', $sidoModal.options[$sidoModal.selectedIndex].text);
          if (this[this.selectedIndex].value) {
            let regcode = this[this.selectedIndex].value.substr(0, 2) + '*00000';
            sendRequest('gugun-modal', regcode);
          } else {
            initOption('gugun-modal');
            initOption('dong-modal');
          }
        });

        // 구군이 바뀌면 동정보 얻기.
        $gugunModal.addEventListener('change', function () {
          document
            .querySelector('#gugun-post')
            .setAttribute('value', $gugunModal.options[$gugunModal.selectedIndex].text);
          if (this[this.selectedIndex].value) {
            let regcode = this[this.selectedIndex].value.substr(0, 5) + '*';
            sendRequest('dong-modal', regcode);
          } else {
            initOption('dong-modal');
          }
        });
        
        $dongModal.addEventListener('change', function () {
        	document
            .querySelector('#dong-post')
            .setAttribute('value', $dongModal.options[$dongModal.selectedIndex].text);
        });
        
      };

      const openInfoModal = () => {
        $backdrop = document.createElement('div');
        $backdrop.classList.add('backdrop');
        $backdrop.addEventListener('click', closeModal);
        document.body.insertBefore($backdrop, document.querySelector('.header'));

        $modal = document.createElement('div');
        $modal.innerHTML = `
        <div class="modification_register_container">
        <div class="modification_register-page">
          <h1>회원 정보 확인</h1>
          <div class="underbar"></div>
          <form id="info-form" method="POST" action="">
          <div class="modification__info">
            <div>
              <label for="modeId">아이디 *</label>
              <input id="modeId" type="text" value="${userinfo.userId}" disabled style="
              width: 180px;
              height: 32px;
              font-size: 15px;
              border: 1px solid;
              border-radius: 15px;
              outline: none;
              padding-left: 10px;
             "/>
            </div>
            <div>
              <label for="modeId">이름 *</label>
              <input type="text" name="newName" value="${userinfo.userName}" disabled style="
              width: 180px;
              height: 32px;
              font-size: 15px;
              border: 1px solid;
              border-radius: 15px;
              outline: none;
              padding-left: 10px;
              "/>
            </div>
            <div>
              <label for="modeId">주소 *</label>
              <input type="text" name="newAddress" value="${userinfo.address}" disabled style="
              width: 180px;
              height: 32px;
              font-size: 15px;
              border: 1px solid;
              border-radius: 15px;
              outline: none;
              padding-left: 10px;
              "/>
            </div>
            <div>
              <label for="modeId">전화번호 *</label>
              <input type="text" name="newPhoneNumber" value="${userinfo.phoneNumber}" disabled style="
              display: inline-block;
              width: 180px;
              height: 32px;
              font-size: 15px;
              border: 1px solid;
              border-radius: 15px;
              outline: none;
              padding-left: 10px;
              margin-bottom : 10px;
              "/>
            </div>
          </div>
      
          <div class="modal__btns">
            <button class="modal__btn confirm" onclick=confirmModal()>확인</button>
            <button class="modal__btn modify" onclick=modifyModal() type="button">수정</button>
            <button class="modal__btn delete" onclick=deleteUser()>삭제</button>
            <button class="modal__btn close" onclick=closeModal()>닫기</button>
          </div>
          </form>
        </div>
      </div>`;

        $modal.classList.add('mymodal');
        $modal.classList.add('poll');
        document.body.insertBefore($modal, $backdrop);
      };

      <c:if test='${userinfo ne null}'>
        $info.addEventListener('click', openInfoModal); 
        $prefer.addEventListener('click',openPreferModal);
      </c:if>;
      //$info.addEventListener('click', () => {
      //	// 유저정보 얻어오기
      //	location.href = "${root}/user?act=getinfo";
      //})

      function sendRequest(selid, regcode) {
        const url = 'https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes';
        let params = 'regcode_pattern=' + regcode + '&is_ignore_zero=true';
        fetch(url + '?' + params)
          .then(response => response.json())
          .then(data => {
            addOption(selid, data);
          });
      }

      // 시도 선택, 구군 선택 ,,,,
      function addOption(selid, data) {
        let opt = ``;
        initOption(selid);
        switch (selid) {
          case 'sido-modal':
            opt += `<option value="">시도선택</option>`;
            data.regcodes.forEach(function (regcode) {
              opt += '<option value=' + regcode.code + '>' + regcode.name + '</option>';
            });
            break;
          case 'gugun-modal':
            opt += `<option value="">구군선택</option>`;
            for (let i = 0; i < data.regcodes.length; i++) {
              if (i != data.regcodes.length - 1) {
                if (
                  data.regcodes[i].name.split(' ')[1] == data.regcodes[i + 1].name.split(' ')[1] &&
                  data.regcodes[i].name.split(' ').length !=
                    data.regcodes[i + 1].name.split(' ').length
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
              opt += '<option value=' + regcode.code + '>' + name + '</option>';
            });
            break;
          case 'dong-modal':
            opt += `<option value="">동선택</option>`;
            let idx = 2;
            data.regcodes.forEach(function (regcode) {
              if (regcode.name.split(' ').length != 3) idx = 3;
              opt +=
                '<option value=' + regcode.code + '>' + regcode.name.split(' ')[idx] + '</option>';
            });
        }
        
        document.querySelector('#' + selid).innerHTML = opt;
      }

      function initOption(selid) {
        console.log(selid);
        let options = document.querySelector('#' + selid);
        options.length = 0;
        // let len = options.length;
        // for (let i = len - 1; i >= 0; i--) {
        //   options.remove(i);
        // }
      }
    </script>