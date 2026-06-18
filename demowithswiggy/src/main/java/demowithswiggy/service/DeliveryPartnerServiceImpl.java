package demowithswiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demowithswiggy.entity.DeliveryPartner;
import demowithswiggy.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

    @Autowired
    private DeliveryPartnerRepository repo;

    @Override
    public DeliveryPartner addPartner(DeliveryPartner partner) {
        partner.setStatus("AVAILABLE");
        return repo.save(partner);
    }

    @Override
    public List<DeliveryPartner> getAllPartners() {
        return repo.findAll();
    }

    @Override
    public DeliveryPartner getPartnerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found"));
    }

    @Override
    public DeliveryPartner updateStatus(Long id, String status) {

        DeliveryPartner partner = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        partner.setStatus(status);

        return repo.save(partner);
    }
}