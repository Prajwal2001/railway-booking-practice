package railway.booking.app.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Engine extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private Long EngineId;

    @Column(name = "max_speed")
    private Long maxSpeed;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "tot_dist_traveled")
    private Long totalDistanceTraveled;

    @Column(name = "manf_year")
    private LocalDateTime manufactureYear;

    @OneToMany(mappedBy = "engine")
    private List<Coach> coaches;

    @OneToOne(mappedBy = "engine")
    private Train train;
}
