package org.zerock.guestbook.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
class GuestbookServiceTest {

  @Autowired
  private GuestbookService service;

  @Test
  void testRegister() {
    GuestbookDTO guestbookDTO = GuestbookDTO.builder()
        .title("Sample Title...")
        .content("Sample Content...")
        .writer("user0")
        .build();

    System.out.println(service.register(guestbookDTO));
  }

  @Test
  void testList() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .build();

    PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

    for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
      System.out.println(guestbookDTO);
    }
  }
}