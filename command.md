# 통합 테스트 curl


> 회원등록
```sh
curl -X POST "http://localhost:8083/api/Member/" -H "accept: */*" -H "Content-Type: application/json" -d "{\"email\":\"scant10@gmail.com\",\"id\":\"jenny\",\"name\":\"제니\",\"passWord\":\"1111\"}"
```

> 도서대여
```sh
curl -X POST "http://localhost:8082/api/book" -H "accept: */*" -H "Content-Type: application/json" -d "{\"author\":\"한정헌\",\"classification\":\"LITERATURE\",\"description\":\"고전 소설\",\"isbn\":\"1232141214\",\"location\":\"JEONGJA\",\"publicationDate\":\"2023-02-11\",\"source\":\"SUPPLY\",\"title\":\"누구를 위하여 종을 울리나?\"}"
```

> 대여상태 조회
```sh
curl -X GET "http://localhost:8082/api/book/1" -H "accept: */*"
```

> 도서 카드 등록  
```sh
curl -X POST "http://localhost:8081/api/RentalCard/" -H "accept: */*" -H "Content-Type: application/json" -d "{\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 도서 대여  
```sh
curl -X POST "http://localhost:8081/api/RentalCard/rent" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":1,\"itemTitle\":\"누구를 위하여 종을 울리나?\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 도서 상태 확인(대여불가)
```sh
curl -X GET "http://localhost:8082/api/book/1" -H "accept: */*"
```

> 회원 포인트 확인
```sh
curl -X GET "http://localhost:8083/api/Member/1" -H "accept: */*"
```

> 베스트 도서 확인
```sh
curl -X GET "http://localhost:8084/api/books" -H "accept: */*"
```

> 도서 반남
```sh
curl -X POST "http://localhost:8081/api/RentalCard/return" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":1,\"itemTitle\":\"누구를 위하여 종을 울리나?\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 도서 상태 확인
```sh
curl -X GET "http://localhost:8082/api/book/1" -H "accept: */*"
```

> 회원 포인트 확인
```sh
curl -X GET "http://localhost:8083/api/Member/1" -H "accept: */*"
```

> 2번째 도서 등록
```sh
curl -X POST "http://localhost:8082/api/book" -H "accept: */*" -H "Content-Type: application/json" -d "{\"author\":\"최재천\",\"classification\":\"LITERATURE\",\"description\":\"최재천의 인생공부\",\"isbn\":\"1232141214\",\"location\":\"JEONGJA\",\"publicationDate\":\"2023-01-11\",\"source\":\"SUPPLY\",\"title\":\"최재천의공부\"}"
```

> 2번째 도서 대여
```sh
curl -X POST "http://localhost:8081/api/RentalCard/rent" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":2,\"itemTitle\":\"최재천의공부\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 도서상태 확인 
```sh
curl -X GET "http://localhost:8082/api/book/2" -H "accept: */*"
```

> 회원포인트는 30으로 증가
```sh
curl -X GET "http://localhost:8083/api/Member/1" -H "accept: */*"
```

> 연체
```sh
curl -X POST "http://localhost:8081/api/RentalCard/overdue" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":2,\"itemTitle\":\"최재천의공부\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 연체
```sh
curl -X POST "http://localhost:8081/api/RentalCard/overdue" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":2,\"itemTitle\":\"최재천의공부\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```


> 도서카드 상태 확인 - 도서대여정지 상태
```sh
curl -X GET "http://localhost:8081/api/RentalCard/jenny" -H "accept: */*"
```


> 연체 도서 반납
```sh
curl -X POST "http://localhost:8081/api/RentalCard/return" -H "accept: */*" -H "Content-Type: application/json" -d "{\"itemId\":2,\"itemTitle\":\"최재천의공부\",\"userId\":\"jenny\",\"userNm\":\"제니\"}"
```

> 도서카드 상태 확인 - 대여 불가
```sh
curl -X GET "http://localhost:8081/api/RentalCard/jenny" -H "accept: */*"
```

> 회원 조회 - 반납했으므로 포인트 40으로 증가 
```sh
curl -X GET "http://localhost:8083/api/Member/1" -H "accept: */*"
```

> 대여정지해제 처리 
```sh
curl -X POST "http://localhost:8081/api/RentalCard/clearoverdue" -H "accept: */*" -H "Content-Type: application/json" -d "{\"userId\":\"jenny\",\"userNm\":\"제니\",\"point\":10}"
```

> 회원정보 조회 - 대여정지 해제했으므로 10포인트 차감되어 30포인트.  
```sh
curl -X GET "http://localhost:8083/api/Member/1" -H "accept: */*"
```

> 도서카드 상태 확인 - 대여 가능
```sh
curl -X GET "http://localhost:8081/api/RentalCard/jenny" -H "accept: */*"
```


