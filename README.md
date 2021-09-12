# 20210908_ Initialize Project
using https://start.spring.io/
- Gradle Project
- 2.5.4
- Dependencies
-- Spring Web
-- Thymeleaf

# 20210911_ [ADD] Welcome Page, Controller

Example of Controller.java
```java
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello"; // return -> viewResolver
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) { // required 기본은 true
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // response body 부분에 return 데이터 그대로 출력
    public String helloString(@RequestParam("name") String name) {
        return "<h1>hello " + name + "</h1>";
    }

    // 데이터 반환 시
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // JSON 출력
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
```

### How to Build And Run
- 프로젝트 폴더 이동 후
```
$ ./gradlew build
$ cd build/libs
$ ls // jar 파일명 copy
java -jar [paste].jar // 실행
$^c // 종료

// build 파일에 문제 있는 경우
$ ./gradlew clean build
```

## MVC : Model-View-Controller

# 20210911_ [ADD] MemoryMemberRepositoryTest
## Test Case
- @Test가 여러 개 존재할 때 실행 순서는 랜덤.
- @Test가 끝날 때 마다 저장소 데이터 클리어 해 주어야 함 -> @afterEach 사용


# 20210912_ [ADD] MemberController

### 컴포넌트 스캔과 자동 의존관계 설정
- @Component : @Controller, @Service, @Repository
- @Autowired : 생성자 DI 자동 주입
- +) 스프링 컨테이너에 스프링 빈 등록 시, 기본으로 싱글톤으로 등록(하나만 등록하여 공유)
   = 같은 스프링 빈이면 모두 같은 인스턴스.

### 자바 코드로 스프링 빈 등록
- AppConfig.java
- @Bean으로 직접 등록

# 20210912_ [ADD] ddl.sql
- ADD ddl.sql
- JDBC 설정
  - application.properties
  - build.gradle