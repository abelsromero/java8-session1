package com.everis.digit.overview;

/**
 * Let's see what FunctionalInterfaces, Lambdas add to the menu!
 */
public class FunctionalInterfaceExample {


    @FunctionalInterface
    public interface IntegerProcessor {

        /**
         * @FunctionalInterface prevents creation fo more than one abstract method.
         */
        Integer process(Integer value);

//        Integer processInAnotherWay(Integer value);

        /**
         * Default method allow adding simple logic to interfaces
         */
        default Integer neutral() {
            return 0;
        }

    }

    static class ProcessorApplier {

        public ProcessorApplier apply(Integer value, IntegerProcessor integerProcessor) {
            System.out.println(String.format("Applied processor to %s gave as a result %s", value, integerProcessor.process(value)));
            return this;
        }

    }

    public static void main(String[] args) {

        /**
         * In good old Java < 8 one must create an anonymous class.
         */
        final IntegerProcessor twoMultiplier = new IntegerProcessor() {
            @Override
            public Integer process(Integer value) {
                return value * 2;
            }
        };

        final Integer acc = twoMultiplier.process(10);
        System.out.println("Java < 8 class:" + acc);
        System.out.println("Default method interface:" + twoMultiplier.neutral());

        final ProcessorApplier applier = new ProcessorApplier();

        applier
                .apply(5, v -> v * 2)
                .apply(10, v -> v - 1)
                .apply(10, v -> v + 10);
    }

}
