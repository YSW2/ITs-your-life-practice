package org.scoula.icecream.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/icecream")
@RequiredArgsConstructor
public class IcecreamController {
    //    @GetMapping("/")
//    public String home() {
//        log.info("================> HomController /");
//        return "index"; // View의 이름
//    }

    final private IcecreamService service;

    @PostMapping("/new")
    public String newPost(IcecreamDTO dto) {
        service.create(dto);
        return "redirect:/icecream/list";
    }

    @GetMapping("/list")
    public void listGet(Model model) {
        List<IcecreamDTO> icecreamDTOList = service.findAll();
        model.addAttribute("list", icecreamDTOList);
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam("no") long no, Model model) {
        boolean deleteResult = service.delete(no);
        model.addAttribute("result", deleteResult);
        return "icecream/delete_result";
    }
}