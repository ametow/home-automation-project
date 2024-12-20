package edu.miu.cs.najeeb.spring.eahomeautomationproject.repository;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepositoryCustomImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Device> findDevicesByState(String state) {
        String query = "select d from Device d JOIN d.room r JOIN r.home h where h.address.state = :state";
        TypedQuery<Device> typedQuery = entityManager.createQuery(query, Device.class);
        typedQuery.setParameter("state", state);
        return typedQuery.getResultList();
    }

    public List<Device> findDevicesByManufacturerAndMinEnergy(String manufacturer, Double minEnergy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> query = cb.createQuery(Device.class);
        Root<Device> device = query.from(Device.class);

        Predicate manufacturerPredicate = cb.equal(device.get("manufacturer"), manufacturer);
        Predicate energyPredicate = cb.greaterThanOrEqualTo(device.get("energyConsumptionPerHour"), minEnergy);

        query.select(device).where(cb.and(manufacturerPredicate, energyPredicate));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Device> findDevicesByRoomId(Long roomId) {
        String query = "select d from Device d JOIN d.room r where r.id = :roomId";
        TypedQuery<Device> typedQuery = entityManager.createQuery(query, Device.class);
        typedQuery.setParameter("roomId", roomId);
        return typedQuery.getResultList();
    }

}
