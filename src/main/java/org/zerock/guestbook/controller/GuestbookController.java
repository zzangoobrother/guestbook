package org.zerock.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.GuestbookDTO;
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

  @GetMapping("/register")
  public void register() {
    log.info("register get...");
  }

  @PostMapping("/register")
  public String registerPost(GuestbookDTO guestbookDTO, RedirectAttributes redirectAttributes) {
    log.info("dto..." + guestbookDTO);

    Long gno = guestbookService.register(guestbookDTO);

    redirectAttributes.addFlashAttribute("msg", gno);

    return "redirect:/guestbook/list";
  }

  @GetMapping("/read")
  public void read(long gno, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO, Model model) {
    log.info("gno : " + gno);
    GuestbookDTO dto = guestbookService.read(gno);
    model.addAttribute("dto", dto);
  }
}
