package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookService {

  Long register(GuestbookDTO dto);

  default Guestbook dtoToEntity(GuestbookDTO dto) {
    return Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
  }
}
