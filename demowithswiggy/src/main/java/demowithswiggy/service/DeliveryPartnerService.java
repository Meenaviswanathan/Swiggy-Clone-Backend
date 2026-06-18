package demowithswiggy.service;

import java.util.List;
import demowithswiggy.entity.DeliveryPartner;

public interface DeliveryPartnerService {

    DeliveryPartner addPartner(DeliveryPartner partner);

    List<DeliveryPartner> getAllPartners();

    DeliveryPartner getPartnerById(Long id);

    DeliveryPartner updateStatus(Long id, String status);
}