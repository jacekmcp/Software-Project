package com.sp.stockmanager.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public Set<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/menus/{id}")
    public Menu getMenuById(@PathVariable  Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping("/menus")
    public void addMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
    }

    @PutMapping("/menus/{id}")
    public void updateMenu(@RequestBody Menu menu, @PathVariable Long id) {
        menuService.updateMenu(menu, id);
    }

    @DeleteMapping("/menus/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
