package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Home;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.HomeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> getAll() {
        return homeRepository.findAll();
    }

    public Home save(Home home) {
        return homeRepository.save(home);
    }

    public Home getById(Long id) {
        return homeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Home not found"));
    }

    public void deleteById(Long id) {
        homeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Home not found"));
        homeRepository.deleteById(id);
    }

    public Home updateById(Long id, Home home) {
        Home existsHome = homeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Home not found"));
        existsHome.setName(home.getName());
        return homeRepository.save(existsHome);
    }

}
