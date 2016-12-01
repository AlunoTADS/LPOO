package br.ufpr.view.util;

import java.awt.Component;

/**
 *
 * @author Lucas
 */
public class ComponentUtil {

    public static void disable(Component c) {
        c.setEnabled(false);
        c.setBackground(Colors.COMPONENT_DISABLED);
    }

    public static void enable(Component c) {
        c.setEnabled(true);
        c.setBackground(Colors.COMPONENT_ENABLED);
    }
}
