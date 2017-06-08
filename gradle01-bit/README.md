# Gradle 사용법
## gradle 설정 파일 준비하기
```
> gradle init
```

## gradle에서 사용할 수 있는 도구 확인하기
```
> gradle tasks
```

## gradle에 자바 빌드 도구 플러그인 추가하기
[build.gradle]
```
apply plugin: 'java'
```

gradle에 추가되었는지 확인하기
```
> gradle tasks --all
```

## gradle 자바 빌드 도구 사용하기
[자바 소스 컴파일하기]
```
gradle 명령 실행:
> gradle [명령(task) 이름]
> gradle compileJava

실행 결과:
build/classes/main/example/Hello.class 파일 생성 

```




