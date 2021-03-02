package java_chobo02_ch14;
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
	R appliy(T t, U u, V v);

}
