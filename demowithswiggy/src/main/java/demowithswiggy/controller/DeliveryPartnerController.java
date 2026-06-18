package demowithswiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demowithswiggy.entity.DeliveryPartner;
import demowithswiggy.service.DeliveryPartnerService;

@RestController
@RequestMapping("/delivery-partners")
public class DeliveryPartnerController {

    @Autowired
    private DeliveryPartnerService service;

    // 🔥 Add partner
    @PostMapping
    public DeliveryPartner add(@RequestBody DeliveryPartner partner) {
        return service.addPartner(partner);
    }

    // 🔥 Get all partners
    @GetMapping
    public List<DeliveryPartner> getAll() {
        return service.getAllPartners();
    }

    // 🔥 Get by id
    @GetMapping("/{id}")
    public DeliveryPartner getById(@PathVariable Long id) {
        return service.getPartnerById(id);
    }

    // 🔥 Update status (AVAILABLE / BUSY)
    @PutMapping("/{id}/status")
    public DeliveryPartner updateStatus(@PathVariable Long id,
                                        @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}