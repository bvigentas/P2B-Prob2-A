package br.furb.view;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class AbstractDialog extends javax.swing.JDialog {

    public AbstractDialog(java.awt.Frame parent) {
        super(parent, Boolean.TRUE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanhoTela = kit.getScreenSize();
	int width = tamanhoTela.width;
	int height = tamanhoTela.height;
	setLocation( width / 2, height / 2 );
    }
   
}
