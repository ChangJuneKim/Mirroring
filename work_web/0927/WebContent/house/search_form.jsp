<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">

		<h2>글 등록</h2>
		<header class="container">
			<h1 class="text-center my-3">아파트 매매 정보</h1>
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
						아파트매매정보가져오기</button>
				</div>
			</div>
		</header>
	</div>
	<%-- --%>
	<script>
		window.onload = function(){
			// 시도 정보 얻기
			const url = '${ root }' + '/rest/house/sido';
			
			fetch(url, {
				method : "GET"
			})
			.then((response) => response.json())
			.then((data) => { 
				let options = `<option value="">시도선택</option>`;
				Object.keys(data).forEach(function(key){
					options += `<option value="\${ key }">\${ data[key] }</option>`;
				});
				
				document.querySelector("#sido").innerHTML = options;
			});
			
			document.querySelector("#sido").addEventListener("change", function() {
				let sidoCode = this[this.selectedIndex].value;
				
				// 구군 정보 얻기
				const url = '${ root }' + '/rest/house/gugun?' + new URLSearchParams({
					sidoCode : sidoCode
				});
				
				fetch(url, {
					method : 'GET'
				})
				.then((response) => response.json())
				.then((data) => {
					let options = `<option value="">구군선택</option>`;
					Object.keys(data).forEach(function(key){
						options += `<option value="\${ key }">\${ data[key] }</option>`;
					});
					
					document.querySelector("#gugun").innerHTML = options;
				});
			});
			
			// 연립다세대 API 호출을 위한 요청 fetch 작성
			const rowHouseUrl = '${ root }' + '/rest/house/row-house/trade?' + new URLSearchParams({
				regionCode : "11110",
				dealYmd : "202112"
			});
			
			fetch(rowHouseUrl, {
				method : 'GET'
			})
			.then((response) => response.json())
			.then((data) => {
				console.log(data);
			})
		}
	</script>
	<%@ include file="/include/footer.jsp"%>