package twindy.common.exception;

/**
 * 服务器内部发生异常抛出的异常
 */
public class ServerInternalException extends BaseException {

    private static final long serialVersionUID = -6559680102152709139L;

    public ServerInternalException(String message) {
        super(message);
    }

    public ServerInternalException(String message, Object[] formatValues) {
        super(message, formatValues);
    }

    public ServerInternalException(String message, Throwable cause) {
        super(message, cause);
    }
}
