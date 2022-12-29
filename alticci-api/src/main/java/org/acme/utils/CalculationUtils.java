package org.acme.utils;

import lombok.Data;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculationUtils {
    public long calculateSequence(long number){
        //Assuming that the rule is applyed to values minors of 0
        if (number <= 0) {
            return 0;
        }

        if (number <= 2) {
            return 1;
        }

        /*
            TODO: Solve problem with big numbers. For now, tried use multithreading (didnt solve)
         */
        SequenceThread thread1 = new SequenceThread((long)number-2);
        thread1.run();
        SequenceThread thread2 = new SequenceThread((long)number-3);
        thread2.run();

        return thread1.getResult() + thread2.getResult();
    }

    @Data
    public class SequenceThread implements Runnable {

        private long value;
        private long result;

        public SequenceThread(long value){
            this.value=value;
        }

        @Override
        public void run() {
            result = calculateSequence(value);
        }

        public static long calculateSequence(long number){
            //Assuming that the rule is applyed to values minors of 0
            if (number <= 0) {
                return 0;
            }

            if (number <= 2) {
                return 1;
            }

            return calculateSequence(number-3) + calculateSequence(number-2);
        }
    }
}
