package yhb.emittor;

import yhb.emittor.impl.Today;

public class Context {

    public static void main(String[] args) {
        IEmitter emitter = new Today();
        for (int i = 0; i < 10; i++) {
            System.out.println(emitter.emit("Sa", "saihi", "sahiuha"));
        }
    }
}
