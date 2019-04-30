//package org.minbox.value.security.minboxvaluesecurity;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@SpringBootApplication
//@RestController
//public class MinboxValueSecurityApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MinboxValueSecurityApplication.class, args);
//        System.out.println("启动完成");
//    }
//    @RequestMapping(value = "/a1", method = RequestMethod.GET)
//    public String a1() throws Exception {
//        return  "aaa";
//    }
//    @RequestMapping(value = "/a2", method = RequestMethod.GET)
//    @NotAuth
//    public String a2() throws Exception {
//        return  "aaa";
//    }
//}
