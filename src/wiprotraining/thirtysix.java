package wiprotraining;

public class thirtysix {

    static class Tank {
        private boolean isFilled = false;
        private boolean isReleased = false;

       
        public void fill() {
            isFilled = true;
            System.out.println("Tank filled.");
        }

   
        public void empty() {
            isFilled = false;
            System.out.println("Tank emptied.");
        }

    
        public void releaseTank() {
            isReleased = true;
            System.out.println("Tank has been released (cleaned up).");
        }

       
        @Override
        protected void finalize() throws Throwable {
            if (!isReleased) {
                System.out.println("WARNING: Tank was not properly released!");
            } else {
                System.out.println("Tank finalized safely.");
            }
            super.finalize();
        }
    }

    // Main method to test scenarios
    public static void main(String[] args) {
        System.out.println("=== Case 1: Proper usage ===");
        Tank t1 = new Tank();
        t1.fill();
        t1.empty();
        t1.releaseTank();

        System.out.println("\n=== Case 2: Forgot to release ===");
        Tank t2 = new Tank();
        t2.fill();
        t2.empty();
        
        System.gc();

       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method ends.");
    }
}
//output:-
//=== Case 1: Proper usage ===
//Tank filled.
//Tank emptied.
//Tank has been released (cleaned up).
//
//=== Case 2: Forgot to release ===
//Tank filled.
//Tank emptied.
//Main method ends.
