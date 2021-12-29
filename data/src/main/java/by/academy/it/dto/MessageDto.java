package by.academy.it.dto;

import by.academy.it.pojo.User;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDto {
    private Long id;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private String value;
    private String status;
    private Date timestamp;
    private User users;
}
