package org.zerock.guestbook.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GuestbookDTO {

  private Long gno;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate, modDate;
}
