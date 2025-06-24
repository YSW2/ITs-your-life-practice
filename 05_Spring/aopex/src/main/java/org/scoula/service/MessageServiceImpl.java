package org.scoula.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.MessageDTO;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    @Override
    public Integer sendMessage(MessageDTO dto) {
        log.info("메시지 전송됨: " + dto.getContent());
        return 0;
    }
}
