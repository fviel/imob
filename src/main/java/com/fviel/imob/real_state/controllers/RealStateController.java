package com.fviel.imob.real_state.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.imob.real_state.components.RealStateBusiness;
import com.fviel.imob.real_state.dao.RealStateDaoService;
import com.fviel.imob.real_state.dtos.RealStateDto;
import com.fviel.imob.real_state.entities.RealState;

@RestController
@RequestMapping("/api/realstate")
public class RealStateController {

    private final RealStateDaoService rsDaoService;
    private final RealStateBusiness rsBusiness;
    public RealStateController(RealStateDaoService rsDaoService, RealStateBusiness rsBusiness){
        this.rsDaoService = rsDaoService;
        this.rsBusiness = rsBusiness;
    }

    @RequestMapping(value="/v1", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Set<RealState>> listAll(){
        Set<RealState> rss = new HashSet<>(rsDaoService.getAllRealStates());
        /*String response;
        Iterator iter = rss.iterator();
        while(iter.hasNext()){
            response += iter.next();
        }*/
        return ResponseEntity.ok(rss);
    }  
    
    @RequestMapping(value="/v2", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<RealStateDto>> listAllDto(){
        List<RealStateDto> rss = rsBusiness.listAll();
        return ResponseEntity.ok(rss);
    }  

    
}
