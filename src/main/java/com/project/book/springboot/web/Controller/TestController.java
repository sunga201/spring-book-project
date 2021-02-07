package com.project.book.springboot.web.Controller;

import com.project.book.springboot.web.vo.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public String hello(){
        return "hello";
    }

    /*@GetMapping("/test/list")
    public List<TestVo> PeopleList(){
        List<TestVo> list = new ArrayList<>();
        TestVo t1 = new TestVo(1L, "Kim", 19);
        TestVo t2 = new TestVo(2L, "Choi", 22);
        TestVo t3 = new TestVo(3L, "Hong", 16);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        return list;
    }*/

    @GetMapping("/test/map")
    public Map<Integer, TestVo> PeopleMap(){
        Map<Integer, TestVo> map = new HashMap<>();
        TestVo t1 = new TestVo(1L, "Kim", 19);
        TestVo t2 = new TestVo(2L, "Choi", 22);
        TestVo t3 = new TestVo(3L, "Hong", 16);
        map.put(1, t1);
        map.put(2, t2);
        map.put(3, t3);
        return map;
    }
}
