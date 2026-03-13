public class GenericsMethods {
    public static class GenericsType<T>{
        private T t;
        public T get() {
            return this.t;
        }
        public void set(T t1) {
            this.t = t1;
        }
    
    }

    // Java Generic Method
    public static <T,U> boolean isEqual(GenericsType<T> g1, GenericsType<U> g2) {
        return g1.get().equals(g2.get());
    }

    public static void main(String args[]) {
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Java");

        GenericsType<Integer> g2 = new GenericsType<>();
        g2.set(43);

        boolean isEqual = GenericsMethods.<String,Integer>isEqual(g1, g2);
        System.out.println(isEqual);
        // above statement can be written simply as 
        isEqual = GenericsMethods.isEqual(g1, g2);
        System.out.println(isEqual);
        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */
        
        // Compiler will infer the type that is needed
    }
}
