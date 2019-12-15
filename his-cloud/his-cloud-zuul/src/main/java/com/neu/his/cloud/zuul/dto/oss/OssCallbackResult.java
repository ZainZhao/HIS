package com.neu.his.cloud.zuul.dto.oss;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OssCallbackResult {
    private String filename;
    private String size;
    private String mimeType;
    private String width;
    private String height;


}
