package com.korit.spring.menus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long categoryId;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT '/images/profile/default1.png'")
    private String imageUrl;

    private String menuDescription;

    @Column(nullable = false)
    private int menuPrice;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isAvailable;

    @Builder
    public Menu(String menuName, String imageUrl, String menuDescription, int menuPrice, Boolean isAvailable) {
        this.menuName = menuName;
        this.imageUrl = imageUrl;
        this.menuDescription = menuDescription;
        this.menuPrice = menuPrice;
        this.isAvailable = isAvailable;
    }
}
