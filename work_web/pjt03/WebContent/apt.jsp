<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>구해줘 홈즈</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="${ root }/style.css" />
<link rel="shortcut icon" href="${ root }/images/favicon.png"
	type="image/x-icon" />
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous" defer></script>
	
<script src="${ root }/js/toggleNav.js" defer></script>
<script src="${ root }/js/getHouseInfo.js" defer></script>
<script src="${ root }/js/getDate.js" async></script>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="/include/header.jsp"%>
	<!-- 헤더 끝-->
	<main class="apt2__main"> <header class="container">
		<h1 class="text-center my-3">연립주택 매매정보</h1>
		<div class="row col-md-12 justify-content-center mb-2">
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="sido">
					<option value="">시도선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="gugun">
					<option value="">구군선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="dong">
					<option value="">동선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-dark text-light" id="year"></select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-dark text-light" id="month">
					<option value="">매매월선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<button type="button" id="list-btn" class="btn btn-outline-primary">
					연립주택 매매정보 가져오기</button>
			</div>
		</div>
	</header> 
	<section>
        <aside class="apt2__list--info">
          <div>
            <ul id="apart-info">
            
            </ul>
          </div>
        </aside>
        <article class="apt2__list--map" id="apt2_map"></article>
      </section>
	</main>
	<!-- 푸터 -->
	<%@ include file="/include/footer.jsp"%>
	<!-- 푸터 끝-->
	<script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74841755f071e21c8b76c72f110f7f23&libraries=services"
    ></script>
    <script>
	const $sido = document.querySelector("#sido");
	const $gugun = document.querySelector("#gugun");
	const $dong = document.querySelector("#dong");
	
	// 시, 도 이름을 불러오는 함수
    const getSidoNames = async () => {
        const url = '${ root }/apart?act=getsido';

        const response = await fetch(url, { method: 'GET' });
        const data = await response.json();

        let options = `<option value="">시도선택</option>`;

        Object.keys(data).forEach(key => {
          options += `<option value="\${ key }">\${ data[key] }</option>`;
        });
        
        $sido.innerHTML = options;
    };
  
    // 구, 군 이름을 불러오는 함수
    const getGugunNames = async (e) => {
    	let sidoCode = e.target.value;
    	if(sidoCode){
    		const url = '${ root }/apart?act=getgugun&' + new URLSearchParams({
    			sidoCode
    		});
            
            const response = await fetch(url, { method: 'GET' });
            const data = await response.json();

            let options = `<option value="">구군선택</option>`;

            Object.keys(data).forEach(key => {
              options += `<option value="\${ key }">\${ data[key] }</option>`;
            });
            
            $gugun.innerHTML = options;
    	} else {
    		initOption("gugun");
    		initOption("dong");
    	}
        
    };
    // 동 이름을 불러오는 함수
    const getDongNames = async (e) => {
    	let gugunCode = e.target.value;
    	if(gugunCode){
	        const url = '${ root }/apart?act=getdong&' + new URLSearchParams({
	        	 gugunCode
			});
	        
	        const response = await fetch(url, { method: 'GET' });
	        const data = await response.json();
	
	        let options = `<option value="">동선택</option>`;
	
	        Object.keys(data).forEach(key => {
	          options += `<option value="\${ key }">\${ data[key] }</option>`;
	        });
	        
	        $dong.innerHTML = options;
    	} else {
    		initOption("dong");
    	}
    };
    
   
	
    // 창이 열리면 시, 도 이름을 불러온다.
    window.onload = getSidoNames;
    // 시 도 select를 바꾸면 구군을 불러온다.
    $sido.addEventListener("change", getGugunNames);
    // 구 군 select를 바꾸면 동을 불러온다.
    $gugun.addEventListener("change", getDongNames);
      
    </script>
</body>
</html>
