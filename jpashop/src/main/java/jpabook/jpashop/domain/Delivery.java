package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity @Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name ="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

//    @Enumerated(EnumType.ORDINAL)은 사용하면 안 된다.
    @Enumerated(EnumType.STRING)
    private DelieryStatus status; //READY, XXX, COMP
}
