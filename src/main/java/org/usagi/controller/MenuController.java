package org.usagi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.usagi.DAO.MenuDAO;
import org.usagi.model.MenuModel;

@Controller
@RequestMapping("/gestion/menus")
public class MenuController {
    private MenuDAO menuDao;

    @Autowired
    public void setMenuDao(MenuDAO menuDao) {
        this.menuDao = menuDao;
    }


    @GetMapping
    public ModelAndView MenuList() {
        List<MenuModel> menus = this.menuDao.getAll();
        ModelAndView mav = new ModelAndView("menuPage");
        mav.addObject("menus", menus);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView CreateMenu(@ModelAttribute MenuModel menu) {
        int res = menuDao.save(menu);
        if (res == 1) {
            return new ModelAndView("redirect: /gestion/menus");
        }
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/update")
    public ModelAndView UpdateMenu(@ModelAttribute MenuModel updateValue) {
        MenuModel menu = menuDao.get(updateValue.getIdplat()).orElse(null);
        int res = 0;
        if (menu != null) {
            res = menuDao.update(menu, updateValue);
        }
        if (res == 1) {
            return new ModelAndView("redirect: /gestion/menus");
        }
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/delete/{idplat}")
    public ModelAndView DeleteMenu(@PathVariable("idplat") String idplat) {
        MenuModel menu = menuDao.get(idplat).orElse(null);
        int res = 0;
        if (menu != null) {
            res = menuDao.delete(menu);
        }
        if (res == 1) {
            return new ModelAndView("redirect: /gestion/menus");
        }
        return new ModelAndView("redirect:/home");
    }

    
}
