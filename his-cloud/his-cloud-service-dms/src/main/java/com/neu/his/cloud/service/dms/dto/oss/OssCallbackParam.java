package com.neu.his.cloud.service.dms.dto.oss;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class OssCallbackParam implements Serializable {
    private String callbackUrl;
    private String callbackBody;
    private String callbackBodyType;

}
