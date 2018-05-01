package br.furb.config;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class SystemConfig {
    
    public enum SystemPersistenceType {
        MEMORY;
    }
    
    /*
     * @return Tipo de persistencia utilizada pelo sistema. 
     */
    public static SystemPersistenceType getPersistenceType() {
        return SystemPersistenceType.MEMORY;
    }
    
}
