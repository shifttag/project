package org.koreait.yumyum.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_categories")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String menuCategory;

    @Column(nullable = false)
    private int menuCategorySequence;


}
