package tacos.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredient {

    @Id
    @Column(length = 4, nullable = false)
    private String id;

    @Column(length = 25, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGETABLE, OTHER, CHEESE, SAUCE
    }

}
