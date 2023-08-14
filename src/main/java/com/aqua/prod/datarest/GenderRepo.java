package com.aqua.prod.datarest;

import com.aqua.prod.common.GenericRepo;
import com.aqua.prod.entity.Gender;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends GenericRepo<Gender, Long> {
}