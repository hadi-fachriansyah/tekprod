class Bound<T extends A> {
        private T objRef;

        public Bound(T obj) {
                this.objRef = obj;
        }

        public void doRunTest() {
                this.objRef.displayClass();
        }
}

class A {
        public void displayClass() {
            System.out.println("Inside super class A");
        }
    }
    
    class B extends A {
        @Override
        public void displayClass() {
            System.out.println("Inside sub class B");
        }
    }
    
    class C extends A {
        @Override
        public void displayClass() {
            System.out.println("Inside sub class C");
        }
    }
    
    public class BoundedClass {
    
        public static void main(String a[]) {
    
            // Creating object of sub class C and
            // passing it to Bound as a type parameter.
            Bound<C> bec = new Bound<>(new C());
            System.out.print("bec = ");
            bec.doRunTest();
    
            // Creating object of sub class B and
            // passing it to Bound as a type parameter.
            Bound<B> beb = new Bound<>(new B());
            System.out.print("beb = ");
            beb.doRunTest();
    
            // similarly passing super class A
            Bound<A> bea = new Bound<>(new A());
            System.out.print("bea = ");
            bea.doRunTest();
        }
    }
    