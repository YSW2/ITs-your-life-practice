package org.scoula.controller;

import org.scoula.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", service.getList());
        return "/board/list";  // templates/board/list.html로 이동
    }
}