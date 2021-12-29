package by.academy.it.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserMessages implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String recipientId;
    private String value;
    private String status;
    private Date timestamp;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "senderId")
    private User user;
}