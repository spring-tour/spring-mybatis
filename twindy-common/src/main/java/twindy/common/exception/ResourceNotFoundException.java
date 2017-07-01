package twindy.common.exception;

import org.apache.commons.lang3.StringUtils;

public class ResourceNotFoundException extends BaseException {

    private static final long serialVersionUID = 2547669165795745411L;

    private String resource;  //没有找到的资源
    private String relativeParams;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resource = null;
        this.relativeParams = null;
    }

    public ResourceNotFoundException(String message, String resource) {
        super(message);
        this.resource = resource;
        this.relativeParams = null;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.resource = null;
        this.relativeParams = null;
    }

    public String getRelativeParams() {
        return relativeParams;
    }

    public void setRelativeParams(String relativeParams) {
        this.relativeParams = relativeParams;
    }

    @Override
    public String getDetails() {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isEmpty(resource) && StringUtils.isEmpty(relativeParams)) {
            return null;
        } else {
            if (resource != null) {
                builder.append(" resource: " + resource);
            }
            if (relativeParams != null) {
                builder.append(" relativeParams: " + relativeParams);
            }
            return builder.toString();
        }
    }
}
