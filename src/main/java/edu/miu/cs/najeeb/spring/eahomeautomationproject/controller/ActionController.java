package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Action;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.TriggerActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ActionController {
    private final TriggerActionService actionService;

    public ActionController(TriggerActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public List<Action> getTriggers() {
        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public Action getActionById(@PathVariable Long id) {
        return actionService.getActionById(id);
    }

    @PostMapping
    public Action createAction(@RequestBody Action action) {
        return actionService.createAction(action);
    }

    @PutMapping("/{id}")
    public Action updateAction(@PathVariable Long id, @RequestBody Action action) {
        actionService.updateAction(id, action);
        return action;
    }

    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
    }
}
