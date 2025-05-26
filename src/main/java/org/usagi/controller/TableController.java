package org.usagi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.usagi.DAO.TableDAO;
import org.usagi.model.TableModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gestion/tables")
public class TableController {
     private TableDAO tableDao;

    @Autowired
    public void setTableDao(TableDAO tableDao) {
        this.tableDao = tableDao;
    }

    @GetMapping
    public ModelAndView MenuList() {
        List<TableModel> menus = this.tableDao.getAll();
        ModelAndView mav = new ModelAndView("tablePage");
        mav.addObject("tables", menus);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView CreateTable(@ModelAttribute TableModel t, HttpServletRequest request) {
        int res = tableDao.save(t);
        if (res == 1) {
            return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables");
        }
        return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables").addObject("error", "Failed to create table");
    }

    @PostMapping("/update")
    public ModelAndView UpdateTable(@ModelAttribute TableModel updateValue, HttpServletRequest request) {
        TableModel table = tableDao.get(updateValue.getId()).orElse(null);
        int res = 0;
        if (table != null) {
            res = tableDao.update(table, updateValue);
        }
        if (res == 1) {
            return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables");
        }
        return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables").addObject("error", "Failed to create table");
    }

    @GetMapping("/delete/{idtable}")
    public ModelAndView DeleteTable(@PathVariable("idtable") String id, HttpServletRequest request) {
        TableModel table = tableDao.get(id).orElse(null);
        int res = 0;
        if (table != null) {
            res = tableDao.delete(table);
        }
        if (res == 1) {
            return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables");
        }
        return new ModelAndView("redirect:"+request.getContextPath()+"/gestion/tables").addObject("error", "Failed to delete table");
    }

}
