package co.udistrital.view;
import co.udistrital.model.*;
import java.awt.*;
import javax.swing.*;
import co.udistrital.model.Pokemon;
import java.util.*;
import java.util.List;

public class PanelSeleccion extends JPanel {
	
	private JButton botonRegresar;
	private JList listaPokemon;
	private List<Pokemon> listaTemp;
	DefaultListModel<Pokemon> listModel;
	
	@SuppressWarnings("unchecked")
	public PanelSeleccion() {
		listaTemp = new ArrayList<Pokemon>();
		botonRegresar = new JButton("VOLVER");
		listaPokemon = new JList(new Vector<Pokemon>());
		listaPokemon.setVisibleRowCount(6);
		listaPokemon.setFixedCellHeight(80);
		listModel = new DefaultListModel();
		
		listaPokemon.setCellRenderer(new DefaultListCellRenderer() {
			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Pokemon) {
                    // Here value will be of the Type 'CD'
                	String temp = String.format("%20s - %8s - %8s",(((Pokemon) value).getNombre()),((Pokemon) value).getTipo1(),((Pokemon) value).getTipo2());
                	((JLabel) renderer).setText(temp);
                }
                return renderer;
            }
		});
		listaPokemon.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void actualizarListaPokemon(Pokemon[] lista) {
		listModel.clear();
		for(int i=0;i<15;i++) {
			if(lista[i]!=null) {
				listModel.addElement(lista[i]);
			}
		}
		listaPokemon.setModel(listModel);
	}
	

	/**
	 * @return the botonRegresar
	 */
	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	/**
	 * @param botonRegresar the botonRegresar to set
	 */
	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	/**
	 * @return the listaPokemon
	 */
	public JList getListaPokemon() {
		return listaPokemon;
	}

	/**
	 * @param listaPokemon the listaPokemon to set
	 */
	public void setListaPokemon(JList listaPokemon) {
		this.listaPokemon = listaPokemon;
	}
	
}
