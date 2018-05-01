package br.furb.util;

import java.text.Normalizer;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class StringUtil {
    
    public static Boolean isNull(String s) {
        return s == null || s.trim().isEmpty();
    }
    
    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    
    public static Boolean possuemPartesIguais(String s1, String s2) {
        if (isNull(s1) && isNull(s2)) {
            return Boolean.TRUE;
        }
        
        if ((!StringUtil.isNull(s1) && StringUtil.isNull(s2)) ||
            (!StringUtil.isNull(s2) && StringUtil.isNull(s1))) {
            return Boolean.FALSE;
        } 
        
        if (s1.equals(s2)) {
            return Boolean.TRUE;
        }
        
        if (removerAcentos(s1).toUpperCase().contains(
                removerAcentos(s2).toUpperCase())) {
            return Boolean.TRUE;
        }
        
        return Boolean.FALSE;
    }
}
