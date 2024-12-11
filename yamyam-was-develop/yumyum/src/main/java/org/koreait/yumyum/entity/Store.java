package org.koreait.yumyum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "stores")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "owner_id", nullable = false)
    @OneToOne
    private User user;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDateTime openingTime;

    @Column(nullable = false)
    private LocalDateTime closingTime;

    @Column(length = 200)
    private LocalTime breakStartTime;

    @Column(length = 200)
    private LocalTime breakEndTime;

    @Column(length = 500)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String description;
}