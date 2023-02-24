
i# book-doit-algorithm
## 😎준비
### 책:  do it 자료구조와 함께 배우는 알고리즘 입문:자바편
### 진행 시간 및 방식
- 매주 월목 2시 진행
- 매 스터디 전까지 한 주차 공부한 것과 연습문제  깃허브에 업로드
- 스터디에서 연습문제 위주 발표와 특별히 공유하고 싶은 것 어려웠던 것 공유

### 깃헙 관련 처리
- 마크다운 내보낼 때 whitespace 에러
![whitespace에러](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c10cc958-aa9b-403b-a22d-e2911ce4e99b/whitespace.png)
 - 리눅스 시스템은 줄 끝이 LF(Line Feed)고 윈도우는 CR(Carriage Return)과 LF인 CRLF로 이루어지기 때문에 에러가 발생한다.

 <br>

 - 윈도우에서는 CRLF 사용하므로 저장소에서 가져올 때 LF를 CRLF로 변경, 다시 내보낼 때는 CRLF를 LF로 변경

 ```bash
 git config --global core.autocrlf true
 ```
 - 리눅스는 원래 LF만 사용하므로 그대로 사용
 ```bash
 git config --global core.autocrlf input
 ```
