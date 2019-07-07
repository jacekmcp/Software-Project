package com.sp.stockmanager.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Set<Menu> getAllMenus() {
        Set<Menu> menus = new HashSet<>();

        menuRepository.findAll().forEach(menus::add);
        return menus;
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void updateMenu(Menu menu, Long id) {
        menu.setId(id);
        menuRepository.save(menu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
