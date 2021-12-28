package org.zerock.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
@Log4j2
public class GuestbookController {

  private final GuestbookService guestbookService;

  public GuestbookController(GuestbookService guestbookService) {
    this.guestbookService = guestbookService;
  }

  @GetMapping("/")
  public String list() {
    log.info("list................");
    return "/guestbook/list";
  }

  @GetMapping("/list")
  public void list(PageRequestDTO pageRequestDTO, Model model) {
    log.info("list................" + pageRequestDTO);
    model.addAttribute("result", guestbookService.getList(pageRequestDTO));
  }
}
