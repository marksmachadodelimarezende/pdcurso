package arquitetura;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pelo gerenciamento de instâncias
 *
 */
public class SingletonFactory {
    private static Map<Class, Object> instances = new HashMap<Class, Object>();
    private static Map<Class, EnumSet> instaciasDeListaDeEnum = new HashMap<Class, EnumSet>();

    @SuppressWarnings("unchecked")
    public static <T extends Object> T getInstance(Class<T> clazz) {
        if (instances.containsKey(clazz)) {
            return (T) instances.get(clazz);
        }
        try {
            Object obj = clazz.newInstance();
            instances.put(clazz, obj);
            return (T) obj;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static <E extends Enum<E>> EnumSet<E> getInstaciaDeListaDeEnum(Class<E> elementType) {
        if(instaciasDeListaDeEnum.containsKey(elementType)){
            return (EnumSet<E>) instaciasDeListaDeEnum.get(elementType);
        } else {
            EnumSet<E> lista = EnumSet.allOf(elementType);
            instaciasDeListaDeEnum.put(elementType, lista);
            return lista;
        }
    }

    public static void setInstance(Object objeto){
        instances.put(objeto.getClass(), objeto);
    }
}