package oca.enthuware.test2;

public class Q21 {

    class ChannelException extends Exception {}
    class DataFloodingException extends ChannelException {}
    class FrameCollisionException extends DataFloodingException {}

    class TransSocket {
        long connect(String ip) throws ChannelException {
           return 0L;
        }
    }

    class AdvancedTransSocket extends TransSocket {
        long connect(String i) throws ChannelException, DataFloodingException, FrameCollisionException {
            return 0L;
        }
    }
}
