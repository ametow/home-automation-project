package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Action;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Trigger;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.ActionRepository;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.TriggerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriggerActionService {
    private final TriggerRepository triggerRepository;
    private final ActionRepository actionRepository;

    public TriggerActionService(TriggerRepository triggerRepository, ActionRepository actionRepository) {
        this.triggerRepository = triggerRepository;
        this.actionRepository = actionRepository;
    }

    public List<Trigger> getAllTriggers() {
        return triggerRepository.findAll();
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Trigger createTrigger(Trigger trigger) {
        return triggerRepository.save(trigger);
    }

    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    public Trigger getTriggerById(Long id) {
        return triggerRepository.findById(id).orElse(null);
    }

    public Action getActionById(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

    public void updateTrigger(Long id, Trigger trigger) {
        triggerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trigger not found"));
        trigger.setId(id);
        triggerRepository.save(trigger);
    }

    public void updateAction(Long id, Action action) {
        actionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Action not found"));
        actionRepository.save(action);
    }

    public void deleteTrigger(Long id) {
        triggerRepository.deleteById(id);
    }

    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }

}
