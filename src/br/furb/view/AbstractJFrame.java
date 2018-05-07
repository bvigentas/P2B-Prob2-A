package br.furb.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class AbstractJFrame extends javax.swing.JFrame {

    public AbstractJFrame(String titulo) throws HeadlessException {
        super(titulo);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanhoTela = kit.getScreenSize();
	int width = tamanhoTela.width;
	int height = tamanhoTela.height;
	setLocation( width / 2, height / 2 );
    }
    
    
    
}
