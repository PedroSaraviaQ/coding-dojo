package com.example.dojosandninjas.services;

import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService extends BaseService<Ninja> {
    @Autowired NinjaRepository ninjaRepository;
}
