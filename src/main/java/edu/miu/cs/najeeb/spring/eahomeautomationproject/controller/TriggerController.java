package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Trigger;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.TriggerActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/triggers")
public class TriggerController {
    private final TriggerActionService triggerService;

    public TriggerController(TriggerActionService triggerService) {
        this.triggerService = triggerService;
    }

    @GetMapping
    public List<Trigger> getTriggers() {
        return triggerService.getAllTriggers();
    }

    @GetMapping("/{id}")
    public Trigger getTriggerById(@PathVariable Long id) {
        return triggerService.getTriggerById(id);
    }

    @PostMapping
    public Trigger createTrigger(@RequestBody Trigger trigger) {
        return triggerService.createTrigger(trigger);
    }

    @PutMapping("/{id}")
    public Trigger updateTrigger(@PathVariable Long id, @RequestBody Trigger trigger) {
        triggerService.updateTrigger(id, trigger);
        return trigger;
    }

    @DeleteMapping("/{id}")
    public void deleteTrigger(@PathVariable Long id) {
        triggerService.deleteTrigger(id);
    }
}
