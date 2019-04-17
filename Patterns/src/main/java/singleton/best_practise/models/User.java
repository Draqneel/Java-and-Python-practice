package singleton.best_practise.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean isHuman;
}
