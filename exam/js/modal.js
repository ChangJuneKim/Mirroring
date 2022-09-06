const $admin = document.querySelector("#admin");
let $backdrop;
let $modal;

const closeModal = () => {
  if ($backdrop) {
    $backdrop.remove();
  }
  if ($modal) {
    $modal.remove();
  }
};

const openModal = () => {
  $backdrop = document.createElement("div");
  $backdrop.classList.add("backdrop");
  $backdrop.addEventListener("click", closeModal);
  document.body.insertBefore($backdrop, document.querySelector(".intro"));

  // backdrop.addEventListener('click', closeModal);

  $modal = document.createElement("div");
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
    `;
  $modal.classList.add("modal");
  $modal.classList.add("poll");
  document.body.insertBefore($modal, $backdrop);
};

$admin.addEventListener("click", openModal);
