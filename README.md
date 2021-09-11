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
