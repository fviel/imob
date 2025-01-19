package com.fviel.imob.real_state.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fviel.imob.real_state.entities.RealState;
import com.fviel.imob.real_state.repositories.RealStateRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RealStateDaoService {
    private final RealStateRepository rsRepository;

    public RealStateDaoService(RealStateRepository rsRepository){        
        this.rsRepository = rsRepository;
    }

    public Set<RealState> getAllRealStates(){        
        Set<RealState> response = new HashSet<>(rsRepository.findAll());
        log.info("RealStateDaoService.getAllRealStates - Found " + response.size() + " items");
        return response;
    }

    public Optional<RealState> getRealStateById(UUID id){
        return rsRepository.findById(id);
    }

    public RealState save(RealState rs){
        return rsRepository.save(rs);
    }

    public void deleteRealStateById(UUID id){
        rsRepository.deleteById(id);
    }
}
