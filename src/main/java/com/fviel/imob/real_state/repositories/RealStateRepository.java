package com.fviel.imob.real_state.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fviel.imob.real_state.entities.RealState;

public interface RealStateRepository extends JpaRepository<RealState, UUID>{
    
}
