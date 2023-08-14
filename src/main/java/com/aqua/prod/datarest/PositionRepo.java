package com.aqua.prod.datarest;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.entity.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends GenericRepo<Position, Integer> {
}