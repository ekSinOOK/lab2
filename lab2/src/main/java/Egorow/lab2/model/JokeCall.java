package Egorow.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "call")
@Table(name = "joke_call")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JokeCall {

    @Id
    @Column(name = "joke_call_id")
    @GeneratedValue(generator = "joke_call_gen_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "joke_call_gen_seq",sequenceName = "joke_call_gen_seq", initialValue = 1, allocationSize = 1)
    private Long callId;

    @CreationTimestamp
    @Column(name = "date_of_call")
    private LocalDateTime dateCall;

    @Column(name = "user_id")
    private Long userId;

    @JsonIgnore
    @OneToMany(mappedBy = "jokeCall", cascade = CascadeType.ALL)
    private List<JokeModel> jokeModel;

}