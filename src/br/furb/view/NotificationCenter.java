package br.furb.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class NotificationCenter {
    
    private static NotificationCenter instance;
    
    public static NotificationCenter getInstance() {
        if (NotificationCenter.instance == null) {
            NotificationCenter.instance = new NotificationCenter();
        }
        return NotificationCenter.instance;
    }
    
    public void showException(Exception e) {
        showErrorNotification("Erro !!!",
                e.getMessage());
    }
    
    public void showInfoNotification(String title, String message) {
        showNotification(title, message, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showErrorNotification(String title, String message) {
        showNotification(title, message, JOptionPane.ERROR_MESSAGE);
    }
    
    public void showWarnNotification(String title, String message) {
        showNotification(title, message, JOptionPane.WARNING_MESSAGE);
    }
    
    private void showNotification(String title, String message, int type) {
        JOptionPane.showMessageDialog(
            null, 
            message, 
            title,
            type, 
            null); 
    }
    
}
