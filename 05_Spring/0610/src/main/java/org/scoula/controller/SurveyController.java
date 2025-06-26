package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.SurveyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/survey")

public class SurveyController {
    private final ServletContext servletContext;
    Map<Integer, SurveyDTO> surveyMap = new HashMap<>();

    public SurveyController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping("")
    public String homeGet() {
        log.info("================> HomController /");
        return "survey/form"; // View의 이름
    }

    @PostMapping("")
    public String homePost(SurveyDTO survey) {
        int id = surveyMap.size();
        surveyMap.put(id, survey);

        return "redirect:survey/share?id=" + id;
    }

    @GetMapping("/share")
    public String shareGet(@RequestParam("id") int id, Model model) {
        SurveyDTO survey = surveyMap.get(id);
        model.addAttribute("name", survey.getName());
        model.addAttribute("ment", survey.getMent());
        model.addAttribute("link", survey.getLink());
        model.addAttribute("id", id);
        log.info(survey.getName());
        return "survey/share";
    }

    @GetMapping("/upload")
    public String uploadGet(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "survey/upload";
    }

    @PostMapping("/upload")
    public String uploadPost(MultipartFile file, @RequestParam("id") int id) {
        SurveyDTO dto = surveyMap.get(id);
        if (dto == null || file.isEmpty()) return "error/404";

        String uploadDir = servletContext.getRealPath("/resources/uploads/");
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String fileName = id + "_" + timeStamp + "_" + file.getOriginalFilename();
        File saveFile = new File(dir, fileName);

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            log.error("업로드 실패: " + e.getMessage());
            return "error/404";
        }
        log.info(saveFile);
        // 업로드 성공 후 다음 단계로
        return "redirect:/survey/report?id=" + id;
    }

    @GetMapping("/report")
    public String reportGet(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        SurveyDTO survey = surveyMap.get(id);

        if (survey == null) return "error/404";

        model.addAttribute("survey", survey);

        String uploadDir = servletContext.getRealPath("/resources/uploads/");
        File dir = new File(uploadDir);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.startsWith(id + "_"));
            if (files != null && files.length > 0) {
                // 가장 최신 파일만 가져오기
                String imageFileName = files[files.length - 1].getName();
                model.addAttribute("uploadedImage", imageFileName);
            }
        }
        log.info(uploadDir);
        return "survey/report";
    }
}