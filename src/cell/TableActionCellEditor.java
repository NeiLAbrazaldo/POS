/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Neil
 */
public class TableActionCellEditor extends DefaultCellEditor{

    private TableActionEvent event;
    public TableActionCellEditor(TableActionEvent event){
    super(new JCheckBox());
    this.event = event;
    }
    
    public Component getTableCellEditorComponent (JTable jtable, Object o, boolean bin, int row,int column){
        panelAction action = new panelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
}
}