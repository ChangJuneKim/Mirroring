function getXMLHttpRequest() {
  if (window.ActiveXObject) { // MS IE
    try {
      return new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e1) {
      try {
        return new ActiveXObject("Microsoft.XMLHTTP");
      }
      catch (e2) {
        return null;
      }
    }
  }
  else if (window.XMLHttpRequest) { //기타 웹 브라우져
    return new XMLHttpRequest();
  }
  else {
    return null;
  }
}

function sendRequest(obj) {
  let httpRequest = getXMLHttpRequest();

  httpRequest.addEventListener('loadend', function (e) {
    const result = e.currentTarget;
    if (result.status == 200) {
      switch (obj.dataType) {
        case 'xml':
          obj.success(result.responseXML);
          break;

        case 'json':
          obj.success(JSON.parse(result.responseText));
          break;

        default:
          obj.success(result.responseText);
          break;
      }
    }
    else {
      obj.error(result.status, result.response);
    }
  });

  let httpMethod = obj.type ? obj.type : 'GET';
  if (httpMethod != 'GET' && httpMethod != 'POST') {
    httpMethod = 'GET';
  }

  let httpUrl = obj.url;
  let params = (obj.data == null || obj.data == '') ? null : Object.keys(obj.data).map(function (k) {
    return encodeURIComponent(k) + '=' + encodeURIComponent(obj.data[k])
  }).join('&');

  if (httpMethod == 'GET' && params != null) {
    httpUrl = httpUrl + '?' + params;
  }

  //open() : 요청의 초기화, GET/POST 선택, 접속할 URL 입력, async(true)
  httpRequest.open(httpMethod, httpUrl, true);
  switch (obj.dataType) {
    case 'json':
      httpRequest.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
      break;

    default:
      httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  }

  //send() : web server에 요청을 전송.
  httpRequest.send(httpMethod == 'POST' ? params : null);
}