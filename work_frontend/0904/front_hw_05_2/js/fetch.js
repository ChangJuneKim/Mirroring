const $contentList = document.querySelector(".content-user-list-ul");

const fetchData = async () => {
  if (!$contentList) {
    return;
  }

  const response = await fetch("./data/user.json");
  const { users } = await response.json();

  const userList = document.querySelector(".content-user-list-ul");

  for (const user of users) {
    const { img, id, name, email, age } = user;

    const userItem = `
      <li>
        <div class="list-item">
          <div>
            <img src="${img}" alt="" />
          </div>
          <div class="user-info">
            <div>
              <div>${id}</div>
              <div>${name}</div>
              <div>${email}</div>
              <div>${age} 세</div>
            </div>
          </div>
        </div>
      </li>
      `;

    userList.innerHTML += userItem;
  }
};

window.onload = fetchData;
