package org.scoula.service;

import org.scoula.dto.MessageDTO;

public interface MessageService {
    public Integer sendMessage(MessageDTO dto);
}
