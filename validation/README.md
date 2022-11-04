# @RequestBody 검증하기

## 공부 배경
이전에 토이 프로젝트를 할 때는 HTML에서 form태그를 사용하여 데이터를 전송하고 @ModelAttribute를 통해 전달받았다. 그리고 @Validated 어노테이션과 BindingResult 등을 사용하여
객체를 검증하였다. 그런데 이번 블로그 프로젝트에서는 AJAX를 통해 JSON의 형태로 데이터를 POST하는 방식을 사용해봤는데 이 경우 데이터를 어떻게 검증해야하는지 몰라 공부를 하고 기록을 하려
한다.

https://mytempo.tistory.com/36
--> 블로그 정리
