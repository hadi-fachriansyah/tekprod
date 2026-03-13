public class GenericsTypeOld<T> {

    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
    public static void main(String args[]) {
        GenericsTypeOld<String> type = new GenericsTypeOld<>();
        type.set("Java");
        String str = type.get(); 
        System.out.println(str);
    }
}
