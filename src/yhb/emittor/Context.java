package yhb.emittor;

import yhb.emittor.impl.DateTimeBefore;

public class Context {

    public static void main(String[] args) {
        IEmitter emitter = new DateTimeBefore();
        for (int i = 0; i < 10; i++) {
            System.out.println(emitter.emit("1999-10-1 05:5","10"));
        }
    }
}
