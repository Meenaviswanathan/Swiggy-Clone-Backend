package demowithswiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demowithswiggy.entity.DeliveryPartner;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {
}