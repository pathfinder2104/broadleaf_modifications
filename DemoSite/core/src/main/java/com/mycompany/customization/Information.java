package com.mycompany.customization;

import java.io.Serializable;

/**
 * Created by ayushyadevmurari on 10/13/15.
 */
public interface Information extends Serializable{
    Long getId();

    void setId(Long id);

    String getType();

    void setType(String type);

    String getDetails();

    void setDetails(String details);
}
