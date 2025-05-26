package org.usagi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.usagi.DAO.ReserverDAO;
import org.usagi.model.ReserverModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gestion/reserver")
public class ReserverController {
    private ReserverDAO reserverDao;

    @Autowired
    public void setReserverDao(ReserverDAO reserverDao) {
        this.reserverDao = reserverDao;
    }

    @GetMapping
    public ModelAndView ReserverList() {
        List<ReserverModel> reservations = this.reserverDao.getAll();
        ModelAndView mav = new ModelAndView("reserverPage");
        mav.addObject("reservations", reservations);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView CreateReservation(ReserverModel reservation, HttpServletRequest request) {
        int res = reserverDao.save(reservation);
        if (res == 1) {
            return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver");
        }
        
        return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver").addObject("error", "Failed to create reservation");
    }

    @PostMapping("/update")
    public ModelAndView UpdateReservation(ReserverModel updateValue, HttpServletRequest request) {
        ReserverModel reservation = reserverDao.get(updateValue.getIdreserv()).orElse(null);
        if (reservation == null) {
            return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver").addObject("error", "Reservation not found");
        }
        int res = reserverDao.update(reservation, updateValue);
        if (res == 1) {
            return new ModelAndView("redirect:/gestion/reserver");
        }
        return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver").addObject("error", "Failed to update reservation");
    }

    @GetMapping("/delete/{idreserve}")
    public ModelAndView DeleteReservation(@PathVariable("idreserve") String idreserve,  HttpServletRequest request) {
        ReserverModel reservation = reserverDao.get(idreserve).orElse(null);
        if (reservation == null) {
            return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver").addObject("error", "Reservation not found");
        }
        int res = reserverDao.delete(reservation);
        if (res == 1) {
            return new ModelAndView("redirect:/gestion/reserver");
        }
        return new ModelAndView("redirect:"+request.getContextPath() +"/gestion/reserver").addObject("error", "Failed to delete reservation");
    }
}
