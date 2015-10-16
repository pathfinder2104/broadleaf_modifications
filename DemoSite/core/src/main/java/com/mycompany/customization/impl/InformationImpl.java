package com.mycompany.customization.impl;

import com.mycompany.customization.Information;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ayushyadevmurari on 10/13/15.
 */
@Entity
@Table(name = "A_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
@AdminPresentationClass(friendlyName = "InformationImpl")
public class InformationImpl implements Information {

    @Id
    @GeneratedValue(
            generator = "InformationId"
    )
    @GenericGenerator(
            name = "InformationId",
            strategy = "org.broadleafcommerce.common.persistence.IdOverrideTableGenerator",
            parameters = {@org.hibernate.annotations.Parameter(
                    name = "segment_value",
                    value = "InformationImpl"
            ), @org.hibernate.annotations.Parameter(
                    name = "entity_name",
                    value = "InformationImpl"
            )}
    )
    @Column(name = "INFORMATION_ID")
    protected Long id;

    @Column(name = "TYPE")
    @AdminPresentation(friendlyName = "TYPE", visibility = VisibilityEnum.VISIBLE_ALL, prominent = true, order = 1)
    private String type;

    @Column(name = "DETAILS")
    @AdminPresentation(friendlyName = "DETAILS", visibility = VisibilityEnum.VISIBLE_ALL, prominent = true, order = 2)
    private String details;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public void setDetails(String details) {
        this.details = details;
    }
}
