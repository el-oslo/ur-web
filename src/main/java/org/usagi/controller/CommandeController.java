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
import org.usagi.DAO.CommandeDAO;
import org.usagi.model.CommandeModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gestion/commandes")
public class CommandeController {
    private CommandeDAO commandeDao;

    @Autowired
    public void setCommandeDao(CommandeDAO commandeDao) {
        this.commandeDao = commandeDao;
    }

    @GetMapping
    public ModelAndView CommandeList() {
        List<CommandeModel> commandes = this.commandeDao.getAll();
        ModelAndView mav = new ModelAndView("commandePage");
        mav.addObject("commandes", commandes);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView CreateCommande(@ModelAttribute CommandeModel t, HttpServletRequest request) {
        int res = commandeDao.save(t);
        if (res == 1) {
            return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes");
        }
        return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes").addObject("error",
                "Failed to create command");
    }

    @PostMapping("/update")
    public ModelAndView UpdateCommande(@ModelAttribute CommandeModel updateValue, HttpServletRequest request) {
        CommandeModel commande = commandeDao.get(updateValue.getIdcom()).orElse(null);
        int res = 0;
        if (commande == null) {
            return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes").addObject("error",
                    "Command not found");
        }
        res = commandeDao.update(commande, updateValue);
        if (res == 1) {
            return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes");
        }
        return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes").addObject("error",
                "Failed to update command");
    }

    @GetMapping("/delete/{idcom}")
    public ModelAndView DeleteCommande(@PathVariable("idcom") String id, HttpServletRequest request) {
        CommandeModel commande = commandeDao.get(id).orElse(null);
        if (commande == null)
            return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes").addObject("error",
                    "Command not found");

        int res = commandeDao.delete(commande);
        if (res == 1)
            return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes");

        return new ModelAndView("redirect:" + request.getContextPath() + "/gestion/commandes").addObject("error",
                "Failed to delete command");
    }
}
