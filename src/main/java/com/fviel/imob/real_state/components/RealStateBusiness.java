package com.fviel.imob.real_state.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import com.fviel.imob.person.entities.Person;
import com.fviel.imob.real_state.dao.RealStateDaoService;
import com.fviel.imob.real_state.dtos.RealStateDto;
import com.fviel.imob.real_state.entities.RealState;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RealStateBusiness {
    private final RealStateDaoService rsDaoService;
    //private final PersonRepository personRepository;

    public RealStateBusiness( RealStateDaoService rsDaoService){
        this.rsDaoService = rsDaoService;
        //this.personRepository = personRepository;
    }

    public boolean registerNewRealState(RealState rs, Person owner){
        try{
            rs.setOwner(owner);
            owner.getRealStateList().add(rs);
            rsDaoService.save(rs);
            return true;
        }catch(Exception e){
            log.error("Failed do add a new Real State");
            return false;
        }
    }   
    
    public List<RealStateDto> listAll(){
        List<RealState> rsList = new ArrayList<>(rsDaoService.getAllRealStates());
        List<RealStateDto> rsDtoList = new ArrayList<>();
        for(RealState rs : rsList){
            rsDtoList.add(new RealStateDto(rs.getAddress(), rs.getValue(), rs.getOwner()));
        }
        return rsDtoList;
    }
}
