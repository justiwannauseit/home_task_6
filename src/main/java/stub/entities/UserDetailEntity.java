package stub.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDetailEntity {
    private final Long id;
    private final String name;
    private final String grade;
    private final String school_name;
    private final String city;
}
