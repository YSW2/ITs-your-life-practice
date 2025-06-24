package org.scoula.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.dto.MessageDTO;
import org.scoula.service.MessageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping("/api/send")
    public ResponseEntity<String> getMessage(MessageDTO dto) throws Exception {
        service.sendMessage(dto);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
                .body("메세지 전송 완료");
    }

}
