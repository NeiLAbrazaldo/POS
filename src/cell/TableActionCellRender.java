/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;
import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
/**
 *
 * @author Neil
 */
public class TableActionCellRender extends DefaultTableCellRenderer{
    
    public Component getTableCellRendererComponent (JTable jtable, Object o, boolean isSelected, boolean bin1, int row,int ii){
    Component com = super.getTableCellRendererComponent(jtable, o, isSelected, bin1, row, ii);
    panelAction action = new panelAction();
    if (isSelected == false && row % 2 == 0) {
    action.setBackground(Color.WHITE);
    }else {
    action.setBackground(com.getBackground());
    }
    return action;
}
}