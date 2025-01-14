package racingcar.Controller;

import java.util.function.Supplier;
import java.util.function.Consumer;

public class ReEnterProcessor<T> {

    private final Supplier<T> processor;
    private final Consumer<IllegalArgumentException> consumer;

    public ReEnterProcessor(Supplier<T> processor, Consumer<IllegalArgumentException> consumer) {
        this.processor = processor;
        this.consumer = consumer;
    }

    public T process(){
        while (true) {
            try{
                return processor.get();
            }catch (IllegalArgumentException exception){
                consumer.accept(exception);
            }
        }
    }

}
