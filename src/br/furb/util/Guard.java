package br.furb.util;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class Guard {
    
    public static void isNotNull(Object obj, String objName) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("%s nao pode ser nulo.", objName));
        }
    }
    
}
