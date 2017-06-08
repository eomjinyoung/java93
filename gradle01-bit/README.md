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
src/main/java/ 폴더의 모든 자바 소스 파일을 컴파일 한 후 그 결과를 
build/classes/main/ 폴더에 저장한다.
예) 
build/classes/main/example/Hello.class 파일 생성 

```

[빌드 관련 모든 폴더와 파일 제거하기]
```
> gradle clean

실행 결과:
build 폴더가 제거된다. 

```

[resources 폴더 파일을 빌드 폴더에 복사하기]
```
> gradle processResources

실행 결과:
src/main/resources/ 폴더의 모든 파일이 build/resources/main/ 폴더에 복사된다.

```

[compileJava + processResources = classes]
```
> gradle classes

실행 결과:
compileJava와 processResources 명령을 모두 실행한 결과이다.

```

[JAR 배포 파일 만들기]
```
> gradle jar

실행 결과:
classes 명령을 실행한 후 
/build/libs/ 폴더에 .jar 파일을 생성한다.

```

[빌드 전 과정을 실행하기]
```
> gradle build

실행 결과:
컴파일 --> 단위 테스트 --> JAR 파일 생성 등 빌드 전과정을 실행한다. 

```

## gradle에 이클립스 플러그인 추가하기
[build.gradle]
```
apply plugin: 'eclipse'
```

gradle에 추가되었는지 확인하기
```
> gradle tasks --all
```

## 이클립스 플러그인 사용하기
[이클립스 프로젝트 설정 파일 만들기]
```
> gradle eclipseProject

실행 결과:
.project 파일이 생성된다. 

```

[이클립스 프로젝트 설정 파일 삭제하기]
```
> gradle cleanEclipseProject

실행 결과:
.project 파일을 제거한다. 

```

[이클립스 관련 모든 설정 파일 만들기]
```
> gradle eclipse

실행 결과:
플러그인이 있다면 그 플러그인과 관련된 이클립스 설정 파일도 만든다.
만약 따로 플러그인이 등록되지 않았다면 단지 .project 파일만 생성될 것이다.

```

[이클립스 관련 모든 설정 파일 삭제하기]
```
> gradle cleanEclipse

실행 결과:
플러그인이 있다면 그 플러그인과 관련된 이클립스 설정 파일을 모두 지운다.
만약 따로 플러그인이 등록되지 않았다면 단지 .project 파일만 제거될 것이다.

```

## 웹 프로젝트 만들기
[웹 관련 플러그인 등록]
[build.gradle]
```
apply plugin: 'eclipse-wtp'
apply plugin: 'war'
```

[gradle에 추가되었는지 확인하기]
```
> gradle tasks --all
```





