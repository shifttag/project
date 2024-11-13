package com.korit.spring.menus.repository;

import com.korit.spring.menus.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
