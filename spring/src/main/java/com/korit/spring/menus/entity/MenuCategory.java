package com.korit.spring.menus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_categories")
@Getter
@Setter
@NoArgsConstructor
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private String menuCategory;

    @Builder
    public MenuCategory(Long id, Long storeId, String menuCategory) {
        this.id = id;
        this.storeId = storeId;
        this.menuCategory = menuCategory;
    }
}
