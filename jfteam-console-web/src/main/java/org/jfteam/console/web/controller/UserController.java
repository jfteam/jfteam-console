package org.jfteam.console.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fengwenping
 * Date: 2017-09-11
 * Time: 下午9:36
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public List<String> list() {
        return new ArrayList();
    }
}
